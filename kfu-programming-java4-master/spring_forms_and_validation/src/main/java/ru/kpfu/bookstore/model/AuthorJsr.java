package ru.kpfu.bookstore.model;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.*;


public class AuthorJsr {
    @NotNull
    @Size(min = 5, max = 128)
    private String surname;
    @NotNull
    @Size(min = 5, max = 128)
    private String name;
    @NotNull
    @Size(min = 5, max = 128)
    private String patronomic;
    private String country;
    @NotNull
    @Email
    private String email;
    private boolean male;
    private boolean news;
    @NotNull
    @Size(min = 6, max = 28)
    private String password;
    private String passwordCheck;

    @AssertTrue(message="Repassword field should be equal than pass field")
    private boolean isValid() {
        return this.password.equals(this.passwordCheck);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronomic() {
        return patronomic;
    }

    public void setPatronomic(String patronomic) {
        this.patronomic = patronomic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isNews() {
        return news;
    }

    public void setNews(boolean news) {
        this.news = news;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }
}
