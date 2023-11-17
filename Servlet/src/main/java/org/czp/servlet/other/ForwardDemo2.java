package org.czp.servlet.other;

import org.czp.utils.CharUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to")
public class ForwardDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html; charset=UTF-8");
        ServletContext context = getServletContext();

        String id = (String) req.getAttribute("id");
        String userInfo = context.getInitParameter("id=" + id);
        resp.getWriter().write("<h1>id=" + id + ", userInfo=" + userInfo + "</h1>");
    }
}
