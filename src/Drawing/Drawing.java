
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
    //An Arraylist to hold the drawing
    private static List<String> canvas = new ArrayList<>();
    
    //prompt the user for a command
    static void prompt(){
    System.out.print("enter command:");}
    
    //get input from the user
    static void getInput(){
    //get console input    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
// tokenize input
    try{String[] command = br.readLine().split("\\s");
    
    //draw a basic canvas 
    if(command[0].equals("c") && command[1].equals("1") && command[2].equals("1")){
        canvas.add("-");
        canvas.add("| |");
        canvas.add("-");
       for (int x=0; x<canvas.size(); x++)
         System.out.println(canvas.get(x));}
    
    //is input the right length?
       else if(command.length ==3){
           System.out.print("Valid!");}
       else{
      System.out.print("Invalid Command");}
    }
    catch(Exception e){
    System.out.print("Exception getting input");
    }
    
       
}}
