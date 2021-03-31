package stuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stuff.model.entities.Role;
import stuff.models.RoleServiceModel;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByAuthority(String role);
}
