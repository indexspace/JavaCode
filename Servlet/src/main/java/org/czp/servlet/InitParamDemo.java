package org.czp.servlet;

import org.czp.utils.CharUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InitParamDemo extends HttpServlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html; charset=UTF-8");

        String name = this.config.getInitParameter("name");
        String password = this.config.getInitParameter("password");
        String charset = this.config.getInitParameter("charset");

        resp.getWriter().write("<h1>name="+name+"<h1>");
        resp.getWriter().write("<h1>password="+password+"<h1>");
        resp.getWriter().write("<h1>charset="+charset+"<h1>");
    }
}
