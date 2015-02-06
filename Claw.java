/* NAME: Jasmine Davis and Pamela Wang
 * DATE: 4th Dec 2013
 * CS111 Pset 11
 * Task 2: Open-Ended Animation
 * Claw Sprite
 */

import java.awt.*; // use graphics

public class Claw extends Sprite {
  //instance variables
  private int x; //x co-ordinate of the middle part of the bottom rectangle side
  private int y; //y co-ordinate of the middle part of the bottom rectangle side
  private int size; //height of grabbing part of Claw
  private int originalY; //placeholder for original Y value
  private int deltaY; //new y co-ordinate
  
  private int stopY;
  //the y co-ordinate where Claw stops moving down, and goes up
  //stopY has to be the same as Alien's y co-ordinate
  
  private int upOrDown; //indicates whether claw should go up or down
  //down = -1, up = 1
  
  private int delay; //number of frames the claw shouldn't move
  private int frameCounter;

  
  //constructor
  public Claw (int x, int size, int stopY, int delay) {
    this.x = x; //need to specify x to Alien's x value
    this.y = 0 - size; //Claw is just above viewable part of screen
    this.size = size;
    this.deltaY = originalY; //starting value of deltaY value
    this.originalY = y; //placeholder y co-ordinate
    this.stopY = stopY;
    this.upOrDown = -1; //Claw always goes down first, by default
    this.delay = delay;
    this.frameCounter = 0; //default value
  }
  
  
  //methods for animation
  public void resetState() {
    deltaY = originalY; //reset to starting y value
    y = originalY; //reset to original y position
    upOrDown = -1; //prepared to go down first
    frameCounter = 0;
  }
  
  public void updateState() {  
    frameCounter++; //counts number of frames
    
    if (frameCounter >= delay) {
      if (upOrDown == -1) { //if Claw is going down
        deltaY = deltaY + 5; //y co-ordinate increases by 5
      } else if(upOrDown == 1) { //when Claw is told to go up
        deltaY = deltaY - 5;
        //fixed movement rate, so it is always the same to the movement rate of the Alien
      }
    }
    
    y = deltaY; //changes y co-ordinate
    
    if ((y+(size/2)) == stopY) { //if Claw has gone down enough
      upOrDown = 1; //command Claw to go up
    }
    
  }
  
  public void drawState (Graphics g) {
    //NOTE: x and y coordinates are the middle of of rectangle Claw part
    
    //rectangle part
    g.setColor(Color.black);
    g.fillRect(x-(size/8), y-5000, size/4, 5000); //5000 is used to make the Claw so long
    //that the top part of the Claw can never be in frame
    
    //left top grabbing part
    g.setColor(Color.gray);
    Polygon topLeftTriangle = new Polygon();
    topLeftTriangle.addPoint(x, y); //top point
    topLeftTriangle.addPoint(x-(size/4), y+(size/2)); //bottom right point
    topLeftTriangle.addPoint(x-(size/2), y+(size/2)); //bottom left point
    g.fillPolygon(topLeftTriangle);
    
    //right top grabbing part
    Polygon topRightTriangle = new Polygon();
    topRightTriangle.addPoint(x, y); //top point
    topRightTriangle.addPoint(x+(size/4), y+(size/2)); //bottom right point
    topRightTriangle.addPoint(x+(size/2), y+(size/2)); //bottom left point
    g.fillPolygon(topRightTriangle);
    
    //left bottom grabbing part
    g.setColor(Color.lightGray);
    Polygon bottomLeftTriangle = new Polygon();
    bottomLeftTriangle.addPoint(x-(size/2), y+(size/2)); //top left point
    bottomLeftTriangle.addPoint(x-(size/4), y+(size/2)); //top right point
    bottomLeftTriangle.addPoint(x-(size/8), y+((size/2)*2)); //bottom point
    g.fillPolygon(bottomLeftTriangle);
    
    //right bottom grabbing part
    Polygon bottomRightTriangle = new Polygon();
    bottomRightTriangle.addPoint(x+(size/2), y+(size/2)); //top left point
    bottomRightTriangle.addPoint(x+(size/4), y+(size/2)); //top right point
    bottomRightTriangle.addPoint(x+(size/8), y+((size/2)*2)); //bottom point
    g.fillPolygon(bottomRightTriangle);
    
  }
}