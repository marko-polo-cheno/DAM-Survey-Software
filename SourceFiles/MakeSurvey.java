/*
//Tang, Chen
//Jan 17 2019
 * Make Survey form
 * This form is used to make and modify surveys
 * Users can give their survey a title, name questions, select question types,
 * and create possible answers for questions based on the question type.
 * Each question can be viewed using controls that can scroll through all questions made, 
 * and new and previous questions can be added and modified.
 */
package finalproject.tang.chen;

import java.awt.Color;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author altan4377
 */
public class MakeSurvey extends javax.swing.JFrame {

    SelectSurvey previousWindow;
    Welcome firstWindow;
    Survey survey;
    File file;
    String oldFileName = "";

    ArrayList<Question> questions;
    JTextField textFields[] = new JTextField[12];

    boolean surveyOldNew;

    /**
     * Primary constructor of the MakeSurvey form
     */
    public MakeSurvey(SelectSurvey m) {
        initComponents();
        getContentPane().setBackground(new Color(153, 204, 255));

        //Parent window
        previousWindow = m;

        survey = new Survey();

        //A textfield array to save lines of code for repetitive functions that need to be doen to all txt choices
        textFields[0] = txtChoice1;
        textFields[1] = txtChoice2;
        textFields[2] = txtChoice3;
        textFields[3] = txtChoice4;
        textFields[4] = txtChoice5;
        textFields[5] = txtChoice6;
        textFields[6] = txtChoice7;
        textFields[7] = txtChoice8;
        textFields[8] = txtChoice9;
        textFields[9] = txtChoice10;
        textFields[10] = txtChoice11;
        textFields[11] = txtChoice12;

        //Set all the txtfields to contain nothing
        resetText();

        //Set the question number displays to show 0 because no questions have been created yet
        txtQuestionNumber.setText("0");
        txtTotQuestions.setText("0");

//        openFiles();
        questions = new ArrayList();

        //Shows a new survey made
        surveyOldNew = true;
    }

    /**
     * Secondary Constructor of the Make Survey form
     *
     * @param m - the information passed from the previous form
     * @param fileName - the file path to be read
     */
    public MakeSurvey(SelectSurvey m, String fileName) {
        this(m);

        try {

            //Set reader to correct file 
            FileReader fr = new FileReader("src\\finalproject\\tang\\chen\\" + fileName);
            BufferedReader br = new BufferedReader(fr);

            boolean eof = false;
            String typeQuestion, question, responses;

            //While there is content to read in the file
            while (!eof) {

                //Reads a line
                typeQuestion = br.readLine();

                //If the line read is empty, the end of the file is reached, and the program can stop reading the file
                if (typeQuestion == null) {
                    eof = true;

                } else {

                    //Make a new question
                    Question newQuestion;
                    
                    //Read the next 2 lines
                    question = br.readLine();
                    responses = br.readLine();

                    //Take the line of answers possible to be added into an array list
                    String responseList[] = responses.split(", ");
                    ArrayList<String> choices = new ArrayList();

                    //Load the array of choice answers into a list
                    for (int i = 0; i < responseList.length; i++) {
                        choices.add(responseList[i]);
                    }

                    //Check the type of question, and perform respective operations based on type
                    if (typeQuestion.equals("Single Response Multiple Choice")) {

                        //Create a new question in form of a Single MC, set its type, and add it to the survey class
                        newQuestion = new SingleMC(question, choices);

                    } else if (typeQuestion.equals("Multiple Response Multiple Choice")) {

                        //Create a new question in form of a Multiple MC, set its type, and add it to the survey class
                        newQuestion = new MultipleMC(question, choices);

                    } else { //Short Answer Type

                        //Rid of useless things
                        responseList = null;
                        choices = null;

                        //Create a new question in form of a Short Answer, set its type, and add it to the survey class
                        newQuestion = new ShortAnswer(question);

                    }
                    
                    //Set the correct type of question to the question
                    newQuestion.setType(typeQuestion);
                    
                    //Add the created question to the survey
                    survey.getSurveyQuestions().add(newQuestion);
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }

        //Format form characteristics based on previous made survey to continue working on it
        
        display(0); // show the form from the 0th question
        
        txtTitleSurvey.setText(fileName); //give the title the name of the survey
        
        txtTitleSurvey.setEditable(false); //make the title uneditable
        
        surveyOldNew = false; //Not a new survey
        
        oldFileName = fileName; //Store the name of the flie
        
        txtTotQuestions.setText(survey.getSurveyQuestions().size() + ""); //Display the total number of questions made
    }

//    public void openFiles() {
//        file = new File("src\\finalproject\\tang\\chen\\newFile");
//
//        try {
//            file.createNewFile();
//        } catch (IOException ex) {
//            Logger.getLogger(MakeSurvey.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDone = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblChoice1 = new javax.swing.JLabel();
        lblChoice2 = new javax.swing.JLabel();
        lblChoice3 = new javax.swing.JLabel();
        lblChoice4 = new javax.swing.JLabel();
        lblChoice5 = new javax.swing.JLabel();
        lblChoice6 = new javax.swing.JLabel();
        lblChoice7 = new javax.swing.JLabel();
        lblChoice8 = new javax.swing.JLabel();
        lblChoice9 = new javax.swing.JLabel();
        lblChoice10 = new javax.swing.JLabel();
        lblChoice11 = new javax.swing.JLabel();
        lblChoice12 = new javax.swing.JLabel();
        txtQuestion = new javax.swing.JTextField();
        txtChoice1 = new javax.swing.JTextField();
        txtChoice2 = new javax.swing.JTextField();
        txtChoice4 = new javax.swing.JTextField();
        txtChoice5 = new javax.swing.JTextField();
        txtChoice6 = new javax.swing.JTextField();
        txtChoice3 = new javax.swing.JTextField();
        txtChoice7 = new javax.swing.JTextField();
        txtChoice8 = new javax.swing.JTextField();
        txtChoice9 = new javax.swing.JTextField();
        txtChoice10 = new javax.swing.JTextField();
        txtChoice12 = new javax.swing.JTextField();
        txtChoice11 = new javax.swing.JTextField();
        cboType = new javax.swing.JComboBox();
        btnType = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnBackward = new javax.swing.JButton();
        btnForward = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        lblQNum = new javax.swing.JLabel();
        lblTotQuestions = new javax.swing.JLabel();
        txtQuestionNumber = new javax.swing.JTextField();
        txtTotQuestions = new javax.swing.JTextField();
        jspInstructions = new javax.swing.JScrollPane();
        txtInstructions = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        txtTitleSurvey = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Make The Survey");

        btnDone.setBackground(new java.awt.Color(255, 216, 26));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        lblQuestion.setText("Question:");

        lblType.setText("Type Of Question");

        lblChoice1.setText("Choice #1:");

        lblChoice2.setText("Choice #2:");

        lblChoice3.setText("Choice #3:");

        lblChoice4.setText("Choice #4:");

        lblChoice5.setText("Choice #5:");

        lblChoice6.setText("Choice #6:");

        lblChoice7.setText("Choice #7:");

        lblChoice8.setText("Choice #8:");

        lblChoice9.setText("Choice #9:");

        lblChoice10.setText("Choice #10:");

        lblChoice11.setText("Choice #11:");

        lblChoice12.setText("Choice #12:");

        cboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single Response Multiple Choice", "Multiple Response Multiple Choice", "Short Answer" }));

        btnType.setBackground(new java.awt.Color(255, 212, 26));
        btnType.setText("Submit");
        btnType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTypeActionPerformed(evt);
            }
        });

        btnFirst.setBackground(new java.awt.Color(255, 212, 26));
        btnFirst.setText("<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBackward.setBackground(new java.awt.Color(255, 212, 26));
        btnBackward.setText("<");
        btnBackward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackwardActionPerformed(evt);
            }
        });

        btnForward.setBackground(new java.awt.Color(255, 212, 26));
        btnForward.setText(">");
        btnForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForwardActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(255, 212, 26));
        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 212, 26));
        btnAdd.setText("Add This Question");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnModify.setBackground(new java.awt.Color(255, 212, 26));
        btnModify.setText("Modify This Question");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        lblQNum.setText("Question Number:");

        lblTotQuestions.setText("Total Number Of Questions Done:");

        txtQuestionNumber.setEditable(false);

        txtTotQuestions.setEditable(false);

        txtInstructions.setEditable(false);
        txtInstructions.setColumns(20);
        txtInstructions.setRows(5);
        txtInstructions.setText("To Create A Question:\n1. Select the type of question and click \"Submit\"\n2. Fill in the question and the possible choices. \nThe maximum number of choices is 12.\n3. Press \"Add This Question\" to register this question.\nYou can also modify the question by selecting the desired question\nand press \"Modify This Question\" once you commit these changes.\nTo save a survey you MUST press \"Done\". ");
        jspInstructions.setViewportView(txtInstructions);

        lblTitle.setText("Title Of Survey");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblChoice1)
                        .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblType, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(lblChoice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChoice12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTitle))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice12, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice11, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice7, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice8, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice9, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice4, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice6, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnType))
                    .addComponent(txtChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice10, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitleSurvey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModify)
                            .addComponent(btnAdd)
                            .addComponent(btnLast)
                            .addComponent(btnForward)
                            .addComponent(btnFirst)
                            .addComponent(btnBackward))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspInstructions)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblQNum)
                                            .addComponent(lblTotQuestions))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtQuestionNumber)
                                            .addComponent(txtTotQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnDone))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jspInstructions)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQNum)
                            .addComponent(txtQuestionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotQuestions)
                            .addComponent(txtTotQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFirst)
                        .addGap(18, 18, 18)
                        .addComponent(btnBackward)
                        .addGap(18, 18, 18)
                        .addComponent(btnForward)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast)
                        .addGap(26, 26, 26)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnModify)
                        .addGap(18, 18, 18)
                        .addComponent(btnDone))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitle)
                            .addComponent(txtTitleSurvey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuestion)
                            .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblType)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnType)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice1)
                            .addComponent(txtChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice2)
                            .addComponent(txtChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChoice3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice4)
                            .addComponent(txtChoice4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice5)
                            .addComponent(txtChoice5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice6)
                            .addComponent(txtChoice6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice7)
                            .addComponent(txtChoice7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice8)
                            .addComponent(txtChoice8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice9)
                            .addComponent(txtChoice9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice10)
                            .addComponent(txtChoice10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice11)
                            .addComponent(txtChoice11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChoice12)
                            .addComponent(txtChoice12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * When the button to finish making the survey is pressed - "Done"
     */
    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        //Takes user back to the first splash screen after finishing their survey
        if (firstWindow == null) {
            firstWindow = new Welcome();
        }
        firstWindow.setVisible(true);
        this.setVisible(false);

        //Get the title from the user's entered title name
        String preProcessTitle = txtTitleSurvey.getText();

        String postProcessTitle = "";

        //Take the title and go through each character of the title
        for (int i = 0; i < preProcessTitle.length(); i++) {

            //Checks for special characters and gets rid of them, adding allowed characters into the new official title
            if ((int) (preProcessTitle.charAt(i)) == 32) { //Space
                postProcessTitle += " ";

            } else if ((int) (preProcessTitle.charAt(i)) >= 65 && (int) (preProcessTitle.charAt(i)) <= 90) { //Lowercase abcs
                postProcessTitle += preProcessTitle.charAt(i);

            } else if ((int) (preProcessTitle.charAt(i)) >= 97 && (int) (preProcessTitle.charAt(i)) <= 122) { //Uppercase ABCs
                postProcessTitle += preProcessTitle.charAt(i);

            } else if ((int) (preProcessTitle.charAt(i)) >= 48 && (int) (preProcessTitle.charAt(i)) <= 57) { //Numbers 0 to 9
                postProcessTitle += preProcessTitle.charAt(i);
            }
        }

        //If the survey is one made from before, make a new file
        if (surveyOldNew = true) {
            String fileName = "src\\finalproject\\tang\\chen\\" + postProcessTitle;
            file = new File(fileName);
        }

//        //Make the response file respective to the name of the survey
//        String responseFileName = "src\\finalproject\\tang\\chen\\" + postProcessTitle + " RESPONSES";
//        File file2 = new File(responseFileName);
//
//        try {
//            if (file2.createNewFile()) {
//
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(MakeSurvey.class.getName()).log(Level.SEVERE, null, ex);
//        }

        //Writing to the response file
        try {
            //Set writer to the correct file
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            //Clears the file in case there is content inside
            PrintWriter pw = new PrintWriter(file);
            pw.print("");
            pw.close();

            String questionType, questionAsked;

            //For the number of questions there are in a survey
            for (int i = 0; i < survey.getSurveyQuestions().size(); i++) {

                //First line of output will be the type of the question
                questionType = survey.getSurveyQuestions().get(i).getType();
                bw.write(questionType + "\n");

                //Second line of output will be the actual question asked
                questionAsked = survey.getSurveyQuestions().get(i).getQuestion();
                bw.write(questionAsked + "\n");

                //Based off of the type of question, the answers of the question will be written to the file
                if (questionType.equals("Single Response Multiple Choice")) {

                    //For Single MCs, get the choices of the question
                    ArrayList<String> choices = ((SingleMC) (survey.getSurveyQuestions().get(i))).getAnswers();

                    //For the maximum number of answers allowed, create a line of answers seperated by commas
                    for (int j = 0; j < 12; j++) {

                        //Write out the choice
                        bw.write(choices.get(j));

                        //If the choice is empty, write out a space
                        if (choices.get(j).equals("")) {
                            bw.write(" ");
                        }

                        //Seperate each entry with a comma
                        bw.write(", ");
                    }

                } else if (questionType.equals("Multiple Response Multiple Choice")) {

                    //For Multiple MCs, get the choices of the question
                    ArrayList<String> choices = ((MultipleMC) (survey.getSurveyQuestions().get(i))).getAnswers();

                    //For the maximum number of answers allowed, create a line of answers seperated by commas
                    for (int j = 0; j < 12; j++) {

                        //Write out the choice
                        bw.write(choices.get(j));

                        //If the choice is empty, write out a space
                        if (choices.get(j).equals("")) {
                            bw.write(" ");
                        }

                        //Seperate each entry with a comma
                        bw.write(", ");
                    }

                } else {
                    //Short answer type
                    bw.write("Short answer question. Choices do not apply");
                }

                //At the end of each complete question entry, add a line space to start next question on new line
                if (i < survey.getSurveyQuestions().size() - 1) {
                    bw.write("\n");
                }

            }

            bw.close();
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }

        //Reads the Survey Storage file to see which surveys exist
        ArrayList<String> whatIsThere = new ArrayList();
        try {

            //Sets reader to the correct file holding all survey names
            FileReader fr = new FileReader("src\\finalproject\\tang\\chen\\SurveyStorage");
            BufferedReader br = new BufferedReader(fr);

            boolean eof = false;
            String line;

            //While an empty line is not read
            while (!eof) {

                //Read a line
                line = br.readLine();

                //If the line is empty, the end of the file is reached
                if (line == null) {

                    //Switch the end of file switch, and terminate the loop
                    eof = true;

                } else {
                    //Add the survey name to the list of names
                    whatIsThere.add(line);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }

        //Add the new survey created to the storage of surveys
        try {

            //Set the writer to the file containing all the names of the surveys
            FileWriter fw = new FileWriter("src\\finalproject\\tang\\chen\\SurveyStorage");
            BufferedWriter bw = new BufferedWriter(fw);

            //Re-Write the SurveyStorage file from the list containing the names
            for (int i = 0; i < whatIsThere.size(); i++) {
                bw.write(whatIsThere.get(i) + "\n");
            }

            //Only if a new survey is created, add on the new survey name
            if (surveyOldNew == true) {

                //Write the new title to the file
                bw.write(preProcessTitle);
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(MakeSurvey.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    /**
     * This method will display the attributes of that question to the text
     * choice boxes
     *
     * @param questionNumber - the question index number in the list of
     * questions
     */
    public void display(int questionNumber) {
        //Show the user the question number (+1 because computers count from 0) as a string
        txtQuestionNumber.setText((questionNumber + 1) + "");

        //Get the actual question asked, and display the question to the user
        txtQuestion.setText(((survey.getSurveyQuestions()).get(questionNumber)).getQuestion());

        //Get the type of question
        String type = (((survey.getSurveyQuestions()).get(questionNumber)).getType());

        //Default the comboBox to select that type of question
        cboType.setSelectedItem(type);

        //Based on the type of question, follow respective operations to show allowed answers of a question to choice boxes
        if (type.equals("Single Response Multiple Choice")) {

            //Get the list of answers from the Single MC question
            ArrayList<String> answers = ((SingleMC) (survey.getSurveyQuestions()).get(questionNumber)).getAnswers();

            //Set all the boxes respective to the answers
            setText(answers);

        } else if (type.equals("Multiple Response Multiple Choice")) {

            //Get the list of answers from the Multiple MC question
            ArrayList<String> answers = ((MultipleMC) (survey.getSurveyQuestions()).get(questionNumber)).getAnswers();

            //Set all the boxes respective to the answers
            setText(answers);
        }
    }

    /**
     * This method will set all the text choice boxes to have their correct data
     * from an list of things to set
     *
     * @param answers - the list of things to put into the text choice boxes
     */
    private void setText(ArrayList<String> answers) {
        //For all 12 boxes, add the respective answer to that box
        for (int i = 0; i < 12; i++) {
            textFields[i].setText(answers.get(i));
        }
    }

    /**
     * When the "backback" button is pressed
     */
    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        //reset all text
        resetText();
        //display the list of questions back to the 0th index - the beginning
        display(0);
    }//GEN-LAST:event_btnFirstActionPerformed

    /**
     * When the "back" button is pressed
     */
    private void btnBackwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackwardActionPerformed
        //Get the number currently in the question number text box, and subtract 1 to get the index number
        int currentQNumber = Integer.parseInt(txtQuestionNumber.getText()) - 1;

        //If going back does not exceed the parameters allowed
        if (currentQNumber >= 1) {
            //Reset all the text
            resetText();

            //Display all stats with the question number being 1 less
            display(currentQNumber - 1);
        }
    }//GEN-LAST:event_btnBackwardActionPerformed

    /**
     * When the "forward" button is pressed
     */
    private void btnForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForwardActionPerformed
        //Get the number currently in the question number text box, and subtract 1 to get the index number
        int currentQNumber = Integer.parseInt(txtQuestionNumber.getText()) - 1;

        //If going forward does not exceed the parameters allowed
        if (currentQNumber < survey.getSurveyQuestions().size() - 1) {
            //Reset all text
            resetText();

            //Display all stats with the question number being 1 more
            display(currentQNumber + 1);
        }
    }//GEN-LAST:event_btnForwardActionPerformed

    /**
     * When the "forward forward" button is pressed
     */
    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        //Reset all the text 
        resetText();

        //Get the final index of the questions in the survey
        int numQuestions = survey.getSurveyQuestions().size();

        //Show the last question number made
        txtQuestionNumber.setText((numQuestions + 1) + "");
    }//GEN-LAST:event_btnLastActionPerformed

    /**
     * When the type selection button is pressed
     */
    private void btnTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTypeActionPerformed
        //Get the type of question
        String typeQuestion = cboType.getSelectedItem().toString();

        //If the type of question does not take answer selection
        if (!typeQuestion.equals("Short Answer")) {
            resetEditable(true);

        } else {

            //Make none of the text choices editable, and make them gray
            resetEditable(false);
            resetMCBoxes(Color.gray);
        }
    }//GEN-LAST:event_btnTypeActionPerformed

    /**
     * This method will set all the text boxes to change to a given color
     *
     * @param color - the color to set the boxes to
     */
    private void resetMCBoxes(Color color) {
        //for the 12 boxes, change their background to a set color
        for (int i = 0; i < 12; i++) {
            textFields[i].setBackground(color);
        }
    }

    /**
     * This method will set all the text boxes to be able or not to be able to
     * be changed
     *
     * @param editable - if the boxes are allowed to be changed
     */
    private void resetEditable(boolean editable) {
        //for the 12 boxes, change their editable setting
        for (int i = 0; i < 12; i++) {
            textFields[i].setEditable(editable);
        }
    }

    /**
     * This method will reset all the text inside the answer boxes and the
     * question box
     */
    private void resetText() {
        //Set the question box to blank
        txtQuestion.setText("");

        //Set the 12 answer boxes contents to nothing
        for (int i = 0; i < 12; i++) {
            textFields[i].setText("");
        }
    }

    /**
     * This method checks if the choices of the question type is allowed
     *
     * @param typeQuestion - the type of question - aka what class
     * @return - boolean to see if answers are allowed to be set
     */
    private boolean checkValidChoices(String typeQuestion) {
        boolean validChoices = false;

        //If the type of question is Short Answer, no choices are allowed
        if (typeQuestion.equals("Short Answer")) {

            //Allow nothing in the boxes for these types of questions
            validChoices = true;

        } else {
            //In all 12 boxes, if any are not empty, an answer set can be made
            for (int i = 0; i < 12; i++) {

                //check to see if they are empty
                if (!textFields[i].getText().equals("")) {
                    validChoices = true;
                }
            }
        }
        return validChoices;
    }

    /**
     * When the "add" button is selected
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //Get the type of question
        String typeQuestion = cboType.getSelectedItem().toString();
        //Get the question
        String question = txtQuestion.getText();

        //If able to have answer(s), and question is not blank
        if (checkValidChoices(typeQuestion) == true && !question.equals("")) {

            Question newQuestion;

            //Based on type of question
            if (typeQuestion.equals("Single Response Multiple Choice")) {

                //Make a list of answers and add what is written in the boxes to the list
                ArrayList<String> answers = new ArrayList();
                for (int i = 0; i < 12; i++) {
                    //Add what is in a box to the arraylist of answers
                    answers.add(textFields[i].getText());
                }

                //create a new Single MC question with the question asked and the set of answers given by the user
                newQuestion = new SingleMC(question, answers);

            } else if (typeQuestion.equals("Multiple Response Multiple Choice")) {

                //Make a list of answers and add what is written in the boxes to the list
                ArrayList<String> answers = new ArrayList();
                for (int i = 0; i < 12; i++) {
                    //Add what is in a box to the arraylist of answers
                    answers.add(textFields[i].getText());
                }

                //create a new Multiple MC question with the question asked and the set of answers given by the user
                newQuestion = new MultipleMC(question, answers);

            } else {
                //Short answer type
                //create a new short answer type from the question asked by the user
                newQuestion = new ShortAnswer(question);

            }

            //Set the type of the question to be the correct type
            newQuestion.setType(typeQuestion);

            //Add this question to the survey object
            survey.getSurveyQuestions().add(newQuestion);

            //Add this question to local question storage
            questions.add(newQuestion);

            //Reset all the text boxes for next question
            resetText();
            resetMCBoxes(Color.white);

            //Take the current number inside the index of the questions and return it back, adding 1 to it
            int questionNumber = Integer.parseInt(txtQuestionNumber.getText());
            txtQuestionNumber.setText((questionNumber + 1) + "");

            //Take the question number in the total number of questions box and return it, adding one more to it
            int numQuestionsDone = Integer.parseInt(txtTotQuestions.getText());
            txtTotQuestions.setText((numQuestionsDone + 1) + "");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        //Take the current index of the question that is to be modified
        int questionNumber = Integer.parseInt(txtQuestionNumber.getText()) - 1;

        //Remove the question that will be modified
        survey.getSurveyQuestions().remove(questionNumber);

        //Create a new question
        Question question;

        //Get the question to be asked
        String questionName = txtQuestion.getText();

        //Get the type of question selected
        String type = cboType.getSelectedItem().toString();

        //Based on type of question
        if (type.equals("Single Response Multiple Choice")) {

            //Make a list of answers and add what is written in the boxes to the list
            ArrayList<String> answers = new ArrayList();

            for (int i = 0; i < 12; i++) {
                //Add what is in a box to the arraylist of answers
                answers.add(textFields[i].getText());
            }

            //change and construct the question to be a Single MC question
            question = new SingleMC(questionName, answers);

        } else if (type.equals("Multiple Response Multiple Choice")) {

            //Make a list of answers and add what is written in the boxes to the list
            ArrayList<String> answers = new ArrayList();

            for (int i = 0; i < 12; i++) {
                //Add what is in a box to the arraylist of answers
                answers.add(textFields[i].getText());
            }

            //change and construct the question to be a Multiple MC question
            question = new MultipleMC(questionName, answers);

        } else {
            //change and construct the question to be a short answer question
            question = new ShortAnswer(questionName);
        }

        //Set the type of the question to be the correct type
        question.setType(type);

        //Add the modified question to the survey
        survey.getSurveyQuestions().add(questionNumber, question);

    }//GEN-LAST:event_btnModifyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBackward;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnForward;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnType;
    private javax.swing.JComboBox cboType;
    private javax.swing.JScrollPane jspInstructions;
    private javax.swing.JLabel lblChoice1;
    private javax.swing.JLabel lblChoice10;
    private javax.swing.JLabel lblChoice11;
    private javax.swing.JLabel lblChoice12;
    private javax.swing.JLabel lblChoice2;
    private javax.swing.JLabel lblChoice3;
    private javax.swing.JLabel lblChoice4;
    private javax.swing.JLabel lblChoice5;
    private javax.swing.JLabel lblChoice6;
    private javax.swing.JLabel lblChoice7;
    private javax.swing.JLabel lblChoice8;
    private javax.swing.JLabel lblChoice9;
    private javax.swing.JLabel lblQNum;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotQuestions;
    private javax.swing.JLabel lblType;
    private javax.swing.JTextField txtChoice1;
    private javax.swing.JTextField txtChoice10;
    private javax.swing.JTextField txtChoice11;
    private javax.swing.JTextField txtChoice12;
    private javax.swing.JTextField txtChoice2;
    private javax.swing.JTextField txtChoice3;
    private javax.swing.JTextField txtChoice4;
    private javax.swing.JTextField txtChoice5;
    private javax.swing.JTextField txtChoice6;
    private javax.swing.JTextField txtChoice7;
    private javax.swing.JTextField txtChoice8;
    private javax.swing.JTextField txtChoice9;
    private javax.swing.JTextArea txtInstructions;
    private javax.swing.JTextField txtQuestion;
    private javax.swing.JTextField txtQuestionNumber;
    private javax.swing.JTextField txtTitleSurvey;
    private javax.swing.JTextField txtTotQuestions;
    // End of variables declaration//GEN-END:variables
}
