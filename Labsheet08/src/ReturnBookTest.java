import javax.swing.*;

public class ReturnBookTest {
    public static void main(String[] args) {
        Book book = new Book("Java Programing",5);


        while (true) {
            int answer = JOptionPane.showConfirmDialog(null, "Do you want to borrow/return book?",
                    "Borrow/Return Book", JOptionPane.YES_NO_OPTION);

            if (answer == JOptionPane.YES_OPTION) {
                int choice = Integer.parseInt(JOptionPane.showInputDialog("Press 1 to borrow book\nPress 2 to return book"));
                if (choice == 1) {
                    book.borrowBook();
                    if (book.getAvailableBook() == 0) {
                        JOptionPane.showMessageDialog(null, "No books available to borrow...",
                                "", JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }
                    System.out.println("Borrowed 1 books, available " + book.getAvailableBook() + " books.");

                } else if (choice == 2) {
                    book.returnBook();
                    if (book.getAvailableBook() == book.getTotalBook()) {
                        JOptionPane.showMessageDialog(null, "Cannot return! All books are already here.",
                                "", JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }
                    System.out.println("Return 1 books, available " + book.getAvailableBook() + " books.");

                }
            }
            else {
                JOptionPane.showMessageDialog(null, "END PROGRAM"); break;
            }

        }

    }
}