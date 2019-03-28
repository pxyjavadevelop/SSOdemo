package com.wkcto.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:AddCookieServlet
 * Package:com.wkcto.servlet
 * Description:
 *
 * @date:2019/3/15 0015 下午 10:36
 * PXY
 */
@WebServlet("/addCookie")
public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieName = req.getParameter("cookieName");
        String cookieValue = req.getParameter("cookieValue");
        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setPath("/");
        resp.addCookie(cookie);
        resp.getWriter().print("ok");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
