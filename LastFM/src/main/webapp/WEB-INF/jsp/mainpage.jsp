<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main_frame>
<p><img src="${image}" alt="User photo" width="150" height="150"></p>
<p><b style="color:blue">Name: ${user.name}</b></p>
<p><b style="color:blue">Country: ${user.country}</b></p>
<p><b style="color:blue">Playcount: ${user.playcount}</b></p>
</t:main_frame>
