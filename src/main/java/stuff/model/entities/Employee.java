package stuff.model.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    private String username;
    private String firstname;
    private String lastname;
    private String position;
    private String email;
    private String phoneNumber;
    private String gender;
    private LocalDate joiningDate;
    private LocalDate expiredDate;
    private Department department;
    private Project project;
    private Set<Training> trainings;
    private Leave leave;
    private Address address;
    private User user;

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "firstname", nullable = false)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "position", nullable = false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "phone_number", nullable = false, unique = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "gender", nullable = false)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "joiningDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Column(name = "expiredDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToMany(targetEntity = Training.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }


    @ManyToOne
    @JoinColumn(name = "project_id")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @ManyToOne
    @JoinColumn(name = "leave_id")
    public Leave getLeave() {
        return leave;
    }

    public void setLeave(Leave leave) {
        this.leave = leave;
    }

    @OneToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
