import java.util.Random;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Auditable Banking
// Files: JunglePark.java,
// Course: CS300, Fall 2018
//
// Author: Ajmain Naqib
// Email: naqib@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __ Write-up states that pair programming is allowed for this assignment.
// __ We have both read and understand the course Pair Programming Policy.
// __ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 *
 */
public class JunglePark {

    private static PApplet processing; // PApplet object that represents the graphic
    // interface of the JunglePark application
    private static PImage backgroundImage; // PImage object that represents the
    // background image
    private static Tiger[] tigers; // array storing the current tigers present
    // in the Jungle Park

    private static Random randGen; // Generator of random numbers

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Utility.startApplication();
    }

    /**
     * Defines the initial environment properties of the application
     * 
     * @param processingObj represents a reference to the graphical interface of the application
     */
    public static void setup(PApplet processingObj) {
        // DEBUG AJ
        System.out.println("Starting setup sequence");

        processing = processingObj; // initialize the processing field to the one passed into
        // the input argument parameter


        // initialize and load the image of the background
        backgroundImage = processing.loadImage("images/background.png");



        randGen = new Random(); // create a Random object and store its reference in randGen

        tigers = new Tiger[8];

    }


    public static void update() {
        // DEBUG AJ
        // System.out.println("Starting update sequence");

        // Set the color used for the background of the Processing window
        processing.background(245, 255, 250); // Mint cream color
        // Draw the background image at the center of the screen
        processing.image(backgroundImage, processing.width / 2, processing.height / 2);
        // width [resp. height]: System variable of the processing library that stores the width
        // [resp. height] of the display window.



        // tigers[0].setPositionX(processing.mouseX);
        // tigers[0].setPositionY(processing.mouseY);

        // tigers[0].setPositionX(processing.width / 2);
        // tigers[0].setPositionY(processing.height / 2);


//        tigers[0].draw();


         for(int i=0; i< tigers.length ; i++) {
//         tigers[i] = new Tiger(processing, (float)randGen.nextInt(processing.width),
//         (float)randGen.nextInt(processing.height));
        
         if(tigers[i] != null) {
         tigers[i].draw(); // where i is the index of the created tiger in the tigers array.
         }
         }

    }

    public static boolean isMouseOver(Tiger tiger) {
        PImage tigerImg = tiger.getImage();
        float tigerWUpper = tigerImg.width / 2 + tiger.getPositionX();
        float tigerHUpper = tigerImg.height / 2 + tiger.getPositionY();
        float tigerWLower = -tigerImg.width / 2 + tiger.getPositionX();
        float tigerHLower = -tigerImg.height / 2 + tiger.getPositionY();

        // DEBUG AJ
//        System.out.println("tigerWUpper: " + tigerWUpper + " tigerHUpper: " + tigerHUpper
//            + " tigerWLower: " + tigerWLower + " tigerHLower: " + tigerHLower);
//        System.out.println("mouseX: " + processing.mouseX + " mouseY: " + processing.mouseY);

        // if(processing.mouseX < tigerWUpper && processing.mouseX > tigerWLower)
        // System.out.println("MOUSEX ON TIGER ");
        //
        // if(processing.mouseY < tigerHUpper && processing.mouseY > tigerHLower)
        // System.out.println("MOUSEY ON TIGER ");


        if (processing.mouseX < tigerWUpper && processing.mouseX > tigerWLower
            && processing.mouseY < tigerHUpper && processing.mouseY > tigerHLower)
            return true;
        else
            return false;

    }
    
    /*
     * This method should check if the mouse is over one of the tiger objects stored in the tigers
     * array and sets the isDragging field defined this tiger object if any to true. You can use the
     * setDragging() method defined in the Tiger class to set this isDragging field as described in
     * the Tiger class javadoc documentation provided here. Note that if the mouse is over more than
     * one tiger, only the tiger with the first lowest index will be considered.
     */

    public static void mouseDown() {
        
        boolean hover;
        
        for(int i=0; i< tigers.length ; i++) {
            hover = false;
            if(tigers[i] != null) {
            hover = isMouseOver(tigers[i]);
            
            if(hover) {
                tigers[i].setDragging(hover);
                break;
            }}
        }
        
        
        
    }

    /*
     * This method should set isDragging field of every tiger object stored in the tigers array to false. No tiger is being dragged when the mouse is released.
     */
    
    public static void mouseUp() {
        
        for(int i=0; i< tigers.length ; i++) {

            if(tigers[i] != null) {
                tigers[i].setDragging(false);
        }
        }
    }
    
    public static void keyPressed() { 
     // DEBUG AJ
         System.out.println("Starting keyPressed sequence");
        
         char pressed = processing.key; 

         System.out.println("pressed: " + pressed);
        
        if(Character.toLowerCase(pressed) == 't') {
            for (int i = 0; i < tigers.length; i++) {
                
                if(tigers[i] == null) {
                    tigers[i] = new Tiger(processing, (float) randGen.nextInt(processing.width),
                        (float) randGen.nextInt(processing.height));
                    break;
                    }
                
               
            }
        }
        
        if(Character.toLowerCase(pressed) == 'r') {
            for (int i = 0; i < tigers.length; i++) {
                
                if(tigers[i] != null) {
                    tigers[i] = null;
                    break;
                    }
                
                
            }
        }
        
    }
    

}
