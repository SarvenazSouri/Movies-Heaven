/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package films;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author isi
 */
public class FilmsManager {
    //Retourner la liste de tous les Films contenus dans le fichier Json sous une variable ArrayList
    public static ArrayList<Films> getFilms(){
        ArrayList<Films> films = new ArrayList<>();
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            File jsonFile = new File("C:\\cours-ISI\\films.json");

            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            
            for(JsonNode un_film : jsonNode){
                Films film = new Films();
                film.setId(un_film.get("@id").asText());
                film.setTitre(un_film.get("titre").asText());
                film.setAnnee(un_film.get("annee").asText());
                film.setPays(un_film.get("pays").asText());
                String langue = un_film.get("langue") != null ? un_film.get("langue").asText() : "";
                film.setLangue(langue);
                film.setDuree(un_film.get("duree").asInt());
                film.setResume(un_film.get("resume").asText());
                String poster = un_film.get("poster") != null ? un_film.get("poster").asText() : "";
                film.setPoster(poster);
                
                //  Genre
                JsonNode genreNode = un_film.get("genre");
                String genre = "";
                if(genreNode != null){
                    for(JsonNode une_genre : genreNode){
                        genre += une_genre.asText() + ", ";
                    }
                }   
                film.setGenre(genre);
                
                //  Realisateur
                JsonNode realisateurNode = un_film.get("realisateur");
                String realisateur = "";
                if(un_film.get("realisateur") != null){                
                   realisateur += realisateurNode.get("@id").asText() + " : " + realisateurNode.get("#text").asText() + ", ";
                }
                film.setRealisateur(realisateur);
                
                //  Scenariste
                JsonNode scenaristeNode = un_film.get("scenariste");
                String scenariste = "";
                if(scenaristeNode != null){
                    for(JsonNode un_scenariste : scenaristeNode){
                        scenariste += un_scenariste.asText() + ", ";
                    }
                }
                
                film.setScenariste(scenariste);
                
                //  Acteur
                JsonNode roleNode = un_film.get("role");
                String acteur = "";
                if(roleNode != null){
//                    acteur = roleNode + "";
                    for(JsonNode role : roleNode){
                        JsonNode un_acteur = role.get("acteur");
                        if(un_acteur != null){
                            acteur += un_acteur.get("@id").asText() + " : " + un_acteur.get("#text").asText() + " personnage : " + role.get("personnage").asText() + ", ";
                        }
                    }
                }
                
                film.setActeur(acteur);
                
                //  Annonce
                JsonNode annonceNode = un_film.get("annonce");
                String annonce = "";
                if(annonceNode != null){
                    
                    for(JsonNode une_annonce : annonceNode){
                        annonce += une_annonce.asText() + ", ";
                    }    
                }
                film.setAnnonce(annonce);
                
                films.add(film);
                
            }   

            
        } catch (IOException e) {
        }
        
        return films;
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public static void insertFilms(ArrayList<Films> films){
        try{
            Class.forName("org.postgresql.Driver");  //charger le diver MariaDB
            String urlServeur = "jdbc:postgresql://localhost:5433/pg_films";
            String identifiant = "postgres";
            String motDePasse = "postgres ";
            
            Connection connection = DriverManager.getConnection(urlServeur, identifiant, motDePasse);
            
            for(Films film : films){
                String query = "INSERT INTO films_bd (id, titre, annee, pays, langue, duree, resume, genre, realisateur, scenariste, acteur, poster, annonce) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
            
                PreparedStatement preparedStatement = connection.prepareStatement(query);
            
                preparedStatement.setString(1, film.getId());
                preparedStatement.setString(2, film.getTitre());
                preparedStatement.setString(3, film.getAnnee());
                preparedStatement.setString(4, film.getPays());
                preparedStatement.setString(5,film.getLangue());
                preparedStatement.setInt(6, film.getDuree());
                preparedStatement.setString(7, film.getResume());
                preparedStatement.setString(8, film.getGenre());
                preparedStatement.setString(9, film.getRealisateur());
                preparedStatement.setString(10, film.getScenariste());
                preparedStatement.setString(11, film.getActeur());
                preparedStatement.setString(12, film.getPoster());
                preparedStatement.setString(13, film.getAnnonce());
                preparedStatement.executeUpdate();
            }

            connection.close();
        }
        catch(ClassNotFoundException | SQLException nfe){}
    }
    
    public static void createSql(ArrayList<Films> films) throws IOException{
        String query = "";
        for(Films film : films){
                query += "INSERT INTO films_bd (id, titre, annee, pays, langue, duree, resume, genre, realisateur, scenariste, acteur, poster, annonce) "
                        + "VALUES ("+film.toString()+")\n" ;
           
            }
            FileWriter fw = new FileWriter("C:\\ISI\\films_bd.sql");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(query);
                bw.close();
    }
}
