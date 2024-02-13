/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import clients.ClientsManager;
import films.FilmsManager;
import java.io.IOException;

/**
 *
 * @author isi
 */
public class Main {
    public static void main(String[] args) throws IOException{
        /*          Tester et exécuter les données de films_bd          */
        FilmsManager.insertFilms(FilmsManager.getFilms());

        /*          Tester et exécuter les données de clients_bd        */ 
        ClientsManager.insertClients(ClientsManager.getClients());
        
    }
}
