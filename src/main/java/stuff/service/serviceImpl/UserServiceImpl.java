package stuff.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import stuff.model.entities.Role;
import stuff.model.entities.User;
import stuff.models.UserServiceModel;
import stuff.repository.UserRepository;
import stuff.service.RoleService;
import stuff.service.UserService;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        User user = this.modelMapper.map(userServiceModel, User.class);

        if (this.userRepository.count() == 0) {
            this.roleService.seedRolesInDb();
            user.setAuthorities(this.roleService.findAllRoles()
                    .stream().map(role -> this.modelMapper.map(role, Role.class))
                    .collect(Collectors.toSet()));

        } else {
            user.setAuthorities(new LinkedHashSet<>());
            user.getAuthorities().add(this.modelMapper.map(this.roleService.findByAuthority("ROLE_EMPLOYEE"),Role.class));
        }

        user.setPassword(this.bCryptPasswordEncoder.encode(userServiceModel.getPassword()));

        return this.modelMapper
                .map(this.userRepository.save(user),UserServiceModel.class);
    }



    @Override
    public UserServiceModel findByUserName(String username) {
        return this.userRepository
                .findByUsername(username)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class)).orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
    }

    @Override
    public UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword) {
        return null;
    }

    @Override
    public void setUserRole(String id, String role) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
    }
}
