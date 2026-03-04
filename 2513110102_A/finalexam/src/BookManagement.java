import java.io.*;
import java.util.Scanner;

public class BookManagement extends TextBook implements BookService{

    private TextBook book;
    private final String filename = "src/Book.txt";

    public BookManagement(TextBook book,int edition,String isbn,String title){
        super(edition,isbn,title);
        this.book = book;
    }

    public TextBook getBook() {
        return book;
    }
    @Override
    public void addNewBook(){
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.println(book.toString());
            System.out.println("Edited data successfully!! Please check the file!");
            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot add "+book.titleFormat()+" into file...");
        }

    }
    @Override
    public void editEdition(int newEdition){
            setEdition(newEdition);
    }

    @Override
    public boolean checkExistingISBN(){
        try {
            FileReader fileReader = new FileReader(filename);
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNext()){
                String[] bookInfo = scanner.nextLine().split(",");
                if (book.getIsbn().equals(bookInfo[0])){
                    setIsbn(book.getIsbn());
                    setTitle(book.getTitle());
                    scanner.close();
                    return true;
                }
            }
        }
        catch (FileNotFoundException e){
            generateFile();
        }
        finally {
            return false;
        }
    }
    public void generateFile(){
        try {
            new FileWriter(filename);
        }catch (IOException e){
            System.out.println("Cannot create a file...");
        }
    }
}
