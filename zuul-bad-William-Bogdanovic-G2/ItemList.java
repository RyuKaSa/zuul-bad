
//import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create and modify Inventory for items
 *
 * @author (Bogdanovic William)
 * @version (2)
 */
public class ItemList
{
    private HashMap<String,Item> aItemList;
    private Item aItem;
    
    /**
     * Constructor of Inventory
     * 
     */
    public ItemList()
    {
        //this.aListe = new ArrayList();
        this.aItemList = new HashMap<String,Item>();
    }//ItemList()

    
    
    /**
     * methode to return a String of all the items of a HashMap
     * 
     * 
     * @return Item that corresponds to the given name
     */
    public String getItemsString()
    {
        String vItemString = "Items :";
        //Set<String> values = (this.aItems.values()).getName();
        //the Hashmap that contains  keys of Items
        
        for(Item vItem : this.aItemList.values()){vItemString += " " +vItem;}//for
        return vItemString;
        
    }//getItemsString()
    
    /**
     * procedure to add an item
     * 
     * @param pName Name of Item
     * @return the item corresponding to the name given
     * 
     */
    public Item getItem(final String pName)
    {
        return this.aItemList.get(pName);
        
    }//getItem(.)
    
    /**
     * procedure to add an item in the inventory
     * 
     * @param pName Name of Item
     * @param pItem the item itself
     * 
     */
    public void addItem(final String pName, final Item pItem)
    {
        aItemList.put(pName, pItem);
        
    }//addItem(..)
    
    /**
     * procedure to create an item
     * 
     * @param pName Name of Item
     * @param pItem Item used
     */
    public void removeItem(final String pName, final Item pItem)
    {
        this.aItemList.remove(pName, pItem);
        
    }//removeItem(..)
    
    /**
     * returns in Strings the price and items
     * 
     * @return strings that correspond to total price and a list of item names
     */
    public String toString()
    {
        return this.aItemList.toString(); //+aPriceTotal;
        
    }//toString()
    
    
}//Inventory
