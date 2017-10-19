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
    
    /**
     * Construtor
     * @param numInput número de entradas do Perceptron
     * @param numOutput número de saídas
     */
    public Perceptron(int numInput, int numOutput) {
        this.numInput = numInput;
        this.numOutput = numOutput;
        weights = new double[numInput + 1][numOutput]; //numInput + 1 = peso do bias + pesos entradas
        bias = -1;
        learnRate = 0.001;
    }//Perceptron
  
    /**
     * Função responsável pelo processo de aprendizagem.
     * @param input são as entradas para o processo de aprendizagem supervisionado
     * @param output são as saídas correspondentes
     */
    public void learn(int input[][], int output[][]) {
        if (input.length != output.length || input[0].length != numInput) {
            System.out.print("Dados de entradas incorretos!");
            exit();
        }

        boolean hasError = true;
        //O ajuste dos pesos ocorre até que não haja erro para classificar nenhum caso de entrada
        while (hasError) {
            hasError = false;
            for (int i = 0; i < output.length; i++) {       // Para todas os casos de teste
                int outNetwork [] = sortNetwork(input[i]);  //Gera a saída da rede 
                for (int k = 0; k < output[0].length; k++) { //Para cada saída
                    int error = output[i][k] - outNetwork[k]; //Calcula o erro
                    if (error != 0) { //Se houver erro, ajusta os pesos
                        weights[0][k] += learnRate * bias * error;
                        for (int j = 0; j < numInput; j++) {
                            weights[j + 1][k] += learnRate * input[i][j] * error;
                        }
                        hasError = true;
                    }
                }
            }
        }//while
    }//learn

    /**
     * 
     * @param input são as entradas da rede
     * @return a saída da rede (classificação)
     */
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
    }//sortNetwork

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
}//class 