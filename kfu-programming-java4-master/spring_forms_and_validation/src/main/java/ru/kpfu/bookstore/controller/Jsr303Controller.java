package ru.kpfu.bookstore.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.bookstore.Service.CityGenerator;
import ru.kpfu.bookstore.model.AuthorJsr;

@Controller
@RequestMapping("/jsr303")
public class Jsr303Controller {

    @RequestMapping(value = "/new_author_jsr", method = RequestMethod.GET)
    public String newAuthorJsr(ModelMap map) {
        map.put("authorjsr", new AuthorJsr());
        map.put("countryList", new CityGenerator().getCitys());

        return "author_jsr_form";
    }

    @RequestMapping(value = "/new_author_jsr", method = RequestMethod.POST)
    public String jsr303Handler(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("authorjsr") AuthorJsr jsr,
            BindingResult result,
            ModelMap map
    ) {

        map.put("countryList", new CityGenerator().getCitys());

        if (result.hasErrors()) {
            return "author_jsr_form";
        } else {
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">AuthorJsr \"" + jsr.getName() + "\" has been added successfully</span>");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("JC#newAuthorJsr").build();
        }

    }
}
