package org.czp.servlet.other;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/download")
public class RefererDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html; charset=UTF-8");

        String referer = req.getHeader("referer");
        if(referer.startsWith("http://localhost:8080/ServletCzp/")) {
            resp.getWriter().write("<h1>downloading...</h1>");
        }
        else{
            resp.getWriter().write("<h1>error!</h1>");
        }
    }
}
