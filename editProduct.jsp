<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body bgcolor="pink">
<h1>Edit Student Details Here</h1>
<form:form method="GET" action="/productControl/editandsave">
    <table>
           <tr>
               <td>Product ID </td>
               <td> <form:input path="productId" readOnly= "true"/> </td>
           </tr>
           <tr>
               <td>Product Name </td>
               <td> <form:input path="productName" required="true"/></td>
           </tr>
           <tr>
               <td>Dept</td>
               <td><form:input path="dept" required="true"/></td>
           <tr>
           <tr>
               <td>Price</td>
               <td><form:input path="price" required="true"/></td>
           </tr>
               <td col span="2"> <input type="submit" value="SUBMIT"> </td>
           </tr>
       </table>
</form:form>
</body>
