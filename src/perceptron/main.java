package perceptron;

/**
 *
 * @author Rafael
 */
public class main {

    public static void main(String[] args) {
        /*  OR */
        int input[][] = {{0, 0},
        {0, 1},
        {1, 0},
        {1, 1}  };
        
        int output[] = {0, 1, 1, 1};
                
        Perceptron perceptron = new Perceptron(input[0].length);
        perceptron.learn(input, output);
        
        int teste[] = {0,0};
        System.out.println(perceptron.sortNetwork(teste));
        

        /*  AND
        int input[][] = {{0, 0},
        {0, 1},
        {1, 0},
        {1, 1}  };
        
        int output[] = {0, 0, 0, 1};
                
        Perceptron perceptron = new Perceptron(input[0].length);
        perceptron.learn(input, output);
        
        int teste[] = {1,1};
        System.out.println(perceptron.sortNetwork(teste));
        */
        
        double w[] = perceptron.getWeights();
        for(int i = 0; i < w.length; i++)
            System.out.print(w[i] +  " ");
    }
}
