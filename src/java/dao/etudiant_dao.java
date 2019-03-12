/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Beans.etudiant;
import java.util.ArrayList;

/**
 *
 * @author Hicham
 */
public interface etudiant_dao {
    
    public etudiant ajouter(etudiant e);
    public ArrayList<etudiant> lister ();
    public ArrayList<etudiant> getByGrp(int id);
    public int auth(String matricule , String pw);
    public etudiant getByMat(String mat);

}
