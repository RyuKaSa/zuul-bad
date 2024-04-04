


/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau and Bogdanovic William
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    public final String[] aValidCommands;

    /**
     * Constructor - initialise the command words.
     * 
     */
    public CommandWords()
    {
        this.aValidCommands = new String[13];
        //String[] aValidCommands = {"go","help","quit","look","eat","back","take","test","drop"};
        
        this.aValidCommands[0] = "go";
        this.aValidCommands[1] = "help";
        this.aValidCommands[2] = "quit";
        this.aValidCommands[3] = "look";
        this.aValidCommands[4] = "eat";
        this.aValidCommands[5] = "back";
        this.aValidCommands[6] = "take";
        this.aValidCommands[7] = "test";
        this.aValidCommands[8] = "drop";
        this.aValidCommands[9] = "items";
        this.aValidCommands[10] = "charge";
        this.aValidCommands[11] = "fire";
        this.aValidCommands[12] = "map";
        
    }//CommandWords()

    /**
     * String that lists all command words
     * 
     * @return String format all the command words that are valid
     */
    
    public String getCommandList()
    {
        String vCommandList = "";
        for(String command : this.aValidCommands)
        {
            vCommandList += command + ", ";
        }
        return vCommandList;
    }//getCommandList()
    
    /**
     * Check whether a given String is a valid command word. 
     * 
     * @param pString to compare the entered word with the list of valid commands
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        for ( int i=0; i<this.aValidCommands.length;i++){
            if ( this.aValidCommands[i].equals(pString))
                return true;
        }//for
        //if we get here, the string was not found in the commands
        return false;
    }//isCommand(.)
}//CommandWord