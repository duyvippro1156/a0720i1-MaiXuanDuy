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

@WebServlet(name = "EditEmployeeServlet", urlPatterns = "/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("mail");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        int id_level_employee = Integer.parseInt(request.getParameter("education_degree_id"));
        int id_position_employee = Integer.parseInt(request.getParameter("position"));
        int id_department_employee = Integer.parseInt(request.getParameter("division"));
        Employee employee =new Employee(id,name,birthday,idCard,salary,phoneNumber,email,address,id_position_employee,id_level_employee, id_department_employee);
        this.employeeService.update(id,employee);
        response.sendRedirect("listEmployee");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("jsp/employee/edit.jsp").forward(request, response);

    }
}
