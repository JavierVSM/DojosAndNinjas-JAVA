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
  <h1 class="my-3">New Dojo</h1>

  <form:form class="form" action="/dojos" method="post" modelAttribute="dojo">
    <div class="form-group row">
      <form:errors path="name" class="errors"></form:errors>
      <form:label path="name">Dojo Name:</form:label>
      <form:input type="text" path="name"/>
    </div>
    <input type="submit" class="my-3 btn btn-danger" value="Create"/>
  </form:form>
  <table class="table">
    <tr class="table-info">
      <th>Location</th>
      <th>Actions</th>
    </tr>
    <c:forEach items="${dojos}" var="dojo">
      <tr>
        <td><c:out value="${dojo.name}"/></td>
        <td><a href='/dojos/<c:out value="${dojo.id}"/>'>See Students</a></td>
      </tr>
    </c:forEach>
  </table>
</div>       
</body>
</html>