package stuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stuff.model.entities.Employee;
import stuff.model.entities.User;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
