/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.entity.Departement;
import com.entity.Employe;
import com.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dell
 */
public class daoEmploye {
  Session S ;
    Transaction Tx ;

    public daoEmploye()
    {
        S = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void addEmploye(Employe emp) 
    {
        try {
            Tx= S.beginTransaction();
            S.save(emp);
            Tx.commit();

        } catch (Exception e){
            Tx.rollback();
            e.printStackTrace();
        }
    }
    
    public void updateEmploye(Employe emp) 
    {
        try {
            Tx= S.beginTransaction();
            S.update(emp);
            Tx.commit();

        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
    }
    
    public void deleteEmploye(String code)
    {
        Employe emp = null;
        try {
            Tx= S.beginTransaction();
            emp = (Employe) S.get(Employe.class, code);
            if (emp != null){
                S.delete(emp);
                if (!Tx.wasCommitted())
                    Tx.commit();
            }
            
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
    }
    
    public Employe getEmploye(String code)
    {
        Employe emp = null;
        
        try {
            Tx= S.beginTransaction();
            emp = (Employe) S.get(Employe.class, code);
            if (!Tx.wasCommitted())
                    Tx.commit();
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
        
        return emp;
    }
    
    public List<Employe> EmpByDept(int refDept) {
       List<Employe> employes = null;
       Query query = null;
        try {
                query = S.createQuery("from Employe where refDept = :refDept");
                query.setParameter("refDept", refDept);
                employes = query.list();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return employes;
    }

    public void DelByDept (int refDept){
        Query query = null;
        try {
                query = S.createQuery("delete from Employe where refDept = :refDept");
                query.setParameter("refDept", refDept);
                int n = query.executeUpdate();
                if(n>0) System.out.println("Employes Deleted");
                else System.out.println("Error!!! Employes not deleted");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    
    public List<Employe> All() {
        List<Employe> employes = null;
        try {
                employes = S.createQuery("from Employe").list();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return employes;
    }
}
