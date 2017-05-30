<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<t:mainLayout title="New question">
    <form:form class="form-horizontal" method="POST" commandName="question">
        <t:input label="Title" required="true" path="title"/>
        <form:errors path="title" />
        <t:select  label="Tag" required="true" path="codeTag" options="${codetags}"/>
        <select class="js-example-disabled-results">
            <option value="one">First</option>
            <option value="two" disabled="disabled">Second (disabled)</option>
            <option value="three">Third</option>
        </select>
        <form:errors path="codeTag" />
        <t:textarea label="Description" required="false" path="description"/>

        <button type="submit" class="btn btn-success">Save</button>
    </form:form>
</t:mainLayout>