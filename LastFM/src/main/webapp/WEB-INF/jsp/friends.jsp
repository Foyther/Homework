<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main_frame>
<p><b style="color:blue">Name: ${user.name}</b></p>
<c:forEach items="${friends}" var="friend" varStatus="counter">
    <div>
    <a href="/${friend.getName()}">${friend.realname}</a>
    </div>
</c:forEach>
</t:main_frame>
