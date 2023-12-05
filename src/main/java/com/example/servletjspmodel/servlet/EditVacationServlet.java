package com.example.servletjspmodel.servlet;

import com.example.servletjspmodel.manager.VacationManager;
import com.example.servletjspmodel.model.EmployeeVacation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editVacation")
public class EditVacationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        EmployeeVacation vacation = VacationManager.getAllVacations().get(index);

        // Обновление данных отпуска
        vacation.setDepartment(request.getParameter("department"));
        vacation.setLastName(request.getParameter("lastName"));
        vacation.setFirstName(request.getParameter("firstName"));
        vacation.setMiddleName(request.getParameter("middleName"));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(request.getParameter("startDate"));
            vacation.setStartDate(startDate);

            Date endDate = dateFormat.parse(request.getParameter("endDate"));
            vacation.setEndDate(endDate);
        } catch (ParseException e) {
            e.printStackTrace(); // Логирование ошибки конвертации даты
        }

        double salary = Double.parseDouble(request.getParameter("salary"));
        vacation.setSalary(salary);
        System.out.println(vacation);
        System.out.println(index);
        VacationManager.editVacation(index, vacation);
        response.sendRedirect("viewVacation");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = Integer.parseInt(req.getParameter("index"));
        System.out.println(index);
        req.setAttribute("vacation",VacationManager.getVacationById(index));
        req.setAttribute("index",index);
        req.getRequestDispatcher("editVacation.jsp").forward(req, resp);
    }
}
