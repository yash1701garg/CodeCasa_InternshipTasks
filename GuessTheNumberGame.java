import java.util.*;
class Game{
    public int number;
    public int inputNumber;
    public int noOfGuesses=0;
    public int getNoOfGuesses(){
        return noOfGuesses;
    }
    public void setNoOfGuesses(int noOfGuesses){
        this.noOfGuesses=noOfGuesses;
    }
    Game(){
        Random ran = new Random();
        this.number = ran.nextInt(100);
    }
    public void takeUserInput(){
        System.out.println("Guess the number : ");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }
    public boolean isCorrectNumber(){
        noOfGuesses++;
        if(inputNumber==number){
            System.out.printf("yes your guess is right it was %d number and you guessed in %d attempts",number,noOfGuesses);
            return true;
        } else if (inputNumber<number) {
            System.out.println("Try again it's low number");
        }
        else {
            System.out.println("Try again it's high number");
        }
        return false;
    }
}
public class GuessTheNumberGame {
    public static void main(String[] args) {
        for (int round = 1; round <= 3; round++) {
            System.out.printf("\nRound %d\n",round);
            Game g = new Game();
            boolean b = false;
            while (!b) {
                g.takeUserInput();
                b = g.isCorrectNumber();
            }
        }
    }
}
