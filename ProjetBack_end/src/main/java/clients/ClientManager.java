/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connexion.Server;
import java.util.Random;


/**
 *
 * @author isi
 */
public class ClientManager {
    public static Clients trouver_utilisateur(String email,String pws){
        
            Clients user = null;
            String s = "";
	    String query = "select * from clients_bd where courriel = '"+email+"' and password = '"+pws+"'";
            PreparedStatement preparedStatement = Server.connexion(query);   
            try  {
            ResultSet resultSet = preparedStatement.executeQuery();
            user = new Clients();
            while (resultSet.next()) {
            
                user.setId(resultSet.getString("id"));
                user.setNom(resultSet.getString("nom"));
                user.setPrenom(resultSet.getString("prenom"));
                user.setCourriel(resultSet.getString("courriel"));
                user.setTel(resultSet.getString("tel"));
                user.setAnniversaire(resultSet.getString("anniversaire"));
                user.setAdresse(resultSet.getString("adresse"));
                user.setVille(resultSet.getString("province"));/*-------------*/
                user.setProvince(resultSet.getString("province"));
                user.setCode_postal(resultSet.getString("code_postal"));
                user.setCarte(resultSet.getString("carte"));
                user.setNo_carte(resultSet.getString("no_carte"));
                user.setExp_mois(resultSet.getString("exp_mois"));
                user.setExp_annee(resultSet.getString("exp_annee"));
                user.setPassword(resultSet.getString("password"));
                user.setForfait(resultSet.getString("forfait"));
            }
                
            } catch (SQLException e) {
            e.printStackTrace();
        }
            return user;
    }
    
    public static void createUser(String email, String password) {
    String query = "INSERT INTO clients_bd (id, courriel, password) VALUES (?, ?, ?)";
    PreparedStatement preparedStatement = Server.connexion(query);
    
    try{
        Random rand = new Random(); 
        int int_random = rand.nextInt(100000000); 
        preparedStatement.setString(1, int_random+"");
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, password);
        

       preparedStatement.executeUpdate();


    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
