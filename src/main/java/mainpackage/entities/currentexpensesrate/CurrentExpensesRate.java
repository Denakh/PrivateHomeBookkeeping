package mainpackage.entities.currentexpensesrate;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CurrentExpensesRate {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private double m1am;
    private double m2am;
    private double m3am;
    private double m4am;
    private double m5am;
    private double m6am;
    private double m7am;
    private double m8am;
    private double m9am;
    private double m10am;
    private double m11am;
    private double m12am;

    public CurrentExpensesRate() {
    }

    public CurrentExpensesRate(double m1am, double m2am, double m3am, double m4am, double m5am, double m6am, double m7am,
                               double m8am, double m9am, double m10am, double m11am, double m12am) {
        this.m1am = m1am;
        this.m2am = m2am;
        this.m3am = m3am;
        this.m4am = m4am;
        this.m5am = m5am;
        this.m6am = m6am;
        this.m7am = m7am;
        this.m8am = m8am;
        this.m9am = m9am;
        this.m10am = m10am;
        this.m11am = m11am;
        this.m12am = m12am;
    }

    public CurrentExpensesRate(CustomUser user, Date date, double m1am, double m2am, double m3am, double m4am, double m5am,
                               double m6am, double m7am, double m8am, double m9am, double m10am, double m11am, double m12am) {
        this.user = user;
        this.date = date;
        this.m1am = m1am;
        this.m2am = m2am;
        this.m3am = m3am;
        this.m4am = m4am;
        this.m5am = m5am;
        this.m6am = m6am;
        this.m7am = m7am;
        this.m8am = m8am;
        this.m9am = m9am;
        this.m10am = m10am;
        this.m11am = m11am;
        this.m12am = m12am;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomUser getUser() {
        return user;
    }

    public void setUser(CustomUser user) {
        this.user = user;
    }

    public double getM1am() {
        return m1am;
    }

    public void setM1am(double m1am) {
        this.m1am = m1am;
    }

    public double getM2am() {
        return m2am;
    }

    public void setM2am(double m2am) {
        this.m2am = m2am;
    }

    public double getM3am() {
        return m3am;
    }

    public void setM3am(double m3am) {
        this.m3am = m3am;
    }

    public double getM4am() {
        return m4am;
    }

    public void setM4am(double m4am) {
        this.m4am = m4am;
    }

    public double getM5am() {
        return m5am;
    }

    public void setM5am(double m5am) {
        this.m5am = m5am;
    }

    public double getM6am() {
        return m6am;
    }

    public void setM6am(double m6am) {
        this.m6am = m6am;
    }

    public double getM7am() {
        return m7am;
    }

    public void setM7am(double m7am) {
        this.m7am = m7am;
    }

    public double getM8am() {
        return m8am;
    }

    public void setM8am(double m8am) {
        this.m8am = m8am;
    }

    public double getM9am() {
        return m9am;
    }

    public void setM9am(double m9am) {
        this.m9am = m9am;
    }

    public double getM10am() {
        return m10am;
    }

    public void setM10am(double m10am) {
        this.m10am = m10am;
    }

    public double getM11am() {
        return m11am;
    }

    public void setM11am(double m11am) {
        this.m11am = m11am;
    }

    public double getM12am() {
        return m12am;
    }

    public void setM12am(double m12am) {
        this.m12am = m12am;
    }

    public static double getExpRateForMonthNum(byte monthNumber, CurrentExpensesRate currentExpensesRate) {
        double dcurrentExpensesRate = 0;
        switch (monthNumber) {
            case 1:
                dcurrentExpensesRate = currentExpensesRate.getM1am();
                break;
            case 2:
                dcurrentExpensesRate = currentExpensesRate.getM2am();
                break;
            case 3:
                dcurrentExpensesRate = currentExpensesRate.getM3am();
                break;
            case 4:
                dcurrentExpensesRate = currentExpensesRate.getM4am();
                break;
            case 5:
                dcurrentExpensesRate = currentExpensesRate.getM5am();
                break;
            case 6:
                dcurrentExpensesRate = currentExpensesRate.getM6am();
                break;
            case 7:
                dcurrentExpensesRate = currentExpensesRate.getM7am();
                break;
            case 8:
                dcurrentExpensesRate = currentExpensesRate.getM8am();
                break;
            case 9:
                dcurrentExpensesRate = currentExpensesRate.getM9am();
                break;
            case 10:
                dcurrentExpensesRate = currentExpensesRate.getM10am();
                break;
            case 11:
                dcurrentExpensesRate = currentExpensesRate.getM11am();
                break;
            case 12:
                dcurrentExpensesRate = currentExpensesRate.getM12am();
                break;
        }
        return dcurrentExpensesRate;
    }

}
