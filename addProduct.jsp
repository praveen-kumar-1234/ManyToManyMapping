<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h2>Welcome TO Add Products Page</h2>
<br><hr>



<form:form action="/manyToMany/saveProducts" method="post" modelAttribute="productModel">
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