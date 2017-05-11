package ru.kpfu.bookstore.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.bookstore.model.Post;
import ru.kpfu.bookstore.repository.PostRepository;

@Controller
public class DefaultController {

    private PostRepository postRepo;

    @Autowired
    public DefaultController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @RequestMapping("/")
    public String list(ModelMap map) {
        map.put("posts", postRepo.findAll());
        return "posts/list";
    }

    @RequestMapping("/post/{id}")
    public String show(@PathVariable("id") Long id, ModelMap map) {
        map.put("post", postRepo.findOneById(id));
        return "posts/show";
    }

    @RequestMapping(value = "/new_post", method = RequestMethod.GET)
    public String add(ModelMap map) {
        map.put("post", new Post());
        return "posts/post_form";
    }

    @RequestMapping(value = "/new_post", method = RequestMethod.POST)
    public String formHandler(
            RedirectAttributes redirectAttributes,
            @Valid Post Post,
            BindingResult result,
            ModelMap map
    ) {

        if (result.hasErrors()) {
            return "posts/post_form";
        } else {
            postRepo.save(Post);
            redirectAttributes.addFlashAttribute("message", "Post \"" + Post.getId() + "\" has been added successfully");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#add").build();
        }
    }
//
//    @RequestMapping("/post/{id}/delete")
//    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes, ModelMap map) {
//        try {
//            postRepo.delete(id);
//            redirectAttributes.addFlashAttribute("message", "Post has been deleted successfully");
//            redirectAttributes.addFlashAttribute("messageType", "success");
//        } catch (EmptyResultDataAccessException e) {
//            redirectAttributes.addFlashAttribute("message", "Can't find Post with id " + id);
//            redirectAttributes.addFlashAttribute("messageType", "fail");
//        } catch (DataAccessException e) {
//            redirectAttributes.addFlashAttribute("message", "Can't delete Post with id " + id);
//            redirectAttributes.addFlashAttribute("messageType", "fail");
//        }
//        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#list").build();
//    }

//  private void setMessageSourceAccessor(MessageSource ms){
//    this.msa = new MessageSourceAccessor(ms);
//  }
//
//  @RequestMapping("/")
//  public String index(ModelMap map){
//    map.put("message0", this.msa.getMessage("controller.message"));
//    map.put("message1", this.msa.getMessage("controller.param.message", new Double[]{9.78}));
//    return "index";
//  }

//  @RequestMapping("/change")
//  public String change(@RequestParam String locale){
//    // Check here for param format
//    String[] localeData = locale.split("_");
//    localeResolver.setLocale(request, response, new Locale(localeData[0], localeData[1]));
//    return "redirect:" + MvcUriComponentsBuilder.fromMappingName("DC#index").build();
//  }
}
