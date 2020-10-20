package sk.kosickaakademia.hingis.lottery;

import java.util.Scanner;

public class Lottery {

    private final int GUESS_LENGTH = 5;
    private final int DRAW_LENGTH = 10;
    private final int MAX_VALUE = 20;
    private int[] guess = new int[GUESS_LENGTH];
    private int[] draw = new int[DRAW_LENGTH];
    private double bet;
    public int match = 0;

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        lottery.betAmount();
        lottery.inputNumbers();
        lottery.drawNumbers();
        lottery.compareNumbers();
        lottery.printoutCashPrize(lottery.match);

    }
    public double betAmount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How much do you want to bet?");
        System.out.print("Min. bet is 0.5$. Enter here: ");
        bet = sc.nextDouble();
        if (bet < 0.5) {
            do {
                System.out.print("Not enough. Try again: ");
                bet = sc.nextDouble();
            } while (bet < 0.5);
        }
        return bet;
    }
    public void inputNumbers(){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter 5 numbers.");
        while (i < GUESS_LENGTH){
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
        while (i < DRAW_LENGTH){
            int in = (int) (Math.random()*MAX_VALUE+1);
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
        for (int i = 0; i < DRAW_LENGTH; i++){
            for (int j = 0; j < GUESS_LENGTH; j++){
                if (guess[j] == draw[i]) match++;
            }
        }
        System.out.println("You guessed "+match+" numbers right.");
    }
    public void printoutCashPrize(int rightGuessed){
        double cashPrize = switch (rightGuessed){
            case 0, 1 -> bet * 0;
            case 2 -> bet * 2;
            case 3 -> bet * 15;
            case 4 -> bet * 500;
            case 5 -> bet * 10000;
            default -> 0;
        };
        System.out.println("Your cashprize is: "+cashPrize);
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
