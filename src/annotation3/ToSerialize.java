package annotation3;

import java.io.Serializable;

/**
 * Created by WUHamster on 28.05.2016.
 */
public class ToSerialize implements Serializable {

    @Save
    public String text;

    public double dNumber;

    @Save
    public int iNumber;

    public String getText() {
        return text;
    }

    public double getdNumber() {
        return dNumber;
    }

    public int getiNumber() {
        return iNumber;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setdNumber(double dNumber) {
        this.dNumber = dNumber;
    }

    public void setiNumber(int iNumber) {
        this.iNumber = iNumber;
    }
}
