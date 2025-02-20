import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Card {
    String symbol; 
    String rank;   


    public Card(String symbol, String rank) {
        this.symbol = symbol;
        this.rank = rank;
    }

    public void display() {
        System.out.println(rank + " of " + symbol);
    }

    public String getSymbol() {
        return symbol;
    }
}

public class CardCollectionSystem {

    private static Collection<Card> cardCollection = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addCard() {
        System.out.print("Enter card symbol (Hearts, Diamonds, Clubs, Spades): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter card rank (2, 3, 4, ..., 10, Jack, Queen, King, Ace): ");
        String rank = scanner.nextLine();

        Card card = new Card(symbol, rank);
        cardCollection.add(card);
        System.out.println("Card added successfully.");
    }

    public static void findCardsBySymbol() {
        System.out.print("Enter the symbol you want to search for (Hearts, Diamonds, Clubs, Spades): ");
        String searchSymbol = scanner.nextLine();

        boolean found = false;
        for (Card card : cardCollection) {
            if (card.getSymbol().equalsIgnoreCase(searchSymbol)) {
                card.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No cards found with the symbol: " + searchSymbol);
        }
    }

    public static void displayAllCards() {
        if (cardCollection.isEmpty()) {
            System.out.println("No cards in the collection.");
        } else {
            for (Card card : cardCollection) {
                card.display();
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    findCardsBySymbol();
                    break;
                case 3:
                    displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
