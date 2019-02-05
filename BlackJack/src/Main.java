import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int loop = 1; // variable needed to avoid chunk of code if player already won or lost before dealer gets a card
        int game = 1; // keeps track of number of games
        int win = 0; // keeps track of number of wins
        int lose = 0; // keeps track of number of loses
        int value; // keeps track of hand value
            boolean outer = true;
// "outer" while loop is used to loop through the whole game
            while (outer) {
                System.out.println("START GAME #" + game);
                value = 0;
                boolean newCard = true;
// "newCard" while loop is used to loop through each new card
                while (newCard) {
                    int card = 1 + (int) (Math.random() * 13); //generates random number between 1 - 13
                    int cardvalue = 0;
                    String cardString = new String();  // string assigns the corresponding card name to each value
                    switch (card) { //assigns gard depending on random number generated
                        case 1:
                            cardvalue = 1;
                            cardString = "an ACE!";
                            break;
                        case 2:
                            cardvalue = 2;
                            cardString = "a 2!";
                            break;
                        case 3:
                            cardvalue = 3;
                            cardString = "a 3!";
                            break;
                        case 4:
                            cardvalue = 4;
                            cardString = "a 4!";
                            break;
                        case 5:
                            cardvalue = 5;
                            cardString = "a 5!";
                            break;
                        case 6:
                            cardvalue = 6;
                            cardString = "a 6!";
                            break;
                        case 7:
                            cardvalue = 7;
                            cardString = "a 7!";
                            break;
                        case 8:
                            cardvalue = 8;
                            cardString = "an 8!";
                            break;
                        case 9:
                            cardvalue = 9;
                            cardString = "a 9!";
                            break;
                        case 10:
                            cardvalue = 10;
                            cardString = "a 10!";
                            break;
                        case 11:
                            cardvalue = 10;
                            cardString = "a JACK!";
                            break;
                        case 12:
                            cardvalue = 10;
                            cardString = "a QUEEN!";
                            break;
                        case 13:
                            cardvalue = 10;
                            cardString = "a KING!";
                            break;
                    }
                    value = value + cardvalue; //combines all cards in hand into one value
                    System.out.println("\nYour Card is " + cardString);
                    System.out.println("Your hand is: " + value + "\n");
                    boolean menu = true;
                    loop = 1;
                    if (value == 21) { //used to win on the spot and exit the loop
                        System.out.println("BLACKJACK! You win!\n");
                        loop=0;
                        game++;
                        win++;
                        break;
                    }
                    if (value > 21) { //used to lose the game and exit the loop
                        System.out.println("You exceeded 21! You lose :(\n");
                        loop=0;
                        game++;
                        lose++;
                        break;
                    }
                    // "menu" while loop is used to loop through each selection in the menu
                    while (menu) {
                        System.out.println("1. Get another card");
                        System.out.println("2. Hold hand");
                        System.out.println("3. Print statistics");
                        System.out.println("4. Exit\n");
                        System.out.print("Choose an option: ");

                        // "error" while loop is used to try and catch the menu input
                        int input = 0;
                        boolean error = true;
                        while (error) {
                            try {
                                input = scnr.nextInt();
                                error = false;
                                if (input<1||input>4){ // used in case input is caught but not appropriate
                                    System.out.println("\nInvalid input!\nPlease enter an integer value between 1 and 4\n");
                                    System.out.println("1. Get another card");
                                    System.out.println("2. Hold hand");
                                    System.out.println("3. Print Statistics");
                                    System.out.println("4. Exit\n");
                                    System.out.print("Choose an option: ");
                                    error = true;
                                }
                            } catch (InputMismatchException Error) {
                                System.out.println("\nInvalid input!\nPlease enter an integer value between 1 and 4\n");
                                System.out.println("1. Get another card");
                                System.out.println("2. Hold hand");
                                System.out.println("3. Print Statistics");
                                System.out.println("4. Exit\n");
                                System.out.print("Choose an option: ");
                                scnr.nextLine();
                            }
                        }
                        switch (input) { //displays the options of the menu
                            case 1:
                                menu = false;
                                break;
                            case 2:
                                menu = false;
                                newCard = false;
                                break;
                            case 3:
                                System.out.println("\nNumber of Player wins: " + win);
                                System.out.println("Number of Dealer wins: " + lose);
                                System.out.println("Number of tie games: " + (game - win - lose - 1));
                                System.out.println("Total # of games played is: "+(game - 1));
                                //if statement used to avoid dividing by zero if user checks stats on the first game
                                if (game==1){
                                    System.out.println("Percentage of Player wins: " + (win * 100 /1)+"%\n");
                                }else{
                                    System.out.println("Percentage of Player wins: " + (win * 100 / (game-1))+"%\n");
                                }
                                break;
                            case 4:
                                return;
                        }
                    }
                }
                //variable "loop" used to skip this set of instructions if player exceeds 21 or gets a blackjack
            if (loop!=0) {
                int dealer = 16 + (int) (Math.random() * 11);
                System.out.println("\nDealers hand is: " + dealer);
                System.out.println("Your hand is: " + value);
                game++;
                if (dealer == value) {
                    System.out.println("\nIt's a tie! No one wins!\n");
                } else if (dealer > 21 || dealer < value) {
                    System.out.println("\nYou win!\n");
                    win++;
                } else {
                    System.out.println("\nDealer wins!\n");
                    lose++;
                }
            }
        }
    }
}