import java.util.Random;

public class QuikPass {

    public static void main(String[] args) {
        System.out.println(generate(8));
    }

    private static char[] generate(int length) {

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
    
}