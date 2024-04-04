



/** 
 * 
 * Class Item with a name, item description
 * 
 * @author Bogdanovic William
 * @version (april 2021)
 */


public class Item 
{
    private String aName;
    private String aDescription;
    private boolean aEdible;
    private double aWeight;
    
    
    /**
     * Contructor of Item
     * initialize the item's information
     * 
     * @param pName stands for the name of the Item
     * @param pDescription will give a quick description 
     * @param pEdible of item, whether edible or not
     * @param pWeight of item
     */
    public Item( final String pName, final String pDescription, final boolean pEdible, final double pWeight )
    {
        this.aName  = pName;
        this.aDescription = pDescription;
        
        this.aEdible = pEdible;
        this.aWeight = pWeight;
    }//Item(....)
    
    /**
     * accessor for the name of the item
     * 
     * @return String name of the item
     */
    public String getName()
    {
        return this.aName;
    }//getName()
    
    /**
     * accessor for the description of the item
     * 
     * @return String description of the item
     */
    public String getDescription()
    {
        return this.aDescription;
        
    }//getDescription()
    
    /**
     * accessor for the description of the item
     * 
     * @return boolean true or false on wether the item is edible or not
     */
    public boolean isEdible()
    {
        return this.aEdible;
        
    }//isEdible()
    
    /**
     * accessor for the weight of the item
     * 
     * @return double description of the item
     */
    public double getItemWeight()
    {
        return this.aWeight;
    }//getItemWeight()
    
    /**
     * return the item's name in strings for a room
     * 
     * @return in Strings the items in a room
     */
    @Override public String toString()
    {
        return this.aName;
    }//toString()
    
}//Item