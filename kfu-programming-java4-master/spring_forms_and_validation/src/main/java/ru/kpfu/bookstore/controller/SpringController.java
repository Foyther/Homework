package ru.kpfu.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.bookstore.Service.CityGenerator;
import ru.kpfu.bookstore.model.Author;
import ru.kpfu.bookstore.model.AuthorValidator;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/spring")
public class SpringController {

    private MessageSourceAccessor msa;

    @Autowired
    private void setMessageSourceAccessor(MessageSource ms){
        this.msa = new MessageSourceAccessor(ms);
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new AuthorValidator());// Task: NPE
    }

    @RequestMapping(value = "/new_author", method = RequestMethod.GET)
    public String newAuthor(ModelMap map) {
        map.put("author", new Author());
        map.put("surname", this.msa.getMessage("surname"));
        map.put("name", this.msa.getMessage("name"));
        map.put("patronomic", this.msa.getMessage("patronomic"));
        map.put("email", this.msa.getMessage("email"));
        map.put("password", this.msa.getMessage("password"));
        map.put("passwordCheck", this.msa.getMessage("passwordCheck"));
        map.put("country", this.msa.getMessage("country"));
        map.put("gender", this.msa.getMessage("gender"));
        map.put("male", this.msa.getMessage("gender.male"));
        map.put("female", this.msa.getMessage("gender.female"));
        map.put("countryList", new CityGenerator().getCitys());
        return "author_form";
    }

    @RequestMapping(value = "/new_author", method = RequestMethod.POST)
    public String springHandler(
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute("author") Author author,
            BindingResult result,
            ModelMap map
    ) {
        map.put("countryList", new CityGenerator().getCitys());

        if (result.hasErrors()) {
            return "author_form";
        } else {
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Author \"" + author.getName() + "\" has been added successfully</span>");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#newAuthor").build();
        }

    }
}
