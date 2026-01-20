public class Book {
    private String title;
    private int totalBook;
    private int availableBook;



    public Book(String title,int totalbook){
        this.title = title;
        this.totalBook = totalbook;
        this.availableBook = totalbook;
    }

    public  Book(String title){
        this(title,0);
    }

    public  Book(){
        this("",0);
    }

    public String getTitle(){
        return title;
    }

    public int getTotalBook(){
        return totalBook;
    }

    public int getAvailableBook() {
        return availableBook;
    }


    public void borrowBook(){
        if (availableBook>0){
            availableBook--;
        }
    }

    public void returnBook(){
        if (availableBook<totalBook){
            availableBook++;
        }
    }
}
