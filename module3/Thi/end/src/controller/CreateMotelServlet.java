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

@WebServlet(name = "CreateMotelServlet", urlPatterns = "/createMotel")
public class CreateMotelServlet extends HttpServlet {
    private IMotelService motelService = new MotelServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name_customer = request.getParameter("name_customer");
        String phone_number = request.getParameter("phone_number");
        String date_begin = request.getParameter("date_begin");
        int id_payment = Integer.parseInt(request.getParameter("id_payments"));
        String note = request.getParameter("note");
        Motel motel = new Motel(name_customer,phone_number,date_begin,id_payment,note);
        try {
            this.motelService.saveMotel(motel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("listMotel");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/create.jsp").forward(request, response);
    }
}
