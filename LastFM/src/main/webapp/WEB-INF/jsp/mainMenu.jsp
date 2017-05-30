<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${spring:mvcUrl('DC#main').build()}">Main</a></li>
                <li><a href="/${user.name}/friends">Friends</a></li>
                <li><a href="/${user.name}/lovetracks">Loved Tracks</a></li>
                <li><a href="/${user.name}">Info</a></li>
                <li><a href="/${user.name}/topartists">Top Artists</a></li>
                <li><a href="/${user.name}/toptracks">Top Tracks</a></li>
            </ul>
        </div>
    </div>
</nav>