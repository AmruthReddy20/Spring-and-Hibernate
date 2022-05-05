<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
    <title>student Form</title>
    </head>
    <body>
    <form:form action="processForm" modelAttribute="student">
    FirstName:<form:input path ="firstName"/>
    <br><br>
       LastName:<form:input path ="lastName"/>
       <br><br>
       Country:
       <form:select path="country" >
       <form:options items="${student.countries}"/>
       </form:select>

<br><br>
    Favourite Programming Language
    <br>
   C++ <form:radiobutton path="favouriteLanguage"  value="C++"/>
   Java <form:radiobutton path="favouriteLanguage"  value="Java"/>
   Python <form:radiobutton path="favouriteLanguage" value="Python"/>
<br>
<br>
Operating Systems known:
Windows <form:checkbox path="operatingSystems" value="windows"/>
Linux <form:checkbox path="operatingSystems" value="linux"/>
Mac Os<form:checkbox path="operatingSystems" value="macOS"/>
<br>
<br>
    <input type="submit" value="Submit">
    </form:form>
    </body>
</html>