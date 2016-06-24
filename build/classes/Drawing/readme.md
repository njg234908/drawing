## Drawing project for Springer Nature Code Problem June 2016

To compile the project:
javac Drawing.java

To run the program:
java -classpath . Drawing.Drawing

A console drawing application supporting the following commands:

C w h - Creates a new canvas of width w and height h.
L x1 y1 x2 y2 - Creates a new line from (x1,y1) to (x2,y2). Only supports horizontal or vertical lines. Horizontal and vertical lines are drawn using the 'x'character.
R x1 y1 x2 y2 - Creates a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines are drawn using the 'x' character.
Q - Quits the program.

## To Do

B x y c Should fill the entire area connected to (x,y) with colour 'c'. The behaviour of this is the same as that of the "bucket fill" tool in paint programs.

## Tests

Tests using JUnit are in DrawingTest.java

## Approach

I tried to use a TDD approach, creating tests, breaking them, improving them etc.

Input validation should be robust, with anything other than a valid command resulting in an error message.

I have not specified a maximum canvas size, the upper limit would depend on screen size but it would probably be sensible to add one.

For minimum canvas size I have just enforced that dimensions must be positive integers over zero. A 1x1 canvas is not really workable so perhaps a larger minimum would make sense.

I have not completed the last part of the problem - to perform the bucket fill. After spending a bit of effort on a non-workable solution I focused on making the application more robust before submission. Should I have had time my next steps would have been to work on implementing one of the Flood Fill approaches described [here](https://en.wikipedia.org/wiki/Flood_fill) 


