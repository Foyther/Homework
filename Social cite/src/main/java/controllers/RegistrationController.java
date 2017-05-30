package controllers;

import models.Question;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repositories.UserRepository;
import utils.LoginForm;
import utils.UserService;

import javax.validation.Valid;

/**
 * Created by Nurislam on 22.05.2017.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userRep;

    @RequestMapping("")
    @PreAuthorize("isAnonymous()")
    public String newUser(ModelMap map) {
        map.put("user", new User());
        return "user/user_form";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String checkingUserData(
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute("user") User user,
            BindingResult result,
            ModelMap map
    ) {
        if(result.hasErrors()) {
            return newUser(map);
        }
        userRep.registerUser(user);

        redirectAttributes.addFlashAttribute("message", "User \"" + user.getName() + "\" has been added successfully");
        redirectAttributes.addFlashAttribute("messageType", "success");
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("RC#show").arg(0, user.getId()).build();
    }

    @RequestMapping(value = "/login")
    @PreAuthorize("isAnonymous()")
    public String login(@RequestParam(required = false) String error,
                        @ModelAttribute("loginForm") LoginForm loginForm,
                        BindingResult result,
                        ModelMap map){
        map.put("error", error);
        return "user/user_login";
    }

    @RequestMapping("/user/{id}")
    @PreAuthorize("isAuthenticated()")
    public String show(@PathVariable int id, ModelMap map) throws Exception {
        User user = (User) userRep.loadUserByID(id);
        map.put("user", user);
        return "user/user_show";
    }
}
