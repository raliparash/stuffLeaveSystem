package stuff.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stuff.model.entities.Role;
import stuff.models.RoleServiceModel;
import stuff.repository.RoleRepository;
import stuff.service.RoleService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    //private final RoleService roleService;
    private final ModelMapper modelMapper;


    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
      //  this.roleService = roleService;
    }


    @Override
    public void seedRolesInDb() {
       if(this.roleRepository.count() == 0){
           this.roleRepository.saveAndFlush(new Role("ROLE_EMPLOYEE"));
           this.roleRepository.saveAndFlush(new Role("ROLE_ADMIN"));
           this.roleRepository.saveAndFlush(new Role("ROLE_ROOT"));
       }
    }

    @Override
    public RoleServiceModel findByAuthority(String role) {
        return this.modelMapper.map(this.roleRepository.findByAuthority(role), RoleServiceModel.class);
    }

    @Override
    public Set<RoleServiceModel> findAllRoles() {
        return this.roleRepository.findAll()
                .stream()
                .map(role -> this.modelMapper
                        .map(role,RoleServiceModel.class))
                .collect(Collectors.toSet());
    }


}

