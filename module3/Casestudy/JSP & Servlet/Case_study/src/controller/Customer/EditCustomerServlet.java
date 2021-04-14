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

@WebServlet(name = "EditCustomerServlet", urlPatterns = "/editCustomer")
public class EditCustomerServlet extends HttpServlet {
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
        this.customerService.update(id,customer);
        response.sendRedirect("listCustomer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("jsp/customer/edit.jsp").forward(request, response);
    }
}
