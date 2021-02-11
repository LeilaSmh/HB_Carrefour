    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.daoDepartement;
import com.dao.daoEmploye;
import com.entity.Departement;
import com.entity.Employe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class Controller extends HttpServlet {

    private daoDepartement daoDept = new daoDepartement();
    private daoEmploye daoEmp = new daoEmploye();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("Departements")) {
            this.Departements(request, response);
        } else if (action.equalsIgnoreCase("addEmp")) {
            this.addEmploye(request, response);
        } else if (action.equalsIgnoreCase("saveEmp")) {
            this.saveEmploye(request, response);
        } else if (action.equalsIgnoreCase("employes")) {
            this.Employes(request, response);
        } else if (action.equalsIgnoreCase("empsByDept")) {
            this.EmpsByDept(request, response);
        } else if (action.equalsIgnoreCase("addDept")) {
            this.AddDepartement(request, response);
        } else if (action.equalsIgnoreCase("saveDept")) {
            this.SaveDepartement(request, response);
        } else if (action.equalsIgnoreCase("editDept")) {
            this.EditDepartement(request, response);
        } else if (action.equalsIgnoreCase("saveDeptEdit")) {
            this.SaveEditDepartement(request, response);
        } else if (action.equalsIgnoreCase("deleteDept")) {
            this.DeleteDepartement(request, response);
        } else if (action.equalsIgnoreCase("editEmp")) {
            this.EditEmploye(request, response);
        } else if (action.equalsIgnoreCase("saveEmpEdit")) {
            this.SaveEditEmploye(request, response);
        } else if (action.equalsIgnoreCase("deleteEmp")) {
            this.DeleteEmploye(request, response);
        } else {
            request.getRequestDispatcher("departements.jsp").forward(request, response);
        }
    }

    private void Departements(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Departement> list = daoDept.All();
        request.setAttribute("list", list);
        request.getRequestDispatcher("departements.jsp").forward(request, response);
    }

    private void Employes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employe> list = daoEmp.All();
        Departement dept = null;
        List<String> names = new ArrayList<String>();
        for (Employe e : list) {
            dept = daoDept.getDepartement(e.getRefDept());
            names.add(dept.getIdDept());
        }
        request.setAttribute("list", list);
        request.setAttribute("names", names);
        request.getRequestDispatcher("employes.jsp").forward(request, response);
    }

    private void addEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = idStr.equals("") ? 0 : Integer.parseInt(idStr);
        Departement dept = new Departement();
        if (idStr != null) {
            dept = daoDept.getDepartement(id);
        }
        request.setAttribute("dept", dept);
        request.getRequestDispatcher("add_emp.jsp").forward(request, response);
    }

    private void saveEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = idStr.equals("") ? 0 : Integer.parseInt(idStr);
        String idEmp = request.getParameter("code");
        String nom = request.getParameter("nom");
        Double salaire = Double.parseDouble(request.getParameter("salaire"));

        Departement dept = daoDept.getDepartement(id);
        Employe emp = new Employe(idEmp, nom, salaire);
        emp.setRefDept(dept.getID());
        daoEmp.addEmploye(emp);
        this.Employes(request, response);
    }

    private void EmpsByDept(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String refDept = request.getParameter("id");
        int id = refDept.equals("") ? 0 : Integer.parseInt(refDept);
        List<Employe> list = daoEmp.EmpByDept(id);
        Departement dept = daoDept.getDepartement(id);
        request.setAttribute("list", list);
        request.setAttribute("NomDept", dept.getNom());
        request.getRequestDispatcher("empsByDept.jsp").forward(request, response);
    }

    private void AddDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("add_dept.jsp").forward(request, response);
    }

    private void SaveDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idDept = request.getParameter("idDept");
        String nom = request.getParameter("nom");

        Departement dept = new Departement();
        dept.setIdDept(idDept);
        dept.setNom(nom);
        daoDept.addDepartement(dept);
        this.Departements(request, response);
    }

    private void EditDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = idStr.equals("") ? 0 : Integer.parseInt(idStr);
        Departement dept = daoDept.getDepartement(id);
        request.setAttribute("dept", dept);
        request.getRequestDispatcher("edit_dept.jsp").forward(request, response);
    }

    private void SaveEditDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = idStr.equals("") ? 0 : Integer.parseInt(idStr);
        String idDept = request.getParameter("idDept");
        String nom = request.getParameter("nom");
        daoDept.updateDepartement(id, idDept, nom);
        this.Departements(request, response);
    }

    private void DeleteDepartement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int i = 0;
        String idStr = request.getParameter("id");
        int id = idStr.equals("") ? 0 : Integer.parseInt(idStr);
        daoEmp.DelByDept(id);
        daoDept.deleteDepartement(id);
        this.Departements(request, response);
    }

    private void EditEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idEmp = request.getParameter("idEmp");
        Employe emp = daoEmp.getEmploye(idEmp);
        request.setAttribute("emp", emp);
        request.getRequestDispatcher("edit_emp.jsp").forward(request, response);
    }

    private void SaveEditEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idEmp = request.getParameter("idEmp");
        String nom = request.getParameter("nom");
        Double salaire = Double.parseDouble(request.getParameter("salaire"));

        Employe emp = new Employe();
        emp.setIdEmp(idEmp);
        emp.setNom(nom);
        emp.setSalaire(salaire);
        daoEmp.updateEmploye(emp);
        this.Employes(request, response);
    }

    private void DeleteEmploye(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = idStr.equals("") ? 0 : Integer.parseInt(idStr);
        daoEmp.deleteEmploye(id);
        this.Employes(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
