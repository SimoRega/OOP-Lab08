package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;

import it.unibo.oop.lab.iogui.BadIOGUI;

/**
 * 
 */
public class Controller {

    private File myFile;
    private static final String PATH = System.getProperty("user.home") 
                                     + System.getProperty("file.separator")
                                     + "output.txt";

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

    public Controller() {
        myFile = new File(PATH);
    }
    
    public void setCurrentFile(File f) {
        this.myFile = f;
    }

    public File getCurrentFile() {
        return this.myFile;
    }
    
    public String getPath() {
        return myFile.getPath();
    }
    
    public void addStringToFile(String s) throws IOException{
        try (PrintStream ps = new PrintStream(myFile.getPath())) {
            ps.print(s);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
