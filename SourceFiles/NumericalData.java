/*
//Tang, Chen
//Jan 17 2019
 * NumericalData class
 */

package finalproject.tang.chen;

import java.util.ArrayList;

public class NumericalData {
    private ArrayList<Integer> numbers;
    
    /**
     * This is the primary constructor of the NumericalData class
     */
    public NumericalData(){
        numbers= null;
    }
    
    /**
     * This is the secondary constructor of the NumericalData class
     *
     * @param numbers - the list of integers as data
     */
    public NumericalData(ArrayList<Integer> numbers) {
        this();
        this.numbers = numbers;
    }

    /**
     * @return the numbers
     */
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    /**
     * @param numbers the numbers to set
     */
    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }
    
    
    /**
     * This method is the equals method of the NumericalData class
     *
     * @param comparedData - the NumericalData question to be compared to
     * @return - true or false if the data contained in the list are the same
     */
    public boolean equals(NumericalData comparedData) {
        boolean same = true;
        //Compares the size of the lists
        //If the sizes are different, the lists are different
        if (numbers.size() == (comparedData.getNumbers()).size()) {
            //In every element of the list, compare to see if they are the same
            for (int i = 0; i < numbers.size(); i++) {
                //If they are different, end check
                if ((numbers.get(i)) != ((comparedData.getNumbers()).get(i))) {
                    i = numbers.size() * 2;
                    same = false;
                }
            }
        } else {
            same = false;
        }
        
        return same;
    }

    /**
     * This method is the clone method of the NumericalData class
     *
     * @return a new NumericalData with the same set of data
     */
    public NumericalData clone() {
        return new NumericalData(numbers);
    }

    /**
     * This is the toString method of the NumericalData class
     *
     * @return the formatted representation of the question
     */
    public String toString() {
        return "Number data: " + printList(numbers) + "\n";
    }
    
    /**
     * This method will print out all the elements in a list
     *
     * @param numbers - the array list of data
     * @return - all elements in list on new line
     */
    public String printList(ArrayList<Integer> numbers) {
        String out = "";
        for (Integer num: numbers) {
            out += num + "\n";
        }
        return out;
    }
}
