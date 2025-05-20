package net.codejava.javaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello") // <-- This makes the servlet accessible at /hello
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String yourName = request.getParameter("yourName");
        response.setContentType("text/html"); // <-- Always set content type
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<html><body>");
            writer.println("<h1>Hello, " + yourName + "!</h1>");
            writer.println("</body></html>");
        }
    }

    // Optional: handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // Redirect GET to POST for simplicity
    }
}
