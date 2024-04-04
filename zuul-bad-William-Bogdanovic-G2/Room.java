

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * Modify rooms and manipulate room information
 *
 * @author BOGDANOVIC William
 * @version (stackedrooms)
 */
public class Room
{
    private String aDescription;
    public Item aItem;
    public ItemList aItemList;
    
    /*
    public Room aNorthExit;
    public Room aSouthExit;
    public Room aEastExit;
    public Room aWestExit;
    public Room aUpExit;
    public Room aDownExit;
    */
   
    private HashMap<String, Room> aExits;
    //private HashMap<Room, Item> aItemsRoom;
    //public HashMap<String, Item> aItems;
    //private Stack<Room> aStackedRooms;
    private String aImageName;
    
    
    /**
     * default Constructor 
     * information about the room
     * 
     * @param pDescription for the description of the room
     * @param pImage for the image corresponding to the room
     */
    public Room(final String pDescription, final String pImage)
    {
        this.aDescription = pDescription;
        this.aImageName   = pImage;
        this.aExits = new HashMap<String, Room>();
        //this.aItemsRoom = new HashMap<Room, Item>();
        this.aItemList = new ItemList();
        //this.aStackedRooms = new Stack<Room>();
    }//Room(..)
    
    /**
     * accessor to return the direction of the exit 
     * 
     * @param pDirection of the cardinal direction 
     * @return exit of room
     */
    public Room get(final String pDirection)
    {
        return aExits.get(pDirection);
        
    }//get(.)
    
    /**
     * modify the exits
     * contains exit directions and next room 
     * 
     * @param pDirection of the cardinal direction of the exit
     * @param pNeighbour associated to the exit
     */
    public void setExit(String pDirection, Room pNeighbour)
    {
        aExits.put(pDirection.toLowerCase(), pNeighbour);
        
    }//setExit(..)
    
    /**
     * modify the items
     * contains rooms in which items are placed
     * 
     * @param pName in which an item wil be
     * @param pItem linked to the room
     */
    public void setItem(String pName, Item pItem)
    {
        aItemList.addItem(pName, pItem);
        
    }//setItem(..)
    
    /**
     * remove an item from a room when it's picked up
     * 
     * @param pName Name of the item
     */
    public void removeItem(final String pName)
    {
        aItemList.removeItem(pName, this.aItemList.getItem(pName));
        
    }//removeItem(.)
    
    /**
     * accessor to return the direction of the exit 
     * 
     * @param pDirection of the cardinal direction 
     * @return exit of room
     */
    public Room getExit(final String pDirection)
    {
        return aExits.get(pDirection);
        
    }//getExit(.)
    
    /**
     * accessor to return the items in the room
     * 
     * @param pItem name of the item of the room
     * @return item of room
     */
    public Item getItem(final String pItem)
    {
        return this.aItemList.getItem(pItem);
        
    }//getItem(.)
    
    /**
     * accessor to return the exits under Hashmap String format
     * 
     * @return String Exits of a room
     */
    public String getExitString()
    {
        String vExitString = "Exits :";
        Set<String> keys = this.aExits.keySet();
        //the Hashmap that contains  keys of exits
        
        for(String vExit : keys){vExitString += " " +vExit;}//for
        return vExitString.toString();
        
    }//getExitString()
    
    /**
     * accessor to return the items under String format
     * 
     * @return String Items of a room
     */
    public String getItemString()
    {
        return this.aItemList.getItemsString();
    }//getItemString()
    
    /**
     * accessor to return the description
     * 
     * @return String description of room
     */
    public String getDescription()
    {
        return this.aDescription;
        
    }//getDescription()
    
    /**
     * accessor to return a long description of this room,
     * contains the description and the exits
     * 
     * @return String description and exits of room
     */
    public String getLongDescription()
    {
        return "You are " + this.aDescription +"\n"+ this.getExitString() +"\n"+ this.getItemString();
        
    }//getLongDescription()
    
    /**
     * Return a string of the room's image name
     * 
     * @return String image's name
     */
    public String getImageName()
    {
       return this.aImageName;
    }//getImageName()
    
    /*
    /**
     * Return a boolean depending on if there is an item or not in the room
     * 
     * @param pName for the name of the item we need to check
     * @return boolean true or false for the presence or not of items
     */
    /*
    public boolean hasItem(final String pName)
    {
       return this.aItemList.containsItem(pName);
        
    }//hasItem()
    */
}//Room











