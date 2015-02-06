/* NAME: Jasmine Davis and Pamela Wang
 * DATE: 4th Dec 2013
 * CS111 Pset 11
 * Task 2: Open-Ended Animation
 * Andy's Room Background Sprite
 */

import java.awt.*; // use graphics

public class AndysRoomBackground extends Sprite {
  private int height; //height of blue section of wall
  private int deltaXCloud; //change in cloud's x coordinate
  private int deltaYCloud; //change in cloud's y coordinate
  
  private int xIncrementOne; //placeholder for new x coordinate for top oval of cloud
  private int xIncrementTwo; //" " for left oval of cloud
  private int xIncrementThree; //" " for bottom oval of cloud
  
  
  public AndysRoomBackground(int height) {
    this.height = height;
    this.deltaXCloud = (height/4)*3; //deltaXCloud is always relative to the size of
       //the blue wall
    
    //deltaYCloud, xIncrementOne, -Two and -Three will be re-initialised to a value in the for loops below
    this.deltaYCloud = 0;
    this.xIncrementOne = 0;
    this.xIncrementTwo = 0;
    this.xIncrementThree = 0;
  }
  
  public void updateState() {
    //blank so Andy's room background never moves or changes regardless of frame
  }
  
  public void resetState() {
    //blank because no value is changed in updateState()
    //(values are changed and reset within the for loops)
  }
  
  public void drawState(Graphics g) {
    //BLUE BACKGROUND
    g.setColor(Color.cyan);
    g.fillRect(0, 0, 5000, height);
       //co-ordinate is (0,0) so background always starts from the top left
       //width is absurdly big so background is also absurdly wide
    
    //CLOUDS
    g.setColor(Color.white);
    //for loop of top row of clouds
    for(int n = 8, xIncrementOne = height/4, xIncrementTwo = height/6, xIncrementThree = height/10;
        //intiation
        n > 0; //boolean
        n--, xIncrementOne = xIncrementOne + deltaXCloud, xIncrementTwo = xIncrementTwo + deltaXCloud,
        xIncrementThree = xIncrementThree + deltaXCloud)
        //update variables, increasing the x-coordinate so that each cloud is farther right
    {
      g.fillOval(xIncrementOne, height/10, height/5, height/5); //top oval
      g.fillOval(xIncrementTwo, height/6, height/8, height/8); //left oval
      g.fillOval(xIncrementThree, height/4, (height/5)*2, height/14); //bottom oval
    }
    
    //for loop of middle row of clouds
    for(int n = 8, xIncrementOne = (height/4)-(height/3), xIncrementTwo = (height/6)-(height/3),
        xIncrementThree = (height/10)-(height/3), deltaYCloud = height/3;
        //intiation, including increasing y coordinate so that this row is below the top row
        n > 0; //boolean
        n--, xIncrementOne = xIncrementOne + deltaXCloud, xIncrementTwo = xIncrementTwo + deltaXCloud,
        xIncrementThree = xIncrementThree + deltaXCloud)
        //update variables, increasing x-coordinate so that each cloud is farther right
    {
      g.fillOval(xIncrementOne, height/10+deltaYCloud, height/5, height/5); //top oval
      g.fillOval(xIncrementTwo, height/6+deltaYCloud, height/8, height/8); //left oval
      g.fillOval(xIncrementThree, height/4+deltaYCloud, (height/5)*2, height/14); //bottom oval
    }
    
    //for loop of bottom row of clouds
    for(int n = 8, xIncrementOne = height/4, xIncrementTwo = height/6, xIncrementThree = height/10,
        deltaYCloud = (height/3)*2; //intiation, larger y-coordinate to be below second row
        n > 0; //boolean
        n--, xIncrementOne = xIncrementOne + deltaXCloud, xIncrementTwo = xIncrementTwo + deltaXCloud,
        xIncrementThree = xIncrementThree + deltaXCloud)
        //update variables, increase in x-coordinate so that each cloud is farther right than the previous
    {
      g.fillOval(xIncrementOne, height/10+deltaYCloud, height/5, height/5); //top oval
      g.fillOval(xIncrementTwo, height/6+deltaYCloud, height/8, height/8); //left oval
      g.fillOval(xIncrementThree, height/4+deltaYCloud, (height/5)*2, height/14); //bottom oval
    }
    
    
    //BOTTOM PART OF WALL
    g.setColor(Color.orange.darker().darker());
    g.fillRect(0, height, 5000, height/8);
    //x is 0 to always start in the left side of the screen
    //y starts at height, to start below the blue part of the wall
    //width is 5000 to encompass whole screen
    
    
    //FLOOR
    g.setColor(Color.red.darker().darker().darker());
    g.fillRect(0, height+(height/8), 5000, 5000);
    //y is height+(height/8) so that it is below the bottom part of the wall
    //height is 5000 to encompass the rest of screen
    //(reasoning for x and width is the same as BOTTOM PART OF WALL)
    
  }
  
}