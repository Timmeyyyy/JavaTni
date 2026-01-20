import javax.swing.*;

public class BorrowBookTest {
    public static void main(String[] args) {
        Book book = new Book("C# Programming",5);

        int confirm =  JOptionPane.showConfirmDialog(null,"Do you want to borrow books?",
                "Borrow Book",JOptionPane.YES_NO_OPTION);
        if (confirm==JOptionPane.YES_OPTION)
        {
            if (book.getAvailableBook()!=0)
            {
                book.borrowBook();
                System.out.println("Borrowed 1 books, available "+book.getAvailableBook()+" books.");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No books available to borrow...",
                        "Warning Message",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(null,"END PROGRAM");

    }
}