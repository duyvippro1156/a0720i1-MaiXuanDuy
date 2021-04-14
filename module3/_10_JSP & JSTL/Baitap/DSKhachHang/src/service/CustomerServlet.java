package service;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/index")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Bruno Fernandes", "08-09-1994", "Portugal",
                "image/img.jpg"));
        customerList.add(new Customer("David De Gea", "07-11-1990", "Spain",
                "image/img.jpg"));
        customerList.add(new Customer("Edinson Cavani", "14-02-1987", "Uruguay",
                "image/img.jpg"));
        customerList.add(new Customer("Marcus Rashford", "31-10-1997", "England",
                "image/img2.jpg"));
        customerList.add(new Customer("Fred", "03-05-1993", "Brazil",
                "image/img2.jpg"));
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
