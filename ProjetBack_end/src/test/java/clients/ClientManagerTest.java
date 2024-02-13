/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package clients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author isi
 */
public class ClientManagerTest {
    
    public ClientManagerTest() {
    }

    

    /*@Test
    public void testTrouverUtilisateur() {
        
        String email = "test@example.com";
        String password = "testPassword";
        String email1 = "RobertCFlores21@gmail.com";
        String password1 = "eishie3meiH";
        String email2 = "RobertCFlores21@gmail.com";
        String password2 = "testPass";

        Clients user = ClientManager.trouver_utilisateur(email, password);
        Clients user1 = ClientManager.trouver_utilisateur(email1, password1);
        Clients user2 = ClientManager.trouver_utilisateur(email2,password2);
        Clients newUser = new Clients();
        assertEquals(user,newUser);
        assertNotNull(user1);
        assertEquals(email1, user1.getCourriel());
        assertNotNull(user2);
        assertNull(user2.getCourriel());
        
    }*/

    /*@Test
    public void testCreateUser() {
        
        String email = "testUser@example.com";
        String password = "testPassword";

        ClientManager.createUser(email, password);

        Clients createdUser = ClientManager.trouver_utilisateur(email, password);
        
        assertNotNull(createdUser);
        assertEquals(email, createdUser.getCourriel());
        assertEquals(password,createdUser.getPassword());/*
    }
    */
}
