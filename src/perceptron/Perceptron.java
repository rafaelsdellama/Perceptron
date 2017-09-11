package perceptron;

import static javafx.application.Platform.exit;

/**
 *
 * @author Rafael Del Lama
 */
public class Perceptron {
    private double weights[][];
    private double bias;
    private int numInput;
    private int numOutput;
    private double learnRate;
    
    public Perceptron(int numInput, int numOutput) {
        this.numInput = numInput;
        this.numOutput = numOutput;
        weights = new double[numInput + 1][numOutput];
        bias = -1;
        learnRate = 0.001;
    }
  
    public void learn(int input[][], int output[][]) {
        if (input.length != output.length || input[0].length != numInput) {
            System.out.print("Dados de entradas incorretos!");
            exit();
        }

        boolean hasError = true;
        while (hasError) {
            hasError = false;
            for (int i = 0; i < output.length; i++) {
                int outNetwork [] = sortNetwork(input[i]);
                for (int k = 0; k < output[0].length; k++) {
                    int error = output[i][k] - outNetwork[k];
                    if (error != 0) {
                        weights[0][k] += learnRate * bias * error;
                        for (int j = 0; j < numInput; j++) {
                            weights[j + 1][k] += learnRate * input[i][j] * error;
                        }
                        hasError = true;
                    }
                }
            }
        }
    }

    public int[] sortNetwork(int input[]) {
        int outNetwork[] = new int[numOutput];
        int n = input.length;
        for (int k = 0; k < numOutput; k++) {
            double sum = bias * weights[0][k];
            for (int i = 0; i < n; i++) {
                sum = sum + input[i] * weights[i + 1][k];
            }
            if (sum > 0) 
                outNetwork[k] = 1;
            else
                outNetwork[k] = 0;
        }
        return outNetwork;
    }

    public void setBias(double threshold) {
        this.bias = threshold;
    }

    public double[][] getWeights() {
        return weights;
    }

    public double getBias() {
        return bias;
    }
    
    public void setWeights(double[][] weights) {
        this.weights = weights;
    }

    public double getLearnRate() {
        return learnRate;
    }

    public void setLearnRate(double learnRate) {
        this.learnRate = learnRate;
    }

    public int getNumInput() {
        return numInput;
    }

    public int getNumOutput() {
        return numOutput;
    }
    
}