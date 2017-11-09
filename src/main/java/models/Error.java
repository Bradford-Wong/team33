package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//This is the error box for errors
public class Error {
    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "Error Message: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

}