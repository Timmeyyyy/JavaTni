import java.util.Scanner;

public class Lab602 {

    public static int find_rank(double[] Movie_score,int movie_number){
        int rank = 1;
        for(int i = 0; i<Movie_score.length;i++){
            if(Movie_score[movie_number]<Movie_score[i]){
                rank++;
            }
        }
        return rank;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] Movie_name = {"Me Before You", "Titanic", "Before Sunrise", "The Holiday","A Walk to Remember"};
        double[] Movie_score = {4.2, 4.9, 4.4, 3.7, 4.3};

        System.out.print("Enter a movie title: ");
        String Input_name = scanner.nextLine();

        int movie_number = -1;
        for(int i = 0;i <Movie_name.length;i++){
            if (Input_name.trim().equalsIgnoreCase(Movie_name[i])){
                movie_number = i;
            }
        }


        if (movie_number!=-1) {
            System.out.println("The rating score of \"" + Movie_name[movie_number] + "\" is " + Movie_score[movie_number] +" and rank is "+find_rank(Movie_score,movie_number));
        }
        else {
            System.out.println("Cannot found this movie title...");
        }


    }



}
