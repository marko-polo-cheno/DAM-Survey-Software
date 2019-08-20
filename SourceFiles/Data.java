/*
//Tang, Chen
//Jan 17 2019
 * Data class
 */

package finalproject.tang.chen;

import java.util.ArrayList;

public class Data {
    private ArrayList<String> propertyNames;
    private NumericalData numericalData;
    private GraphicalData graphicalData;
    
    private ArrayList<String> modeOfEachProperty;
    private ArrayList<String> leastCommonOfEachProperty;
    
    /**
     * This is the primary constructor of the Data class
     */
    public Data(){
        graphicalData = null;
        numericalData  = null;
        propertyNames  = null;
        modeOfEachProperty = null;
        leastCommonOfEachProperty = null;
    }
    
    /**
     * This is the 2nd constructor of the Data class
     * @param propertyNames the list of names of the properties a data set has
     */
    public Data(ArrayList<String> propertyNames){
        this();
        this.propertyNames = propertyNames;
    }
    
    /**
     * This is the 3rd constructor of the Data class
     * @param propertyNames the list of names of the properties a data set has
     * @param numericalData the list of data relating to the property
     */
    public Data(ArrayList<String> propertyNames, NumericalData numericalData){
        this(propertyNames);
        this.numericalData = numericalData;
    }
    
    /**
     * This is the 4th constructor of the Data class
     * @param propertyNames the list of names of the properties a data set has
     * @param numericalData the list of data relating to the property
     * @param graphicalData the type of graph created
     */
    public Data(ArrayList<String> propertyNames, NumericalData numericalData, GraphicalData graphicalData){
        this(propertyNames, numericalData);
        this.graphicalData = graphicalData;
    }
    
    
    /**
     * This method is the equals method of the Data class
     *
     * @param comparedData - the Data question to be compared to
     * @return - true or false if the attribute in the Data are the same
     */
    public boolean equals(Data comparedData) {
        return this.propertyNames.containsAll(comparedData.getPropertyNames())
                && comparedData.getPropertyNames().containsAll(this.propertyNames)
                && numericalData.equals(comparedData.getNumericalData())
                && graphicalData.equals(comparedData.getGraphicalData());
    }

    /**
     * This method is the clone method of the Data class
     * @return a new Data with the same basic attributes
     */
    public Data clone() {
        return new Data(propertyNames, numericalData, graphicalData);
    }

    /**
     * This is the toString method of the Data class
     *
     * @return the formatted representation of the question
     */
    public String toString() {
        return  "Data: " + printList(propertyNames) + "\n" + 
                numericalData + "\n"+
                graphicalData;
    }

    
    /**
     * This method will print out all the elements in a list
     * @param list - the list of property names
     * @return - the properties in a string format
     */
    public String printList(ArrayList<String> list){
        String out = "";
        for (String str: list) {
            out+= str + "\n";
        }
        return out;
    }
    
    
    /**
     * @return the propertyNames
     */
    public ArrayList<String> getPropertyNames() {
        return propertyNames;
    }

    /**
     * @param propertyNames the propertyNames to set
     */
    public void setPropertyNames(ArrayList<String> propertyNames) {
        this.propertyNames = propertyNames;
    }

    /**
     * @return the numericalData
     */
    public NumericalData getNumericalData() {
        return numericalData;
    }

    /**
     * @param numericalData the numericalData to set
     */
    public void setNumericalData(NumericalData numericalData) {
        this.numericalData = numericalData;
    }

    /**
     * @return the graphicalData
     */
    public GraphicalData getGraphicalData() {
        return graphicalData;
    }

    /**
     * @param graphicalData the graphicalData to set
     */
    public void setGraphicalData(GraphicalData graphicalData) {
        this.graphicalData = graphicalData;
    }

    /**
     * @return the modeOfEachProperty
     */
    public ArrayList<String> getModeOfEachProperty() {
        return modeOfEachProperty;
    }

    /**
     * @param modeOfEachProperty the modeOfEachProperty to set
     */
    public void setModeOfEachProperty(ArrayList<String> modeOfEachProperty) {
        this.modeOfEachProperty = modeOfEachProperty;
    }

    /**
     * @return the leastCommonOfEachProperty
     */
    public ArrayList<String> getLeastCommonOfEachProperty() {
        return leastCommonOfEachProperty;
    }

    /**
     * @param leastCommonOfEachProperty the leastCommonOfEachProperty to set
     */
    public void setLeastCommonOfEachProperty(ArrayList<String> leastCommonOfEachProperty) {
        this.leastCommonOfEachProperty = leastCommonOfEachProperty;
    }
}
