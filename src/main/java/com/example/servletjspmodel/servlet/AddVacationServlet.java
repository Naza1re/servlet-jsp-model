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

@WebServlet("/addVacation")
public class AddVacationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmployeeVacation vacation = new EmployeeVacation();
        vacation.setEmployeeCode(request.getParameter("employeeCode"));
        vacation.setDepartment(request.getParameter("department"));
        vacation.setLastName(request.getParameter("lastName"));
        vacation.setFirstName(request.getParameter("firstName"));
        vacation.setMiddleName(request.getParameter("middleName"));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(request.getParameter("startDate"));
            Date endDate = dateFormat.parse(request.getParameter("endDate"));

            // Check for date validation
            if (startDate.after(endDate)) {
                // Handle the case where the start date is after the end date
                response.sendRedirect("addVacation.jsp?error=startAfterEnd");
                return;
            }

            vacation.setStartDate(startDate);
            vacation.setEndDate(endDate);
        } catch (ParseException e) {
            // Handle the case where date parsing fails
            response.sendRedirect("addVacation.jsp?error=dateParsing");
            return;
        }

        // Check for non-negative salary
        try {
            double salary = Double.parseDouble(request.getParameter("salary"));
            if (salary < 0) {
                // Handle the case where salary is negative
                response.sendRedirect("addVacation.jsp?error=negativeSalary");
                return;
            }
            vacation.setSalary(salary);
        } catch (NumberFormatException e) {
            // Handle the case where salary parsing fails
            response.sendRedirect("addVacation.jsp?error=salaryParsing");
            return;
        }

        VacationManager.addVacation(vacation);
        response.sendRedirect("viewVacation");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addVacation.jsp").forward(req, resp);
    }
}
