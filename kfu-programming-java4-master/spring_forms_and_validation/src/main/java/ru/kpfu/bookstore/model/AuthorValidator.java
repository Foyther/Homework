package ru.kpfu.bookstore.model;

import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.bookstore.Service.RegularTest;

public class AuthorValidator implements Validator {

  @Override
  public boolean supports(Class clazz) {
    return Author.class.equals(clazz);
  }

  @Override
  public void validate(Object obj, Errors e) { /// КАК ЭТО РАБОТАЕТ? и как выводить разные ошибки
    Author a = (Author) obj;
    RegularTest rt = new RegularTest();

    if(!rt.isCorrectName(a.getSurname())){
      e.rejectValue("surname","surname", new Object[]{}, "Your surname is very big or small");
    }

    if(!rt.isCorrectName(a.getName())){
      e.rejectValue("name","name", new Object[]{}, "Your name is very big or small");
    }

    if(!rt.isCorrectName(a.getPatronomic())){
      e.rejectValue("patronomic","patronomic", new Object[]{}, "Your patronomic is very big or small");
    }

    if(!rt.isCorrectPassword(a.getPassword())){
      e.rejectValue("password","password", new Object[]{}, "Your password is very big or small");
    }

    if(!a.getPassword().equals(a.getPasswordCheck())){
      e.rejectValue("passwordCheck", "repassword", new Object[]{}, "Your repassword isn't equally password");
    }

    if(!a.getCountry().equals("NONE")){
      e.rejectValue("country", "countryNull", new Object[]{}, "You didn't choose your country");
    }

    if(!rt.isCorrectEmail(a.getEmail())){
      e.rejectValue("email", "email", new Object[]{}, "Email is incorrect");
    }
//    try {
//      new URL(a.getAvatarUrl());
//    } catch (MalformedURLException ex) {
//      e.rejectValue("avatarUrl","incorrectURL", new Object[]{}, "URL is incorrect");
//    }
  }
}
