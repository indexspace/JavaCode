package org.czp.servlet.other;


import org.czp.utils.CharUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/user")
public class HttpServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html; charset=UTF-8");

        String name = CharUtils.fixCharsets(req.getParameter("name"));
        String gender = CharUtils.fixCharsets(req.getParameter("gender"));

        resp.getWriter().write("<h1>"+name+"<h1>"+"<br/>"+"<h1>"+gender+"<h1>");
    }
}
