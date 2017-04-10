<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <a href="<c:url value="/" />">Homepage</a><br><br>
    <c:if test="${not empty message}">
      <h1>${message}</h1>
    </c:if>
    <form:form method="POST" commandName="author">
      <form:label path="surname">${surname}</form:label>
      <form:input path="surname"/>
      <form:errors path="surname" /><br>

      <form:label path="name">${name}</form:label>
      <form:input path="name"/>
      <form:errors path="name" /><br>

      <form:label path="patronomic">${patronomic}</form:label>
      <form:input path="patronomic"/>
      <form:errors path="patronomic" /><br>

      <form:label path="email">${email}</form:label>
      <form:input path="email"/>
      <form:errors path="email" /><br>

      <form:label path="password">${password}</form:label>
      <form:input path="password" type="password"/>
      <form:errors path="password" /><br>

      <form:label path="passwordCheck">${passwordCheck}</form:label>
      <form:input path="passwordCheck" type="password"/>
      <form:errors path="passwordCheck" /><br>

      <form:label path="male">${gender}</form:label>
      <form:radiobutton path="male" value="true"/>${male}
      <form:radiobutton path="male" value="false"/>${female}
      <br>

      <form:label path="country">${city}</form:label>
      <form:select path="country">
        <form:option value="NONE" label="--- Select ---"/>
        <form:options items="${countryList}" />
      </form:select>
      <form:errors path="country"/><br>

      <form:label path="news">${news}</form:label>
      <form:checkbox path="news"/><br>

      <input type="submit" value="Submit" />
    </form:form>
  </body>
</html>
