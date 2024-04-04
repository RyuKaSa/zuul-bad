
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class player 
 *
 * @author (Bogdanovic William)
 * @version (april 2021)
 */
public class Player
{
    private GameEngine             aGameEngine;
    //private Inventory              aPlayerInventory;
    private Room                   aCurrentRoom;
    private UserInterface          aGuiPlayer;
    private Item                   aItem;
    private Beamer                 aBeamer;//extends item
    private Map                    aMap;//extends item
    
    private Stack<Room>            aStackedRooms;
    //private ArrayList<Item>        aPlayerInventory;
    private ItemList               aPlayerInventory;
    
    private double                 aMaxWeight;
    private double                 aCurrentWeight;
    
    /**
     * Constructor for objects of class Player, Player has its own stacked rooms for the back() command and PlayerInventory
     * 
     * @param pGameEngine GameEngine used
     */
    public Player(final GameEngine pGameEngine)
    {
        this.aStackedRooms = new Stack<Room>();
        //this.aInventory = new Inventory();
        this.aPlayerInventory = new ItemList();
        this.aMaxWeight = 15;//15.00 kg
        this.aCurrentWeight = 0;
        this.aBeamer = new Beamer();
        this.aMap = new Map();
        this.aGameEngine = pGameEngine;//to print simply from Player Class
    }//Player(.) 
    
    /**
     * access the current room
     * 
     * @return Current room
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }//getCurrentRoom()
    
    /**
     * access the current room
     * 
     * @return Current room
     */
    public boolean getMapIsLive()
    {
        return this.aMap.getMapIsLive();
    }//getMapIsLive()
    
    /**
     * modify the max weight that the player can carry
     * 
     * @param pMoreWeight takes into parameter a double that will modify the max weight the Player can carry
     */
    public void setMaxWeight(final double pMoreWeight)
    {
        this.aMaxWeight *= pMoreWeight;
    }//setMaxWeight(.)
    
    /**
     * delete the complete stack for the trapdoor purpose, no going back at all
     * 
     * 
     */
    public void removeAll()
    {
        this.aStackedRooms.clear();
    }//removeAll()
    
    
    /**
     * access the previous room through the use of Stack methodes
     * 
     * @return Previous room
     */
    public Room getLastRoom()
    {
        return this.aStackedRooms.peek();
    
    }//getLastRoom()
    
    
    /**
     * modify the current room
     * 
     * @param pNewCurrentRoom Room that will modify the current room
     */
    public void setCurrentRoom(final Room pNewCurrentRoom)
    {
        this.aCurrentRoom = pNewCurrentRoom;
    }//setCurrentRoom()
    
    /**
     * modify the GUI to only have a single GUI between this class and GameEngine
     * 
     * @param pUserInterface that will define the current room
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        this.aGuiPlayer = pUserInterface;
    }//setGUI(.)
    
    /**
     * set the new room
     * 
     * @param pRoom to modify the current room
     */
    public void goingNextRoom(final Room pRoom)
    {
        this.aStackedRooms.push(this.aCurrentRoom);
        this.aCurrentRoom = pRoom;
        
    }//goingNextRoom(.)
    
    /**
     * Procedure to let Player Class println text from Player Class
     * 
     * 
     */
    public void printLocationInfoBeamer()
    {
        this.aGameEngine.printLocationInfo();
        
    }//setGui(.)
    
    /**
     * access stack of previous rooms
     * 
     * @return stack of all previous rooms
     */
    public Stack getStackedRooms()
    {
        return this.aStackedRooms;
    }//getStackedRooms()
    
    /**
     * shows or exits the image of a map of the dungeon
     * 
     * 
     */
    public void map()
    {
        if(this.aPlayerInventory.getItem("Marauder's_Map")==null)//the map is not in inventory
        {
            this.aGuiPlayer.println("You do not possess the allseeing Marauder's Map.");
        }
        else//Map is in inventory
        {
            if(this.aMap.getMapIsLive())//aMapIsLive == true
            //the map is shown and we want to exit the map image
            {
                this.aGameEngine.showImageGameEngine();
                this.aMap.setMapIsLive(false);
                this.aGuiPlayer.println("You put away the allseeing Marauder's Map.");
            }
            else//aMapIsLive == false
            //the map is not used so the player wants to see the map
            {
                this.aGuiPlayer.showImage("vMap.png");
                this.aMap.setMapIsLive(true);
                this.aGuiPlayer.println("You take a hold of the allseeing Marauder's Map.");
            }
            
        }
    }//map()
   
   /**
     * charge the beamer with the current room
     * 
     */
    public void charge()
    {
        if(this.aPlayerInventory.getItem("Ring_Of_Souvenirs")==null)
        {
            this.aGuiPlayer.println("You need to wield the relic that has the charge and fire functions.");
            //this.aBeamer.setCharged(false);
            return;
        }
        else
        {
            if(this.aBeamer.getCharged())
            {
                this.aBeamer.setMemorizedRoom(this.aCurrentRoom);
                this.aGuiPlayer.println("You forget the last room you memorized.");
                this.aGuiPlayer.println("You then memorized your current room.");
            }
            //if(!this.aBeamer.getCharged())
            else{
                this.aGuiPlayer.println("You memorized the room you are currently in.");
                this.aBeamer.setCharged(true);
                this.aBeamer.setMemorizedRoom(this.aCurrentRoom);
            }
        }
    }//charge()
    
    /**
     * fire the beamer which teleports the user 
     * 
     */
    public void fire()
    {
        if(this.aPlayerInventory.getItem("Ring_Of_Souvenirs")==null)
        {
            this.aGuiPlayer.println("You need to wield the relic that has the charge and fire functions.");
            //this.aBeamer.setCharged(false);
            return;
        }
        else
        {
        
            if(this.aBeamer.getCharged())
            {
                this.goingNextRoom(this.aBeamer.getMemorizedRoom());
                this.printLocationInfoBeamer();
                this.aBeamer.setMemorizedRoom(null);
                this.aBeamer.setCharged(false);
                //this.aUsed = true;
                this.aGuiPlayer.println("The ring has been fired.");
                this.aGuiPlayer.println("You find yourself in the room like you remembered.");
                return;
            }
            //if(!this.aBeamer.getCharged())
            else{
                this.aGuiPlayer.println("You do not seem to remember any previous place.");
                this.aGuiPlayer.println("Try using ->charge to remember a place.");
                return;
            }
        }
    }//fire()
    
    /**
     * eat edible items
     * takes into account whether the item is the magic cookie or not
     * 
     * @param pCommand to check what the user wants to eat (eating system not finished)
     */
    public void eat(final Command pCommand)
    {
        String vSecondWord = pCommand.getSecondWord();
        Item vItem = this.aPlayerInventory.getItem(vSecondWord);
        
        if(pCommand.hasSecondWord())
        {
            if(vItem == null)
            {
                this.aGuiPlayer.println("What can I feast upon?");
                return;
            }
            else if(vItem.isEdible())//item can be eaten
            {
                if(vItem.getName().equals("Magic_Shroom"))//magic cookie can be eaten
                {
                    this.aGuiPlayer.println("You have consumed the secret magic shroom!");
                    this.aGuiPlayer.println("You feel weird but also much lighter.");
                    this.aCurrentWeight -= vItem.getItemWeight();
                    this.aPlayerInventory.removeItem(vSecondWord, vItem);
                    this.setMaxWeight(1.2);//we multiply the max weight by 1.2
                    return;
                }
                if(vItem.getName().equals("Magic_Cookie"))//magic cookie can be eaten
                {
                    this.aGuiPlayer.println("You have consumed the secret magic cookie!");
                    this.aGuiPlayer.println("You feel great but also much lighter!");
                    this.aCurrentWeight -= vItem.getItemWeight();
                    this.aPlayerInventory.removeItem(vSecondWord, vItem);
                    this.setMaxWeight(1.5);//we multiply the max weight by 1.2
                    return;
                }
                else//any other item is eaten
                {
                    this.aGuiPlayer.println("You have consumed "+ vSecondWord + "! You feel replenished.");
                    this.aCurrentWeight -= vItem.getItemWeight();
                    this.aPlayerInventory.removeItem(vSecondWord, vItem);
                    return;
                }
            }
            else if(!vItem.isEdible())//item can be eaten
            {
                this.aGuiPlayer.println("You really should not try to consume this,");
                this.aGuiPlayer.println("for you might not be able to digeste it."); 
                return;
            }
        }
        else
        {
            this.aGuiPlayer.println("What can I feast upon?");
            return;
        }
    }//eat(.)
    
    
    /**
     * look around 
     * returns long description at the moment
     * 
     * @param pHasSecondWord check if the user wants to look at something in particular
     */
    public void look(final Command pHasSecondWord)
    {
        if(pHasSecondWord.hasSecondWord()){
            this.aGuiPlayer.println("I am unable look at something in paticular right now.");
        }
        else
        {
            this.aGuiPlayer.println(this.getCurrentRoom().getLongDescription());
             
        }
        
    }//look(.)
    
    /**
     * Procedure to modify the room to the last room
     * 
     */
    public void goBackRoom()
    {
        this.aCurrentRoom = this.aStackedRooms.peek();
        this.aStackedRooms.pop();
        
    }//goBackRoom()
    
    /**
     * procedure to show the player's inventory 
     * 
     * Returns strings of the items and their total weight held by the player
     */
    public void items()
    {
        /*
        if(pCommand.hasSecondWord())
        {
            this.aGuiPlayer.println("");
        }
        
        else
        {*/
            
            this.aGuiPlayer.println(aPlayerInventory.getItemsString());
            this.aGuiPlayer.println("For a total weight of : " + this.aCurrentWeight + " / " + this.aMaxWeight + " kg");
            
        //}
        
     
    }//setGui(.)
    
    /**
     * sums up the weight of the items the player holds
     * 
     * @return double weight of items held
     */
    public double currentlyCarrying()
    {
        return this.aCurrentWeight;
        
    }//currentlyCarrying()
    
    /**
     * procedure to drop a specified item and make it appear in the room again
     * 
     * @param pCommand to have access to the command's second word
     */
    public void drop(final Command pCommand)
    {
        String vSecondWord = pCommand.getSecondWord();
        Item vItem = this.aPlayerInventory.getItem(vSecondWord);
        if(pCommand.hasSecondWord())
        {
            if(vSecondWord.equals(vItem.getName()))
            {
               this.getCurrentRoom().aItemList.addItem(vItem.getName(),vItem);
               this.aGuiPlayer.println("You dropped the following item: " + vSecondWord +"\n"+ "On the ground.");
               this.aPlayerInventory.removeItem(vSecondWord, vItem);
               this.aCurrentWeight -= vItem.getItemWeight();
            }
            else
            {
               this.aGuiPlayer.println("What should I drop?"); 
            } 
        }
        else
        {
            this.aGuiPlayer.println("What should I drop?");  
        }
        
    }//drop(.)
    
    
    /**
     * procedure to take a specified item from the floor and get it into the player's inventory
     * 
     * @param pCommand to have access to the command's second word
     */
    public void take(final Command pCommand)
    {
        String vItemName = pCommand.getSecondWord();
        Item vItem = this.aCurrentRoom.getItem(vItemName);
        
        if(vItem == null)//no item of this name has been found
        {
            this.aGuiPlayer.println("There is no Item of this name here.");
            return;
        }
        
        else//Item taken or not
        {
            
            double vSumNewItem = vItem.getItemWeight() + this.currentlyCarrying();
            
            if(vSumNewItem <= this.aMaxWeight)//item weight + currently carrying <= max weight
            {
                this.aPlayerInventory.addItem(vItemName,vItem);//add the item into the player inventory
                this.aCurrentRoom.removeItem(vItemName);//remove the item from the room
                this.aGuiPlayer.println(this.aPlayerInventory.getItem(vItemName).getDescription());
                this.aGuiPlayer.println("You took "+ vItemName +" from the room");
                this.aCurrentWeight += vItem.getItemWeight();
            }
            
            //item has NOT been taken (too much weight)
            else if(vSumNewItem > this.aMaxWeight)//item weight + currently carrying > max weight
            {
                this.aGuiPlayer.println("You hold too much for your own good.");
                this.aGuiPlayer.println("Remember, a knight's back is brittle.");
                this.aGuiPlayer.println("You should let go of another item.");
            }
        }
        
    }
    //take(.)
    
}//Player()
