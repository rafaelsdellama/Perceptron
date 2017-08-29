package perceptron;

import static javafx.application.Platform.exit;

/**
 *
 * @author Rafael
 */
public class Perceptron {
    private double weights[];
    private double threshold;
    private int numInput;
    private double learnRate;
    
    public Perceptron(int numInput) {
        this.numInput = numInput;
        weights = new double[numInput];
        threshold = -1;
        learnRate = 0.5;
    }
    
    public void training(int input[][], int output[]){
        if(input.length != output.length || input[0].length != numInput){
            System.out.print("Dados de entradas incorretos!");
            exit();
        }
        for(int i = 0; i < output.length; i++){   
            float error = output[i] - output(input[i]);
            if(error != 0)
                for(int j = 0; j < input[0].length; j++)
                weights[j] += learnRate * input[i][j] * error;
        }                
    }
    
    public int output(int input[]) {
        int n = input.length;
        double sum = threshold;
        for(int i = 0; i < n; i++)
            sum = sum + input[i] * weights[i];
        if(sum > 0)
            return 1;
        return 0;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double[] getWeights() {
        return weights;
    }

    public double getThreshold() {
        return threshold;
    }
    
    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public double getLearnRate() {
        return learnRate;
    }

    public void setLearnRate(double learnRate) {
        this.learnRate = learnRate;
    } 
}