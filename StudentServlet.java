package edu.deakin.studentanalytics;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String studentName = request.getParameter("studentName");

        // Mock analytics logic (hardcoded)
        String trend;
        switch (studentName.toLowerCase()) {
            case "alice":
                trend = "Strong in Science, needs improvement in History.";
                break;
            case "bob":
                trend = "Improving in Math, needs focus on English.";
                break;
            default:
                trend = "General improvement across subjects, monitor consistency.";
        }

        request.setAttribute("studentName", studentName);
        request.setAttribute("trend", trend);

        RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
        dispatcher.forward(request, response);
    }
}
