import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner scanner;
    public Generator(Scanner scanner) {
        this.scanner = scanner;
    }

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSymbol) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSymbol);
    }


    public void mainLoop() {
        System.out.println("-------Welcome to Strong Password Services--------");
        printMenu();


    }


    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Generate a Strong Password");
        System.out.println("Enter 2 - Check Strength of Your Password ");
        System.out.println("Enter 3 - Some Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice:");
    }
}


