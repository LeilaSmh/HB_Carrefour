/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;

import com.dao.daoDepartement;
import com.dao.daoEmploye;
import com.entity.Departement;
import com.entity.Employe;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {// TODO code application logic here
        daoDepartement dao = new daoDepartement();
       List<Departement> L= dao.All();
       for (Departement dept : L)
            System.out.println(dept.getIdDept()+"   " + dept.getNom());
        daoEmploye daoe = new daoEmploye();
        List<Employe> E= daoe.All();
       for (Employe emp : E)
            System.out.println(emp.getIdEmp()+"   " + emp.getNom());
    }
    
}
