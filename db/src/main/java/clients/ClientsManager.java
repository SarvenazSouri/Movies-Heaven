/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clients;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author isi
 */
public class ClientsManager {
    public static ArrayList<Clients> getClients(){
        ArrayList<Clients> clients = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            File jsonFile = new File("C:\\cours-ISI\\clients.json");

            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            
            for(JsonNode un_client : jsonNode){
                Clients client = new Clients();
                client.setId(un_client.get("@id").asText());
                client.setNom(un_client.get("nom-famille").asText());
                client.setPrenom(un_client.get("prenom").asText());
                client.setCourriel(un_client.get("courriel").asText());
                client.setTel(un_client.get("tel").asText());
                client.setAnniversaire(un_client.get("anniversaire").asText());
                client.setAdresse(un_client.get("adresse").asText());
                client.setVille(un_client.get("ville").asText());
                client.setProvince(un_client.get("province").asText());
                client.setCode_postal(un_client.get("code-postal").asText());
                client.setPassword(un_client.get("mot-de-passe").asText());
                client.setForfait(un_client.get("forfait").asText());
                
                //Info carte
                JsonNode info_credit = un_client.get("info-credit");
//                if(info_credit != null){
                    client.setCarte(info_credit.get("carte").asText());
                    client.setNo_carte(info_credit.get("no").asText());
                    client.setExp_mois(info_credit.get("exp-mois").asText());
                    client.setExp_annee(info_credit.get("exp-annee").asText()); 
//                }
                
                
                clients.add(client);
                
            }
            
        } catch (IOException e) {
        }
        
        return clients;
    }

    public static void insertClients(ArrayList<Clients> clients) {
        try{
            Class.forName("org.postgresql.Driver");  //charger le diver MariaDB
            String urlServeur = "jdbc:postgresql://localhost:5433/pg_films";
            String identifiant = "postgres";
            String motDePasse = "postgres ";
            
            Connection connection = DriverManager.getConnection(urlServeur, identifiant, motDePasse);
            
            for(Clients client : clients){
                String query = "INSERT INTO clients_bd (id, nom, prenom, courriel, tel, anniversaire, adresse, ville, province, code_postal, carte, no_carte, exp_mois, exp_annee, password, forfait) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
            
                PreparedStatement preparedStatement = connection.prepareStatement(query);
            
                preparedStatement.setString(1, client.getId());
                preparedStatement.setString(2, client.getNom());
                preparedStatement.setString(3, client.getPrenom());
                preparedStatement.setString(4, client.getCourriel());
                preparedStatement.setString(5,client.getTel());
                preparedStatement.setString(6, client.getAnniversaire());
                preparedStatement.setString(7, client.getAdresse());
                preparedStatement.setString(8, client.getVille());
                preparedStatement.setString(9, client.getProvince());
                preparedStatement.setString(10, client.getCode_postal());
                preparedStatement.setString(11, client.getCarte());
                preparedStatement.setString(12, client.getNo_carte());
                preparedStatement.setString(13, client.getExp_mois());
                preparedStatement.setString(14, client.getExp_annee());
                preparedStatement.setString(15, client.getPassword());
                preparedStatement.setString(16, client.getForfait());
                preparedStatement.executeUpdate();
            }

            connection.close();
        }
        catch(ClassNotFoundException | SQLException nfe){}
    }
}
