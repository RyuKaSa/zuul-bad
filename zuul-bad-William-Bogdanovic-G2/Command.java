

/**
 * Class to easily access the command words and second word
 * 
 * 
 * 
 * @author Bogdanovic William
 * @version (1)
 */

public class Command
{
    private String aCommandWord;
    private String aSecondWord;

    /**
     * default constructor of Command
     * 
     * @param pCommandWord to attribute the command word
     * @param pSecondWord to attribute the second word
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;

    }//Command(..)
    
    /**
     * access the command word
     * 
     * @return String of the command word
     */
    public String getCommandWord()
    {
        return this.aCommandWord;
    }//getCommandWord()
    
    /**
     * access the second word
     * 
     * @return String of the second word
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }//getSecondWord()
    
    /**
     * to return true or false depending on if there is a second word or not
     * 
     * @return boolean true or false if there is or not a second word
     */
    public boolean hasSecondWord()
    {
        return (this.aSecondWord != null);
    }//hasSecondWord()

    /**
     * to return true or false depending on if the first word is a valid command word or not
     * 
     * @return boolean true or false if the first word is a valid command word or not
     */
    public boolean isUnknown()
    {
       return (this.aCommandWord == null);
        
        
    }//isUnknown()
    
}//Command




