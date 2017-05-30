package controllers;

import annotations.Loggable;
import models.Question;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repositories.QuestionRepository;
import repositories.TagRepository;
import repositories.UserRepository;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class QuestionController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/")
    public String list(ModelMap map) {
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("QC#add").build();
    }

    @Loggable
    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/question/new", method = RequestMethod.GET)
    public String add(ModelMap map) {
        map.put("question", new Question());
        return showForm(map);
    }


    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/question/new", method = RequestMethod.POST)
    public String addHandler(
            RedirectAttributes redirectAttributes,
            @ModelAttribute("question") @Valid Question question,
            BindingResult result,
            ModelMap map
    ) {
        if (result.hasErrors()) {
            return showForm(map);
        } else {
            User user = userRepository.findOne(1);
            question.setUser(user);
            question.setDate(new Date(System.currentTimeMillis()));
            questionRepository.save(question);
            redirectAttributes.addFlashAttribute("message", "Question \"" + question.getTitle() + "\" has been added successfully");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("QC#show").arg(0, question.getId()).build();
        }
    }


    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/question/{id}")
    public String show(@PathVariable int id, ModelMap map) throws Exception {
        Question question = questionRepository.findOne(id);

        map.put("question", question);
        return "questions/show";
    }

    protected String showForm(ModelMap map) {
        map.put("codetags", tagRepository.findAll());
        return "questions/question_form";
    }
}
