package perceptron;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class main {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        /*  OR, NOR, AND, NAND */
        int input[][] = {{0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}};
       
        int output[][] = {{0,1,0, 1, 1}, {1,0,0, 1, 1}, {1,0,0, 1, 0}, {1,0,0, 1, 0}, {1,0,0, 1, 1}, {1,0,0, 1, 1}, {1,0,0, 1, 0}, {1, 0, 1, 0, 0}};
                
        Perceptron perceptron = new Perceptron(input[0].length, output[0].length);
        perceptron.learn(input, output);
        
        int teste[] = new int[input[0].length];
        int out[] = new int[output[0].length];
        
        while (true) {          
            System.out.println("Digite o conjunto de entradas que deseja classificar:");
            for (int i = 0; i < input[0].length; i++) {
                teste[i] = in.nextInt();
            }

            out = perceptron.sortNetwork(teste);

            System.out.println("Saída:");
            System.out.println("OR: " + out[0]);
            System.out.println("NOR: " + out[1]);
            System.out.println("AND: " + out[2]);
            System.out.println("NAND: " + out[3]);
            System.out.print("Entrada do meio é 0: ");
            if(out[4] == 0)
                System.out.println("não");
            else
                System.out.println("sim");
            System.out.println();
        }
    }// main
}// class main
