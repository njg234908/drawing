
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
     static void prompt(){
    System.out.print("enter command:");}
     
     static void getInput(){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try{String[] command = br.readLine().split("\\s");
    if(command[0].equals("c") && command[1].equals("1") && command[2].equals("1")){
       System.out.print("-\n| |\n-");}
       else if(command.length ==3){
           System.out.print("Valid!");}
       else{
      System.out.print("Invalid Command");}
    }
    catch(Exception e){
    System.out.print("Exception");
    }
    
       
}}
