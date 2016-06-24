
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
    int width;
    int height;
    
    //prompt the user for a command
    void prompt(){
        System.out.print("Enter Command:");
    }
    
    //get input from the user
    void getInput(){  
    //get console input    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //tokenize input
    try{
        String inputtext = br.readLine();
        String[] splitinput = inputtext.split("\\s");
        Scanner command = new Scanner(inputtext);
        
        //exit on Q 
        if(inputtext.equals("Q"))
            System.exit(0);
        else
        //valid build canvas command
        if(splitinput[0].equals("C") && splitinput.length == 3){
            try{
                width=Integer.parseInt(splitinput[1]);
                height =Integer.parseInt(splitinput[2]);
                
            //dimensions above minimum allowed    
            if (width >0 && height >0){    
                canvas = this.buildCanvas();
                this.printCanvas();
            }
            else
                this.invalidCommand();
            }
            catch (Exception e){
                this.invalidCommand();
            }
            }
        //draw line command
        else if(splitinput.length == 5){
            try{ 
                int x1 = Integer.parseInt(splitinput[1]);
                int y1 = Integer.parseInt(splitinput[2]);
                int x2 = Integer.parseInt(splitinput[3]);
                int y2 = Integer.parseInt(splitinput[4]);
         
                if ((x1>0 && y1>0 && x2>0 && y2>0) && (x1 <=width && x2 <=width) && (y1 <=height && y2 <=height)){
                    switch (splitinput[0]) {
                        case "L":
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
                            else this.invalidCommand();
                            break;
                        case "R":
                            drawHorizontalLine(x1,y1,x2,y1);
                            drawHorizontalLine(x1,y2,x2,y2);
                            drawVerticalLine(x1,y1,x1,y2);
                            drawVerticalLine(x2,y1,x2,y2);
                            this.printCanvas();
                            break;
                        default:
                            this.invalidCommand();
                            break;
                    }
                }
            else this.invalidCommand();
            }
            catch (Exception e){
                this.invalidCommand();
            }
       
        }    
        else{
            this.invalidCommand();
        }
      
    }
    catch(Exception e){
        this.invalidCommand();
    }
    
}
    //message on invalid command
    void invalidCommand(){
        System.out.println("Invalid Command");
    }
    
    //build a canvas to specified dimensions
    List<String> buildCanvas(){
        List<String> canvasbuild;
        canvasbuild = new ArrayList<>();
        String top = " ";
        String side = "|";
        for(int i = 0; i < width ;i++){
            top = top+"-";
            side = side+" ";
        }
        side = side+"|";
        canvasbuild.add(top);
        for(int i = 0; i < height ;i++){
            canvasbuild.add(side);
        }
        canvasbuild.add(top);
        return canvasbuild;
    }
    
    //print the canvas
    void printCanvas(){
      for (int x=0; x<canvas.size(); x++)
         System.out.println(canvas.get(x));}
    
    //draw vertical line between specified coords
    void drawVerticalLine(int x1,int y1, int x2, int y2){
        for(int i=y1;i<=y2;i++){
            StringBuilder line = new StringBuilder(canvas.get(i));
            line.setCharAt(x1, 'x');
            canvas.set(i, line.toString());
         }   
           } 
    //draw horizontal line between specified coords
    void drawHorizontalLine(int x1,int y1, int x2, int y2){
       StringBuilder line = new StringBuilder(canvas.get(y1));
         for(int i=x1;i<=x2;i++)
            line.setCharAt(i, 'x');
         canvas.set(y1, line.toString());  
             
    }
}
