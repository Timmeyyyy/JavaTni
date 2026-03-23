import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class RecipeAdd {
    public boolean RecipeCheck(String Menu) throws FileNotFoundException {
        File file = new File("Recipe/RecipeList.txt");
        Scanner sc = new Scanner(file);
        String RecipeList = sc.nextLine();
        String[] Recipe_ = RecipeList.split(",");
        for (int i = 0; i < Recipe_.length; i++) {
            if (Recipe_[i].equalsIgnoreCase(Menu)) {
                sc.close();
                return true;
            }
        }
        sc.close();
        return false;
    }

    public void RecipeCreate(String Menu) throws IOException {
        File file = new File("RecipeInfo/" + Menu);
        if (file.createNewFile()) {
        }


    }

    public void RecipeStepWrite(String Menu,String Step) throws IOException {
        FileWriter writer = new FileWriter("RecipeInfo/" + Menu);
        writer.write("Menu: "+Menu+"\n\n");
        writer.write(Step);
        writer.close();
    }

    public void  RecipeListAdd(String Menu) throws IOException {
        File file = new File("Recipe/RecipeList.txt");
        Scanner sc = new Scanner(file);
        String RecipeList = sc.nextLine();
        FileWriter writer = new FileWriter(file);
        writer.write(RecipeList+","+Menu);
        writer.close();
        sc.close();
    }
}

