/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Hicham
 */
public class etudiant implements Serializable{
    
    private int id;
    private String matricule;
    private String nom;
    private String prenom;
    private Date DateNais;
    private String LieuNais;
    private float note;
    private String pw;
    private int code;

    public etudiant(int id, String matricule, String nom, String prenom, Date DateNais, String LieuNais, float note, String pw, int code) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.DateNais = DateNais;
        this.LieuNais = LieuNais;
        this.note = note;
        this.pw = pw;
        this.code = code;
    }

    public etudiant(String matricule, String nom, String prenom, Date DateNais, String LieuNais, float note, String pw, int code) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.DateNais = DateNais;
        this.LieuNais = LieuNais;
        this.note = note;
        this.pw = pw;
        this.code = code;
    }

    public etudiant() {
        super();
    }
    
    
    public int getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNais() {
        return DateNais;
    }

    public String getLieuNais() {
        return LieuNais;
    }

    public float getNote() {
        return note;
    }

    public String getPw() {
        return pw;
    }

    public int getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNais(Date DateNais) {
        this.DateNais = DateNais;
    }

    public void setLieuNais(String LieuNais) {
        this.LieuNais = LieuNais;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public etudiant(String matricule, String nom, String prenom, Date DateNais, String LieuNais, int code) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.DateNais = DateNais;
        this.LieuNais = LieuNais;
        this.code = code;
    }

    public etudiant(String matricule, String nom, String prenom, Date DateNais, String LieuNais, String pw, int code) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.DateNais = DateNais;
        this.LieuNais = LieuNais;
        this.pw = pw;
        this.code = code;
    }
    
    
    
    
    
}
