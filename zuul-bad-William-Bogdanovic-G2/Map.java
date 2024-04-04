


/**
 * Object that lets the player see a map of the castle when requirements are met
 * 
 * @author Bogdanovic William
 * @version (april 2021)
 */
public class Map extends Item
{
    
    private Player      aPlayer;
    private boolean     aMapIsLive;
    
    
    /**
     * create the Item map
     * 
     * 
     */
    public Map()
    {
        super( "Marauder's_Map", "this legendary relic lets the holder see the entire map of where he lies.", false, 0.4 );
        this.aMapIsLive = false;
        
    }//Map()

    /**
     * access to the boolean aMapIsLive
     * 
     * @return the boolean aMapIsLive
     */
    public boolean getMapIsLive()
    {
        return this.aMapIsLive;
    }//getMapIsLive()
    
    
    /**
     * set the boolean aMapIsLive
     * 
     * @param pBoolean to modify boolean aMapIsLive
     */
    public void setMapIsLive(final boolean pBoolean)
    {
        this.aMapIsLive = pBoolean;
    }//setMapIsLive(.)
}//Map