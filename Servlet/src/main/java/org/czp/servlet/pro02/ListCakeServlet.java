package org.czp.servlet.pro02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "ListCakeServlet", urlPatterns = "/ListCakeServlet")
public class ListCakeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Collection<Cake> cakes = CakeDB.getAllCake();
        for (Cake cake: cakes) {
            String url = "/PurchaseServlet?id=" + cake.getId();
            out.write(cake.getName() + " <a href='" + url + "'>点击购买</a> <br/>");
        }
    }
}
