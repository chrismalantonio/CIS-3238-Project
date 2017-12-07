/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameWindow;

import card_deck.Card;
import card_deck.Deck;
import card_deck.GofishPlayer;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class GoFishWindow extends javax.swing.JFrame {

    /**
     * Creates new form GoFishWindow
     */
    public boolean[] buttonsShowing;
    public boolean running = false;
    public boolean playerValueObtained = false;
    public boolean cardValueObtained = false;
    public GofishPlayer playerToAskFrom = null;
    PrintStream stdout = System.out;
    PrintStream gameOutput;
    public Card cardToAskFor = null;
    public String cardValue = "";
    private GofishPlayer[] AIPlayers;
    private GofishPlayer human;
    private javax.swing.JPopupMenu cardRequestMenu;
    private CardRequestMenu requestMenu;
    private ArrayList<ImageIcon> cardImages;
    private HashMap<String, Integer> imageMapper;
    public GoFishWindow() throws IOException {
        initComponents();
        interactButtons[0] = jButton2;
        interactButtons[1] = jButton3;
        interactButtons[2] = jButton4;
        buttonsShowing = new boolean[interactButtons.length];
        cardImages = new ArrayList<ImageIcon>();
        this.initMapper();
        this.loadImages();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GoFishWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GoFishWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GoFishWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GoFishWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        gameOutput = new PrintStream(new gameoutput(this.jTextArea1));
        System.setOut(gameOutput);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jDialog3 = new javax.swing.JDialog();
        requestField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        requestButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        AIWindow0 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        p0handCount = new javax.swing.JLabel();
        AIWindow2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        p2handCount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AIWindow1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        p1handCount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        playerWindow = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jDialog3.setTitle("Request value");
        jDialog3.setMinimumSize(new java.awt.Dimension(400, 300));

        requestField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Which card do you want to request?:");

        requestButton.setText("Request");
        requestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requestButton)
                .addGap(77, 77, 77))
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requestField, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(requestField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestButton)
                    .addComponent(jLabel2))
                .addGap(124, 124, 124))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        AIWindow0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AIWindow0.setPreferredSize(new java.awt.Dimension(200, 100));

        jButton2.setText("Interact");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Player 0");

        jLabel4.setText("Cards in hand:");

        javax.swing.GroupLayout AIWindow0Layout = new javax.swing.GroupLayout(AIWindow0);
        AIWindow0.setLayout(AIWindow0Layout);
        AIWindow0Layout.setHorizontalGroup(
            AIWindow0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AIWindow0Layout.createSequentialGroup()
                .addGroup(AIWindow0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AIWindow0Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel3))
                    .addGroup(AIWindow0Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton2))
                    .addGroup(AIWindow0Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p0handCount)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        AIWindow0Layout.setVerticalGroup(
            AIWindow0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AIWindow0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AIWindow0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(p0handCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        AIWindow2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AIWindow2.setPreferredSize(new java.awt.Dimension(200, 100));

        jButton4.setText("Interact");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Player 2");

        jLabel6.setText("Cards in hand:");

        javax.swing.GroupLayout AIWindow2Layout = new javax.swing.GroupLayout(AIWindow2);
        AIWindow2.setLayout(AIWindow2Layout);
        AIWindow2Layout.setHorizontalGroup(
            AIWindow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AIWindow2Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(74, 74, 74))
            .addGroup(AIWindow2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(AIWindow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AIWindow2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel5))
                    .addGroup(AIWindow2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p2handCount)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AIWindow2Layout.setVerticalGroup(
            AIWindow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AIWindow2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AIWindow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(p2handCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        AIWindow1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AIWindow1.setPreferredSize(new java.awt.Dimension(200, 100));

        jButton3.setText("Interact");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Player 1");

        jLabel8.setText("Cards in hand:");

        javax.swing.GroupLayout AIWindow1Layout = new javax.swing.GroupLayout(AIWindow1);
        AIWindow1.setLayout(AIWindow1Layout);
        AIWindow1Layout.setHorizontalGroup(
            AIWindow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AIWindow1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(93, 93, 93))
            .addGroup(AIWindow1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(AIWindow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AIWindow1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel7))
                    .addGroup(AIWindow1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p1handCount)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AIWindow1Layout.setVerticalGroup(
            AIWindow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AIWindow1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AIWindow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(p1handCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        playerWindow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playerWindow.setMinimumSize(new java.awt.Dimension(600, 200));
        playerWindow.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane2.setViewportView(playerWindow);

        jButton1.setText("My books");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AIWindow0, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AIWindow1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(AIWindow2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AIWindow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AIWindow0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AIWindow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        interactPopups[0].show(jButton2, 0, 0);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        interactPopups[1].show(jButton3, 0, 0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        interactPopups[2].show(jButton4, 0, 0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void requestFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requestFieldActionPerformed

    private void requestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestButtonActionPerformed
        if(requestField.getText().isEmpty()){
            jLabel2.setText("You didn't enter anything.");
        }
        else{
            this.cardValue = requestField.getText().toLowerCase();
            this.cardToAskFor = new Card("spades", this.cardValue);
            this.cardValueObtained = true;
            this.playerValueObtained = true;
            jDialog3.dispose();
        }
    }//GEN-LAST:event_requestButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<ImageIcon> books = new ArrayList<ImageIcon>();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void loadImages() throws IOException{
        String filename;
        for(int i = 0; i < 52; i++){
            filename = "src/images/"+(i+1)+".png";
            System.out.println(filename);
            BufferedImage img = ImageIO.read(new File(filename));
            this.cardImages.add(new ImageIcon(img));
        }
    }
    
    private void initMapper(){
        imageMapper = new HashMap<String, Integer>();
        imageMapper.put("clubs", 0);
        imageMapper.put("spades", 1);
        imageMapper.put("hearts", 2);
        imageMapper.put("diamonds", 3);
        imageMapper.put("ace", 1);
        imageMapper.put("jack", 11);
        imageMapper.put("queen", 12);
        imageMapper.put("king", 13);
    }
    
    private ImageIcon getImage(Card c){
        int cardVal;
        switch(c.value){
            case("ace"):
                cardVal = imageMapper.get("ace");
                break;
            case("jack"):
                cardVal = imageMapper.get("king");
                break;
            case("queen"):
                cardVal = imageMapper.get("queen");
                break;
            case("king"):
                cardVal = imageMapper.get("jack");
                break;
            default:
                cardVal = Integer.parseInt(c.value);
        }
        return this.cardImages.get(((13 * imageMapper.get(c.suit)) 
                                    + cardVal)-1);
    }
    
    public boolean pressButton(int buttonIndex){
        switch(buttonIndex){
            case 0:
                this.jButton2MouseClicked(null);
                return interactPopups[0].isVisible();
            case 1:
                this.jButton3ActionPerformed(null);
                return interactPopups[1].isVisible();
            case 2:
                this.jButton4ActionPerformed(null);
                return interactPopups[2].isVisible();  
            default:
                break;
        }
        return false;
    }
    
    public void updateHandLabel(GofishPlayer player){
        switch(player.ID){
            case(0):
                this.p0handCount.setText(Integer.toString(player.hand.size()));
                break;
            case(1):
                this.p1handCount.setText(Integer.toString(player.hand.size()));
                break;
            case(2):
                this.p2handCount.setText(Integer.toString(player.hand.size()));
                break;
            default:
                break;
        }
    }
    
//    interactPopups[0].
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { 
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>
        /* Create and display the form */
    }
    
    public boolean valuesFound(){
        if(playerValueObtained && cardValueObtained){
            playerValueObtained = false;
            cardValueObtained = false;
            return true;
        }
        else{
            return false;
        }
    }
    
    public GofishPlayer getPlayerRequest(){
        return this.playerToAskFrom;
    }
    
    public Card getCardRequest(){
        return this.cardToAskFor;
    }
    
    public void nullifyValues(){
        playerToAskFrom = null;
        cardToAskFor = null;
    }
    
    public void updatePlayerWindow(GofishPlayer human){
        ArrayList<Card> humanHand = human.hand;
        this.playerWindow.removeAll();
        for(Card c: humanHand){
            JLabel cardImage = new JLabel();
            cardImage.setIcon(this.getImage(c));
            this.playerWindow.add(cardImage);
            System.out.println("Creating cards...");
        }
        this.pack();
    }

    public boolean linkWindow(GofishPlayer[] AIs){
        this.AIPlayers = AIs;
        this.link();
        return false;
    }
    
    private void link(){
        for(int i = 0; i < 3; i++){
            interactPopups[i] = new javax.swing.JPopupMenu();
            interactPopups[i].putClientProperty("AIPlayer", AIPlayers[i]);
            JMenuItem tempMenu = new JMenuItem("show books");
            JMenuItem askChoice = new JMenuItem("ask for a card");
            tempMenu.putClientProperty("AIPlayer", AIPlayers[i]);
            tempMenu.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<ImageIcon> bookImages = new ArrayList<ImageIcon>();
                    GofishPlayer AI = ((GofishPlayer)((JMenuItem)e.getSource())
                            .getClientProperty("AIPlayer"));
                    for(Card c: AI.books){
                        int suitVal,cardVal;
                        suitVal = cardVal = 0;
                        switch(c.suit.toLowerCase()){
                            case("clubs"):
                                suitVal = 0;
                                break;
                            case("spades"):
                                suitVal = 1;
                                break;
                            case("hearts"):
                                suitVal = 2;
                                break;
                            case("diamonds"):
                                suitVal = 3;
                                break;
                        }
                        switch(c.value){
                            case("ace"):
                                cardVal = 1;
                                break;
                            case("jack"):
                                cardVal = 11;
                                break;
                            case("queen"):
                                cardVal = 12;
                                break;
                            case("king"):
                                cardVal = 13;
                                break;
                            default:
                                cardVal = Integer.parseInt(c.value);
                                break;
                        }
                        try {
                            System.out.println("Creating image of " + c.toString() +
                                    "with file src/images/" + (13* suitVal
                                    + cardVal)+".png");
                            bookImages.add(new ImageIcon(ImageIO.read(
                                    new File("src/images/"+(13* suitVal
                                            + cardVal)+".png"))));
                        } catch (IOException ex) {
                            Logger.getLogger(GoFishWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("hi from player " + 
                            ((GofishPlayer)((JMenuItem)e.getSource())
                            .getClientProperty("AIPlayer")).ID );
                    new BookViewer(bookImages).setVisible(true);
                }                
            });
            interactPopups[i].add(tempMenu);
            
            askChoice.putClientProperty("AIPlayer", AIPlayers[i]);
            askChoice.putClientProperty("window", this);
            askChoice.addActionListener(new ActionListener(){
                JDialog menu;
                @Override
                public void actionPerformed(ActionEvent ae) {
                    playerToAskFrom = (GofishPlayer)((JMenuItem)ae.getSource())
                                      .getClientProperty("AIPlayer");
                    System.out.println("You are going to ask for a card from player " + 
                                       playerToAskFrom.ID);
                    jDialog3.setVisible(true);
                }
            });
            interactPopups[i].add(askChoice);
        }
        this.human = 
    }
    
    private javax.swing.JButton[] interactButtons = new javax.swing.JButton[3];
    private javax.swing.JButton[] requestButtons = new javax.swing.JButton[3];
    private javax.swing.JPopupMenu[] interactPopups = new javax.swing.JPopupMenu[3];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AIWindow0;
    private javax.swing.JPanel AIWindow1;
    private javax.swing.JPanel AIWindow2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel p0handCount;
    private javax.swing.JLabel p1handCount;
    private javax.swing.JLabel p2handCount;
    private javax.swing.JPanel playerWindow;
    private javax.swing.JButton requestButton;
    private javax.swing.JTextField requestField;
    // End of variables declaration//GEN-END:variables
}
