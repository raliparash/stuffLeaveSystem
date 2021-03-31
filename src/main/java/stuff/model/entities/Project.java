package stuff.model.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project extends BaseEntity {

    private String title;
    private Date started_on;
    private Date expirationDate;
    private Date deadLineDate;
    private User employees;
    private Set<Department> departments;


    public Project() {
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "started_on", nullable = false)
    public Date getStarted_on() {
        return started_on;
    }

    public void setStarted_on(Date started_on) {
        this.started_on = started_on;
    }

    @Column(name = "expiration_date", nullable = false)
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Column(name = "deadline_date", nullable = false)
    public Date getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(Date deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    public User getEmployees() {
        return employees;
    }

    public void setEmployees(User employees) {
        this.employees = employees;
    }

    @ManyToMany
    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
