package stuff.service;


import stuff.model.entities.Role;
import stuff.models.RoleServiceModel;

import java.util.Collection;
import java.util.Set;

public interface RoleService {

    void seedRolesInDb();


    RoleServiceModel findByAuthority(String role);


    Set<RoleServiceModel>findAllRoles();
}
