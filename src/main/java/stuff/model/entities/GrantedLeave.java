package stuff.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "granted_leave")
public class GrantedLeave extends BaseEntity {

    private Date approved;
    private TypeLeave typeLeave;
    private int duration;
    private Date returnDate;




    public GrantedLeave() {
    }

    @Column(name = "approved",nullable = false)
    public Date getApproved() {
        return approved;
    }

    public void setApproved(Date approved) {
        this.approved = approved;
    }

    @Enumerated(EnumType.STRING)
    public TypeLeave getTypeLeave() {
        return typeLeave;
    }

    public void setTypeLeave(TypeLeave typeLeave) {
        this.typeLeave = typeLeave;
    }

    @Column(name = "duration",nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Column(name = "return_date",nullable = false)
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
