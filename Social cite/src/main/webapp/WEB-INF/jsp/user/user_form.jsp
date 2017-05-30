<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<t:mainLayout title="New user">

    <form:form class="form-horizontal" method="POST" commandName="user">
        <t:input label="Userame" required="true" path="name"/>
        <form:errors path="name" />
        <t:input label="Email" required="true" path="email"/>
        <form:errors path="email" />
        <t:input label="Password" required="true" path="password" />
        <form:errors path="password"/>
        <button type="submit" class="btn btn-success">Save</button>
    </form:form>
</t:mainLayout>