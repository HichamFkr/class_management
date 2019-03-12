/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Beans.groupe;
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
public class groupe_dao_impl implements groupe_dao{

    @Override
    public ArrayList<groupe> lister() {
        Connection connection = (Connection) ConnexionDB.getConnection();
        ArrayList<groupe> listGrp = new ArrayList<groupe>();
        
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from groupe");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                groupe grp = new groupe();
                grp.setCode(rs.getInt("code"));
                grp.setLibelle(rs.getString("libelle"));
                
                listGrp.add(grp);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(etudiant_dao_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGrp;
        
    }
   
}
