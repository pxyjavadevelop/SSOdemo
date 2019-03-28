package com.wkcto.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:CheckLoginServlet
 * Package:com.wkcto.servlet
 * Description:
 *
 * @date:2019/3/15 0015 下午 9:46
 * PXY
 */
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieName = req.getParameter("cookieName");
        String cookieValue = req.getParameter("cookieValue");
        if ("ssoCookie".equals(cookieName) && "sso".equals(cookieValue)) {
            resp.getWriter().print("1");
        } else {
            resp.getWriter().print("0");
        }
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
