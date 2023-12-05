<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>Список отпусков</title>
</head>
<body>
<h2>Список отпусков</h2>

<table border="1">
    <tr>
        <th>Код сотрудника</th>
        <th>Отдел</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Дата начала отпуска</th>
        <th>Дата окончания отпуска</th>
        <th>Заработная плата</th>
        <th>Размер отпускных</th>
        <th>Действия</th>
    </tr>

    <c:forEach var="vacation" items="${vacations}">
        <tr>
            <td>${vacation.employeeCode}</td>
            <td>${vacation.department}</td>
            <td>${vacation.lastName}</td>
            <td>${vacation.firstName}</td>
            <td>${vacation.middleName}</td>
            <td>${vacation.startDate}</td>
            <td>${vacation.endDate}</td>
            <td>${vacation.salary}</td>
            <td>${vacation.vacationAllowance}</td>
            <td>
                <a href="editVacation?index=${vacations.indexOf(vacation)}">Изменить</a>
                <a href="deleteVacation?index=${vacations.indexOf(vacation)}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="addVacation" >Добавить работника </a>

<p>Общая сумма отпускных по организации: ${totalVacationAllowance}</p>

<p>Промежуток времени с наименьшим количеством сотрудников в отделе:</p>
<c:forEach var="departmentTime" items="${departmentTimes}">
    <p>${departmentTime}</p>
</c:forEach>
</body>
</html>
