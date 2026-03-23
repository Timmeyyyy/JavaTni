import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class RecipeCheck {
    public String RecipeList() throws FileNotFoundException {
        File file = new File("Recipe/RecipeList.txt");
        Scanner sc = new Scanner(file);
        String RecipeList = sc.nextLine();
        sc.close();
        return RecipeList;
    }

    public int RecipeAmount() throws FileNotFoundException {
        String[] Recipe_ = RecipeList().split(",");
        return  Recipe_.length;
    }

    public String RecipeStep(String Menu){
        try {
            File file = new File("RecipeInfo/" + Menu);
            Scanner sc = new Scanner(file);
            String Recipe = "";
            while (sc.hasNextLine()) {
                Recipe = Recipe + "\n" + sc.nextLine();
            }

            return Recipe;
        }
        catch (FileNotFoundException e){
            return "File not found.";
        }
    }
}
