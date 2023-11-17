package org.czp.servlet.pro02;

import org.czp.utils.CharUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        name = CharUtils.fixCharsets(name);
        if(name.equals("曹兆鹏") && password.equals("123456")) {
            HttpSession session = req.getSession();
            session.setAttribute("username", "曹兆鹏");
            resp.sendRedirect("/index.jsp");
        }
        else {
            resp.sendRedirect("/login1");
        }
    }
}
