<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Order with in Price Range Report</h2>		
		<form:form action="FetchRecordsWithinDateRange.html" modelAttribute="billRangeObj">
			<table border="2">
				<tr>
					<td>From Price:<form:input path="fromPrice" /> </td>
					<td>To Price:<form:input path="toPrice" /> </td>
				</tr>	
			</table>
			<br>
			<input type="submit" value="Fetch Details">
			<br>
			<br>
			<br>
			<c:if test="${not empty pizzaOrderList}">
				
				<table border="2">
				<tr>
					<th>Order Id</th><th>Customer Name</th><th>PizzaId</th><th>Bill</th><th>Quantity</th>
				</tr>
				
				<c:forEach items="${pizzaOrderList}" var="itr">
				<tr>
					<td><c:out value="${itr.orderId}"/> </td>
					<td><c:out value="${itr.customerName}"/> </td>
					<td><c:out value="${itr.pizzaId}"/></td>
					<td> <fmt:formatNumber value="${itr.bill}" type="currency" currencySymbol="INR." ></fmt:formatNumber>
					</td>
					<td><c:out value="${itr.numberOfPiecesOrdered}"/></td>
				</tr>
				</c:forEach>
				
			</table>
			
			</c:if>
			<br/>
			<a href="${pageContext.request.contextPath}/index.jsp">
			Home</a>
		</form:form>

	</center>
</body>
</html>