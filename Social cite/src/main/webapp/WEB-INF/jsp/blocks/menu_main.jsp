<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="${spring:mvcUrl('RC#newUser').build()}">Home</a></li>
        <li><a href="${spring:mvcUrl('QC#add').build()}">New</a></li>
        <li><a href="<c:url value='/about' />">About</a></li>
      </ul>
    </div>
  </div>
</nav>