<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Редактирование отпуска</title>
</head>
<body>
<h2>Редактирование отпуска</h2>

<form action="editVacation" method="post">
    <input type="text" name="index" value="${index}">
    <label>Код сотрудника: <input type="text" name="employeeCode" value="${vacation.employeeCode}" readonly></label><br>
    <label>Отдел: <input type="text" name="department" value="${vacation.department}"></label><br>
    <label>Фамилия: <input type="text" name="lastName" value="${vacation.lastName}"></label><br>
    <label>Имя: <input type="text" name="firstName" value="${vacation.firstName}"></label><br>
    <label>Отчество: <input type="text" name="middleName" value="${vacation.middleName}"></label><br>
    <label>Дата начала отпуска: <input type="date" name="startDate" value="${vacation.startDate}"></label><br>
    <label>Дата окончания отпуска: <input type="date" name="endDate" value="${vacation.endDate}"></label><br>
    <label>Заработная плата: <input type="text" name="salary" value="${vacation.salary}"></label><br>
    <input type="submit" value="Обновить отпуск">
</form>

<a href="viewVacation">Назад к списку отпусков</a>
</body>
</html>
