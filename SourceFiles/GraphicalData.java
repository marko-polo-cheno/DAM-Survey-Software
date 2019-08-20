/*
//Tang, Chen
//Jan 17 2019
 * GraphicalData class
 */

package finalproject.tang.chen;

abstract public class GraphicalData {
    private String typeOfGraph;

    /**
     * This is the primary constructor of the GraphicalData class
     */
    public GraphicalData() {
        typeOfGraph = "";
    }

    /**
     * This is the secondary constructor of the GraphicalData class
     *
     * @param typeOfGraph - the typeOfGraph to be set
     */
    public GraphicalData(String typeOfGraph) {
        this();
        this.typeOfGraph = typeOfGraph;
    }


    /**
     * This method is the equals method of the GraphicalData class
     *
     * @param comparedData - the GraphicalData typeOfGraph to be compared to
     * @return - true or false if the type Of Graph are the same
     */
    public boolean equals(GraphicalData comparedData) {
        return this.getTypeOfGraph().equals(comparedData.getTypeOfGraph());
    }

    /**
     * This is the toString method of the GraphicalData class
     *
     * @return the formatted representation of the typeOfGraph
     */
    public String toString() {
        return "Graph Type: " + getTypeOfGraph() + "\n";
    }

    /**
     * @return the typeOfgraph
     */
    public String getTypeOfGraph() {
        return typeOfGraph;
    }

    /**
     * @param typeOfgraph the typeOfgraph to set
     */
    public void setTypeOfgraph(String typeOfgraph) {
        this.typeOfGraph = typeOfgraph;
    }
}
