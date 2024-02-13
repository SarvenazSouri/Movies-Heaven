/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package connexion;

import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author isi
 */
public class ServerTest {

    /**
     * Test database connection.
     */
    /*@Test
    public void testConnexion() {
        // Verify that the connection is not null, indicating a successful connection
        assertNotNull(Server.connexion("Select * from clients_bd"));
        assertNotNull(Server.connexion(""));
        try {
            // Perform additional checks if needed, such as checking if the connection is open
            assertFalse(Server.getConnection().isClosed());
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void testFermer(){
        Server.fermer();
        try{
        assertTrue(Server.getConnection().isClosed());
        }catch(SQLException s){}
    }
    */
    
}
