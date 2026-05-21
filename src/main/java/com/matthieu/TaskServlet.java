package com.matthieu;

import freemarker.template.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    
    
    private Configuration fmConfig;

    @Override
    public void init() throws ServletException {
        fmConfig = new Configuration(Configuration.VERSION_2_3_33);
        fmConfig.setServletContextForTemplateLoading(
            getServletContext(), "/WEB-INF/templates"
        );
        fmConfig.setDefaultEncoding("UTF-8");

        getServletContext().setAttribute("tasks", new ArrayList<Task>());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<Task> tasks = (List<Task>) getServletContext().getAttribute("tasks");
        
        Map<String, Object> model = new HashMap<>();
        model.put("tasks", tasks);

        Template template = fmConfig.getTemplate("tasks.ftl");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");

        List<Task> tasks = (List<Task>) getServletContext().getAttribute("tasks");

        if (title != null && !title.isBlank()) {
            tasks.add(new Task(title));
        }

        resp.sendRedirect(req.getContextPath() + "/tasks");
    }
}
