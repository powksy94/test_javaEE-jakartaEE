package com.matthieu;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    
    private final List<Task> tasks = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        out.println("<h1>Ma liste de tâches</h1>");
        out.println("<form method='POST' action='tasks'>");
        out.println("   <input type='text' name='title' placeholder='Nouvelle tâche' required/>");
        out.println("   <button type='submit'>Ajouter</button>");
        out.println("</form><hr/>");

        if (tasks.isEmpty()) {
            out.print("<p>Aucune tâche pour l'instant.</p>");
        } else {
            out.println("<ul>");
            for (Task t : tasks) {
                out.println("<li>" + t.getTitle() + "</li>");
            }
            out.println("</ul>");
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");

        if (title != null && !title.isBlank()) {
            tasks.add(new Task(title));
        }

        resp.sendRedirect(req.getContextPath() + "/tasks");
    }
}
