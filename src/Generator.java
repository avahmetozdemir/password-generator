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

        String userOption = "-1";

        while (!userOption.equals("4")) {
            userOption = scanner.next();

            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    printMenu();
                }
                case "2" -> {
                    checkPassword();
                    printMenu();
                }
                case "3" -> {
                    printUsefulInfo();
                    printMenu();
                }
                case "4" -> {
                    System.out.println("Closing the program!!!");
                }
                default -> {
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                }
            }
        }

    }


    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Generate a Strong Password");
        System.out.println("Enter 2 - Check Strength of Your Password ");
        System.out.println("Enter 3 - Some Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice:");
    }

    private void requestPassword(){
        boolean IncludeUpper = false;
        boolean IncludeLower  =false;
        boolean IncludeNumber = false;
        boolean IncludeSymbol = false;

        boolean correctParams = false;

        System.out.println("Hello, welcome to the Password Generator. Answer "
                + "the following questions by typing 1 for Yes or 2 for No \n");

        do {
            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
            int input = scanner.nextInt();


            if (input == 1) IncludeLower = true;

            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
            input = scanner.nextInt();

            if (input == 1) {
                IncludeUpper = true;
            }

            System.out.println("Do you want Numbers \"1234...\" to be used? ");
            input = scanner.nextInt();

            if (input == 1) IncludeNumber = true;

            System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
            input = scanner.nextInt();

            if (input == 1) IncludeSymbol = true;

            //No Pool Selected
            if (!IncludeUpper && !IncludeLower && !IncludeNumber && !IncludeSymbol) {
                System.out.println("You have selected no characters to generate your " +
                        "password at least one of your answers should be Yes");
                correctParams = true;
            }



        } while (correctParams);

        System.out.println("Great! Now enter the length of the password");
        int length = scanner.nextInt();

        final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNumber, IncludeSymbol);

        final Password password = generator.GeneratePassword(length);

        System.err.println("Your generated password -> " + password );
    }

    private void checkPassword() {
        String input;
        final Scanner in = new Scanner(System.in);

        System.out.print("\nEnter your password:");
        input = in.nextLine();

        final Password p = new Password(input);

        System.out.println(p.calculateScore());

    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }
}


