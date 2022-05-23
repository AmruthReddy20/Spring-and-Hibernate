<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
    <head>
    <title>Company Home Page</title>
    </head>
    <body>
    <h2>Company Home Page</h2>
    <p>
    User:<security:authentication property="principal.username"/>

    <br><br>
    Role(s):<security:authentication property="principal.authorities"/>
    </p>
    <hr>
    Welcome to company home page!<br><br>
    <security:authorize access="hasRole('MANAGER')">
    <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
    Only fro Mangaer people
    <br>
    </security:authorize>

      <security:authorize access="hasRole('ADMIN')">
     <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
        Only fro Admin  people

            </security:authorize>
        <br>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">

    <input type="submit" value="logout"/>
    </form:form>
    </body>
</html>