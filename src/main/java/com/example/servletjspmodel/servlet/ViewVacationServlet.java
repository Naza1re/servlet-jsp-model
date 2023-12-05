package com.example.servletjspmodel.servlet;
import com.example.servletjspmodel.manager.VacationManager;
import com.example.servletjspmodel.model.EmployeeVacation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewVacation")
public class ViewVacationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<EmployeeVacation> vacations = VacationManager.getAllVacations();
        request.setAttribute("vacations", vacations);

        int total = vacations.stream().mapToInt(v -> (int) v.getSalary()).sum();
        request.setAttribute("totalVacationAllowance", total);
        
        Map<String, List<EmployeeVacation>> vacationsByDepartment = vacations.stream()
                .collect(Collectors.groupingBy(EmployeeVacation::getDepartment));

        List<String> departmentTimes = new ArrayList<>();

        vacationsByDepartment.forEach((department, departmentVacations) -> {
            Optional<LocalDate> minEndDate = departmentVacations.stream()
                    .map(vacation -> vacation.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                    .min(LocalDate::compareTo);

            Optional<LocalDate> maxStartDate = departmentVacations.stream()
                    .map(vacation -> vacation.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                    .max(LocalDate::compareTo);

            if (minEndDate.isPresent() && maxStartDate.isPresent()) {
                String timePeriod = maxStartDate.get() + " - " + minEndDate.get();
                departmentTimes.add(department + ": " + timePeriod);
            }
        });

        request.setAttribute("departmentTimes", departmentTimes);

        request.getRequestDispatcher("viewVacation.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
