/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package films;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connexion.Server;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 *
 * @author isi
 */


public class ManagerFilms {
/*
recup_film() retourn tous les films de la bd
film_louer() retourne un boolean et ajoute a la base de donnée
louer le user_id et film_id de l'utilisateur qui a louer le film
*/
    public static ArrayList<Films> recup_film() {
        ArrayList<Films> films = new ArrayList<>();
        String query = "SELECT * FROM films_bd";
        PreparedStatement preparedStatement = Server.connexion(query);
         
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Films film = new Films();
                film.setId(resultSet.getString("id"));
                film.setTitre(resultSet.getString("titre"));
                film.setAnnee(resultSet.getString("annee"));
                film.setPays(resultSet.getString("pays"));
                film.setLangue(resultSet.getString("langue"));
                film.setDuree(resultSet.getInt("duree"));
                film.setResume(resultSet.getString("resume"));
                film.setGenre(resultSet.getString("genre"));
                film.setRealisateur(resultSet.getString("realisateur"));
                film.setScenariste(resultSet.getString("scenariste"));
                film.setActeur(resultSet.getString("acteur"));
                film.setPoster(resultSet.getString("poster"));
                film.setAnnonce(resultSet.getString("annonce"));
                films.add(film);
            }
       
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Server.fermer();
        }
        return films;
    }
    
    public static boolean film_louer(String id_film, String id_client) {
        String selectSql = "SELECT COUNT(*) AS nb_films FROM louer WHERE id_client = ?";
        String insertSql = "INSERT INTO louer (id_film, id_client) VALUES (?, ?)";
 
        try {
            PreparedStatement selectStatement = Server.connexion(selectSql);
            selectStatement.setString(1, id_client);
            ResultSet resultSet = selectStatement.executeQuery();
 
            resultSet.next();
            int count = resultSet.getInt("nb_films");
 
            if (count == 0) {
                PreparedStatement insertStatement = Server.connexion(insertSql);
                insertStatement.setString(1, id_film);
                insertStatement.setString(2, id_client);
                insertStatement.executeUpdate();
            } else {
                return false;
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
 
        return true;
    }
}


