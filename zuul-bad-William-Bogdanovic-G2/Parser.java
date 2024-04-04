import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau and Bogdanovic William
 * @version 2008.03.30 + 2013.09.15
 */
public class Parser 
{
    private CommandWords    aCommandWords;// (voir la classe CommandWords)
    private Command         aCommand;
    private UserInterface   aGui;
    private GameEngine      aGameEngine;
    
    /**
     * Create a new Parser.
     * 
     */
    public Parser() 
    {
        this.aCommandWords = new CommandWords();
    }//Parser()

    /**
     * default constructor that created the objects for the attributs 
     * 
     */
    public void showCommands() 
    {
        this.aGui.println(this.aCommandWords.getCommandList());
        
    }//showCommands()
        
    /**
     * Get a new command from the user. The command is read by
     * parsing the 'inputLine'.
     * 
     * @param pInputLine new input from the user
     * @return Command that contains two words from the user
     */
    public Command getCommand( final String pInputLine ) 
    {
        String vWord1;
        String vWord2;

        StringTokenizer tokenizer = new StringTokenizer( pInputLine );

        if ( tokenizer.hasMoreTokens() )
            vWord1 = tokenizer.nextToken();//get first word
        else
            vWord1 = null;

        if ( tokenizer.hasMoreTokens() )
            vWord2 = tokenizer.nextToken();//get second word
        else
            vWord2 = null;

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).

        if ( this.aCommandWords.isCommand( vWord1 ) )
            return new Command( vWord1, vWord2 );
        else
            return new Command( null, vWord2 );
    }//getCommand(.)
    
    /**
     * Returns a String with valid command words.
     * 
     * @return String to return all valid command words
     */
    public String getCommandString()//was showCommands()
    {
        return this.aCommandWords.getCommandList();
    }//getCommandString()
}//Parser
