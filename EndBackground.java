/* NAME: Jasmine Davis and Pamela Wang
 * DATE: 4th Dec 2013
 * CS111 Pset 11
 * Task 2: Open-Ended Animation
 * End Background Sprite
 */

import java.awt.*; // use graphics

public class EndBackground extends Sprite {
  private int delayBackground;
  private int delayWord;
  
  private int frameCounter;
  
  public EndBackground(int delayBackground) {
    this.delayBackground = delayBackground; //delay for background to come on
    this.delayWord = delayBackground + 10; //after 10 frames, the word will appear
    
    this.frameCounter = 0;
  }
  
  public void updateState() {
    frameCounter++; //every time there is a new frame, frameCounter increases
  }
  
  public void resetState() {
    frameCounter = 0;
  }
  
  public void drawState(Graphics g) {
    
    if (frameCounter >= delayBackground) {
      g.setColor(Color.black);
      g.fillRect(0, 0, 5000, 5000); //draws black background
      //size is 5000, 5000 to cover whole screen
      
      //changes font size to be bigger than default
      g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
      
      if(frameCounter >= delayWord) { //after the background has appeared
        g.setColor(Color.yellow);
        g.drawString("The", 280, 200);
      }
      
      if(frameCounter >= (delayWord+15)) { //after the background has appeared
        g.setColor(Color.yellow);
        g.drawString("CLAW", 420,200);
      }
    }
  }
  
}