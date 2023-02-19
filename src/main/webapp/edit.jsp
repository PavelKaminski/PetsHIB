<%--
  Created by IntelliJ IDEA.
  User: Pasha
  Date: 06.02.2023
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pets</title>
</head>
<body>
<h2>Edit information about selected pet, please:</h2>
<br/>
<form name="EditForm" method="post" action="engine">
    <fieldset style="width: 300px">
        <legend>Edit</legend>
    <input type="hidden" name="command" value="edit"><br/>
    <input type="hidden" name="id" value="${pet.petId}">
    Species: <input type="text" name="species" value="${pet.petSpecies}"/>
    <p></p>
    Name: <input type="text" name="name" value="${pet.petName}"/>
    <p></p>
    Age: <input type="text" name="age" value="${pet.petAge}"/>
    <p></p>
    Color: <input type="text" name="color" value="${pet.petColor}"/>
    <p></p>
    Owner: <input type="text" name="owner" value="${pet.petOwner}">
    <p></p>
    <input type="submit" value="Edit" style="font-weight: bold">
    </fieldset>
</form>
<br/>
<br/>
<a href="/PetsHIB/main.html">Return to main</a>
</body>
</html>
