package stuff.model.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "trainings")
public class Training extends BaseEntity {

    private String name;
    private String type;
    private String description;
    private Date start_date;
    private Date endDate;

    public Training() {
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "type",nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Column(name = "description",nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "start_date",nullable = false)
    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
    @Column(name = "end_date",nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
