<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body bgcolor="pink">
<h1>Edit Customer Details Here</h1>
<form:form method="GET" action="/manyToMany/editandsave">
   <table>
       <tr>
           <td>Customer Id:</td>
       <td> <form:input path="customerId" type="number" readonly="true" required="true"/></td>
       </tr>
       <tr>
           <td>Customer Name:</td>
       <td> <form:input path="customerName" required="true"/></td>
       </tr>
       <tr>
       <td>Email:</td>
           <td><form:input path="email" required="true"/></td>
       </tr>
       <tr>
       <td><input type="submit" value="submit"/></td>
       </tr>
   </table>
</form:form>
</body>
