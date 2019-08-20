/*
//Tang, Chen
//Jan 17 2019
 * Multiple MC Class
 * This is a question that is simliar to a SingleMC, 
 * but a MultipleMC allows users to choose more than one answer.
 */
package finalproject.tang.chen;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mache9294
 */
public class MultipleMC extends Question {

    private String question;
    private int[] userSelectedAnswers;
    private ArrayList<String> answers;
    private int[] collectionOfAnswers = new int[12];

    /**
     * This is the primary constructor of the MultipleMC class
     */
    public MultipleMC() {
        question = "";
        userSelectedAnswers = new int[12];
        answers = new ArrayList();
    }

    /**
     * This is the secondary constructor of the MultipleMC class
     *
     * @param question - the question of this multiple choice question
     * @param answers - the list of answers available to be selected by the user
     */
    public MultipleMC(String question, ArrayList<String> answers) {
        this();
        this.question = question;
        this.answers = answers;
        collectionOfAnswers = new int[answers.size()];
    }

    /**
     * This is the tertiary constructor of the MultipleMC class
     *
     * @param question - the question of this multiple choice question
     * @param answers - the list of answers available to be selected by the user
     * @param userSelectedAnswers - the indexes of the choice of the user in the
     * list, stored in a list
     */
    public MultipleMC(String question, ArrayList<String> answers, int[] userSelectedAnswers) {
        this(question, answers);
        this.userSelectedAnswers = userSelectedAnswers;
        addAnswerToCollection(userSelectedAnswers);
    }
    
    /**
     * This method will add the selected answer to an array of responses
     *
     * @param userSelectedAnswers - the list of indexes of the user's selected answers
     */
    public void addAnswerToCollection(int[] userSelectedAnswers) {
        int userSelected;
        
        for (int i = 0; i < userSelectedAnswers.length; i++) {
            userSelected = userSelectedAnswers[i];
            
            collectionOfAnswers[userSelected] += 1;

        }
    }

    /**
     * This method is the equals method of the MultipleMC class
     *
     * @param comparedQuestion - the MultipleMC to be compared to
     * @return - true or false if the string and answers contained in the
     * MultipleMC is the same
     */
    public boolean equals(MultipleMC comparedQuestion) {
        return this.getQuestion().equals(comparedQuestion.getQuestion())
                && this.getAnswers().containsAll(comparedQuestion.getAnswers())
                && comparedQuestion.getAnswers().containsAll(this.getAnswers());
    }

    /**
     * This is the clone method for a MultipleMC question
     *
     * @return a new MultipleMC question with the same question and answer
     * selections
     */
    public MultipleMC clone() {
        return new MultipleMC(getQuestion(), getAnswers());
    }

    /**
     * This is the toString method of the MultipleMC class
     *
     * @return the formatted representation of the MultipleMC
     */
    public String toString() {
        String out = "";
        out += "Question: " + getQuestion() + "\n";
        out += "Answers: " + printList(getAnswers()) + "\n";
        return out;
    }

    /**
     * This method will print out all the elements in a list
     *
     * @param answers - the array list of selectable choices of a single MC
     * question
     * @return - all elements in list on new line
     */
    public String printList(ArrayList<String> answers) {
        String out = "";
        for (String str : answers) {
            out += str + "\n";
        }
        return out;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }


    /**
     * @return the answers
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    /**
     * @return the collectionOfAnswers
     */
    public int[] getCollectionOfAnswers() {
        return collectionOfAnswers;
    }

    /**
     * @param collectionOfAnswers the collectionOfAnswers to set
     */
    public void setCollectionOfAnswers(int[] collectionOfAnswers) {
        this.collectionOfAnswers = collectionOfAnswers;
    }

    /**
     * @return the userSelectedAnswers
     */
    public int[] getUserSelectedAnswers() {
        return userSelectedAnswers;
    }

    /**
     * @param userSelectedAnswers the userSelectedAnswers to set
     */
    public void setUserSelectedAnswers(int[] userSelectedAnswers) {
//        addAnswerToCollection(userSelectedAnswers);
//        System.out.print(Arrays.toString(userSelectedAnswers));
//        System.out.println();
        this.userSelectedAnswers = userSelectedAnswers;
    }
}
