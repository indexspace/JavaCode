package org.czp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login1")
public class Login1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setIntHeader("refresh", 10);
        resp.getWriter().write("<form method=\"post\" action=\"/ServletCzp/login2\">" +
                "        姓名<input type=\"text\" name=\"name\"><br/>" +
                "        密码<input type=\"text\" name=\"password\"><br/>" +
                "        <input type=\"submit\">" +
                "    </form>");
    }
}
