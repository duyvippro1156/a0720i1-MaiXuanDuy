package controller;

import service.IMotelService;
import service.Impl.MotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteMotelServlet", urlPatterns = "/deleteMotel")
public class DeleteMotelServlet extends HttpServlet {
    private IMotelService motelService = new MotelServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            motelService.deleteMotel(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("listMotel");
    }

}
