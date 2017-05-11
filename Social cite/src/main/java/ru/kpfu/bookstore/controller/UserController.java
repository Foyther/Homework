package ru.kpfu.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.bookstore.model.User;
import ru.kpfu.bookstore.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by Nurislam on 01.05.2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo){
        this.userRepo=userRepo;
    }

    @RequestMapping("/registration")
    public String registration(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("user")User user,
            BindingResult result,
            ModelMap modelMap){

        if(result.hasErrors()){
            return "user/registration";
        }
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("UC#userPage").build();
    }

    @RequestMapping("/{id}")
    public String userPage(@PathVariable("id") int id, ModelMap map){
        map.put("user", userRepo.findOneById(id));
        return "user/show";
    }




}
