<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<t:mainLayout title="LogIn">

    <form:form class="form-horizontal" method="POST" commandName="user">
        <t:input label="Email" required="true" path="email"/>
        <form:errors path="email" />
        <t:input label="Password" required="true" path="password" />
        <form:errors path="password"/>
        <button type="submit" class="btn btn-success">Log In</button>
    </form:form>
</t:mainLayout>