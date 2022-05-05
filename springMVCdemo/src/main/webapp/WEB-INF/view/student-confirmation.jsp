<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <title>student Form</title>
    </head>
    <body>
    The Student is confirmed:${student.firstName} ${student.lastName}
    <br>
    <br>
    Country:${student.country}
    <br>
    <br>
    Favourite Language is ${student.favouriteLanguage}
    <br><br>
    Known Operating Systems:
    <ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
    <li>${temp}</li>
    </c:forEach>
    </ul>

    </body>
</html>