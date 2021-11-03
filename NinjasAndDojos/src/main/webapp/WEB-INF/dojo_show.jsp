<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

<div class="container">

  <a href="/dojos">Dashboard</a>
  <a href="/ninjas">Register a new Ninja</a>
  <h1 class="my-3"><c:out value="${dojo.name}"/> Ninjas</h1>
  
    <table class="table">
    <tr class="table-info">
      <th>First Name</th>
      <th>Second Name</th>
      <th>Age</th>
    </tr>
    <c:forEach items="${ninjas}" var="ninja">
      <tr>
        <td><c:out value="${ninja.first_name}"/></td>
        <td><c:out value="${ninja.last_name}"/></td>
        <td><c:out value="${ninja.age}"/></td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>