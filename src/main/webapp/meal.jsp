<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://topjava.ru" %>
<html>
<head>
    <title>Add/Edit meal</title>
</head>
<body>
<form method="post" name="formMeal">
    <br>
    <label>
        date
        <input type="datetime-local" name="datetime" value="${meal.dateTime}"/>
    </label>
    <br>
    <label>
        description
        <input type="text" name="description" value="<c:out value="${meal.description}"/>"/>
    </label>
    <br>
    <label>
        calories
        <input type="number" name="calories" value="<c:out value="${meal.calories}"/>"/>
    </label>
    <br>
    <input type="submit" value="Отправить">
</form>
</body>
</html>
