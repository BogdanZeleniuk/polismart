package com.insurance.polismart.web;

import com.insurance.polismart.LoggedUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 06.07.2016.
 */
public class UserServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("userList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.valueOf(req.getParameter("userId"));
        LoggedUser.setId(userId);
        resp.sendRedirect("insurance");
    }
}
