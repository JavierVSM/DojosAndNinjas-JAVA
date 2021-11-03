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
	
	  <a href="dojos">Dashboard</a>
	  <h1  class="my-3">New Ninja</h1>

	  <form:form class="form" action="/newNinja" method="post" modelAttribute="ninja">
	
	    <div class="form-group row">
	      <form:label path="first_name">First Name:</form:label>
	      <form:input type="text" path="first_name"/>
	    </div>
	    <div class="form-group row">
	      <form:label path="last_name">Last Name:</form:label>
	      <form:input type="text" path="last_name"/>
	    </div>
	    <div class="form-group row">
	      <form:label path="age">Age:</form:label>
	      <form:input type="number" path="age"/>
	    </div>
	   
	    
	  <div class="form-group row">
	      <form:label path="dojo">Select Dojo:</form:label>
		  	  <form:select path="dojo">
		    	<c:forEach items="${dojos}" var="dojo">
		      		<form:option value="${dojo.id}" label="${dojo.name}"/>
		      	</c:forEach>
		      </form:select> 
	 </div>
	 
	    <input type="submit" class="my-3 btn btn-danger" value="Create"/>
	  </form:form>
	</div>
	
</body>
</html>