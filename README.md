# One-level-game
Creating a one level but complex user friendly game using java.
//ORGANIZATION @Abdirahman,Dillon,Nyakundi,Ahmed 

4 Main CLASS 

4 MAJOR SUB CLASSES 

 

 

MAIN CLASSES (4) -- classes well be using often

GAME – LOGIC 
(Has maingame class -- contains handler and tick and render methods + the width and height, also has a for loop for the fps counter)  
 
 Game Object 
 
 (has x and y corrdinate values for the current object, also has running and falling methods, has Object ID (returns current objects id))

Window 
    has jframe for the cutrrent window also has the height 
    has constructpor which has the title,height,width, and game object
    add all the fram requirements
    add the game to the frame.
    
handler class  -- bettr than saying add -player1 ,player 2 , etc....
    handles gameobject classes using a game object lister -- just like array lister 
    use for loops to get current index of the object
    has addobject 
    has remove object
    has create level - handles current level
    

SECTION 2: MAJOR SUBCLASSES (4)

PLAYER extends gameobject ::

       CONTAINS THE FOLLOWING BASIC SUBCLASSES :

   COLLISION AND MOVEMENT (DETECTION OF COLLISION) 

    PlayerInf: (has player info // color etc...) -- spritesheet

    Movement: (deriving from main game logic we create a user-friendly movement framework)  --- HAS VELOCITY WHICH HAS A FLOAT GRAVITY LOW GRAVITY MEANS HIGHER JUMP -- HIGH GRAVITY MEANS LOW JUMP

    E.g  Hit (left click) jump (up key) left (left key) right/forward(right key) special (x key) exit (esc)  duck (down key) 

    Background: (beautiful scenery made to work expertly with collision detection) 

    We will add sub classes like date, login page etc... later 
    
    
Block extends gameobject ::
   Contains the following ::
     a single Rectangle block wich we loop over in handlers [createlevel() method -- it creates alot of blocks in symmetry]
     extends game object so we implement the constructor for this block object and also all its x,y and vely,vel x values.
     in render method add rectangle


RUNTIME::

        CONTAINS THE FOLLOWING BASIC SUBCLASSES 

    Simulation(method): (we also run it in menu class and main page class (use downcasting to achieve this) 

MAINMENU ::

         CONTAINS THE FOLLOWING BASIC SUBCLASSES 

      Play: (easy to program // need user typing script from parent game-logic // press enter) 

      Edit:  ---- WONT BE IMPLEMENTED 

        Picture of default player color on right  

        Use random color combination algorithm / have a fixed rgb or other color system on the right side of the screen (allows user to           change color to desire) 

        Replaces default of current playerinfo color to the the chosen one. (when click save) 
 
        Renames player (when click rename) 

        Both rename and coloeredit have access to player info  

        Reset. (changes back to default) if too problematic then we remove feature. 

    Credits:  

       Running text going up down of the team info. 

       Escape (from object class game-logic) pressed to go back to main 

    Exit:  

      Ends game (asks using if and only if) are you sure yes or no?  --- USE WINDOWS_LISTENER

      If sure end. 

  N/BBB – ESCAPE PRESSED HERE (MAIN MENU) CALLS (4.) 

  N/BBB - NO INPUT DETECTED (MAIN MENU) THEN THE SIMULATION METHOD IS RUN. 

MENUPAGE ::  -- AS YOU PRESS THE .EXE FILE TYOU GET THIS STARTIMNG MENU

           CONTAINS THE FOLLOWING BASIC SUBCLASSES 

    1. Start: (if pressed enter goes to main menu class) 

    2. No action object: (uses runtime class and simulation method to determine how much   time spent and plays animation/video) 
