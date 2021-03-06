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
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.prompt();
        assertEquals("Enter Command:", outContent.toString());
        
    }
    
    //test a valid command
    @Test
    public void testValidCommandInput() {
        //write command "This is an invalid command" to stdin
        ByteArrayInputStream in = new ByteArrayInputStream("C 2 2".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        assertThat(outContent.toString(), not(equalTo("Invalid Command\n")));
        
    }
    
    @Test
    public void testInvalidCommandInput() {
        //write command "This is an invalid command" to stdin
        ByteArrayInputStream in = new ByteArrayInputStream(((String)"Invalid").getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        assertEquals("Invalid Command\n", outContent.toString());
        
    }
    
    
    
    @Test
    public void drawBasicCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 1 1".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        assertEquals(" -\n| |\n -\n", outContent.toString() );
    }
    
    @Test
    public void drawAnotherCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 2 2".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        assertEquals(" --\n|  |\n|  |\n --\n", outContent.toString() );
    }
    
   @Test
    public void drawrectangularCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 4 2".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        assertEquals(" ----\n|    |\n|    |\n ----\n", outContent.toString() );
    }
    
    @Test
    public void drawHorizRectangularCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 4 2".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        assertEquals(" ----\n|    |\n|    |\n ----\n", outContent.toString() );
    }
    
    @Test
    public void drawVertRectangularCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 2 4".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        assertEquals(" --\n|  |\n|  |\n|  |\n|  |\n --\n", outContent.toString() );
    }
    @Test
    public void drawInvalidCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("C -2 4".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        assertEquals("Invalid Command\n", outContent.toString() );
    }
    
    @Test
    public void drawHorizontalLine(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("L 1 2 6 2".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\n ----------\n|          |\n|xxxxxx    |\n|          |\n ----------\n", outContent.toString() );
    }
     @Test
    public void drawHorizontalLineOutsideCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("L 1 2 11 2".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\nInvalid Command\n", outContent.toString());
    }
    
     @Test
    public void drawDiagonalLineAttempt(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("L 1 1 3 3".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\nInvalid Command\n", outContent.toString());
    }
    
    @Test
    public void negativeCoordsDrawLine(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("L -2 1 2 2".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\nInvalid Command\n", outContent.toString() );
        
    }
    @Test
    public void drawOverlappingHorizontalLines(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("L 1 2 6 2".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        ByteArrayInputStream in3 = new ByteArrayInputStream("L 4 2 8 2".getBytes());
        System.setIn(in3);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\n ----------\n|          |\n|xxxxxx    |\n|          |\n ----------\n ----------\n|          |\n|xxxxxxxx  |\n|          |\n ----------\n", outContent.toString() );
    
    }
    
    @Test
    public void drawOverlappingVerticalLines(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("L 2 1 2 2".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        ByteArrayInputStream in3 = new ByteArrayInputStream("L 2 2 2 3".getBytes());
        System.setIn(in3);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\n ----------\n| x        |\n| x        |\n|          |\n ----------\n ----------\n| x        |\n| x        |\n| x        |\n ----------\n", outContent.toString() );
        
    }
    @Test
    public void drawRectangle(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("R 1 1 3 3".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\n ----------\n|xxx       |\n|x x       |\n|xxx       |\n ----------\n", outContent.toString() );
        
    
    }
    
    @Test
    public void drawRectangleOutsideCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("R 1 1 3 4".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\nInvalid Command\n", outContent.toString()); 
    
    }
    
    @Test
    public void drawRectanglInvalidCoords(){
        ByteArrayInputStream in = new ByteArrayInputStream("C 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("R r 1 -5 5".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\nInvalid Command\n", outContent.toString()); 
    
    }
    
    
    /*
    @Test
    public void fillRectangle(){
        ByteArrayInputStream in = new ByteArrayInputStream("c 10 4".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("R 2 2 4 4".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        ByteArrayInputStream in3 = new ByteArrayInputStream("B 3 3 b".getBytes());
        System.setIn(in3);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n|          |\n ----------\n ----------\n|          |\n| xxx      |\n| x x      |\n| xxx      |\n ----------\n ----------\n|          |\n| xxx      |\n| xbx      |\n| xxx      |\n ----------\n", outContent.toString() );
        
    
    }
    
    @Test
    public void fillLongerRectangle(){
        ByteArrayInputStream in = new ByteArrayInputStream("c 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("R 1 1 8 3".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        ByteArrayInputStream in3 = new ByteArrayInputStream("B 2 2 b".getBytes());
        System.setIn(in3);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\n ----------\n|xxxxxxxx  |\n|x      x  |\n|xxxxxxxx  |\n ----------\n ----------\n|xxxxxxxx  |\n|xbbbbbbx  |\n|xxxxxxxx  |\n ----------\n", outContent.toString() );
        
    
    }
    
    @Test
    public void fillMultipleLines(){
        ByteArrayInputStream in = new ByteArrayInputStream("c 10 4".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("R 1 1 8 4".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        ByteArrayInputStream in3 = new ByteArrayInputStream("B 3 3 b".getBytes());
        System.setIn(in3);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n|          |\n ----------\n ----------\n|xxxxxxxx  |\n|x      x  |\n|x      x  |\n|xxxxxxxx  |\n ----------\n ----------\n|xxxxxxxx  |\n|xbbbbbbx  |\n|xbbbbbbx  |\n|xxxxxxxx  |\n ----------\n", outContent.toString() );
        
    
    }
@Test
public void fillWholeCanvas(){
        ByteArrayInputStream in = new ByteArrayInputStream("c 10 4".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in3 = new ByteArrayInputStream("B 2 2 c".getBytes());
        System.setIn(in3);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n|          |\n ----------\n ----------\n|cccccccccc|\n|cccccccccc|\n|cccccccccc|\n|cccccccccc|\n ----------\n", outContent.toString() );
        
    
    }

@Test
    public void fillAroundVerticalLine(){
        ByteArrayInputStream in = new ByteArrayInputStream("c 10 3".getBytes());
        System.setIn(in);
        MyDrawing mydrawing = new MyDrawing();
        mydrawing.getInput();
        ByteArrayInputStream in2 = new ByteArrayInputStream("l 2 1 2 2".getBytes());
        System.setIn(in2);
        mydrawing.getInput();
        ByteArrayInputStream in3 = new ByteArrayInputStream("B 2 2 c".getBytes());
        System.setIn(in3);
        mydrawing.getInput();
        assertEquals(" ----------\n|          |\n|          |\n|          |\n ----------\n ----------\n| x        |\n| x        |\n|          |\n ----------\n ----------\n|cccccccccc|\n|ccccxccccc|\n|ccccxccccc|\n|cccccccccc|\n ----------\n", outContent.toString() );
        
    }*/

}