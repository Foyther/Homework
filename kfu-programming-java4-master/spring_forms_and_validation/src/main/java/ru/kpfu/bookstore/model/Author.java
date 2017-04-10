package ru.kpfu.bookstore.model;

public class Author {
  private String surname;
  private String name;
  private String patronomic;
  private String country;
  private String email;
  private boolean male;
  private boolean news;
  private String password;
  private String passwordCheck;

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

  public String getPatronomic() {
    return patronomic;
  }

  public void setPatronomic(String patronomic) {
    this.patronomic = patronomic;
  }
}
