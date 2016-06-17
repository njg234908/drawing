
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;
import java.io.*;
import java.util.*;
/**
 *
 * @author nicholas.gould
 */
public class Drawing {
    
    public static void main (String args[]){
        MyDrawing mydrawing = new MyDrawing();
    while (true){
        mydrawing.prompt();
    mydrawing.getInput();}
    }
}
class MyDrawing{
    //prompt the user for a command
    void prompt(){
    System.out.print("enter command:");}
    
    //get input from the user
    void getInput(){  
    //get console input    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
// tokenize input
    try{
        String inputtext = br.readLine();
    String[] splitinput = inputtext.split("\\s");
    Scanner command = new Scanner(inputtext);
    
   
    //exit on q 
    if(inputtext.equals("q"))
        System.exit(0);
    else
    if(command.next().equals("c") && splitinput.length == 3){
    List<String> canvas = this.buildCanvas(splitinput,command);
       for (int x=0; x<canvas.size(); x++)
         System.out.println(canvas.get(x));}
    
    //is input the right length?
    else if(splitinput.length==3){
           System.out.print("Valid!");}
       else{
      System.out.println("Invalid Command");}
      
    }
    catch(Exception e){
    System.out.println("Invalid Command");
    }
    }
    
    List<String> buildCanvas(String[] splitinput, Scanner command){
    List<String> canvas = new ArrayList<>();
        int w = Integer.parseInt(splitinput[1]);
        int h = Integer.parseInt(splitinput[2]);
        String top = new String(" ");
        String side = new String("|");
        for(int i = 0; i < w ;i++){
            top = top+"-";
            side = side+" ";
        }
        side = side+"|";
        canvas.add(top);
        for(int i = 0; i < h ;i++){
            canvas.add(side);
        }
        canvas.add(top);
        return canvas;
    }
    
       
}
