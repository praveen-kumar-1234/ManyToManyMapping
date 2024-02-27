<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<h2>Welcome to Products Page</h2>
${message}<br>
<table border="1">
    <tr>
        <th>productId	</th>
        <th>productName</th>
        <th>dept</th>
        <th>price</th>
    </tr>

    <c:if test="${!empty CarDelarsList}">
        <c:forEach items="${CarDelarsList}" var="product">
            <tr>
                <td> <c:out value="${product.productId}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.dept}"/></td>
                <td><c:out value="${product.price}"/></td>
            </tr>
        </c:forEach>
    </c:if>
</table>