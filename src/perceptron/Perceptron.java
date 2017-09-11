package perceptron;

import static javafx.application.Platform.exit;

/**
 *
 * @author Rafael Del Lama
 */
public class Perceptron {
    private double weights[];
    private double bias;
    private int numInput;
    private double learnRate;
    
    public Perceptron(int numInput) {
        this.numInput = numInput;
        weights = new double[numInput + 1];
        bias = -1;
        learnRate = 0.001;
    }
  
    public void learn(int input[][], int output[]) {
        if (input.length != output.length || input[0].length != numInput) {
            System.out.print("Dados de entradas incorretos!");
            exit();
        }
        
        boolean hasError = true;
        while (hasError) {
            hasError = false;
            for (int i = 0; i < output.length; i++) {
                float error = output[i] - sortNetwork(input[i]);
                if (error != 0) {
                    weights[0] += learnRate * bias * error;
                    for (int j = 0; j < numInput; j++) {
                        weights[j+1] += learnRate * input[i][j] * error;
                    }
                    hasError = true;
                }
            }
        }
    }

    public int sortNetwork(int input[]) {
        int n = input.length;
        double sum = bias * weights[0];
        for(int i = 0; i < n; i++)
            sum = sum + input[i] * weights[i+1];
        if(sum > 0)
            return 1;
        return 0;
    }

    public void setBias(double threshold) {
        this.bias = threshold;
    }

    public double[] getWeights() {
        return weights;
    }

    public double getBias() {
        return bias;
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