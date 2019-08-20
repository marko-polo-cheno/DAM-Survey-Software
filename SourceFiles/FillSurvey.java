/*
//Tang, Chen
//Jan 17 2019
 * Fill Survey form
 * This form allows the user to fill in a created survey
 * The form will create a response file storing all the responses
 */
package finalproject.tang.chen;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class FillSurvey extends javax.swing.JFrame {

    ChoiceDoSurvey choiceDoSurvey;
    Survey survey;
    String response[];
    String surveyName;

    /**
     * This method creates the FillSurvey form for the user to complete the
     * survey based on what the user selected
     *
     * @param choiceDoSurvey - the parent form
     * @param fileName - the name of the survey
     */
    public FillSurvey(ChoiceDoSurvey choiceDoSurvey, String fileName) {
        initComponents();

        this.choiceDoSurvey = choiceDoSurvey;

        //create a new survey object
        survey = new Survey();

        getContentPane().setBackground(new Color(153, 204, 255));

        //Establish the survey based on the name of the file to be read
        this.surveyName = fileName;

        //establish the survey
        establishSurvey(surveyName);

        //Initialise the response string array based on the size of the number of questions
        response = new String[survey.getSurveyQuestions().size()];

        //Create an array of radio buttons, checkboxes, and labels
        JRadioButton singleMC[] = {btnChoice1, btnChoice2, btnChoice3, btnChoice4, btnChoice5, btnChoice6, btnChoice7, btnChoice8, btnChoice9, btnChoice10, btnChoice11, btnChoice12};
        JCheckBox multipleMC[] = {chkChoice1, chkChoice2, chkChoice3, chkChoice4, chkChoice5, chkChoice6, chkChoice7, chkChoice8, chkChoice9, chkChoice10, chkChoice11, chkChoice12};
        JLabel choices[] = {lblChoice1, lblChoice2, lblChoice3, lblChoice4, lblChoice5, lblChoice6, lblChoice7, lblChoice8, lblChoice9, lblChoice10, lblChoice11, lblChoice12};

        //Display the questions in the using the arrays of radio buttons, checkboxes, and labels
        displayQuestions(singleMC, multipleMC, choices, 0);

    }

    /**
     * This method will display to the user the question asked and the choices
     * to choose from
     *
     * @param singleMC - the array of radio buttons
     * @param multipleMC - the array of check boxes
     * @param choices - the array of labels to display answer choices
     * @param questionNumber - the index of the question being shown
     */
    public void displayQuestions(JRadioButton singleMC[], JCheckBox multipleMC[], JLabel choices[], int questionNumber) {
        //Show the user the question number they are answering
        lblQuestionNum.setText((questionNumber + 1) + "");

        //Get the question the user is to answer
        Question question = survey.getSurveyQuestions().get(questionNumber);

        //Display the actual question that prompts the responder
        lblQuestionTitle.setText(question.getQuestion() + "");

        //Get the type of question that is being answered
        String type = question.getType();

        //Based on the type of question, set the question into the arrays of radio-buttons/check-boxes and answers into the labels
        if (type.equals("Single Response Multiple Choice")) {
            setSingleMC(singleMC, multipleMC, choices, questionNumber);
        } else if (type.equals("Multiple Response Multiple Choice")) {
            setMultipleMC(singleMC, multipleMC, choices, questionNumber);
        } else {
            setShortAnswer(singleMC, multipleMC, choices, questionNumber);
        }
    }

    /**
     * This method will create the survey object from a data file
     *
     * @param fileName - the name of the survey
     */
    public void establishSurvey(String fileName) {
        try {
            //Set the reader to the correct survey file
            FileReader fr = new FileReader("src\\finalproject\\tang\\chen\\" + fileName);
            BufferedReader br = new BufferedReader(fr);

            boolean eof = false;
            String typeQuestion, question, responses;

            //While there are lines to still read
            while (!eof) {

                //Read a line
                typeQuestion = br.readLine();

                //If a line read is empty
                if (typeQuestion == null) {
                    //The end of the file is reached
                    eof = true;

                } else {
                    //Create a new question
                    Question newQuestion;

                    //Read the next two lines for the actual question and the possible answers to the question
                    question = br.readLine();
                    responses = br.readLine();

                    //Split the answer choices by commas to seperate individual responses
                    String responseList[] = responses.split(", ");

                    //Set an array list with the choices of the individual responses
                    ArrayList<String> choices = new ArrayList();

                    for (int i = 0; i < responseList.length; i++) {
                        choices.add(responseList[i]);
                    }

                    //Based on the type of the question, 
                    if (typeQuestion.equals("Single Response Multiple Choice")) {
                        //Create the short SingleMC question
                        newQuestion = new SingleMC(question, choices);

                    } else if (typeQuestion.equals("Multiple Response Multiple Choice")) {
                        //Create the short MultipleMC question
                        newQuestion = new MultipleMC(question, choices);

                    } else {
                        //Rid of what is not used, just in case
                        responseList = null;
                        choices = null;

                        //Create the short answer question
                        newQuestion = new ShortAnswer(question);
                    }
                    //Set the correct type of question to the question to be added to the survey
                    newQuestion.setType(typeQuestion);

                    //Add the question created to the survey object
                    survey.getSurveyQuestions().add(newQuestion);
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
    }

    /**
     * This method will create the answering environment for a user who is
     * completing a Single MC question
     *
     * @param singleMC - the array of radio buttons
     * @param multipleMC - the array of check boxes
     * @param choices - the array of labels
     * @param questionNumber - the index of the question
     */
    public void setSingleMC(JRadioButton singleMC[], JCheckBox multipleMC[], JLabel choices[], int questionNumber) {
        //For the maximum number of answers allowed
        for (int i = 0; i < 12; i++) {

            //Because this is a SingleMC, let the radio buttons be seen, and all not selected
            singleMC[i].setVisible(true);
            singleMC[i].setSelected(false);

            //Because this is a SingleMC, disable things pertaining to MultipleMC
            multipleMC[i].setVisible(false);
            multipleMC[i].setSelected(false);

            //Set the choices based on the possible answers to be chosen from
            choices[i].setText(((SingleMC) (survey.getSurveyQuestions().get(questionNumber))).getAnswers().get(i));

            //If any labels are empty, disable the respective radio button
            if (choices[i].getText().equals(" ")) {
                singleMC[i].setEnabled(false);
            }
        }

        //Hide information pertaining to short answer questions.
        txtSA.setVisible(false);
        txtSA.setText("");
    }

    /**
     * This method will create the answering environment for a user who is
     * completing a Multiple MC question
     *
     * @param singleMC - the array of radio buttons
     * @param multipleMC - the array of check boxes
     * @param choices - the array of labels
     * @param questionNumber - the index of the question
     */
    public void setMultipleMC(JRadioButton singleMC[], JCheckBox multipleMC[], JLabel choices[], int questionNumber) {
        //For the maximum number of answers allowed
        for (int i = 0; i < 12; i++) {

            //Because this is a MultipleMC, disable things pertaining to SingleMC
            singleMC[i].setVisible(false);
            singleMC[i].setSelected(false);

            //Because this is a MultipleMC, let the check boxes be seen, and all not selected
            multipleMC[i].setVisible(true);
            multipleMC[i].setSelected(false);

            //Set the choices based on the possible answers to be chosen from
            choices[i].setText(((MultipleMC) (survey.getSurveyQuestions().get(questionNumber))).getAnswers().get(i));

            //If any labels are empty, disable the respective check box
            if (choices[i].getText().equals(" ")) {
                multipleMC[i].setEnabled(false);
            }
        }

        //Hide information pertaining to short answer questions.
        txtSA.setVisible(false);
        txtSA.setText("");
    }

    /**
     * This method will create the answering environment for a user who is
     * completing a Short Answer question
     *
     * @param singleMC - the array of radio buttons
     * @param multipleMC - the array of check boxes
     * @param choices - the array of labels
     * @param questionNumber - the index of the question
     */
    public void setShortAnswer(JRadioButton singleMC[], JCheckBox multipleMC[], JLabel choices[], int questionNumber) {
        //For the maximum number of answers allowed - all the fields
        for (int i = 0; i < 12; i++) {
            //Disable everything, making them insivible and unselectable
            singleMC[i].setVisible(false);
            singleMC[i].setSelected(false);
            multipleMC[i].setVisible(false);
            multipleMC[i].setSelected(false);

            //Set all labels to contain nothing
            choices[i].setText("");
        }

        //Set the short answer box to be able to be manipulated by the user
        txtSA.setText("");
        txtSA.setVisible(true);
        txtSA.setEditable(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgSingleMC = new javax.swing.ButtonGroup();
        lblQuestion = new javax.swing.JLabel();
        lblQuestionNum = new javax.swing.JLabel();
        lblQuestionTitle = new javax.swing.JLabel();
        btnChoice1 = new javax.swing.JRadioButton();
        btnChoice2 = new javax.swing.JRadioButton();
        btnChoice3 = new javax.swing.JRadioButton();
        btnChoice4 = new javax.swing.JRadioButton();
        btnChoice6 = new javax.swing.JRadioButton();
        btnChoice5 = new javax.swing.JRadioButton();
        btnChoice7 = new javax.swing.JRadioButton();
        btnChoice8 = new javax.swing.JRadioButton();
        btnChoice9 = new javax.swing.JRadioButton();
        btnChoice10 = new javax.swing.JRadioButton();
        btnChoice11 = new javax.swing.JRadioButton();
        btnChoice12 = new javax.swing.JRadioButton();
        chkChoice1 = new javax.swing.JCheckBox();
        chkChoice2 = new javax.swing.JCheckBox();
        chkChoice3 = new javax.swing.JCheckBox();
        chkChoice4 = new javax.swing.JCheckBox();
        chkChoice5 = new javax.swing.JCheckBox();
        chkChoice6 = new javax.swing.JCheckBox();
        chkChoice7 = new javax.swing.JCheckBox();
        chkChoice8 = new javax.swing.JCheckBox();
        chkChoice9 = new javax.swing.JCheckBox();
        chkChoice10 = new javax.swing.JCheckBox();
        chkChoice11 = new javax.swing.JCheckBox();
        chkChoice12 = new javax.swing.JCheckBox();
        lblChoice1 = new javax.swing.JLabel();
        lblChoice2 = new javax.swing.JLabel();
        lblChoice3 = new javax.swing.JLabel();
        lblChoice4 = new javax.swing.JLabel();
        lblChoice5 = new javax.swing.JLabel();
        lblChoice6 = new javax.swing.JLabel();
        lblChoice7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblChoice8 = new javax.swing.JLabel();
        lblChoice9 = new javax.swing.JLabel();
        lblChoice10 = new javax.swing.JLabel();
        lblChoice11 = new javax.swing.JLabel();
        lblChoice12 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        txtSA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblQuestion.setText("Question");

        btgSingleMC.add(btnChoice1);

        btgSingleMC.add(btnChoice2);

        btgSingleMC.add(btnChoice3);

        btgSingleMC.add(btnChoice4);

        btgSingleMC.add(btnChoice6);

        btgSingleMC.add(btnChoice5);

        btgSingleMC.add(btnChoice7);

        btgSingleMC.add(btnChoice8);

        btgSingleMC.add(btnChoice9);

        btgSingleMC.add(btnChoice10);

        btgSingleMC.add(btnChoice11);

        btgSingleMC.add(btnChoice12);

        btnNext.setBackground(new java.awt.Color(255, 212, 26));
        btnNext.setText("Next Question");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSA, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice11)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice11)
                                .addGap(18, 18, 18)
                                .addComponent(lblChoice11, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice10)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice10)
                                .addGap(18, 18, 18)
                                .addComponent(lblChoice10, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice9)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice9)
                                .addGap(18, 18, 18)
                                .addComponent(lblChoice9, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice8)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice8)
                                .addGap(18, 18, 18)
                                .addComponent(lblChoice8, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice6)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice6)
                                .addGap(18, 18, 18)
                                .addComponent(lblChoice6, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice2)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice2)
                                .addGap(18, 18, 18)
                                .addComponent(lblChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice1)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice1)
                                .addGap(18, 18, 18)
                                .addComponent(lblChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblQuestionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblQuestionNum, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnChoice4)
                                        .addGap(18, 18, 18)
                                        .addComponent(chkChoice4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnChoice5)
                                        .addGap(18, 18, 18)
                                        .addComponent(chkChoice5)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblChoice4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblChoice5, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice7)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice7)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblChoice7, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice3)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice3)
                                .addGap(18, 18, 18)
                                .addComponent(lblChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChoice12)
                                .addGap(18, 18, 18)
                                .addComponent(chkChoice12)
                                .addGap(18, 18, 18)
                                .addComponent(lblChoice12, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(btnNext)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQuestionNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQuestionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnChoice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkChoice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblChoice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChoice2)
                            .addComponent(chkChoice2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChoice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkChoice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChoice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkChoice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChoice4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChoice5)
                    .addComponent(chkChoice5)
                    .addComponent(lblChoice5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkChoice6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChoice6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblChoice6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkChoice7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChoice7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChoice7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChoice8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkChoice8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChoice8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChoice9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkChoice9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChoice9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblChoice10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChoice10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkChoice10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChoice11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkChoice11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblChoice11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChoice12)
                    .addComponent(chkChoice12)
                    .addComponent(lblChoice12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNext)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method will see if a response was made
     *
     * @param singleMC - the array of radio buttons
     * @param multipleMC - the array of check boxes
     * @param questionNumber - the index of the question
     * @return - true or false if a legal answer was given by the user
     */
    private boolean checkResponseMade(JRadioButton singleMC[], JCheckBox multipleMC[], int questionNumber) {
        //Get the type of question being answered
        String typeQuestion = survey.getSurveyQuestions().get(questionNumber - 1).getType();

        //Initialize the response's legality to be false
        boolean responseMade = false;

        //Check if a legal answer was made based off type of question
        if (typeQuestion.equals("Single Response Multiple Choice")) {

            //Cycle down the radiobuttons and see if any radio button was selected
            for (int i = 0; i < 12; i++) {

                if (singleMC[i].isSelected() == true) {
                    //If a radiobutton was selected, make the response legailty to be true
                    responseMade = true;
                }
            }
        } else if (typeQuestion.equals("Multiple Response Multiple Choice")) {
            //Cycle down the check boxes and see if any box was selected
            for (int i = 0; i < 12; i++) {

                if (multipleMC[i].isSelected() == true) {
                    //If a check box was selected, make the response legailty to be true
                    responseMade = true;
                }
            }
        } else {
            //Short Answer

            //If the user input in the answer box is not empty, then a legal response was made
            if (!txtSA.getText().equals("")) {
                responseMade = true;
            }
        }
        //System.out.println(responseMade);
        return responseMade;
    }

    /**
     * When the "Next" button is pressed to move onto the next question
     */
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        //Make another array of radio buttons, check boxes, and labels (the same one) - for clarity
        JRadioButton singleMC[] = {btnChoice1, btnChoice2, btnChoice3, btnChoice4, btnChoice5, btnChoice6, btnChoice7, btnChoice8, btnChoice9, btnChoice10, btnChoice11, btnChoice12};
        JCheckBox multipleMC[] = {chkChoice1, chkChoice2, chkChoice3, chkChoice4, chkChoice5, chkChoice6, chkChoice7, chkChoice8, chkChoice9, chkChoice10, chkChoice11, chkChoice12};
        JLabel choices[] = {lblChoice1, lblChoice2, lblChoice3, lblChoice4, lblChoice5, lblChoice6, lblChoice7, lblChoice8, lblChoice9, lblChoice10, lblChoice11, lblChoice12};

        //Get the question number of the current answer being done
        int questionNumber = Integer.parseInt(lblQuestionNum.getText());

        //Get the question type
        String questionType = survey.getSurveyQuestions().get(questionNumber - 1).getType();

        //See if a legal answer was made before clicking "next"
        boolean responseMade = checkResponseMade(singleMC, multipleMC, questionNumber);

        //If a legal answer was made
        if (responseMade == true) {

            //Based on the question type
            if (questionType.equals("Single Response Multiple Choice")) {

                //For each possible radio button chosen, see if any are chosen
                for (int indexChosen = 0; indexChosen < 12; indexChosen++) {

                    if (singleMC[indexChosen].isSelected() == true) {

                        //Add the chosen index of the button chosen to the response array as a string
                        response[questionNumber - 1] = indexChosen + "";
                    }
                }

            } else if (questionType.equals("Multiple Response Multiple Choice")) {
                
                //Initiliaze a string to contain the added indexes of an answer
                String choiceSelected = "";

                //For each possible check box chosen, see if any are chosen
                for (int i = 0; i < 12; i++) {
                    if (multipleMC[i].isSelected() == true) {
                        //Add the chosen index of the boxes chosen to a string
                        choiceSelected += i + ".";
                    }
                }

                //Add the user's chosen indexes to the array of responses
                response[questionNumber - 1] = choiceSelected;
                
                
            } else {
                //Short answer

                //Add the user's short anwswer question to the array of responses
                response[questionNumber - 1] = txtSA.getText();
            }
            
            //Array list that will contain lines of all answers from one response
            ArrayList<String> fileContain = new ArrayList();
            
            //Create a line of all responses seperated by a comma
            String toWrite = "";
            for (int i = 0; i < response.length; i++) {
                toWrite += (response[i] + ",");
            }

            //If the question number indicates that the survey is not completely filled in, ...
            if (questionNumber < survey.getSurveyQuestions().size()) {
                
                //Move onto the next question to continue filling in the survey
                displayQuestions(singleMC, multipleMC, choices, questionNumber);
                
            } else {
                //Otherwise, the survey is complete
                
                
                //Reads all past responses in response file
                try {
                    //Set the reader to the correct response file
                    FileReader fr = new FileReader("src\\finalproject\\tang\\chen\\" + surveyName + " RESPONSES");
                    BufferedReader br = new BufferedReader(fr);
                    
                    boolean eof = false;
                    
                    //While there are sill lines to be read
                    while (!eof) {
                        
                        //read a line
                        String responseRead = br.readLine();

                        //If the line is empty, the end of the file is reached and the reading can terminate
                        if (responseRead == null) {
                            eof = true;
                            
                        } else {
                            //Otherwise, add the previous response line read to the list of responses
                            fileContain.add(responseRead);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("ERROR " + e);
                }
                
                
                //Re-Writes the file with the new response
                try {
                    //Set the writer to the correct file
                    FileWriter fw = new FileWriter("src\\finalproject\\tang\\chen\\" + surveyName + " RESPONSES");
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    //For all previous responses that existed in the file, write them out again, seperated by a new line
                    for (int i = 0; i < fileContain.size(); i++) {
                        bw.write(fileContain.get(i) + "\n");
                    }
                    
                    //Write out the new response of the survey on the last line to be written
                    bw.write((fileContain.size() + 1) + "," + toWrite);
                    
                    
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(MakeSurvey.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //Reset the content to show the first question
                displayQuestions(singleMC, multipleMC, choices, 0);
                
                //Go back to the Do Survey Menu
                choiceDoSurvey.setVisible(true);
                
                //Hide the response form
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgSingleMC;
    private javax.swing.JRadioButton btnChoice1;
    private javax.swing.JRadioButton btnChoice10;
    private javax.swing.JRadioButton btnChoice11;
    private javax.swing.JRadioButton btnChoice12;
    private javax.swing.JRadioButton btnChoice2;
    private javax.swing.JRadioButton btnChoice3;
    private javax.swing.JRadioButton btnChoice4;
    private javax.swing.JRadioButton btnChoice5;
    private javax.swing.JRadioButton btnChoice6;
    private javax.swing.JRadioButton btnChoice7;
    private javax.swing.JRadioButton btnChoice8;
    private javax.swing.JRadioButton btnChoice9;
    private javax.swing.JButton btnNext;
    private javax.swing.JCheckBox chkChoice1;
    private javax.swing.JCheckBox chkChoice10;
    private javax.swing.JCheckBox chkChoice11;
    private javax.swing.JCheckBox chkChoice12;
    private javax.swing.JCheckBox chkChoice2;
    private javax.swing.JCheckBox chkChoice3;
    private javax.swing.JCheckBox chkChoice4;
    private javax.swing.JCheckBox chkChoice5;
    private javax.swing.JCheckBox chkChoice6;
    private javax.swing.JCheckBox chkChoice7;
    private javax.swing.JCheckBox chkChoice8;
    private javax.swing.JCheckBox chkChoice9;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblQuestionNum;
    private javax.swing.JLabel lblQuestionTitle;
    private javax.swing.JTextField txtSA;
    // End of variables declaration//GEN-END:variables
}
