package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

public class ControllerServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(ControllerServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/jsp/Tsetik.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getQueryString() != null) {
            getServletContext().getRequestDispatcher("/check").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/jsp/Tsetik.jsp").forward(request, response);
        }
    }
}