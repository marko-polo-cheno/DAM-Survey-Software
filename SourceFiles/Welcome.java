/*
 * Albert Tang and Mark Chen
 * January 17 2018
 * This is our ICS4U Final Project
 * This project is designed to allow users to make surveys, do surveys, and analyze surveys.
 * In creating the survey, users can make single answer questions, multi answer questions, or short answer questions.
 * In the analyzing portion of this project, users can see graphical representions of the responses of a specific question,
 * or they can select specific criteria to see how many repsponses had chosen those specific things.
 * 
 * Welcome Splash Screen Form 
 */
package finalproject.tang.chen;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Welcome extends javax.swing.JFrame {

    private AnalyzeSurvey analyzeWindow;
    private Exit exitWindow;
    private DoSurvey doWindow;
    private ChoiceOfSurvey makeWindow;

    /**
     * This is the constructor of the Welcome splash screen that will be ran
     * upon startup of program
     */
    public Welcome() {
        initComponents();
        getContentPane().setBackground(new Color(153, 204, 255));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblWelcome1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnDoSurvey = new javax.swing.JButton();
        btnAnalyzeSurvey = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnCredits = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome!");
        setBackground(new java.awt.Color(153, 204, 255));
        setForeground(new java.awt.Color(204, 204, 255));

        lblWelcome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome1.setText("WELCOME TO DAM SURVEY!");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WHAT WOULD YOU LIKE TO DO?");

        btnCreate.setBackground(new java.awt.Color(255, 212, 26));
        btnCreate.setText("Create Survey");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDoSurvey.setBackground(new java.awt.Color(255, 212, 26));
        btnDoSurvey.setText("Do Survey");
        btnDoSurvey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoSurveyActionPerformed(evt);
            }
        });

        btnAnalyzeSurvey.setBackground(new java.awt.Color(255, 212, 26));
        btnAnalyzeSurvey.setText("Analyze Survey");
        btnAnalyzeSurvey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalyzeSurveyActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 212, 26));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnCredits.setBackground(new java.awt.Color(255, 212, 26));
        btnCredits.setText("Credits");
        btnCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDoSurvey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAnalyzeSurvey, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblWelcome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreate)
                .addGap(27, 27, 27)
                .addComponent(btnDoSurvey)
                .addGap(32, 32, 32)
                .addComponent(btnAnalyzeSurvey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnCredits)
                .addGap(29, 29, 29)
                .addComponent(btnExit)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * When the button to do a survey - "Do Survey" - is selected
     */
    private void btnDoSurveyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoSurveyActionPerformed
        //If no DoSurvey form exists, create a new one
        if (doWindow == null) {
            doWindow = new DoSurvey(this);
        }

        //Change visiblity of forms to link to the next form respective to the user's choice
        doWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDoSurveyActionPerformed

    /**
     * When the button to analyze a survey - "Analyze Survey" - is selected
     */
    private void btnAnalyzeSurveyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalyzeSurveyActionPerformed
        //If no AnalyzeSurvey form exists, create a new one
        if (analyzeWindow == null) {
            analyzeWindow = new AnalyzeSurvey(this);
        }

        //Change visiblity of forms to link to the next form respective to the user's choice
        analyzeWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAnalyzeSurveyActionPerformed

    /**
     * When the button to exit the program - "Exit" - is selected
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        //If no Exit form exists, create a new one
        if (exitWindow == null) {
            exitWindow = new Exit(this);
        }

        //Change visiblity of forms to link to the next form respective to the user's choice
        exitWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * When the button to create a survey - "Create Survey" - is selected
     */
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        //If no ChoiceOfSurvey form exists, create a new one
        if (makeWindow == null) {
            makeWindow = new ChoiceOfSurvey(this);
        }

        //Change visiblity of forms to link to the next form respective to the user's choice
        makeWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCreateActionPerformed

    /**
     * Display the credits of the program
     * @param evt The "Credits" button is pressed
     */
    private void btnCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditsActionPerformed
        JOptionPane.showMessageDialog(null, "This survey program is brought to you by\n" + 
                                       "Forms R Us\n" + 
                                       "Creators Albert Tang and Mark Chen\n" + 
                                       "The developers resolve to make the analysis of surveys as convenient and accessible as possible.\n" + 
                                       "The developers resolve to allow survey users to process data more efficiently\n" + 
                                       "and make the best decisions possible with the time and energy they save by using this program.\n" + 
                                       "Forms R Us owns the copyright of this program\n" + 
                                       "Created January 2019", "Credits", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCreditsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalyzeSurvey;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnCredits;
    private javax.swing.JButton btnDoSurvey;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblWelcome1;
    // End of variables declaration//GEN-END:variables
}
