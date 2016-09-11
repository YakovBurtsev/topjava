<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://topjava.ru" %>
<html>
<head>
    <title>Meal list</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css">
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
                <td>${f:formatter(meal.dateTime, 'yyyy-MM-dd HH:mm')}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
