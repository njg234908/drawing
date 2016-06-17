/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author nicholas.gould
 */
public class DrawingTest {
    
private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    
    public DrawingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
}
    
    @After
    public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
}

    @Test
    public void testPromptText() {
        
        Drawing.prompt();
        assertEquals("enter command:", outContent.toString());
        
    }
    
    //test a valid command
    @Test
    public void testValidCommandInput() {
        //write command "This is an invalid command" to stdin
        ByteArrayInputStream in = new ByteArrayInputStream("C 2 2".getBytes());
        System.setIn(in);
        Drawing.getInput();
        assertThat(outContent.toString(), not(equalTo("Invalid Command")));
        
    }
    
    @Test
    public void testInvalidCommandInput() {
        //write command "This is an invalid command" to stdin
        ByteArrayInputStream in = new ByteArrayInputStream(((String)"Invalid").getBytes());
        System.setIn(in);
        Drawing.getInput();
        assertEquals("Invalid Command", outContent.toString());
        
    }
    
    @Test
    public void drawBasicCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("c 1 1".getBytes());
        System.setIn(in);
        Drawing.getInput();
        assertEquals("-\n| |\n-", outContent.toString() );
    }
}
