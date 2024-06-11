package com.mycompany.Controleur;

import com.example.ejb.EmployeService;
import com.example.jpa.Employe;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list-employes")
public class ListEmployeServlet extends HttpServlet {

    @EJB
    private EmployeService employeService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employe> employes = employeService.findAllEmployes();
        
        // Debugging: Print the list of employees to the console
        for (Employe employe : employes) {
            System.out.println("Name: " + employe.getNom());
            System.out.println("Department: " + employe.getDepartement());
            System.out.println("Email: " + employe.getEmail());
            System.out.println("Type: " + employe.getEmployeeType());
            System.out.println("Address: " + employe.getAddress().getStreet() + ", " + employe.getAddress().getCity() + ", " +
                               employe.getAddress().getState() + ", " + employe.getAddress().getZipCode());
            System.out.println("----------------------------------------");
        }

        request.setAttribute("employes", employes);
        request.getRequestDispatcher("/listEmployes.jsp").forward(request, response);
    }
}
