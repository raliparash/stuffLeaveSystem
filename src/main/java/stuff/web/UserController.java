package stuff.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import stuff.bindingModels.UserRegisterBindingModel;
import stuff.model.entities.User;
import stuff.models.UserServiceModel;
import stuff.service.UserService;
import stuff.viewModels.UserAllViewModel;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView register() {


        return super.model("/register");
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registrationConfirm(@ModelAttribute UserRegisterBindingModel model) {

        if (!model.getPassword().equals(model.getConfirmPassword())) {


            return super.model("/register");
        }

        this.userService.registerUser(this.modelMapper.map(model, UserServiceModel.class));
        return super.redirect("/login");
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ModelAndView login() {

        return super.model("/login");
    }





}
