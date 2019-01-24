package com.mitrais.rms.controller;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends AbstractController
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String path = getTemplatePath(req.getServletPath());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String path = getTemplatePath(req.getServletPath());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao dao = UserDaoImpl.getInstance();
        Optional<User> data = dao.findByUserName(username);

        if(data.isPresent())
        {
            User user = data.get();
            if(user.getPassword().equals(password))
            {

                //Create Session
                HttpSession newSession = req.getSession(true);
                newSession.setAttribute("userId",user.getId());

                //set inactive interval 10 mins
                newSession.setMaxInactiveInterval(10*60);

                resp.sendRedirect(req.getContextPath()+ UserServlet.USERLIST_URI);

            }
            else
            {
                req.setAttribute("msg","Password is incorrect");
                requestDispatcher.forward(req,resp);
            }
        }
        else
        {
            req.setAttribute("msg","Username is incorrect");
            requestDispatcher.forward(req,resp);
        }

    }
}
