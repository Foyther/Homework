<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
  Creating own tags and simple templating system : http://stackoverflow.com/questions/1296235/jsp-tricks-to-make-templating-easier
--%>
<t:mainLayout title="Question">
  <div class="book-page">
    <h1 class="book-name">${question.title}</h1>
    <div class="book-field">
      <span class="field-name">Date:</span>
      <span class="field-value">${question.date}</span>
    </div>
    <div class="book-description">${question.description}</div>
  </div>
</t:mainLayout>