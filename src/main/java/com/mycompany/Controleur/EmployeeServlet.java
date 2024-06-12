package com.mycompany.Controleur;

import com.example.TypesPersonnels.Address;
import com.example.TypesPersonnels.EmployeeId;
import com.example.TypesPersonnels.EmployeeType;
import com.example.ejb.EmployeService;
import com.example.jpa.Employe;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    @EJB
    private EmployeService employeService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer et valider les paramètres
            String nom = request.getParameter("nom");
            String departement = request.getParameter("departement");
            String employeeEmail = request.getParameter("employeeEmail");
            String departmentId = request.getParameter("departmentId");
            String employeeNumberStr = request.getParameter("employeeNumber");
            String employeeTypeStr = request.getParameter("employeeType");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zipCode");

            if (nom == null || departement == null || 
                    employeeEmail == null || departmentId == null || 
                employeeNumberStr == null || employeeTypeStr == null || 
                    street == null || city == null || 
                state == null || zipCode == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, 
                        "All parameters are required.");
                return;
            }

            Long employeeNumber;
            try {
                employeeNumber = Long.parseLong(employeeNumberStr);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "Invalid employee number.");
                return;
            }

            // Création d'un nouvel employé
            Employe employe = new Employe();
            
            EmployeeId id = new EmployeeId();
            id.setDepartmentId(departmentId);
            id.setEmployeeNumber(employeeNumber);
            employe.setId(id);
            
            employe.setNom(nom);
            employe.setDepartement(departement);
            employe.setEmail(employeeEmail); // Assurez-vous de définir l'email
            employe.setEmployeeType(EmployeeType.valueOf(employeeTypeStr));
            
            Address address = new Address();
            address.setStreet(street);
            address.setCity(city);
            address.setState(state);
            address.setZipCode(zipCode);
            employe.setAddress(address);

            employeService.createEmploye(employe);

            response.getWriter().write("Employe created successfully!");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input: "
                    + "" + e.getMessage());
        }
    }
}



