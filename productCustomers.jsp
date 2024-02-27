<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<h2>Welcome to Customers Page</h2>
${message}<br>
<table border="1">
    <tr>
        <th>customerId	</th>
        <th>customerName</th>
        <th>Email</th>
    </tr>

    <c:if test="${!empty CarDelarsList}">
        <c:forEach items="${CarDelarsList}" var="customer">
            <tr>
                <td> <c:out value="${customer.customerId}"/></td>
                <td><c:out value="${customer.customerName}"/></td>
                <td><c:out value="${customer.dept}"/></td>
                <td><c:out value="${customer.price}"/></td>
            </tr>
        </c:forEach>
    </c:if>
</table>