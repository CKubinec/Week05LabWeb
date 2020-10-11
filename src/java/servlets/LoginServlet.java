package servlets;

import models.AccountService;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (request.getParameter("logout") != null) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "You have successfully logged out");
        }
        if (session.getAttribute("user") != null){
            response.sendRedirect("home");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService account = new AccountService();
        HttpSession session = request.getSession(false);
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

         if (userName != null && password != null) {
            if (account.login(userName, password) != null) {
                User user = account.login(userName, password);
                session.setAttribute("user", user);
                response.sendRedirect("home");
            } else {
                request.setAttribute("username", userName);
                request.setAttribute("password", password);
                request.setAttribute("message", "Username/password don't match");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("username", userName);
            request.setAttribute("password", password);
            request.setAttribute("message", "Both name and password must be filled in");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
