package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = "/create")
public class CreateServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String producer = request.getParameter("producer");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        Product product = new Product(id, name, price, producer, description);
        this.productService.save(product);
        response.sendRedirect("list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("JSP/create.jsp").forward(request, response);
    }
}
