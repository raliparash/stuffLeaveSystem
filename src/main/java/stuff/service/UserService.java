package stuff.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import stuff.models.UserServiceModel;

import java.util.Collection;


public interface UserService extends UserDetailsService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);


    UserServiceModel findByUserName(String username);

    UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword);



    void setUserRole(String id, String role);


}
