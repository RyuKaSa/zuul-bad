

/**
 * Object that lets the player tp back to a previous room he cleared
 * 
 * @author Bogdanovic William
 * @version (april 2021)
 */
public class Beamer extends Item//type of item
{
    private Room        aMemorizedRoom;
    private Player      aPlayer;
    //private GameEngine  aGameEngine;
    private boolean     aCharged;
    //private boolean     aUsed;

    
    /**
     * constructor of beamer
     * 
     * 
     */
    public Beamer(/*final GameEngine pGameEngine*/)
    {
        super( "Ring_Of_Souvenirs", "this legendary relic lets the weilder teleport back to a place he remembers vividly.", false, 0.2 );
        this.aMemorizedRoom = null;
        this.aCharged = false;
        //this.aGameEngine = pGameEngine;
        //this.aUsed = false;
    }//Beamer()

    /**
     * access to the memorized room
     * 
     * @return the memorized room
     */
    public Room getMemorizedRoom()
    {
        return this.aMemorizedRoom;
    }//getMemorizedRoom()
    
    /**
     * access to aCharged 
     * 
     * @return true if the beamer if charged
     */
    public boolean getCharged()
    {
        return this.aCharged;
    }//getCharged()
    
    /**
     * modify aCharged with the boolean in parameter
     * 
     * @param pBoolean Boolean used
     */
    public void setCharged(final boolean pBoolean)
    {
        this.aCharged = pBoolean;
        
    }//setCharged(.)

    /**
     * modify aMemorizedRoom
     * 
     * @param pRoom to access the room
     */
    public void setMemorizedRoom(final Room pRoom)
    {
        this.aMemorizedRoom = pRoom;
        
    }//setMemorizedRoom()
}//Beamer
