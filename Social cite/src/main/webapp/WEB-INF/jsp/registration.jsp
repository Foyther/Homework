<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Nurislam
  Date: 01.05.2017
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form method="POST" commandName="user">
    <form:label path="Nickname">${surname}</form:label>
    <form:input path="Nickname"/>
    <form:errors path="Nickname"/><br>

    <form:label path="email">${email}</form:label>
    <form:input path="email"/>
    <form:errors path="email"/><br>

    <form:label path="password">${password}</form:label>
    <form:input path="password" type="password"/>
    <form:errors path="password"/><br>

    <form:label path="age">${age}</form:label>
    <form:input path="age"/>
    <form:errors path="age"/><br>

    <form:label path="male">${gender}</form:label>
    <form:radiobutton path="male" value="true"/>${male}
    <form:radiobutton path="male" value="false"/>${female}
    <br>

    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
