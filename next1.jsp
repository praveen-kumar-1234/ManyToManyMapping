<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<center>
    <h2>Welcome to Product List Page</h2>
    ${message}<br>
   <%-- ${productList}<br><hr> --%>
    <a href="/manyToMany/">Home Page</a><br><br>
    <table border="1">
        <tr>
            <th>PRODUCT ID</th>
            <th>PRODUCT Name</th>
            <th>DEPT</th>
            <th>EMAIL</th>
            <th>ADD CUSTOMER</th>
            <th>DELETE PRODUCT</th>
        </tr>

        <c:if test="${!empty productList}">
            <c:forEach items="${productList}" var="prod">
                <tr>
                    <td> <c:out value="${prod.productId}"/></td>
                    <td><c:out value="${prod.productName}"/></td>
                    <td><c:out value="${prod.dept}"/></td>
                    <td><c:out value="${prod.price}"/></td>
                    <td>
                        <a href="/productControl/AddCustomers?productId=${prod.productId}"> Add Customers </a>
                    </td>
                    <td>
                        <a href="/productControl/viewProductCustomers?productId=${prod.productId}">View Product Customers </a>
                    <td>
                    <td>
                     <a href="/productControl/editProduct?productId=${prod.productId}">Edit Product</a>
                    </td>
                    <td>
                        <a href="/productControl/deleteProduct?productId=${prod.productId}">Delete Product along with Customers</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</center>