package controller.Customer;

import model.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateCustomerServlet", urlPatterns = "/createCustomer")
public class CreateCustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("mail");
        String address = request.getParameter("address");
        int idTypeCustomer = Integer.parseInt(request.getParameter("id_type_customer"));
        Customer customer = new Customer(id, idTypeCustomer,name, birthday, gender, idCard, phoneNumber,email, address);
        this.customerService.save(customer);
        response.sendRedirect("listCustomer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/customer/create.jsp").forward(request, response);
    }
}
