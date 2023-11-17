package org.czp.servlet.other;

import org.czp.utils.CharUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ConfigAndContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-type", "text/html; charset=UTF-8");

        resp.getWriter().write("<h1>"+"config:"+"</h1>");
        ServletConfig config = getServletConfig();
        Enumeration<String> configParam = config.getInitParameterNames();
        while(configParam.hasMoreElements()) {
            String key = configParam.nextElement();
            String value = config.getInitParameter(key);
            resp.getWriter().write("<h3>"+key+"="+value+"<h3>");
        }

        resp.getWriter().write("<h1>"+"context:"+"</h1>");
        ServletContext context = getServletContext();
        Enumeration<String> contextParam = context.getInitParameterNames();
        while(contextParam.hasMoreElements()) {
            String key = contextParam.nextElement();
            String value = context.getInitParameter(key);
            resp.getWriter().write("<h3>"+key+"="+value+"<h3>");
        }

        Integer cnt = (Integer) context.getAttribute("cnt");
        if (cnt == null) cnt = 1;
        else cnt++;
        context.setAttribute("cnt", cnt);
        resp.getWriter().write("<h2><i>访问网页次数:"+cnt+"</i></h2>");

    }
}
