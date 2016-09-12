<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://topjava.ru" %>
<html>
<head>
    <title>Meal list</title>
    <link href="mealList.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>

<c:if test="${!empty mealList}">
    <table class="mealList">
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${mealList}" var="meal">
            <tr class="${meal.exceed ? 'exceed' : 'no-exceed'}">
                <td>${f:formatter(meal.dateTime)}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=edit&id=<c:out value="${meal.id}"/>">Править</a></td>
                <td><a href="meals?action=delete&id=<c:out value="${meal.id}"/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<p><a href="meals?action=insert">Add meal</a></p>

</body>
</html>
