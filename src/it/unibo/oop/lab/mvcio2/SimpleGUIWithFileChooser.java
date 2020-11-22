package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;
import it.unibo.oop.lab.mvcio.SimpleGUI;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("My First graphical interface");
    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface. Suggestion: use a second JPanel with a second
     * BorderLayout, put the panel in the North of the main panel, put the text
     * field in the center of the new panel and put the button in the line_end of
     * the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the current
     * selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should use
     * the method showSaveDialog() to display the file chooser, and if the result is
     * equal to JFileChooser.APPROVE_OPTION the program should set as new file in
     * the Controller the file chosen. If CANCEL_OPTION is returned, then the
     * program should do nothing. Otherwise, a message dialog should be shown
     * telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to update
     * the UI: in this example the UI knows when should be updated, so try to keep
     * things separated.
     */

    public SimpleGUIWithFileChooser() {
        Controller c = new Controller();

        JPanel myPanel = new JPanel();
        JTextArea myArea = new JTextArea();
        JButton myButton = new JButton("save");
        myPanel.setLayout(new BorderLayout());

        JPanel browsePanel=new JPanel();
        browsePanel.setLayout(new BorderLayout());
        JTextField myText = new JTextField(c.getCurrentFile().toString());
        myText.setEditable(false);
        JButton browseButton = new JButton("Browse");
        browsePanel.add(myText, BorderLayout.CENTER);
        browsePanel.add(browseButton, BorderLayout.LINE_END);

        myPanel.add(browsePanel, BorderLayout.NORTH);
        myPanel.add(myArea, BorderLayout.CENTER);
        myPanel.add(myButton, BorderLayout.PAGE_END);
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myButton.addActionListener((ActionListener) new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    c.addStringToFile(myArea.getText());
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        
        browseButton.addActionListener((ActionListener) new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                var risultato = jfc.showSaveDialog(myPanel);
                if(risultato ==JFileChooser.APPROVE_OPTION) {
                    c.setCurrentFile(jfc.getSelectedFile());
                    myText.setText(c.getPath().toString());
                }else if(risultato!=JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "An error as occured");
                }
                
            }
        });

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String... args) {
        SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser();
    }

}
