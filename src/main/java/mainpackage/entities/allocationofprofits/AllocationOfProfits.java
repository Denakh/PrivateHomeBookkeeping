package mainpackage.entities.allocationofprofits;

import mainpackage.entities.charity.Charity;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.health.Health;
import mainpackage.entities.health.HealthService;
import mainpackage.entities.kidsandpets.KidsAndPets;
import mainpackage.entities.kidsandpets.KidsAndPetsService;
import mainpackage.entities.othercapitaloutlays.OtherCapitalOutlays;
import mainpackage.entities.othercapitaloutlays.OtherCapitalOutlaysService;
import mainpackage.entities.recreation.Recreation;
import mainpackage.entities.recreation.RecreationService;
import mainpackage.entities.reserve.Reserve;
import mainpackage.entities.reserve.ReserveService;
import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AllocationOfProfits {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private double charityPercent;
    private double healthPercent;
    private double kidsAndPetsPercent;
    private double otherCapOutLaysPercent;
    private double recreationPercent;
    private double reservePercent;

    public AllocationOfProfits() {
    }

    public AllocationOfProfits(double charityPercent, double healthPercent, double kidsAndPetsPercent,
                               double otherCapOutLaysPercent, double recreationPercent, double reservePercent) {
        this.charityPercent = charityPercent;
        this.healthPercent = healthPercent;
        this.kidsAndPetsPercent = kidsAndPetsPercent;
        this.otherCapOutLaysPercent = otherCapOutLaysPercent;
        this.recreationPercent = recreationPercent;
        this.reservePercent = reservePercent;
    }

    public AllocationOfProfits(CustomUser user, Date date, double charityPercent, double healthPercent,
                               double kidsAndPetsPercent, double otherCapOutLaysPercent, double recreationPercent, double reservePercent) {
        this.user = user;
        this.date = date;
        this.charityPercent = charityPercent;
        this.healthPercent = healthPercent;
        this.kidsAndPetsPercent = kidsAndPetsPercent;
        this.otherCapOutLaysPercent = otherCapOutLaysPercent;
        this.recreationPercent = recreationPercent;
        this.reservePercent = reservePercent;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCharityPercent() {
        return charityPercent;
    }

    public void setCharityPercent(double charityPercent) {
        this.charityPercent = charityPercent;
    }

    public double getHealthPercent() {
        return healthPercent;
    }

    public void setHealthPercent(double healthPercent) {
        this.healthPercent = healthPercent;
    }

    public double getKidsAndPetsPercent() {
        return kidsAndPetsPercent;
    }

    public void setKidsAndPetsPercent(double kidsAndPetsPercent) {
        this.kidsAndPetsPercent = kidsAndPetsPercent;
    }

    public double getOtherCapOutLaysPercent() {
        return otherCapOutLaysPercent;
    }

    public void setOtherCapOutLaysPercent(double otherCapOutLaysPercent) {
        this.otherCapOutLaysPercent = otherCapOutLaysPercent;
    }

    public double getRecreationPercent() {
        return recreationPercent;
    }

    public void setRecreationPercent(double recreationPercent) {
        this.recreationPercent = recreationPercent;
    }

    public double getReservePercent() {
        return reservePercent;
    }

    public void setReservePercent(double reservePercent) {
        this.reservePercent = reservePercent;
    }

}
