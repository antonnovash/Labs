package forms;

import Lab_8_Data.Buffer;
import Lab_8_Data.Record;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainWindow extends JFrame {
    private JPanel formPanel;
    private JTextField carNumber;
    private JTextField ownerName;
    private JTextField dataStart;
    private JTextField dataEnd;
    private JPanel listPanel;
    private JPanel dataPanel;
    private JTextField ratePerHour;
    private JPanel JListPanel;
    private JList listView;
    private JButton submitButton;
    private JButton cleanButton;
    private JButton findUp;
    private JButton findLow;
    private JButton remove;
    private JTextField Index;


    public MainWindow() throws ParseException {
        JFrame self = this;
        this.getContentPane().add(formPanel);
        DefaultListModel<Record> listModel = new DefaultListModel<>();
        listView.setModel(listModel);
        ArrayList<Record> magazine = new ArrayList<>();
        createArrayList(magazine);
        Map<Object, Long> map = Buffer.write(magazine);
        //SortedMap sortedMap = new TreeMap(map);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        /*Record firstRecord = new Record("9012AB-1", "Anton Novash", simpleDateFormat.parse("24.10.2018 10:00:00"), simpleDateFormat.parse("30.10.2018 18:00:00"), "250$");
        Record secondRecord = new Record("1234AB-5", "Anton Novash", simpleDateFormat.parse("22.10.2018 11:00:00"), simpleDateFormat.parse("26.10.2018 11:30:00"), "150$");
        Record thirdRecord = new Record("5678AB-7", "Artur Ysnov", simpleDateFormat.parse("23.10.2018 12:00:00"), simpleDateFormat.parse("28.10.2018 12:30:00"), "200$");
        listModel.addElement(firstRecord);
        listModel.addElement(secondRecord);
        listModel.addElement(thirdRecord);*/
        for (Record arrayList : magazine) {
            listModel.addElement(arrayList);
        }

        submitButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carNumberText = carNumber.getText();
                String ownerNameText = ownerName.getText();
                Date dataStartText = null;
                try {
                    dataStartText = simpleDateFormat.parse(dataStart.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                Date dataEndText = null;
                try {
                    dataEndText = simpleDateFormat.parse(dataEnd.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                String ratePerHourText = ratePerHour.getText();
                listModel.addElement(new Record(carNumberText, ownerNameText, dataStartText, dataEndText, ratePerHourText));
            }

        });
        cleanButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
            }
        });
        findLow.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(Index.getText());
                Record record = Buffer.findLow(magazine.get(index).getOwnerName(), map);
                listModel.addElement(record);
            }
        });
        findUp.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(Index.getText());
                Record record = Buffer.findUp(magazine.get(index).getOwnerName(), map);
                listModel.addElement(record);
            }
        });
        remove.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(Index.getText());
                Buffer.removeByIndex(magazine.get(index).getOwnerName(),map);

                for (Map.Entry<Object, Long> entry : map.entrySet()) {
                    Record record = Buffer.read(entry.getKey(), map);
                    if (record != null) {
                        listModel.addElement(Buffer.read(entry.getKey(), map));
                    }
                }
            }
        });
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu AboutMenu = new JMenu("Status");
        JMenuItem statusFirstLine = new JMenuItem("\n" +
                "The program displays a list of car records in the parking place.\n" +
                " In the File section you can upload and read files.\n");
        JMenuItem statusSecondLine = new JMenuItem("\n Add to the list, you can add each of the fields. Developed by Anton Novash.");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");

        fileMenu.add(load);
        fileMenu.add(save);
        AboutMenu.add(statusFirstLine);
        AboutMenu.add(statusSecondLine);
        menuBar.add(fileMenu);
        menuBar.add(AboutMenu);
        setJMenuBar(menuBar);

        load.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                int result = fileChooser.showOpenDialog(self);
                if (result != JFileChooser.APPROVE_OPTION) {
                    return;
                }

                File file = fileChooser.getSelectedFile();

                try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    ArrayList<Record> loadedInvoices = (ArrayList) ois.readObject();
                    ois.close();
                    fis.close();

                    listModel.clear();
                    for (Record record : loadedInvoices) {
                        listModel.addElement(record);
                    }
                } catch (IOException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        save.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                int result = fileChooser.showSaveDialog(self);
                if (result != JFileChooser.APPROVE_OPTION) {
                    return;
                }

                File file = fileChooser.getSelectedFile();


                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    ArrayList<Record> records = new ArrayList<>();

                    for (int i = 0; i < listModel.size(); ++i) {
                        records.add(listModel.get(i));
                    }

                    oos.writeObject(records);
                    oos.close();
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private static void createArrayList(ArrayList<Record> magazine) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Record firstRecord = new Record("9012AB-1", "Anton Novash", simpleDateFormat.parse("24.10.2018 10:00:00"), simpleDateFormat.parse("30.10.2018 18:00:00"), "250$");
        Record secondRecord = new Record("5678AB-7", "Artur Ysnov", simpleDateFormat.parse("23.10.2018 12:00:00"), simpleDateFormat.parse("28.10.2018 12:30:00"), "200$");
        Record thirdRecord = new Record("1234AB-5", "Egor Butckevich", simpleDateFormat.parse("22.10.2018 11:00:00"), simpleDateFormat.parse("26.10.2018 11:30:00"), "150$");

        magazine.add(firstRecord);
        magazine.add(secondRecord);
        magazine.add(thirdRecord);
    }

}
