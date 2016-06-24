
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
    int width;
    int height;
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
    if(inputtext.equals("Q"))
        System.exit(0);
    else
    
    //valid build canvas command
    if(splitinput[0].equals("C") && splitinput.length == 3){
       canvas = this.buildCanvas(splitinput,command);
       this.printCanvas();}
    
    //draw line command
    else if(splitinput.length == 5){
    try{ int x1 = Integer.parseInt(splitinput[1]);
         int y1 = Integer.parseInt(splitinput[2]);
         int x2 = Integer.parseInt(splitinput[3]);
         int y2 = Integer.parseInt(splitinput[4]);
         
         if ((x1>0 && y1>0 && x2>0 && y2>0) && (x1 <=width && x2 <=width) && (y1 <=height && y2 <=height)){
             if(splitinput[0].equals("L")){
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
    }
        //rectangle
        else if((splitinput[0].equals("R"))){
          drawHorizontalLine(x1,y1,x2,y1);
          drawHorizontalLine(x1,y2,x2,y2);
          drawVerticalLine(x1,y1,x1,y2);
          drawVerticalLine(x2,y1,x2,y2);
          this.printCanvas();
          
       }
        else this.invalidCommand();
    }else this.invalidCommand();
    }
    catch (Exception e){
       this.invalidCommand();}
       
    }
    /*
    //Bucket Fill
    else if(splitinput.length == 4 && splitinput[0].equals("B") && splitinput[3].length()==1 ){
    try{ int x1 = Integer.parseInt(splitinput[1]);
         int y1 = Integer.parseInt(splitinput[2]);
         char colour = splitinput[3].charAt(0);
         
         StringBuilder line = new StringBuilder(canvas.get(y1));
         
         //check point is not already part of a line
         if(line.charAt(x1)!= 'x'){
             this.fillHorizontalLine(x1,y1,line,colour);
             //line = new StringBuilder (canvas.get(y1));
             //this.fillVerticalLine(x1,y1,line,colour);
               
         //fill lines above
         for(int a=y1+1;a<=h;a++){
             StringBuilder currentLine = new StringBuilder(canvas.get(a));
             
             if(currentLine.charAt(x1)!= 'x'){
             //fill current line
             this.fillHorizontalLine(x1, a, currentLine, colour);
            
             }}
         //fill lines below
         for(int a=y1-1;a>0;a--){
             StringBuilder currentLine = new StringBuilder(canvas.get(a));
             
             if(currentLine.charAt(x1)!= 'x'){
             //fill current line
             this.fillHorizontalLine(x1, a, currentLine, colour);
             }
         
         }
         //fill lines right
         //for(int a=x1;a<=w;a++)
         //    this.fillVerticalLine(a,y1,line,colour);     
         
         //fill lines left
         //for(int a=x1-1;a>0;a--)
         //    this.fillVerticalLine(a,y1,line,colour);     
         
         }
         
       this.printCanvas();
    }catch (Exception e){
       System.out.println("Invalid Command");}
         
         
    
    }*/
   
    
       else{
      this.invalidCommand();}
      
    }
    catch(Exception e){
    this.invalidCommand();
    }
    
    }
    
    void invalidCommand(){
        System.out.println("Invalid Command");
    }
    
    List<String> buildCanvas(String[] splitinput, Scanner command){
    List<String> canvas = new ArrayList<>();
        width = Integer.parseInt(splitinput[1]);
        height = Integer.parseInt(splitinput[2]);
        String top = new String(" ");
        String side = new String("|");
        for(int i = 0; i < width ;i++){
            top = top+"-";
            side = side+" ";
        }
        side = side+"|";
        canvas.add(top);
        for(int i = 0; i < height ;i++){
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
    
    void fillHorizontalLine(int x1, int y1, StringBuilder line,char colour){
    //fill current line
             int i = x1;
             while(line.charAt(i)!='x'&& i<=width){
                 //System.out.println("i:"+i);
                 line.setCharAt(i, colour);
                 i++;
             }
             int j = x1;
             while(line.charAt(j)!='x'&& j>0){
                 //System.out.println("i:"+i);
                 line.setCharAt(j, colour);
                 j--;
             }
         canvas.set(y1, line.toString());}
    
    void fillVerticalLine(int x1,int y1,StringBuilder line,char colour){
        int i = y1;
        while(line.charAt(x1)!='x' && i<height){
            line.setCharAt(x1, colour);
            canvas.set(i, line.toString());
            i++;
            line = new StringBuilder(canvas.get(i));        
        }
        int j = y1;
        while(line.charAt(x1)!='x' && j>0){
            line.setCharAt(x1, colour);
            canvas.set(j, line.toString());
            j--;
            line = new StringBuilder(canvas.get(j));        
        }
    }
}
