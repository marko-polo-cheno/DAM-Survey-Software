/*
//Tang, Chen
//Jan 17 2019
 * BarGraph Class
 * This class will create a bar graph based on Multiple MC question responses
 */
package finalproject.tang.chen;
import java.util.Arrays;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BarGraph extends ApplicationFrame {
    
    //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    MultipleMC questionMC = new MultipleMC();
    /**
     * Constructs a bar graph to be displayed
     * @param applicationTitle - the title of the application
     * @param chartTitle - the chart title
     * @param question - the question of the Multiple MC
     */
    public BarGraph(String applicationTitle, String chartTitle, MultipleMC question, int[] userSelectedAnswers) {
        super(applicationTitle);
        
        this.questionMC = question;

        question.setUserSelectedAnswers(userSelectedAnswers);
        
        //Creates the bar chart
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
        
        //Sets size of created panel
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
        
        //Attempt to make it not close the program on close
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    /**
     * Creates a dataset for the graphs
     * @return - the data set
     */
    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        //for all answers in a multiple select choice question, add its data to the data set
        for (int i = 0; i < questionMC.getAnswers().size(); i++) {
            
            //Add number, add criteria
            dataset.addValue(questionMC.getUserSelectedAnswers()[i], questionMC.getAnswers().get(i),"");
        }
        
        return dataset;
    }
}