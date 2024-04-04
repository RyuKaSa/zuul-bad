      
import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


/**
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that 
 *  the parser returns.
 *  
 * @author BOGDANOVIC William
 * @version (platformtest)
 */
public class GameEngine
{
    private Room                aKingsTower3;
    private Room                aFirePlace;
    
    private Parser              aParser;
    private UserInterface       aGui;
    private Command             aCommand;
    private Player              aPlayer;
    
    private Item                aItem;
    private ItemList            aInventory;
    
    
    
    //private Stack<Room>         aStackedRooms;
    //private Stack<Room>         aStackedRoomsTempo;
    
    /**
     * default constructor of GameEngine
     * 
     */
    public GameEngine()
    {
        createRooms();
        
        this.aParser = new Parser();
        
    }//GameClassWords()
    
    /**
     * Initialize the graphics user interface and calls the welcome message
     * 
     * @param pUserInterface to initialize GUI
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.aPlayer.setGUI(this.aGui);
        this.printWelcome();
    }//setGUI(.)
    
    /**
     * welcome text at the start of the game
     * 
     */
    private void printWelcome()
    {
        String Welcome1 = "Welcome to JailBreak Dungeon, "+"\n"+"where you are dropped in the dangerous Saxon territory! "+"\n"+"Only the best knights can survive this adventure,"+"\n"+" Do you think you have what it takes to make it out safely? "+"\n"+" Type 'help' if you need help.";
        
        this.aGui.println(Welcome1);
        this.printLocationInfo();
        /*if (this.aCurrentRoom.getImageName()!= null)
            this.aGui.showImage(this.aCurrentRoom.getImageName());*/
    }//printWelcome()
    
    /**
     * to show the image of the current room
     * 
     */
    public void showImageGameEngine()
    {
       if (this.aPlayer.getCurrentRoom().getImageName()!= null)
            this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    }//showImageGameEngine()
    
    /**
     * create rooms, items and links between each of them
     * 
     */
    private void createRooms()
    {
        //create rooms
        Room vStart = new Room("Sir Galahad, your only hope is a jailbreak, good luck.", "vStart.png");
        //this.aComparator = vStart;
        Room vCachot1 = new Room("in front of the prison cells.", "vCachot1.png");
        Room vCachot2 = new Room("in front of more prison cells.", "vCachot2.png");
        Room vLibrary = new Room("in the main library of the Castle.", "vLibrary.png");
        Room vLiving_Room = new Room("in the Living room.", "vLiving_Room.png");
        Room vKitchen = new Room("in the kitch, it smells like rotten fish.", "vKitchen.png");
        Room vDining_Room = new Room("in the Dining Room, there are large tables over there.", "vDining_Room.png");
        Room vKings_Bedroom = new Room("in the King's Royal bedroom.", "vKings_Bedroom.png");
        
        //several levels in the tower
        Room vKings_Tower1 = new Room("in the King's Tower, survive, but be wary, the floor is Lava!", "vKings_Tower1.png");
        Room vKings_Tower2 = new Room("in the second floor of the King's Tower, be carefull, the lava is catching up!", "vKings_Tower2.png");
        Room vKings_Tower3 = new Room("in the third floor of the King's Tower, be carefull, the lava is still catching up!", "vKings_Tower3.png");
        this.aKingsTower3 = vKings_Tower3;
        
        Room vFire_Place = new Room("in a warm spot next to a fire place!", "vFire_Place.png");
        this.aFirePlace = vFire_Place;
        Room vEntrance_Hall = new Room("in the Entrance Hall, the light is near!", "vEntrance_Hall.png");
        Room vBonus_Room1 = new Room("in this lore filled room.", "vBonus_Room1.png");
        Room vBonus_Room2 = new Room("in this lore filled room.", "vBonus_Room2.png");
        Room vEND = new Room("outside of the Castle, free!", "vEND.png");

        //exits
        vStart.setExit("north", vCachot1);
        vCachot1.setExit("north", vCachot2);
        vCachot1.setExit("south", vStart);
        vCachot2.setExit("north", vLibrary);
        vCachot2.setExit("south", vCachot1);
        vLibrary.setExit("north", vLiving_Room);
        vLibrary.setExit("south", vCachot2);
        vLiving_Room.setExit("south", vLibrary);
        vLiving_Room.setExit("north", vKitchen);
        vLiving_Room.setExit("west", vDining_Room);
        vKitchen.setExit("south",vLiving_Room);
        vKitchen.setExit("west",vKings_Bedroom);
        vDining_Room.setExit("north", vKings_Bedroom);
        vDining_Room.setExit("east", vLiving_Room);
        vKings_Bedroom.setExit("south", vDining_Room);
        vKings_Bedroom.setExit("east", vKitchen);
        vKings_Bedroom.setExit("west", vKings_Tower1);
        vKings_Tower1.setExit("up",vKings_Tower2);
        vKings_Tower1.setExit("east",vKings_Bedroom);
        vKings_Tower2.setExit("up",vKings_Tower3);
        vKings_Tower2.setExit("down",vKings_Tower1);
        vKings_Tower3.setExit("down",vFire_Place);
        vFire_Place.setExit("east", vEntrance_Hall);
        //vFire_Place.setExit("up", vKings_Tower3); trapdoor, no going back after here
        vFire_Place.setExit("south", vBonus_Room1);
        vEntrance_Hall.setExit("south", vEND);
        vEntrance_Hall.setExit("west", vFire_Place);
        vBonus_Room1.setExit("south", vBonus_Room2);
        vBonus_Room1.setExit("north", vFire_Place);
        vBonus_Room2.setExit("north", vBonus_Room1);
        
        
        
        
        
        //create Items
        //keys
        Item vKeyStart = new Item("Cell_Keys","The Guards dropped your cell key here.",false,0.1);
        vStart.setItem("Cell_Keys", vKeyStart);
        
        Item vKeyBedRoom = new Item("BedRoom_Keys","You found keys for the King's bedroom",false,0.1);
        vLiving_Room.setItem("BedRoom_Keys", vKeyBedRoom);
        
        
        
        
        //edibles
        Item vRottenFlesh = new Item("Rotten_Flesh","You found Rotten Flesh in the kitchen, you wonder if that's what the guards get to eat everyday.",true,0.8);
        vKitchen.setItem("Rotten_Flesh", vRottenFlesh);
        
        Item vApple = new Item("Apple","You found apples in the kitchen, you wonder if they're fresh or if they went bad already.",true,0.4);
        vKitchen.setItem("Apple", vApple);
        
        Item vMoldyBread = new Item("Moldy_Bread","There is some bread here, but it looks moldy and greenish.",true,0.3);
        vStart.setItem("Moldy_Bread", vMoldyBread);
        
        Item vMagicShroom = new Item("Magic_Shroom","You found something weird, you wonder what it tastes like.",true,0.8);
        vKitchen.setItem("Magic_Shroom", vMagicShroom);
        
        Item vMagicCookie = new Item("Magic_Cookie","You found something weird, you wonder what it tastes like.",true,0.6);
        vLibrary.setItem("Magic_Cookie", vMagicCookie);
        
        
        
        
        //armor
        Item vIronHelmet = new Item("Iron_Helmet","A rusty helmet for you, they feel heavy but they fit you nicely",false,4.2);
        vCachot2.setItem("Iron_Helmet", vIronHelmet);
        
        Item vLeatherPants = new Item("Leather_Pants","You found a pair of leather pants, they're rather heavy but protective at the same time",false,6.9);
        vLibrary.setItem("Leather_Pants", vLeatherPants);
        
        Item vSilverChestplate = new Item("Silver_Chestplate","You found a shiny and sparkly chestplate in silver.",false,13.9);
        vLiving_Room.setItem("Silver_Chestplate", vSilverChestplate);
        
        Item vChainmailBoots = new Item("Chainmail_Boots","You found an old pair of boots in chainmail.",false,3.4);
        vCachot1.setItem("Chainmail_Boots", vChainmailBoots);
        
        
        
        
        //relics
        Item vBeamer = new Beamer();
        vLiving_Room.setItem("Ring_Of_Souvenirs", vBeamer);
        
        Item vMap = new Map();
        vKings_Bedroom.setItem("Marauder's_Map", vMap);
        
        
        
        
        
        
        
        //Spawn point
        this.aPlayer = new Player(this);
        this.aPlayer.setCurrentRoom(vStart);
        
    }//create rooms()
    
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * 
     * @param pCommandLine to read and the actions of the buttons
     */
    public void interpretCommand(final String pCommandLine) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine);

        if(vCommand.isUnknown()) {
            this.aGui.println("I don't know what you mean...");
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if(vCommandWord.equals("help"))
            this.printHelp();
        else if(vCommandWord.equals("go"))
            this.goRoom(vCommand);
        else if(vCommandWord.equals("eat"))
            this.aPlayer.eat(vCommand);
        else if(vCommandWord.equals("look"))
            this.aPlayer.look(vCommand);
        else if(vCommandWord.equals("back"))
            this.back(vCommand);
        else if(vCommandWord.equals("test"))
            this.test(vCommand); 
        else if(vCommandWord.equals("take"))
            this.aPlayer.take(vCommand); 
        else if(vCommandWord.equals("drop"))
            this.aPlayer.drop(vCommand);
        else if(vCommandWord.equals("items"))
            this.aPlayer.items(/*vCommand*/);
        else if(vCommandWord.equals("charge"))
            this.aPlayer.charge(/*vCommand*/);
        else if(vCommandWord.equals("fire"))
            this.aPlayer.fire(/*vCommand*/);
        else if(vCommandWord.equals("map"))
            this.aPlayer.map();
        else if(vCommandWord.equals("quit")){
            if(vCommand.hasSecondWord())
                this.aGui.println("Quit what?");
            else
                this.endGame();
        }
    }//interpretCommand(.)
    
    
    /**
     * test command to run different .txt files 
     * test will try to read commands by going through each line of the .txt
     * 
     * @param pCommand to be able to use the methodes that come from the class Command
     */
    public void test(final Command pCommand) 
    {
        Scanner vScanner;
        if(!pCommand.hasSecondWord()){
            this.aGui.println("Please precise which test to run.");return;
        }//if to check if the test command has a second word or not
        
        try{
            /*Scanner*/ vScanner = new Scanner(new File("./test/" + pCommand.getSecondWord() + ".txt" ));
            while(vScanner.hasNextLine()){
                this.interpretCommand(vScanner.nextLine());
                
            }//while
            
        }//try
        
        catch(java.io.FileNotFoundException pFileEx){//if try fails
            this.aGui.println("File not found.");return;
        }//catch
        
    }//test(.)
    
    /**
     * help text when typing help
     * 
     */
    private void printHelp()
    {
        String help1 = "You are held captive in this Saxon Castle.";
        String help2 = "Your only goal is to espace alive.";
        String help3 = "Your command words are :"; 

        this.aGui.println(help1);this.aGui.println(help2);this.aGui.println(help3);
        this.aGui.println(this.aParser.getCommandString());
        
    }//printHelp()
    
    /**
     * shows in text format which exits are open and shows the room's image
     * 
     */
    public void printLocationInfo()
    {
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        if (this.aPlayer.getCurrentRoom().getImageName()!= null)
            this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
        //System.out.println(this.aCurrentRoom.getExitString());
    }//printLocationInfo()
    
    /**
     * method runs if first command word is "go"
     * 
     * @param pCommandWord to know in which room to go to, and keep in a stack each previous room for the back methode
     */  
    private void goRoom(final Command pCommandWord)
    {
        if(!pCommandWord.hasSecondWord())
        {
            this.aGui.println("Where should I go?");
        }//if
        
        String vDirection = pCommandWord.getSecondWord();
        String vLost = "Unknown direction ? Please try again, Sir.";
        //this.aCurrentRoom = this.aLastRoom;
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit(vDirection);
        
        if(vNextRoom == null)
        {
            this.aGui.println(vLost);
            return;
        }
        /*
        else if(this.aPlayer.getMapIsLive())
        {
            this.aGui.println("I cannot go anywhere for the Marauder's Map blocks my view.");
            return;
        }
        */
        else if(((vNextRoom == aFirePlace) || (!this.aPlayer.getMapIsLive()) ) && (this.aPlayer.getCurrentRoom() == aKingsTower3))
        {//to make the trapdoor effective, we take away the ability to use the procedure back() after taking the one way exit
            this.aPlayer.goingNextRoom(vNextRoom);
            this.printLocationInfo();
            this.aPlayer.removeAll();
            
        }
        else
        {//Next Room becomes current room, display current room info
            
            this.aPlayer.goingNextRoom(vNextRoom);
            this.printLocationInfo();
        }
        
        
    }//goRoom(.)
    
    
    /**
     * returns true to quit the game or false if unsure
     * 
     * @param pHasSecondWord to check if the command quit is used correctly without a second word
     * @return boolean true or false depending on wether there is a second word or not
     */
    private boolean quit(final Command pHasSecondWord)
    {
        if(pHasSecondWord.hasSecondWord()){this.aGui.println("Quit what ?? A knight be all but coward!!"); return false;}

        else{return true;}
    }//quit(.)
    
    /**
     * backing to the last room if possible 
     * returns previous room when possible     
     * 
     * @param pHasSecondWord to check if the back command is used correctly or not
     */
    private void back(final Command pHasSecondWord)
    {
        if(pHasSecondWord.hasSecondWord()){this.aGui.println("I cannot go back to a specific place.");}
        else{
            if(this.aPlayer.getStackedRooms().empty()){this.aGui.println("The Grande Espace isn't finished at last and yet thou wish to abandon?"
                + "\n"+ "Unacceptable!"+ "\n"+ "Unworthy of the knight that you are!");return;}
            else{
                this.aPlayer.goBackRoom();
                //this.aGui.showImage(this.aCurrentRoom.getImageName());
                this.printLocationInfo();
            }
        }
        
    }//back(.)
    
    
    
    /**
     * calls correct method depending on player's input
     * 
     * @param pProcessCommand to run code corresponding to the command
     * @return boolean true or false whether the command works not not
     */
    private boolean processCommand(final Command pProcessCommand)
    {   
        if(pProcessCommand.isUnknown()){this.aGui.println("I don't know what you mean...");return false;}
        
        else{
            if(pProcessCommand.getCommandWord().equals("go")){this.goRoom(pProcessCommand);}
            if(pProcessCommand.getCommandWord().equals("look")){this.aPlayer.look(pProcessCommand);}
            if(pProcessCommand.getCommandWord().equals("eat")){this.aPlayer.eat(pProcessCommand);}
            if(pProcessCommand.getCommandWord().equals("back")){this.back(pProcessCommand);}
            if(pProcessCommand.getCommandWord().equals("help")){this.printHelp();}
            if(pProcessCommand.getCommandWord().equals("fire")){this.aPlayer.fire();}
            if(pProcessCommand.getCommandWord().equals("charge")){this.aPlayer.charge();}
            if(pProcessCommand.getCommandWord().equals("quit")){this.quit(pProcessCommand);}
            if(!pProcessCommand.getCommandWord().equals("quit")){return false;}
            else{return quit(pProcessCommand);}
        }
        
        /*
        switch (pProcessCommand.getCommandWord()){
            case "go": goRoom(pProcessCommand); break;
                
            case "help": printHelp(); break;
            
            case "quit": quit(pProcessCommand); break;
            
            case 
            
            default: 
        */
            
    }//processCommand(.)
    
    /**
     * text message when user quits the game
     * disables the GUI instance to shut off the game
     * 
     */
    public void endGame()
    {
        this.aGui.println("Thank you for playing.  Good bye.");
        this.aGui.enable(false);
    }//endGame()
    
}//Game()

