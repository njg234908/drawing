
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;
import java.io.*;
import java.util.*;
import java.lang.*;
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
    
    //valid build canvas command
    if(splitinput[0].equals("c") && splitinput.length == 3){
       canvas = this.buildCanvas(splitinput,command);
       this.printCanvas();}
    
    //valid draw line command
    else if(splitinput.length == 5){
    try{ int x1 = Integer.parseInt(splitinput[1]);
         int y1 = Integer.parseInt(splitinput[2]);
         int x2 = Integer.parseInt(splitinput[3]);
         int y2 = Integer.parseInt(splitinput[4]);
         
         if (splitinput[0].equals("l")){
         //vertical line
         if(x1==x2){
         drawVerticalLine(x1,y1, x2, y2);
         this.printCanvas();
         }      
         
         //horizontal line
         else if(y1==y2){
             drawHorizontalLine(x1,y1, x2, y2);
             this.printCanvas();
         }
    }
        //rectangle
        else if((splitinput[0].equals("R"))){
          drawHorizontalLine(x1,y1,x2,y1);
          drawHorizontalLine(x1,y2,x2,y2);
          drawVerticalLine(x1,y1,x1,y2);
          drawVerticalLine(x2,y1,x2,y2);
          this.printCanvas();
          
       }
    }
    catch (Exception e){
       System.out.println("Invalid Command");}
       
    }
   
    
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
    
    void drawVerticalLine(int x1,int y1, int x2, int y2){
        for(int i=y1;i<=y2;i++){
            StringBuilder line = new StringBuilder(canvas.get(i));
            line.setCharAt(x1, 'x');
            canvas.set(i, line.toString());
         }   
           } 
    
    void drawHorizontalLine(int x1,int y1, int x2, int y2){
       StringBuilder line = new StringBuilder(canvas.get(y1));
         for(int i=x1;i<=x2;i++)
            line.setCharAt(i, 'x');
         canvas.set(y1, line.toString());  
             
         }
    
       
}
