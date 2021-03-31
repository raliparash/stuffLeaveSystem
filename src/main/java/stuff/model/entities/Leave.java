package stuff.model.entities;

import javax.annotation.Priority;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "leaves")
public class Leave  extends BaseEntity{

    private TypeLeave typeLeave;
    private String request;
    private Date requestDate;
    private PriorityLevel priorityLevel;
    private boolean approved;
    private GrantedLeave grantedLeave;


    public Leave() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type_leave",nullable = false)
    public TypeLeave getTypeLeave() {
        return typeLeave;
    }

    public void setTypeLeave(TypeLeave typeLeave) {
        this.typeLeave = typeLeave;
    }

    @Column(name = "request",nullable = false)
    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Column(name = "request_date",nullable = false)
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "priority_level")
    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Column(name = "is_approved")
    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @OneToOne
    public GrantedLeave getGrantedLeave() {
        return grantedLeave;
    }

    public void setGrantedLeave(GrantedLeave grantedLeave) {
        this.grantedLeave = grantedLeave;
    }
}
