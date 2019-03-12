/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Beans.etudiant;
import Beans.groupe;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Hicham
 */
public class testDao {
    public static void main(String[] args) {
        
        
        
        ArrayList<etudiant> etudiants = new ArrayList<etudiant>();
        etudiant_dao_impl et = new etudiant_dao_impl();
        
        etudiant e = et.getByMat("x130268");
        System.out.println(e.getNom()+""+e.getPrenom());
        
       
       
    }
}
