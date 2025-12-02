import java.util.Scanner;

public class Lab303 {
    static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        String quadrant = " ";
        System.out.print("Enter the value for X coordinate: ");
        int X_coordinate = Integer.parseInt (Input.next());
        System.out.print("Enter the value for Y coordinate: ");
        int Y_coordinate = Integer.parseInt (Input.next());

        if (X_coordinate > 0){
            if (Y_coordinate > 0 ){
                quadrant = "Frist";
            } else if (Y_coordinate < 0) {
                quadrant = "Fourth";
            }
        }
        else {
            if(X_coordinate == 0 && Y_coordinate == 0 ){
                quadrant = "Origin";
            }
            else if (Y_coordinate > 0){
                quadrant = "Second";
            }
            else{
                quadrant = "Third";
            }
        }
        if (quadrant != "Origin"){
            System.out.println("The coordinate point ("+X_coordinate+","+Y_coordinate+") lies in the "+quadrant+" quadrant" );
        }
        else {
            System.out.println("The coordinate point ("+X_coordinate+","+Y_coordinate+") lies in the "+quadrant );
        }




    }
}