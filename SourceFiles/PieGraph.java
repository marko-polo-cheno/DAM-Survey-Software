/*
//Tang, Chen
//Jan 17 2019
 * PieGraph class
 * This class will create a 3D Pie chart based on Single MC question responses
 */
package finalproject.tang.chen;

import java.text.AttributedString;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.util.Rotation;

/**
 * A pie chart with a custom label generator.
 */
public class PieGraph extends ApplicationFrame {

    SingleMC questionMC = new SingleMC();

    /**
     * Creates a new 3D pie chart.
     *
     * @param title the frame title.
     * @param questionMC the single multiple choice question to be displayed in
     * graphical form
     */
    public PieGraph(String title, SingleMC questionMC) {
        super(title);

        this.questionMC = questionMC;
        
        //Create the data set
        PieDataset dataset = createDataset();
        
        //Pass the dataset to create the pie graph
        JFreeChart chart = createChart(dataset);
        
        //Display the 
        ChartPanel chartPanel = new ChartPanel(chart);
        
        //Changed close operation to only dispose of this frame
        //Attempt to make it not close the program on close
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Creates the dataset for the demo.
     *
     * @return The dataset to be used to graph the pie chart.
     */
    private PieDataset createDataset() {
        //The number of possible answers this Single MC has
        int fields = (questionMC.getAnswers()).size();

        String category;
        int categoryVal;

        int totalAnswers = getTotalAnswerNum(questionMC.getCollectionOfAnswers());

        DefaultPieDataset result = new DefaultPieDataset();

        //For every field in the Single MC
        for (int i = 0; i < fields; i++) {
            //Get the selectable answer
            category = questionMC.getAnswers().get(i);
            
            //Get the number of responses that chose that selectable answer
            categoryVal = (questionMC.getCollectionOfAnswers())[i];
            
            //If the value is not zero, add that value to the dataset
            if (categoryVal != 0) {
                //Add answer name and percent of that answer chosen compared to total number of responses
                result.setValue(category, new Double((double) categoryVal / (double) totalAnswers * 100.0));
            }

        }

        return result;

    }

    /**
     * This method will take in an array of integers and return the summation of
     * the elements in the array
     *
     * @param collectionOfAnswers - the array of numbers to be summed
     * @return - the value of the total sum of elements
     */
    public int getTotalAnswerNum(int[] collectionOfAnswers) {
        int total = 0;

        //For each element in the array, add the value containted to the counter
        for (int indexValue : collectionOfAnswers) {
            total += indexValue;
        }

        return total;
    }

    /**
     * Creates the chart.
     *
     * @param dataset the dataset.
     * @return The chart displaying information of the Single MC.
     */
    private JFreeChart createChart(PieDataset dataset) {
        //Creates the chart
        JFreeChart chartMake = ChartFactory.createPieChart3D(
                questionMC.getQuestion(), // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );

        //Displays the chart and formats it
        PiePlot3D plot = (PiePlot3D) chartMake.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);

        //If no chart appears, display no data underneath
        plot.setNoDataMessage("No data to display");

        //Create labels of the answers of the SingleMC
        plot.setLabelGenerator(new CustomLabelGenerator());

        return chartMake;

    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public JPanel createDemoPanel() {
        JFreeChart chartPrint = createChart(createDataset());
        return new ChartPanel(chartPrint);
    }

    /**
     * A custom label generator (returns null for one item as a test).
     */
    static class CustomLabelGenerator implements PieSectionLabelGenerator {

        /**
         * Generates a label for a pie section.
         *
         * @param dataset the dataset (<code>null</code> not permitted).
         * @param key the section key (<code>null</code> not permitted).
         *
         * @return the label (possibly <code>null</code>).
         */
        public String generateSectionLabel(PieDataset dataset, Comparable key) {
            String result = null;
            if (dataset != null) {
                if (!key.equals("X")) {
                    result = key.toString();
                }
            }
            return result;
        }

        /**
         * Not used.
         *
         * @param dataset the dataset.
         * @param key the key.
         *
         * @return null.
         */
        public AttributedString generateAttributedSectionLabel(PieDataset dataset, Comparable key) {
            return null;
        }

    }

}
