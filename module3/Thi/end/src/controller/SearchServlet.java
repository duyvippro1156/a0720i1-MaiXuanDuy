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

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private IMotelService motelService = new MotelServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Motel> motel = null;
        try {
            motel = this.motelService.findByNameCustomer(search);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listMotel", motel);
        request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
