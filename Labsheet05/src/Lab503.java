import java.util.Scanner;

public class Lab503 {
    public static int count_vowel(String massage,char letter){
        int count = 0;
        for (int i=0;i<=massage.length()-1;i++){
            if (massage.toLowerCase().charAt(i) == letter) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a massage: ");
        String massage = scanner.nextLine();

        System.out.println("\nList of vowel in \""+massage+"\""+
                "\nThe letter 'A' appear "+count_vowel(massage,'a')+" time(s)."+
                "\nThe letter 'E' appear "+count_vowel(massage,'e')+" time(s)."+
                "\nThe letter 'I' appear "+count_vowel(massage,'i')+" time(s)."+
                "\nThe letter 'O' appear "+count_vowel(massage,'o')+" time(s)."+
                "\nThe letter 'U' appear "+count_vowel(massage,'u')+" time(s).");
    }
}
