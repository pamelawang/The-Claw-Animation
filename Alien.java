/* NAME: Jasmine Davis and Pamela Wang
 * DATE: 4th Dec 2013
 * CS111 Pset 11
 * Task 2: Open-Ended Animation
 * Alien Sprite
 */

import java.awt.*; // use graphics

public class Alien extends Sprite {
  //instance variables
  private int x;
  private int y;
  private int width; //total width of body
  private int height; //total height of body
  private int delay; //# of frames before Alien moves up with Claw
  private int originalY; //placeholder for original Y value
  private int deltaY; //new y co-ordinate
  
  private Color bodyColor;
  private Color bodyAccent;
  
  private int frameCounter;
  
  //constructor #1 - this alien doesn't move
  public Alien (int x, int y, int height) {
    this.x = x;
    this.y = y;
    this.width = (height/8)*5;
    this.height = height;
    this.bodyColor = Color.blue.brighter().brighter().brighter(); //light blue of clothing
    this.bodyAccent = Color.blue.darker().darker().darker(); //dark blue
    this.delay = 0; //default setting so Alien doesn't move
    this.originalY = y;
    this.deltaY = originalY;
    this.frameCounter = 0; //default frameCounter value
   }
  
  //constructor #2 - when delay is stated, so that alien moves after the delay
  public Alien (int x, int y, int height, int delay) {
    this.x = x;
    this.y = y;
    this.width = (height/8)*5;
    this.height = height;
    this.bodyColor = Color.blue.brighter().brighter().brighter(); //light blue of clothing
    this.bodyAccent = Color.blue.darker().darker().darker(); //dark blue
    this.delay = delay;
    this.deltaY = originalY;
    this.originalY = y;
    this.frameCounter = 0; //default value
   }
  
  
  //methods for animation
  public void resetState() {
    deltaY = originalY; //sets deltaY to the original y coordinate
    y = originalY; //puts Alien in original position
    frameCounter = 0; //reset frame count
  }
  
  public void updateState() {  
    frameCounter++; //increases frame count each time there is a new frame
    
    if (delay <= 0) {
      //no movement
    } else if(frameCounter >= delay) {
        //when the frame count is the same or greater than the delay, Alien should move
        
        deltaY = deltaY - 5;
        //fixed movement rate, so it is always the same to the movement rate of the Claw
        //deltaY decreases so that Alien moves upwards
    }
    
    y = deltaY;
  }
  
  public void drawState (Graphics g) {
    /* NOTE: many variables in drawState are strange (i.e. height/5 or width/26) because we
     * didn't want to put in fixed values, so that no matter the size of the alien
     * the ratio remains consistent
     */
    
    g.setColor(bodyColor); //blue of clothing
    
    //torso/legs
    g.fillRect(x, y, width,((height/3)*2));
    
    //arms
    Polygon leftArm = new Polygon();
    leftArm.addPoint(x,y);
    leftArm.addPoint(x-(height/6),y+(height/6)); //upper sleeve point
    leftArm.addPoint(x-(height/12),y+(height/4)); //lower sleeve point
    leftArm.addPoint(x,y+(height/5)); //shoulder/top point
    g.fillPolygon(leftArm);
    
    Polygon rightArm = new Polygon();
    rightArm.addPoint(x+width-1,y);
    rightArm.addPoint((x+(height/6)+width-1),y+(height/6)); //upper sleeve point
    rightArm.addPoint((x+(height/12)+width-1),y+(height/4)); //lower sleeve point
    rightArm.addPoint((x+width-1),y+(height/5)); //shoulder/top point
    g.fillPolygon(rightArm);
    
    g.setColor(bodyAccent); //dark blue
    
    //belt
    g.fillRect(x, y+(height/3), width, height/12);
    
    //feet
    g.fillOval(x-(height/24), y+(2*(height/3)-(height/18)),
               (width/2 + height/24), height/8); //left foot
    g.fillOval(x+(width/2), y+(2*(height/3)-(height/18)),
               (width/2 + height/24), height/8); //right foot
    
    //collar
    g.setColor(Color.magenta.darker());
    g.fillOval(x, y-(height/24), width, height/12);
   
    //head
    g.setColor(Color.green);
    g.fillOval(x-(height/24), y-((height/3)), width+(height/12), height/3);
    
    //antenna
    Polygon antenna = new Polygon();
    antenna.addPoint(x+(width/2), y-(height/2)); //top of triangle
    antenna.addPoint(x+(width/2)-(height/40), y-(height/3)+2); //bottom left point
    antenna.addPoint(x+(width/2)+(height/40) , y-(height/3)+2); //bottom right point
    g.fillPolygon(antenna);
    g.fillOval(x+(width/2)-(height/50), y-(height/2), width/15,width/15); //circle tip of antenna
    
    //ears
    Polygon leftEar = new Polygon();
    leftEar.addPoint(x-(height/8),y-(height/3)); //top
    leftEar.addPoint(x-(height/14), y-(height/10)); //bottom
    leftEar.addPoint(x-(height/200), y-(height/6)); //middle
    g.fillPolygon(leftEar);
                     
    Polygon rightEar = new Polygon();
    rightEar.addPoint(x+(height/8)+width,y-(height/3)); //top
    rightEar.addPoint(x+(height/14)+width, y-(height/10)); //bottom
    rightEar.addPoint(x+(height/200)+width, y-(height/6)); //middle
    g.fillPolygon(rightEar);
    
    //hands
    g.fillOval(x-(height/4),y+(height/6), width/3, width/5); //left hand
    g.fillOval((x+width+height/16),y+(height/6), width/3, width/5); //right hand
    
    //leg line
    g.setColor(bodyAccent); //dark blue
    g.drawLine(x+(width/2),y+(height/2),x+(width/2),y+(width)+(height/20));
    
    //left eye
    g.setColor(Color.white);
    g.fillOval(x-(height/200), y-(height/4), width/3, width/5);
    //left pupil
    g.setColor(Color.black);
    g.fillOval(x-(height/200)+(width/10), y-(height/4), width/10, width/10);
    
    //middle eye
    g.setColor(Color.white);
    g.fillOval(x-(height/200)+(width/3)+(width/28), y-(height/3)+(width/20),
               width/3, width/5);
    //middle pupil
    g.setColor(Color.black);
    g.fillOval(x-(height/200)+(width/10)+(width/4)+(width/10)+(width/20), y-(width/2),
               width/10, width/10);
    
    //right eye
    g.setColor(Color.white);
    g.fillOval(x-(height/200)+(width/2)+(width/5), y-(height/4), width/3, width/5);
    //right pupil
    g.setColor(Color.black);
    g.fillOval(x-(height/200)+(width/10)+(width/2)+(width/5), y-(height/4),
               width/10, width/10);
    
    //mouth
    g.setColor(Color.green.darker().darker());
    Polygon mouth = new Polygon();
    mouth.addPoint(x-(height/200)+(width/3)+(width/28), y-(height/10)); //left top point
    mouth.addPoint(x-(height/200)+(width/2)+(width/6), y-(height/10)); //right top point
    mouth.addPoint(x-(height/200)+(width/2), y-(height/20)); //bottom top point
    g.fillPolygon(mouth);
    
    
  }
}