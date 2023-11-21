// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.*;

class Book implements Comparable<Book> {
    
    private String name;
    private double cost;

    Book(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public int compareTo(Book book) {
        return this.name.compareTo(book.getName());
    }

    public String toString() {
        return "Name: " + name + ", Cost: " + cost + "\n";
    }

}

class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        return Double.compare(book1.getCost(), book2.getCost());
    }

}

class GeneralizedSearch {

    public static boolean search(Object[] arr, Object item) {
        if (item instanceof Comparable) {
            for (Object object : arr) {
                if (object instanceof Comparable)
                    if (((Comparable)object).compareTo((Comparable)item) == 0)
                        return true;
            }
        }
        return false;
    }

}

public class L12Q2 {
    public static void main(String args[]) {
        
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book A", 1));
        books.add(new Book("Book B", 2));
        books.add(new Book("Book C", 3));

        Book book = new Book("Book A", 10);
        if(GeneralizedSearch.search(books.toArray(), book))
            System.out.println(book.toString());
        else
            System.out.println("Book not found!");

        BookComparator bc = new BookComparator();
        Collections.sort(books, bc);
        Collections.reverse(books);

        for (Book tempBook : books) {
            System.out.println(tempBook.getName());
        }

    }
}

// Code by arcenter
// https://github.com/arcenter/UniCode/