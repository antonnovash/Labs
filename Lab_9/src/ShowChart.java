import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class ShowChart extends Applet {

    private ArrayList<Pair> data = new ArrayList<>();

    public void init() {

        String inputData;
        int quantity = 0;
        while ((inputData = getParameter(String.format("param_%d", quantity++))) != null) {
            String[] words = inputData.split(" ");
            data.add(new Pair(words[0], words[1]));
        }
    }

    public void paint(Graphics g) {
        int prevAngle = 0;
        int summaNumberOfVoters = 0;
        int angleFromChart = 0;
        int rColor, gColor, bColor;
        Dimension dimAppWndDimension = getSize();

        g.setColor(Color.white);
        g.fillRect(0, 0, dimAppWndDimension.width - 1, dimAppWndDimension.height - 1);
        g.setColor(Color.black);
        g.drawRect(0, 0, dimAppWndDimension.width - 1, dimAppWndDimension.height - 1);
        g.drawString(getParameter("param_0"), 15, 15);
        for (int i = 1; i < 6; i++) {
            summaNumberOfVoters += Integer.parseInt(data.get(i).getNumberOfVoters());
        }

        for (int i = 1; i < 6; i++) {
            rColor = (int) (240 * Math.random());
            gColor = (int) (230 * Math.random());
            bColor = (int) (250 * Math.random());
            g.setColor(new Color(rColor, gColor, bColor));
            angleFromChart = (Integer.parseInt(data.get(i).getNumberOfVoters()) * 360) / summaNumberOfVoters;
            g.fillArc(50, 30, 200, 200, prevAngle, angleFromChart);
            prevAngle += angleFromChart;
            g.fillRect(5, (25 * i) + 225, 15, 15);
            g.drawRect(5, (25 * i) + 225, 15, 15);
            g.drawString(data.get(i).getCarBrand(), 30, (25 * i) + 240);
        }
        g.fillArc(50, 30, 200, 200, prevAngle, 360 - prevAngle);
    }
}
