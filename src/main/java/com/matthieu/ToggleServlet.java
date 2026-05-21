package com.matthieu;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/toggle")
public class ToggleServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Task> tasks = (List<Task>) getServletContext().getAttribute("tasks");

        int index = Integer.parseInt(req.getParameter("index"));
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setDone(!task.isDone());
        }

        resp.sendRedirect(req.getContextPath() + "/tasks");
    }
}
