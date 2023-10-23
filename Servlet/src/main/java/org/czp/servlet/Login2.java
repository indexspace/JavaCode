package org.czp.servlet;

import org.czp.utils.CharUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login2")
public class Login2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        name = CharUtils.fixCharsets(name);
        System.out.println("password = " + password);
        if(name.equals("曹兆鹏") && password.equals("123456")) {
            resp.sendRedirect("/ServletCzp/index.jsp");
        }
        else {
            resp.sendRedirect("/ServletCzp/login1");
        }
    }
}
