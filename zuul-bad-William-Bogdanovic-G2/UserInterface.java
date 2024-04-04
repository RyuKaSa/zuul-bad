
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;
import java.awt.FlowLayout;
import java.awt.Component.*;


/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling and Bogdanovic William
 * @version 1.0 (Jan 2003) DB edited (2019)
 */
public class UserInterface implements ActionListener
{
    private GameEngine           aEngine;
    private JFrame               aMyFrame;
    private JTextField           aEntryField;
    private JTextArea            aLog;
    private JLabel               aImage;
    private JButton              aButtonDirection;
    private JButton              aButtonUtility;
    private UserInterface        aGui;
    
    /*
    private JButton              aButtonNorth;
    private JButton              aButtonSouth;
    private JButton              aButtonEast;
    private JButton              aButtonWest;
    */
    
    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param pGameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    }//UserInterface(.)

    /**
     * Print out some text into the text area.
     * 
     * @param pText that we want printed in the text area
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    }//print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     * 
     * @param pText that we want printed in the text area on seperate lines (\n)
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    }//println(.)

    /**
     * Show an image file in the interface.
     * 
     * @param pImageName of the image name linked to its room
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )//code to run if there is no image found
            this.aGui.println( "Image not found : " + vImagePath );
        else {//display the image
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    }//showImage(.)

    /**
     * Enable or disable input in the input field.
     * 
     * @param pOnOff to disable or not the entry field when needed
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable(pOnOff);//enable/disable
        if (!pOnOff) { // disable
            this.aEntryField.getCaret().setBlinkRate(0);//cursor won't blink
            this.aEntryField.removeActionListener(this);//won't react to entry
        }
    }//enable(.)

    /**
     * Set up graphical user interface.
     * 
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame("JailBreak Dungeon"); //title
        this.aEntryField = new JTextField(34);

        this.aLog = new JTextArea();
        this.aLog.setEditable(false);
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(310, 100) );
        vListScroller.setMinimumSize( new Dimension(310, 100) );

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();

        vPanel.setLayout( new BorderLayout() ); // ==> only five places
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add( this.gridButtonUtility(), BorderLayout.WEST );
        vPanel.add( this.gridButtonDirection(), BorderLayout.EAST );
        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aEntryField.addActionListener( this );
        
        // to end program when window is closed
        this.closeWindow();
        /*this.aMyFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );*/
        
        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    }//createGUI()
    
    
    /**
     * Creates a JButton class that contains several buttons to navigate throughout the map
     * 
     * @return gridButtonDirection which contains all the buttons for directions
     */
    public JButton gridButtonDirection()
    {
        this.aButtonDirection = new JButton();
        
        //creation
        /*
        JButton vButtonGo = new JButton("Go Somewhere");
        this.aButtonMenu.add(vButtonGo);
        vButtonGo.addActionListener(this);
        vButtonGo.setVisible(true);
        */
        
        
        //button placements Utility
        /***/   /***/   /***/
        //eat   look    back    
        /***/   /***/   /***/  
        //save  help    quit
        /***/   /***/   /***/
        //items                  
        
        
        //button placements Direction
        /***/   /***/   /***/
        //      north    up
        /***/   /***/   /***/
        //west          east
        /***/   /***/   /***/
        //      south   down
        
        
        JButton vButtonBlank1 = new JButton(" ");
        this.aButtonDirection.add(vButtonBlank1);
        vButtonBlank1.addActionListener(this);
        
        JButton vButtonNorth = new JButton("North");
        this.aButtonDirection.add(vButtonNorth);
        vButtonNorth.addActionListener(this);
        
        JButton vButtonUp = new JButton("Up");
        this.aButtonDirection.add(vButtonUp);
        vButtonUp.addActionListener(this);
        
        JButton vButtonWest = new JButton("West");
        this.aButtonDirection.add(vButtonWest);
        vButtonWest.addActionListener(this);
        
        JButton vButtonBlank2 = new JButton(" ");
        this.aButtonDirection.add(vButtonBlank2);
        vButtonBlank2.addActionListener(this);
        
        JButton vButtonEast = new JButton("East");
        this.aButtonDirection.add(vButtonEast);
        vButtonEast.addActionListener(this);
        
        JButton vButtonBlank3 = new JButton(" ");
        this.aButtonDirection.add(vButtonBlank3);
        vButtonBlank3.addActionListener(this);
        
        JButton vButtonSouth = new JButton("South");
        this.aButtonDirection.add(vButtonSouth);
        vButtonSouth.addActionListener(this);
        
        JButton vButtonDown = new JButton("Down");
        this.aButtonDirection.add(vButtonDown);
        vButtonDown.addActionListener(this);
       
        
        //grid layout
        this.aButtonDirection.setVisible(true);
        this.aButtonDirection.setLayout(new GridLayout(3,3));
        return aButtonDirection;
    }//gridButtonDirection()
    
    /**
     * Creates a JButton class that contains several buttons to fully utilize the different functions of the game
     * 
     * @return gridButtonUtility which contains all the buttons for different functions
     */
    public JButton gridButtonUtility()
    {
        this.aButtonUtility = new JButton();
        
        //creation
        /*
        JButton vButtonGo = new JButton("Go Somewhere");
        this.aButtonMenu.add(vButtonGo);
        vButtonGo.addActionListener(this);
        vButtonGo.setVisible(true);
        */
        
        
        //button placements Utility
        /***/   /***/   /***/
        //eat   look    back    
        /***/   /***/   /***/  
        //save  help    quit
        /***/   /***/   /***/
        //items            
        
        
        //button placements Direction
        /***/   /***/   /***/
        //      north    up
        /***/   /***/   /***/
        //west          east
        /***/   /***/   /***/
        //      south   down
        
        /*
        JButton vButtonEat = new JButton("Eat");
        this.aButtonUtility.add(vButtonEat);
        vButtonEat.addActionListener(this);
        vButtonEat.setVisible(true);
        */
        
        JButton vButtonLook = new JButton("Look");
        this.aButtonUtility.add(vButtonLook);
        vButtonLook.addActionListener(this);
        vButtonLook.setVisible(true);
        
        JButton vButtonItem = new JButton("Items");
        this.aButtonUtility.add(vButtonItem);
        vButtonItem.addActionListener(this);
        vButtonItem.setVisible(true);
        
        JButton vButtonBack = new JButton("Back");
        this.aButtonUtility.add(vButtonBack);
        vButtonBack.addActionListener(this);
        vButtonBack.setVisible(true);
        
        JButton vButtonMap = new JButton("Map");
        this.aButtonUtility.add(vButtonMap);
        vButtonMap.addActionListener(this);
        vButtonMap.setVisible(true);
        
        JButton vButtonCharge = new JButton("Charge");
        this.aButtonUtility.add(vButtonCharge);
        vButtonCharge.addActionListener(this);
        vButtonCharge.setVisible(true);
        
        JButton vButtonFire = new JButton("Fire");
        this.aButtonUtility.add(vButtonFire);
        vButtonFire.addActionListener(this);
        vButtonFire.setVisible(true);
        
        
        
        
        JButton vButtonSave = new JButton("Save");//not implemented yet
        this.aButtonUtility.add(vButtonSave);
        vButtonSave.addActionListener(this);
        vButtonSave.setVisible(true);
        
        JButton vButtonHelp = new JButton("Help");
        this.aButtonUtility.add(vButtonHelp);
        vButtonHelp.addActionListener(this);
        vButtonHelp.setVisible(true);
        
        JButton vButtonQuit = new JButton("Quit");
        this.aButtonUtility.add(vButtonQuit);
        vButtonQuit.addActionListener(this);
        vButtonQuit.setVisible(true);
        
        
        //grid layout
        this.aButtonUtility.setVisible(true);
        this.aButtonUtility.setLayout(new GridLayout(3,3));
        return aButtonUtility;
    }//gridButtonUtility()
    
    /*
    public JButton gridButtonDirection()
    {
        this.aButtonDirection = new JButton();
        
        //creation
        JButton vButtonNorth = new JButton("North");
        this.aButtonDirection.add(vButtonNorth);
        vButtonNorth.addActionListener(this);
        vButtonNorth.setVisible(false);
        
        JButton vButtonEast = new JButton("East");
        this.aButtonDirection.add(vButtonEast);
        vButtonEast.addActionListener(this);
        vButtonEast.setVisible(false);
        
        JButton vButtonWest = new JButton("West");
        this.aButtonDirection.add(vButtonWest);
        vButtonWest.addActionListener(this);
        vButtonWest.setVisible(false);
        
        JButton vButtonSouth = new JButton("South");
        this.aButtonDirection.add(vButtonSouth);
        vButtonSouth.addActionListener(this);
        vButtonSouth.setVisible(false);
        
        //grid layout
        this.aButtonDirection.setLayout(new GridLayout(2,2));
        return aButtonDirection;
    }
    */
    
    /**
     * close window on command
     * 
     */
    public void closeWindow() 
    {
        // to end program when window is closed
        this.aMyFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){System.exit(0);}
        });
    }//closeWindow()
    
    /**
     * Actionlistener interface for entry textfield.
     * 
     * @param pE to run text commands through the usage of buttons
     */
    public void actionPerformed(final ActionEvent pE) 
    {
        //no need to check the type of action at the moment
        //because there is only one possible action (text input) :
        this.processCommand();// never suppress this line
        
        //quit
        if(pE.getActionCommand().equals("Quit")){
            this.aEngine.endGame();return;
        }
        
        //help
        if(pE.getActionCommand().equals("Help")){
            this.aEngine.interpretCommand("help");return;
        }
        
        //north
        if(pE.getActionCommand().equals("North")){
            this.aEngine.interpretCommand("go north");
            //this.gridButtonDirection().setVisible(false);
            return;
        }
        
        //south
        if(pE.getActionCommand().equals("South")){
            this.aEngine.interpretCommand("go south");
            
            return;
        }
        
        //east
        if(pE.getActionCommand().equals("East")){
            this.aEngine.interpretCommand("go east");
            
            return;
        }
        
        //west
        if(pE.getActionCommand().equals("West")){
            this.aEngine.interpretCommand("go west");
            
            return;
        }
        
        //up
        if(pE.getActionCommand().equals("Up")){
            this.aEngine.interpretCommand("go up");
            
            return;
        }
        
        //down
        if(pE.getActionCommand().equals("Down")){
            this.aEngine.interpretCommand("go down");
            
            return;
        }
        
        if(pE.getActionCommand().equals("Look")){
            this.aEngine.interpretCommand("look");
            
            return;
        }
        
        if(pE.getActionCommand().equals("Eat")){
            this.aEngine.interpretCommand("eat");
            
            return;
        }
        
        if(pE.getActionCommand().equals("Back")){
            this.aEngine.interpretCommand("back");
            
            return;
        }
        
        if(pE.getActionCommand().equals("Items")){
            this.aEngine.interpretCommand("items");
            
            return;
        }
        
        if(pE.getActionCommand().equals("Save")){
            //this.aEngine.interpretCommand("save");
            
            return;
        }
        
        if(pE.getActionCommand().equals("Charge")){
            this.aEngine.interpretCommand("charge");
            
            return;
        }
        
        //map
        if(pE.getActionCommand().equals("Map")){
            this.aEngine.interpretCommand("map");
            
            return;
        }
        
        if(pE.getActionCommand().equals("Fire")){
            this.aEngine.interpretCommand("fire");
            
            return;
        }
        
        /*
        //go somewhere
        if(pE.getActionCommand().equals("Go Somewhere")){
            this.gridButtonDirection();
            this.aButtonNorth.setVisible(true);
            this.aButtonSouth.setVisible(true);
            this.aButtonEast.setVisible(true);
            this.aButtonWest.setVisible(true);
            return;            
        }
        */
    }//actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     * 
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText("");

        this.aEngine.interpretCommand( vInput );
    }//processCommand()
    
}//UserInterface