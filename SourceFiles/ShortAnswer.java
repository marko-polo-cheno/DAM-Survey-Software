/*
//Tang, Chen
//Jan 17 2019
 * ShortAnswer class
 * This is a type of question that allows users to enter a open ended response
 */
package finalproject.tang.chen;

public class ShortAnswer extends Question {

    private String question;
    private String answer;

    /**
     * This is the primary constructor of the ShortAnswer class
     */
    public ShortAnswer() {
        question = "";
        answer = "";
    }

    /**
     * This is the secondary constructor of the ShortAnswer class
     *
     * @param question - the question to be set
     */
    public ShortAnswer(String question) {
        this();
        this.question = question;
    }

    /**
     * This is the tertiary constructor of the ShortAnswer class
     *
     * @param question - the question to be set
     * @param answer - the user`s inputted answer to the question
     */
    public ShortAnswer(String question, String answer) {
        this(question);
        this.answer = answer;
    }

    /**
     * This method is the equals method of the ShortAnswer class
     *
     * @param comparedQuestion - the ShortAnswer question to be compared to
     * @return - true or false if the string contained in the question is the
     * same
     */
    public boolean equals(ShortAnswer comparedQuestion) {
        return this.getQuestion().equals(comparedQuestion.getQuestion());
    }

    /**
     * This method is the clone method of the ShortAnswer class
     *
     * @return a new ShortAnswer with the same question
     */
    public ShortAnswer clone() {
        return new ShortAnswer(getQuestion());
    }

    /**
     * This is the toString method of the ShortAnswer class
     *
     * @return the formatted representation of the question
     */
    public String toString() {
        return "Question: " + getQuestion() + "\n";
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
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
