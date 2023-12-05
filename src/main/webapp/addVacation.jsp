<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Добавление отпуска</title>
</head>
<body>
<h2>Добавление отпуска</h2>

<%-- Показать ошибки (если они есть) --%>
<c:if test="${not empty errors}">
    <p style="color: red;">Ошибка(и):</p>
    <ul>
        <c:forEach var="error" items="${errors}">
            <li>${error}</li>
        </c:forEach>
    </ul>
</c:if>

<form action="addVacation" method="post">
    <label>Код сотрудника: <input type="text" name="employeeCode"></label><br>
    <label>Отдел: <input type="text" name="department"></label><br>
    <label>Фамилия: <input type="text" name="lastName"></label><br>
    <label>Имя: <input type="text" name="firstName"></label><br>
    <label>Отчество: <input type="text" name="middleName"></label><br>
    <label>Дата начала отпуска: <input type="date" name="startDate"></label><br>
    <label>Дата окончания отпуска: <input type="date" name="endDate"></label><br>
    <label>Заработная плата: <input type="text" name="salary"></label><br>
    <label>Заработная плата: <input type="text" name="alloyens"></label><br>
    <!-- Добавьте другие поля, если необходимо -->
    <input type="submit" value="Добавить отпуск">
</form>

<a href="viewVacation">Назад к списку отпусков</a>
</body>
</html>
