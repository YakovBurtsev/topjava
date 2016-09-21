<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meal list</title>
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }

        .filter-column {
            display: inline-block;
            text-align: left;
            margin-right: 10px;
        }

        .filter-row {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h3>Meal list</h3>
    <a href="meals?action=create">Add Meal</a>
    <hr>
    <form method="get" action="meals">
        <div class="filter">
            <input type="hidden" name="action" value="filter">
            <div class="filter-column">
                <div class="filter-row">
                    <label for="startDate">From Date:</label>
                    <input type="date" name="startDate" id="startDate">
                </div>
                <div class="filter-row">
                    <label for="startTime">From Time:</label>
                    <input type="time" name="startTime" id="startTime">
                </div>
            </div>
            <div class="filter-column">
                <div class="filter-row">
                    <label for="endDate">To Date:</label>
                    <input type="date" name="endDate" id="endDate">
                </div>
                <div class="filter-row">
                    <label for="endTime">To Time:</label>
                    <input type="time" name="endTime" id="endTime">
                </div>
            </div>
        </div>
        <button style="margin-top: 15px" type="submit">Filter</button>
    </form>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.to.MealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                        ${fn:formatDateTime(meal.dateTime)}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>