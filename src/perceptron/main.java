package perceptron;

/**
 *
 * @author Rafael
 */
public class main {

    public static void main(String[] args) {
        /*
        int input[][] = {{0, 0, 0},
        {0, 0, 1},
        {0, 1, 0},
        {0, 1, 1},
        {1, 0, 0},
        {1, 0, 1},
        {1, 1, 0},
        {1, 1, 1}
        };
        
        int output[] = {0, 0, 0, 0, 0, 0, 0, 1};
        */
        int input[][] = {{0, 0},
        {0, 1},
        {1, 0},
        {1, 1}  };
        
        int output[] = {0, 0, 0, 1};
                
        Perceptron perceptron = new Perceptron(input[0].length);
        perceptron.learn(input, output);
        
        int teste[] = {1,1};
        System.out.println(perceptron.output(teste));
    }
}
