package mainpackage.entities.income;

import mainpackage.entities.kidsandpets.KidsAndPetsExpensesPerQuarter;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Income {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generalIncome_id")
    private GeneralIncome generalIncome;

    private double amount;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private String purpose;

    public Income() {
    }

    public Income(CustomUser user, double amount, Date date, String description, String purpose) {
        this.user = user;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.purpose = purpose;
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

    public GeneralIncome getGeneralIncome() {
        return generalIncome;
    }

    public void setGeneralIncome(GeneralIncome generalIncome) {
        this.generalIncome = generalIncome;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
