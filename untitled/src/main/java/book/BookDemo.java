package book;

public class BookDemo {
    public static void main(String[] args) {
        Book book = new Book("Developing Java Software", "Russel Winder", 79.75);
        System.out.println(book);
        Author author = new Author("Russel", "Winder");
        System.out.println(author);
    }
}
