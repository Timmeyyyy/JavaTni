import java.util.Random;
import java.util.Scanner;

public class Lab603 {

    public static int[] random_array() {
        Random random = new Random();
        int[] number_random = new int[10];
        for (int i = 0 ; i < number_random.length;i++) number_random[i] = random.nextInt(20);
        return  number_random;
    }

    public  static void display_array(int[] numbers){
        System.out.println("Sorry, try again next time...");
        System.out.print("Here are the element in the array: " );
        for (int num:numbers)System.out.print(num + " ");
    }

    public static int count_element(int[] numbers, int element){
        int count = 0 ;
        for (int num:numbers){
            if(num == element){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = random_array();
        System.out.print("Enter your guess (0-20): ");
        int guess_number = scanner.nextInt();
        System.out.println();
//        กรณีที่ทายตัวเลขถูก ให้แสดงผลว่า “Congratulations!! <ตัวเลขที่ทาย> is an element in the array!!”
//        § และถ้าตัวเลขที่ทายถูก มีในอาร์เรย์มากกว่า 1 ตัว ให้แสดงผลต่อไปว่า “Fantastic!! It also appears
//        more than once!!”
        int check = count_element(numbers,guess_number);
        if (check == 1){
            System.out.println("Congratulations!! "
                    + guess_number
                    + " is an element in the array!!");
        } else if (check > 1) {
            System.out.println("Congratulations!! "
                    + guess_number
                    + "is an element in the array!!");
            System.out.println("Fantastic!! It also appears more than once!!");
        } else {
            display_array(numbers);
        }

    }
}
 