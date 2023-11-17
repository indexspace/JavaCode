package org.czp.servlet.pro02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        List<Cake> cart = null;
        boolean pruFlag = true;
        HttpSession session = req.getSession(false);
        if (session == null) {
            pruFlag = false;
        } else {
            cart = (List) session.getAttribute("cart");
            if (cart == null) pruFlag = false;
        }
        if (!pruFlag) {
            out.write("对不起, 你还没有购买任何产品! <br/>");
        } else {
            out.write("您购买的蛋糕有: <br/>");
            double price = 0;
            for (Cake cake : cart) {
                out.write(cake.getName() + "<br/>");
            }

            String repeat = (String) session.getAttribute("repeat");
            if (repeat != null) {
                session.setAttribute("repeat", null);
                out.write("<br/>您重复购买了 " + repeat + ", 将在五秒后跳转至购物界面.....");
                resp.setHeader("refresh", "5;url=/ListCakeServlet");
            }
        }
    }
}