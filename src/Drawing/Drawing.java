
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
    List<String> canvas;
    int w;
    int h;
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
    if(splitinput[0].equals("c") && splitinput.length == 3){
       canvas = this.buildCanvas(splitinput,command);
       this.printCanvas();}
    
    else if(splitinput[0].equals("l") && splitinput.length == 5){
    try{ int x1 = Integer.parseInt(splitinput[1]);
         int y1 = Integer.parseInt(splitinput[2]);
         int x2 = Integer.parseInt(splitinput[3]);
         int y2 = Integer.parseInt(splitinput[4]);
         //vertical line
         if(x1==x2){
         String line ="|";
         int height = (y2-y1);
         for(int i=1;i<x1;i++)
             line = line+" ";
         line = line+"*";
         for(int i=x1;i<w;i++)
             line= line+" ";
         line=line+"|";
         for(int i=y1;i<=y2;i++)
            canvas.set(i, line);
         this.printCanvas();  }
         
         
         //horizontal line
         else if(y1==y2){
         String line ="|";
         int length = (x2-x1);
         for(int i=1;i<x1;i++)
             line = line+" ";
         for(int i=0;i<=length;i++)
             line= line+"*";
         for(int i=x2;i<w;i++)
             line= line+" ";
         line=line+"|";
         canvas.set(y1, line);
         this.printCanvas();   
             
         }
    }
    catch (Exception e){
       System.out.println("Invalid Command");}
       
    }
    
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
        w = Integer.parseInt(splitinput[1]);
        h = Integer.parseInt(splitinput[2]);
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
    void printCanvas(){
      for (int x=0; x<canvas.size(); x++)
         System.out.println(canvas.get(x));}
    
       
}
