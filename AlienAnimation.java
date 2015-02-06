/* NAME: Jasmine Davis and Pamela Wang
 * DATE: 4th Dec 2013
 * CS111 Pset 11
 * Task 2: Open-Ended Animation
 * AlienAnimation
 */
import java.awt.*; 

class AlienAnimation extends Animation
{ 
  public AlienAnimation() {
    //Alien (int x, int y, int height)
    //Alien (int x, int y, int height, int delay)
    this.addSprite(new Alien(300, 200, 200, 20));
    
    
    
    
    this.setNumberFrames(300);
  }
} // class AlienAnimation