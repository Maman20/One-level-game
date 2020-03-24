# One-level-game
Creating a one level but complex user friendly game using java.
//ORGANIZATION @Abdirahman,Dillon,Nyakundi,Ahmed 

1 OBJECT CLASS 

4 MAJOR SUB CLASSES 

 

 

1.OBJECT CLASS (1)

GAME – LOGIC (ONLY HAS A FEW COMMON INSTANCE VARIABLES // E.G CLICKING DETECTION AND KEYBOARD DETECTION.)  

Common(instance vars/functions etc..) – esc, enter, mouse click, keyboard detection, Title and bg


SECTION 2: MAJOR SUBCLASSES (4)

PLAYER  ::

       CONTAINS THE FOLLOWING BASIC SUBCLASSES :

    COLLISION AND MOVEMENT (DETECTION OF COLLISION) 

    PlayerInf: (has player info // color etc...) 

    Movement: (deriving from main game logic we create a user-friendly movement framework) 

    E.g  Hit (left click) jump (up key) left (left key) right/forward(right key) special (x key) exit (esc)  duck (down key) 

    Background: (beautiful scenery made to work expertly with collision detection) 

    We will add sub classes like date, login page etc... later 

RUNTIME::

        CONTAINS THE FOLLOWING BASIC SUBCLASSES 

    Simulation(method): (we also run it in menu class and main page class (use downcasting to achieve this) 

MAINMENU ::

         CONTAINS THE FOLLOWING BASIC SUBCLASSES 

      Play: (easy to program // need user typing script from parent game-logic // press enter) 

      Edit: 

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

      Ends game (asks using if and only if) are you sure yes or no? 

      If sure end. 

  N/BBB – ESCAPE PRESSED HERE (MAIN MENU) CALLS (4.) 

  N/BBB - NO INPUT DETECTED (MAIN MENU) THEN THE SIMULATION METHOD IS RUN. 

MENUPAGE ::

           CONTAINS THE FOLLOWING BASIC SUBCLASSES 

    1. Start: (if pressed enter goes to main menu class) 

    2. No action object: (uses runtime class and simulation method to determine how much   time spent and plays animation/video) 
