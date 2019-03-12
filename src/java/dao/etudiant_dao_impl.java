/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Beans.etudiant;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hicham
 */
public class etudiant_dao_impl implements etudiant_dao{

    @Override
    public etudiant ajouter(etudiant e) {
        Connection connection = (Connection) ConnexionDB.getConnection();
        try {
            PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement
        ("INSERT INTO `etudiant`(`id`, `matricule`, `nom`, `prenom`, `code`, `DateNais`, `LieuNais`, `pw`, `note`) VALUES (?,?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, e.getId());
            ps.setString(2, e.getMatricule());
            ps.setString(3,e.getNom());
            ps.setString(4,e.getPrenom());
            ps.setInt(5, e.getCode());
            ps.setDate(6, e.getDateNais());
            ps.setString(7, e.getLieuNais());
            ps.setString(8,e.getPw());
            ps.setFloat(9, e.getNote());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(etudiant_dao_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return e;
    }

    @Override
    public ArrayList<etudiant> lister() {
        ArrayList<etudiant> listEtudiant = new ArrayList<etudiant>();
        Connection connection = (Connection) ConnexionDB.getConnection();
        
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from etudiant");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                etudiant etud = new etudiant();
                etud.setId(rs.getInt("id"));
                etud.setNom(rs.getString("nom"));
                etud.setPrenom(rs.getString("prenom"));
                etud.setMatricule(rs.getString("matricule"));
                etud.setDateNais(rs.getDate("DateNais"));
                etud.setLieuNais(rs.getString("LieuNais"));
                etud.setCode(rs.getInt("code"));
                etud.setPw(rs.getString("pw"));
                etud.setNote(rs.getFloat("note"));
                
                listEtudiant.add(etud);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(etudiant_dao_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEtudiant;
    }

    @Override
    public ArrayList<etudiant> getByGrp(int id) {
        ArrayList<etudiant> listGrp = new ArrayList<>();
        Connection connection = (Connection) ConnexionDB.getConnection();
            
        try {
            PreparedStatement ps = connection.prepareStatement("Select * from etudiant where code = ?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                etudiant etud = new etudiant();
                etud.setId(rs.getInt("id"));
                etud.setNom(rs.getString("nom"));
                etud.setPrenom(rs.getString("prenom"));
                etud.setMatricule(rs.getString("matricule"));
                etud.setDateNais(rs.getDate("DateNais"));
                etud.setLieuNais(rs.getString("LieuNais"));
                etud.setCode(rs.getInt("code"));
                etud.setPw(rs.getString("pw"));
                etud.setNote(rs.getFloat("note"));
                
                listGrp.add(etud);
            }
        } catch (SQLException ex) {
            Logger.getLogger(etudiant_dao_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listGrp;
    }

    @Override
    public int auth(String matricule , String pw) {
        Connection connection = (Connection) ConnexionDB.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("Select * from etudiant where matricule = ? and pw = ?");
            ps.setString(1, matricule);
            ps.setString(2, pw);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                return 1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(etudiant_dao_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return 0;
    }

    @Override
    public etudiant getByMat(String mat) {
        Connection connection = (Connection) ConnexionDB.getConnection();
        etudiant etud = new etudiant();
        try {
            PreparedStatement ps = connection.prepareStatement("Select * from etudiant where matricule = ?");
            ps.setString(1, mat);
 
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                etud.setId(rs.getInt("id"));
                etud.setNom(rs.getString("nom"));
                etud.setPrenom(rs.getString("prenom"));
                etud.setMatricule(rs.getString("matricule"));
                etud.setDateNais(rs.getDate("DateNais"));
                etud.setLieuNais(rs.getString("LieuNais"));
                etud.setCode(rs.getInt("code"));
                etud.setPw(rs.getString("pw"));
                etud.setNote(rs.getFloat("note"));   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(etudiant_dao_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etud;
    }
    
}
