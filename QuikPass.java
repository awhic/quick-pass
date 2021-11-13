import java.util.Random;
import java.util.Scanner;

public class QuikPass {

    public static void main(String[] args) throws Exception {

        int length = setLength();
        String specialChars;

        try {
            specialChars = setSpecChar();
        } catch (Exception e) {

            specialChars = "!@#$%^&*.";
            System.out.println((char)27 + "[33m" + "Input Invalid. Defaulting to include special characters...");
            Thread.sleep(3250L);
        }
        
        clearScreen();
        Thread.sleep(500L);
        String output = generatePass(length, specialChars).toString();

        System.out.println("");
        System.out.println((char)27 + "[37m" + output);
    }

    private static int setLength() {

        String askLength = "Password Length: ";
        String warnLength = "Invalid password length. Please enter a valid two-digit number.";

        Scanner lengthInq = new Scanner(System.in);
        int length;

        // Validate length input
        do {
            System.out.println((char)27 + "[37m" + askLength);
            while (!lengthInq.hasNextInt()) {
                System.out.println((char)27 + "[31m" + warnLength);
                System.out.println((char)27 + "[37m" + askLength);
                lengthInq.next();
            }
            length = lengthInq.nextInt();

            if (length <= 0 && length > 100) {
                System.out.println((char)27 + "[31m" + warnLength);
            }
        } while (length <= 0 && length >= 100);

        return length;
    }

    private static String setSpecChar() throws Exception {

        Scanner specCharInq = new Scanner(System.in);
        String specCharValue;
        String specChar;

        System.out.println("Do you want to include special characters? (y/n):");
        specCharValue = specCharInq.nextLine();

        if (specCharValue.equals("Y") || specCharValue.equals("y")) {
            specChar = "!@#$%^&*.";
        } else if (specCharValue.equals("N") || specCharValue.equals("n")) {
            specChar = "";
        } else {
            specChar = "";
            throw new Exception("Invalid Input");
        }
        return specChar;
    }

    private static char[] generatePass(int length, String specialCharacters) {

        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String specialChars = specialCharacters;
        String numbers = "1234567890";

        String allTypesConcat = upperCase + lowerCase + specialChars + numbers;

        Random rand = new Random();
        char[] password = new char[length];

        password[0] = upperCase.charAt(rand.nextInt(upperCase.length()));
        password[1] = lowerCase.charAt(rand.nextInt(lowerCase.length()));
        if (!specialCharacters.equals("")) {
            password[2] = specialChars.charAt(rand.nextInt(specialChars.length()));
        }
        password[3] = numbers.charAt(rand.nextInt(numbers.length()));

        for(int i = 4; i < length; i++) {
            password[i] = allTypesConcat.charAt(rand.nextInt(allTypesConcat.length()));
        }
        return password;
    }

    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}