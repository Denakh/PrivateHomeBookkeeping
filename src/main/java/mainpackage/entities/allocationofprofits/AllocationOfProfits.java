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

@Entity
public class AllocationOfProfits {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    //CHARITY, HEALTH, KIDSANDPATS, OTHERCAPOUTLAYS, RECREATION, RESERVE;

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

    public static void allocationOfProfitsExe(AllocationOfProfitsService allocationOfProfitsService, CustomUser dbUser,
     CharityService charityService, HealthService healthService, KidsAndPetsService kidsAndPetsService,
      OtherCapitalOutlaysService otherCapitalOutlaysService, RecreationService recreationService, ReserveService reserveService) {
        AllocationOfProfits allocationOfProfits = allocationOfProfitsService.findLastEntry(dbUser);
        double am = 0;
        Charity c = charityService.findLastEntry();
        if (c != null) am = c.getAmount();
        damount = allocationOfProfits.getCharityPercent()*excessForAllocationRest/100;
        charityService.addCharity(new Charity(dbUser, damount, date, description, am + damount));
        am = 0;
        Health h = healthService.findLastEntry();
        if (h != null) am = h.getAmount();
        damount = allocationOfProfits.getHealthPercent()*excessForAllocationRest/100;
        healthService.addHealth(new Health(dbUser, damount, date, description, am + damount));
        am = 0;
        KidsAndPets k = kidsAndPetsService.findLastEntry();
        if (k != null) am = k.getAmount();
        damount = allocationOfProfits.getKidsAndPetsPercent()*excessForAllocationRest/100;
        kidsAndPetsService.addKidsAndPets(new KidsAndPets(dbUser, damount, date, description,
                am + damount));
        am = 0;
        OtherCapitalOutlays o = otherCapitalOutlaysService.findLastEntry();
        if (o != null) am = o.getAmount();
        damount = allocationOfProfits.getOtherCapOutLaysPercent()*excessForAllocationRest/100;
        otherCapitalOutlaysService.addOtherCapitalOutlays(new OtherCapitalOutlays(dbUser, damount, date,
                description, am + damount));
        am = 0;
        Recreation rec = recreationService.findLastEntry();
        if (rec != null) am = rec.getAmount();
        damount = allocationOfProfits.getRecreationPercent()*excessForAllocationRest/100;
        recreationService.addRecreation(new Recreation(dbUser, damount, date, description,
                am + damount));
        am = 0;
        Reserve res = reserveService.findLastEntry();
        if (res != null) am = res.getAmount();
        damount = allocationOfProfits.getReservePercent()*excessForAllocationRest/100;
        reserveService.addReserve(new Reserve(dbUser, damount, date, description, am + damount));
    }

}
