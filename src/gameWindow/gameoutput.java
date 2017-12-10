/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameWindow;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class gameoutput extends OutputStream {
    private JTextPane  textArea;
     
//    public gameoutput(JTextArea textArea) {
//        this.textArea = textArea;
//    }
    
     
    public gameoutput(JTextPane textArea) {
        this.textArea = textArea;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        Document doc = textArea.getDocument();
        try {
            doc.insertString(doc.getLength(), (Character.toString((char)b)), null);
        } catch (BadLocationException ex) {
            Logger.getLogger(gameoutput.class.getName()).log(Level.SEVERE, null, ex);
        }
//        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
//        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
