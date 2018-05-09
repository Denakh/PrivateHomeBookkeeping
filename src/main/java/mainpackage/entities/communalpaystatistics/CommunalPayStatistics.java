package mainpackage.entities.communalpaystatistics;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class CommunalPayStatistics {

    private double amount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;



}
