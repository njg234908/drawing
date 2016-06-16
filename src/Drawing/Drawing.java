
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;
import java.io.*;
/**
 *
 * @author nicholas.gould
 */
public class Drawing {
     static void prompt(){
    System.out.print("enter command:");}
     
     static void getInput(){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try{br.readLine();
        System.out.print("Invalid Command");}
    catch(Exception e){}
   
    
}}
