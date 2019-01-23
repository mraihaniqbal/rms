package com.mitrais.rms.controller;

import com.mitrais.rms.helper.GeneralHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends AbstractController
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(!GeneralHelper.isLoggedIn(req)){
            req.setAttribute("msg","You are not allowed to access the page.");
        }else{
            HttpSession session = req.getSession(false);
            session.invalidate();

            req.setAttribute("msg","You have successfully logout from application");
        }

        resp.sendRedirect(BASE_URI);

    }
}
