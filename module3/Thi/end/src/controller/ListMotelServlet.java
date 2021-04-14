package controller;

import model.Motel;
import service.IMotelService;
import service.Impl.MotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListMotelServlet", urlPatterns = "/listMotel")
public class ListMotelServlet extends HttpServlet {
    private IMotelService motelService = new MotelServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Motel> motel = null;
        try {
            motel = motelService.getAllMotel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listMotel", motel);
        request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
    }
}
