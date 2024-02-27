<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<center>

    <h1>Welcome to Add Product Page </h1>
    <form:form action="/productControl/saveProduct" method="post" modelAttribute="productModel">
<table>
    <tr>
        <td>Product Id:</td>
    <td> <form:input path="productId" type="number" readonly="true" required="true"/></td>
    </tr>
    <tr>
        <td>Product Name:</td>
    <td> <form:input path="productName" required="true"/></td>
    </tr>
    <tr>
    <td>Dept:</td>
        <td><form:input path="dept" required="true"/></td>
    </tr>
    <tr>
    <td>Price:</td>
    <td><form:input path="price" required = "true"/></td>
    </tr>
    <tr>
    <td><input type="submit" value="submit"/></td>
    </tr>
</table>
</form:form>
</center>