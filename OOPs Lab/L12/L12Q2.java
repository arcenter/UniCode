// Code by arcenter
// https://github.com/arcenter/UniCode/

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

    @Override
    public int compareTo(Book book) {
        return this.name.compareTo(book.getName());
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
        
        Book[] books = new Book[3];
        
        books[0] = new Book("Book A", 1);
        books[1] = new Book("Book B", 2);
        books[2] = new Book("Book C", 3);

        Book book = new Book("Book A", 3);

        System.out.println(GeneralizedSearch.search(books, book));

    }
}

// Code by arcenter
// https://github.com/arcenter/UniCode/