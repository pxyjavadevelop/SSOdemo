package com.wkcto.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:LoginServlet
 * Package:com.wkcto.servlet
 * Description:
 *
 * @date:2019/3/15 0015 下午 9:57
 * PXY
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        URL url = new URL("http://www.login.com:8080/ssoLoginCheck/login?username=" + username + "&password=" + password);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String temp = "";
        StringBuffer stringBuffer = new StringBuffer();
        while ((temp = bufferedReader.readLine()) != null) {
            stringBuffer.append(temp);
        }
        if ("1".equals(stringBuffer.toString())) {
            Cookie cookie = new Cookie("ssoCookie","sso");
            cookie.setPath("/");
            resp.addCookie(cookie);
            List<String> list = new ArrayList<>();
            list.add("http://www.demo02.com:8080/ssoDemo02/addCookie?cookieName=ssoCookie&cookieValue=sso");
            req.getSession().setAttribute("addCookieList","list");
            resp.sendRedirect("demo.jsp");
        } else {
            System.out.println("Login Fail......");
        }
    }
}
