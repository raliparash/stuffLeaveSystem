package stuff.model.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity {

    private String name;
    private Set<Project> projects;


    public Department() {
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(targetEntity = Project.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }



}
