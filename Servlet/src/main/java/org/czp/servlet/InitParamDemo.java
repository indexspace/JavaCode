package org.czp.servlet;

import org.czp.utils.CharUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class InitParamDemo extends HttpServlet {

    private ServletConfig config;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html; charset=UTF-8");

        String name = getServletConfig().getInitParameter("name");
        String password = getServletConfig().getInitParameter("password");
        String charset = getServletConfig().getInitParameter("charset");
        Enumeration<String> initParameterNames = getServletConfig().getInitParameterNames();
        String servletName = getServletConfig().getServletName();


        resp.getWriter().write("<h1>用getInitParameter获取参数name="+name+"<h1>");
        resp.getWriter().write("<h1>用getInitParameter获取参数password="+password+"<h1>");
        resp.getWriter().write("<h1>用getInitParameter获取参数charset="+charset+"<h1>");
        resp.getWriter().write("<h1>用getServletName获取servletName="+servletName+"<h1>");


        resp.getWriter().write("<h3>=================开始用getInitParameterNames获取参数===============<h3>");
        while(initParameterNames.hasMoreElements()) {
            String key = initParameterNames.nextElement();
            String value = getInitParameter(key);
            resp.getWriter().write("<h1>"+key+"="+value+"<h1>");
        }
        resp.getWriter().write("<h3>============================end============================<h3>");

    }
}
