package controller.Employee;

import model.Customer;
import model.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListEmployeeServlet", urlPatterns = "/listEmployee")
public class ListEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.findAll();
        request.setAttribute("listEmployee", employees);
        request.getRequestDispatcher("jsp/employee/list.jsp").forward(request, response);
    }
}
