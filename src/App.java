import java.util.ArrayList;

import processing.core.*;

public class App extends PApplet {
    //bubble firstOne;
    ArrayList<bubble> bubbles; //Creates an array list for bubbles
    double timer;
    int scene;
    double highscore;//Making it in arraylist makes the highscore not reset
    double gameStart;
    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
       // firstOne = new bubble(50, 100, this); // *This* giving the bubble access to the screen
        bubbles = new ArrayList<>(); //Assigns + creates the array list
        for (int i = 0; i < 4; i++){
            bubbleMaker();
        }
        scene = 0;
        gameStart = millis();
    }

    public void settings() {
        size(400, 400);
    }

    public void draw() {
        background(0);
        
        if (scene == 0){
            for (bubble b : bubbles){ //Makes the bubbles actually show up on the screen
            b.display(); //Dont need to call canvas because you are in the main app
            b.update();
        }
        fill(255);
        textSize(50);
        textAlign(RIGHT); //Makes it allign to the top right
        timer = millis() - gameStart; 
        timer = ((int)(timer/100))/10.0; // thousands of seconds its been running
        text("" + timer , width - 100, 50); // Makes the "" not mad
        if (bubbles.size() == 0){
            scene = 1;
            if(highscore < timer){
                highscore = timer; 
            }
        }
        }else {
            text("Score " + timer, 200, 200);
            text("High Score " + highscore, 200, 100);
        }

    }
    public void bubbleMaker(){
         int x = (int)random(400); //When you press space a bubble should appear in a random spot
            int y = (int)random(400);
 
            bubble bubble = new bubble(x, y, this);
            bubbles.add(bubble); //Adding to the array list

            // for (int i = 0; i < 100; i++){ //Makes 10 bubbles go every click
    }
    public void keyPressed(){
        if (key == ' '){
            if (scene == 0){
                   bubbles.clear();
             } else{
                setup();
             }
            }
           
        }

        public void mousePressed(){
          //  for(bubble b: bubbles)
          // //This gives an error called (concurrent Modification Exception)
               //In a for each loop it really does not want you to remove things 

          for(int i = 0; i < bubbles.size(); i++){ //Get out of the error you use this for loop
            bubble b = bubbles.get(i);
             if(b.checkTouch(mouseX, mouseY) == false);
               bubbles.remove(b); 
    
          }
             
        }



    }

