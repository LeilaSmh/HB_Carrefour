
package com.entity;

import com.dao.daoDepartement;
import javax.persistence.*;

/**
 *
 * @author Dell
 */

@Entity
@Table(name = "EMPLOYE")
public class Employe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "ID")
    private int ID;
    @Column(name = "ID_EMP")
    private String idEmp;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "SALAIRE")
    private Double salaire;
    @JoinColumn(name = "RefDept", referencedColumnName = "ID")
    private int refDept;
    
    public Employe() {
    }

   public Employe(String idEmp,String Name, Double Salaire){
        this.salaire = Salaire;
        this.nom = Name;
        this.idEmp = idEmp;
    }
   
   public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public int getRefDept() {
        return refDept;
    }

    public void setRefDept(int refDept) {
        this.refDept = refDept;
    }
}