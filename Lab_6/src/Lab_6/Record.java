package Lab_6;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Record implements Serializable {
    String carNumber;
    String ownerName;
    Date dataStart;
    Date dataEnd;
    String ratePerHour;

    public Record() {
    }

    public Record(String carNumber, String ownerMame, Date dataStart, Date dataEnd, String ratePerHour) {
        this.carNumber = carNumber;
        this.ownerName = ownerMame;
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
        this.ratePerHour = ratePerHour;
    }
    public Record(String string) throws ParseException {
        StringTokenizer stringTokenizer = new StringTokenizer(string,",");
        if(stringTokenizer.hasMoreTokens()) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            this.carNumber = stringTokenizer.nextToken();
            this.ownerName = stringTokenizer.nextToken();
            this.dataStart = simpleDateFormat.parse(stringTokenizer.nextToken());
            this.dataEnd = simpleDateFormat.parse(stringTokenizer.nextToken());
            this.ratePerHour =  stringTokenizer.nextToken();
        }
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getDataStart() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    public Date getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(Date dataEnd) {
        this.dataEnd = dataEnd;
    }

    public String getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(String ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public String toString() {
        return "Record{" +
                "carNumber='" + carNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", dataStart=" + dataStart +
                ", dataEnd=" + dataEnd +
                ", ratePerHour='" + ratePerHour + '\'' +
                '}';
    }
}
