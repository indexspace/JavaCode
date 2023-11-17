package org.czp.servlet.pro02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet", urlPatterns = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null) { resp.sendRedirect("ListCakeServlet"); return;}

        Cake cake = CakeDB.getCakeById(id);
        HttpSession session = req.getSession();
        List<Cake> cart = (List) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Cake>();
            session.setAttribute("cart", cart);
        }
        if(cart.contains(cake)) session.setAttribute("repeat", cake.getName());
        else cart.add(cake);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("/Servlet");
        resp.addCookie(cookie);
        resp.sendRedirect("CartServlet");
    }
}
