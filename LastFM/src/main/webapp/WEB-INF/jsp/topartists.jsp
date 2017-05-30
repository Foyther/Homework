<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main_frame>
<c:if test="${not empty message}">
    <h1>{{message}}</h1>
</c:if>
<p><b style="color:blue">Name: ${user.name}</b></p>
<c:forEach items="${topartists}" var="artist" varStatus="counter">
    <div>Name: ${artist.name}</div>
    <div>Playcount: ${artist.playcount}</div>
</c:forEach>
</t:main_frame>
