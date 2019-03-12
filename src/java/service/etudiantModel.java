/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import Beans.etudiant;
import java.util.ArrayList;

/**
 *
 * @author Hicham
 */
public class etudiantModel {
    private etudiant etudiant;
    private ArrayList<etudiant> listEtudiant;
    private int CodeGrp;

    public etudiant getEtudiant() {
        return etudiant;
    }

    public ArrayList<etudiant> getListEtudiant() {
        return listEtudiant;
    }

    public int getCodeGrp() {
        return CodeGrp;
    }

    public void setEtudiant(etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setListEtudiant(ArrayList<etudiant> listEtudiant) {
        this.listEtudiant = listEtudiant;
    }

    public void setCodeGrp(int CodeGrp) {
        this.CodeGrp = CodeGrp;
    }
    
    
    
}
