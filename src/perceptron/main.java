package perceptron;

/**
 *
 * @author Rafael
 */
public class main {

    public static void main(String[] args) {
        /*  OR, NOR, AND */
        int input[][] = {{0, 0},
        {0, 1},
        {1, 0},
        {1, 1} };
        
        int output[][] = {{0,1,0}, {1,0,0}, {1,0,0}, {1,0,1}};
                
        Perceptron perceptron = new Perceptron(input[0].length, output[0].length);
        perceptron.learn(input, output);
        
        int teste[] = {1,1};
        int out[] = perceptron.sortNetwork(teste);
        for(int i = 0; i < out.length; i++)
            System.out.print(out[i] + " ");
        System.out.println();

    }
}
