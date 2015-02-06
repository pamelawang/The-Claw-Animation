/* NAME: Jasmine Davis and Pamela Wang
 * DATE: 4th Dec 2013
 * CS111 Pset 11
 * Task 2: Open-Ended Animation
 * MyShowcase
 */

import java.awt.*; // use colors

public class MyShowcase extends AnimationShowcase {

  public MyShowcase () {
    // Add any animations for your PS11 Task 2 Animation here
    // You should change the string and class name "MyAnimation"
    // to be something that reflects the nature of your project. 
    
    addAnimation("Toy Story", new ToyStoryAnimation());
  }
    
  public static void main (String[] args) {
    runAsApplication(new MyShowcase(), "MyShowcase"); 
  }
}
