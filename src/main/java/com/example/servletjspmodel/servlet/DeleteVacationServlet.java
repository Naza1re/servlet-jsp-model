package com.example.servletjspmodel.servlet;

import com.example.servletjspmodel.manager.VacationManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteVacation")
public class DeleteVacationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        VacationManager.deleteVacation(index);
        response.sendRedirect("viewVacation");
    }
}
