// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class Book {

    void print(String string) {
        System.out.println(string);
    }

    private long ISBN_no;
    private String name, author, publisher;
    private int edition, status;

    long getISBN() {
        return ISBN_no;
    }

    Book() {}

    Book(long ISBN_no, String name, String author, String publisher, int edition, int status) {
        this.ISBN_no = ISBN_no;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.status = status;
    }

    public void checkStatus() {
        switch(status) {
            case 0: print("Available"); break;
            case 1: print("Issued"); break;
            case 2: print("Reserved"); break;
        }
    }

    public void changeStatus(int newStatus) {
        this.status = newStatus;
    }

    public void display() {
        print("ISBN Number = " + ISBN_no);
        print("Name        = " + name);
        print("Author      = " + author);
        print("Publisher   = " + publisher);
        print("Edition     = " + edition);
        print("Status      = " + status);
    }

}

public class L8Q2 {
    
    static void print(String string) {
        System.out.println(string);
    }

    static Book getBook(long ISBN, LinkedList books) {
        ListIterator<Book> itr = books.listIterator();
        while(itr.hasNext()) {
            Book temp = itr.next();
            if (temp.getISBN() == ISBN)
                return temp;
        }
        return null;
    }
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        LinkedList books = new LinkedList();
        int choice = 0;
        
        while (choice != 5) {
            
            print("Enter choice:\n1. Add Book\n2. Check Status\n3. Change Status\n4. Display\n5. Exit\n");
            choice = Integer.parseInt(sc.nextLine());
            print("");

            if (choice == 1) {
                print("Enter the ISBN Number, Name, Author, Publisher, Edition, and Status");
                books.add(new Book(Long.parseLong(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
            }

            else if (choice > 1 && choice < 5) {
                print("Enter ISBN Number of the book = ");
                Book book = getBook(Long.parseLong(sc.nextLine()), books);
                print("");
                if (book == null) {
                    print("ISBN Number not found");
                } else {
                    switch (choice) {
                        case 2:
                            book.checkStatus();
                            break;
                        case 3:
                            print("Enter new status (0-2) = ");
                            book.changeStatus(Integer.parseInt(sc.nextLine()));
                            break;
                        case 4:
                            book.display();
                            break;
                    }
                }
            }

            print("");
        }

        sc.close();

    }
}

// Code by arcenter
// https://github.com/arcenter/UniCode/