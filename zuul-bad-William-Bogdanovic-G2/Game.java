
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class.
 * 
 *  This main class creates the necessary implementation objects and starts the game off.
 * 
 * @author  Michael Kolling and David J. Barnes and Bogdanovic William
 * @version 2.0 (Jan 2003) DB edited (2019)
 */

public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Create the game and initialise its internal map. Create the inerface and link to it.
     * 
     */
    public Game() 
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface(this.aEngine);
        this.aEngine.setGUI(this.aGui);
    }//Game()
    
    /**
     * Main method to start the game.
     */
    public static void main(String[] args) 
    {
        Game game = new Game();
        // possibly add more code here if you need to do additional setup
    }//main(String[] args)

}//Game
