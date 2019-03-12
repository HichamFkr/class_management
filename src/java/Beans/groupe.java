/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.io.Serializable;

/**
 *
 * @author Hicham
 */
public class groupe implements Serializable{
    
    private int code;
    private String libelle;

    public int getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "groupe{" + "code=" + code + ", libelle=" + libelle + '}';
    }

    public groupe(int code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public groupe() {
        super();
    }

    
}
