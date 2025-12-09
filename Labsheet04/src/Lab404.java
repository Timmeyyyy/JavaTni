import java.util.Scanner;

public class Lab404 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "";
        String sentence = "";
        while (true) {
            System.out.print("Enter word: ");
            word = scanner.nextLine();
            if (word.equalsIgnoreCase("stop")) {
                break;
            }
            sentence = sentence + word+" " ;
        }
        System.out.println(sentence);
    }
}
 