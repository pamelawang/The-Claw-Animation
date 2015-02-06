/* NAME: Jasmine Davis and Pamela Wang
 * DATE: 4th Dec 2013
 * CS111 Pset 11
 * Task 2: Open-Ended Animation
 * Toy Story Animation
 */

import java.awt.*; // graphics

class ToyStoryAnimation extends Animation
{ 
  public ToyStoryAnimation()
  {
    //AndysRoomBackground(height)
    
    //Alien (int x, int y, int height) <-- this alien won't move
    //Alien (int x, int y, int height, int delay) <-- this alien will move up with claw
    
    //Claw (int x, int size, int stopY, int delay)
    
    //EndBackground(int delayBackground)
    
    this.addSprite(new AndysRoomBackground(250)); //background
    this.addSprite(new Alien(600, 240, 100)); //background alien, doesn't move
    this.addSprite(new Alien(290, 200, 200, 80)); //alien that is picked up
    this.addSprite(new Claw(350, 200, 200, 20)); //claw
    this.addSprite(new Alien(-40, 300, 450)); //alien doesn't move, foreground alien
    this.addSprite(new EndBackground(180)); //black background
    this.addSprite(new Claw(450, 300, 150, 215)); //final Claw, so the end scene says
       //"The Claw"
    
    //this.setNumberFrames(Animation.NO_MAX_FRAMES);
    this.setNumberFrames(275);
    // this.setNumberRepeats(2);
    // this.setNumberRepeats(Animation.FOREVER);
    this.setFrameSize(700, 400);
  }
}