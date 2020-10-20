package sk.kosickaakademia.hingis.lottery;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Lottery {
    private int[] guess = new int[5];
    private int[] draw = new int[10];
    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        lottery.inputNumbers();
        lottery.drawNumbers();
        lottery.compareNumbers();

    }
    public void inputNumbers(){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter 5 numbers.");
        while (i < guess.length){
            System.out.print((i+1)+". : ");
            int in = sc.nextInt();
            if (in > 0 && in <= 20 && checkGuessArray(i, in)){
                guess[i] = in;
                i++;
            }
            else System.out.println("Wrong input, try again: ");
        }
        System.out.print("Your guessed numbers are: ");
        for (i=0; i<5; i++){
            System.out.print(guess[i]+" ");
        }
        System.out.println();
    }
    public void drawNumbers(){
        int i = 0;
        while (i < draw.length){
            int in = (int) (Math.random()*20+1);
            if (checkDrawArray(i, in)){
                draw[i] = in;
                i++;
            }
        }
        System.out.print("Drawn numbers are: ");
        for (i = 0; i < 10; i++){
            System.out.print(draw[i]+" ");
        }
        System.out.println();
    }
    public void compareNumbers(){
        int match = 0;
        for (int i = 0; i < draw.length; i++){
            for (int j = 0; j < guess.length; j++){
                if (guess[j] == draw[i]) match++;
            }
        }
        System.out.println("You guessed "+match+" numbers right.");
    }
    public boolean checkGuessArray(int i, int in){
        if (i == 0)
            return true;
        for (int j = 0; j < i; j++){
            if (guess[j] == in)
                return false;
        }
        return true;
    }
    public boolean checkDrawArray(int i, int in){
        if (i == 0)
            return true;
        for (int j = 0; j < i; j++){
            if (draw[j] == in)
                return false;
        }
        return true;
    }
}
