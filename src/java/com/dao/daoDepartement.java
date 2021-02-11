/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.entity.Departement;
import com.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dell
 */
public class daoDepartement {
    Session S ;
    Transaction Tx ;

    public daoDepartement()
    {
        S = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void addDepartement(Departement dept) 
    {
        try {
            Tx= S.beginTransaction();
            S.save(dept);
            Tx.commit();

        } catch (Exception e){
            Tx.rollback();
            e.printStackTrace();
        }
    }
    
    public void updateDepartement(int id, String idDept, String nom) 
    {
        Departement dept = null;
        try {
            Tx= S.beginTransaction();
            dept = (Departement) S.get(Departement.class, id);
            dept.setIdDept(idDept);
            dept.setNom(nom);
            S.update(dept);
            Tx.commit();

        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
    }
    
    public void deleteDepartement(String code)
    {
        Departement dept = null;
        try {
            Tx= S.beginTransaction();
            dept = (Departement) S.get(Departement.class, code);
            if (dept != null){
                S.delete(dept);
                if (!Tx.wasCommitted())
                    Tx.commit();
            }
            
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
    }
    public void deleteDepartement(int id)
    {
        Departement dept = null;
        try {
            Tx= S.beginTransaction();
            dept = (Departement) S.get(Departement.class, id);
            if (dept != null){
                S.delete(dept);
                if (!Tx.wasCommitted())
                    Tx.commit();
            }
            
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
        
    }
    
    public Departement getDepartement(int id)
    {
        Departement dept = null;
        
        try {
            Tx= S.beginTransaction();
            dept = (Departement) S.get(Departement.class, id);
            if (!Tx.wasCommitted())
                    Tx.commit();
        } catch (Exception e) {
            Tx.rollback();
            e.printStackTrace();
        }
        
        return dept;
    }
    
    public String getDeptById(int id){
        return this.getDepartement(id).getNom();
    }
    
    public List<Departement> All() {
        List<Departement> departements = null;
        try {
                departements = S.createQuery("from Departement").list();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return departements;
    }
    
    
}
