import java.util.Random;
import java.util.Scanner;

public class QuikPass {

    public static void main(String[] args) {

        int length = setLength();

        clearScreen();
        System.out.println(generatePass(length));
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
                lengthInq.next(); // this is important!
            }
            length = lengthInq.nextInt();

            if (length <= 0) {
                System.out.println((char)27 + "[31m" + warnLength);
            }
        } while (length <= 0);
        
        lengthInq.close();
        return length;
    }

    private static char[] generatePass(int length) {

        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String specialChars = "!@#$%^&*";
        String numbers = "1234567890";

        String allTypesConcat = upperCase + lowerCase + specialChars + numbers;

        Random rand = new Random();
        char[] password = new char[length];

        password[0] = upperCase.charAt(rand.nextInt(upperCase.length()));
        password[1] = lowerCase.charAt(rand.nextInt(lowerCase.length()));
        password[2] = specialChars.charAt(rand.nextInt(specialChars.length()));
        password[3] = numbers.charAt(rand.nextInt(numbers.length()));

        for(int i = 4; i < length; i++) {
            password[i] = allTypesConcat.charAt(rand.nextInt(allTypesConcat.length()));
        }
        return password;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
}