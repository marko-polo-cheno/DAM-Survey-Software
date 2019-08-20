/*
//Tang, Chen
//Jan 17 2019
 * Survey Class
 * A survey will contain a set of questions
 */
package finalproject.tang.chen;

import java.util.ArrayList;

public class Survey {

    private ArrayList<Question> surveyQuestions;

    /**
     * This is the primary constructor of the Survey class
     */
    public Survey() {
        surveyQuestions = new ArrayList();
    }

    /**
     * This is the secondary constructor of the Survey Class
     *
     * @param surveyQuestions - The array list of questions contained in a
     * survey
     */
    public Survey(ArrayList<Question> surveyQuestions) {
        this();
        this.surveyQuestions = surveyQuestions;
    }

    /**
     * This method is the equals method of the Survey class
     *
     * @param comparedSurvey - the Survey question to be compared to
     * @return - true or false if the string contained in the question is the
     * same
     */
    public boolean equals(Survey comparedSurvey) {
        return this.getSurveyQuestions().containsAll(comparedSurvey.getSurveyQuestions())
                && comparedSurvey.getSurveyQuestions().containsAll(this.getSurveyQuestions());
    }

    /**
     * This method is the clone method of the Survey class
     *
     * @return a new Survey with the same question
     */
    public Survey clone() {
        return new Survey(getSurveyQuestions());
    }

    /**
     * This is the toString method of the Survey class
     *
     * @return the formatted representation of the question
     */
    public String toString() {
        return "Survey: " + printList(surveyQuestions) + "\n";
    }

    /**
     * This method will print out all the elements in a list
     *
     * @param answers - the array list of answers
     * @return - all elements in list on new line
     */
    public String printList(ArrayList<Question> answers) {
        String out = "";
        for (Question question : answers) {
            out += question + "\n";
        }
        return out;
    }

    /**
     * @return the surveyQuestions
     */
    public ArrayList<Question> getSurveyQuestions() {
        return surveyQuestions;
    }

    /**
     * @param surveyQuestions the surveyQuestions to set
     */
    public void setSurveyQuestions(ArrayList<Question> surveyQuestions) {
        this.surveyQuestions = surveyQuestions;
    }
}
