package prototype;

public class Main {

        public static void main(String[] args) {
            Book book = new Book("J.K. Rowling", "Harry Potter", "Fantasy", 1997);
            Book book2 = new Book("J.R.R. Tolkien", "The Lord of the Rings", "Fantasy", 1954);
            Book book3 = new Book("George Orwell", "1984", "Dystopian", 1949);
            Book book4 = new Book("Aldous Huxley", "Brave New World", "Dystopian", 1932);
            Book book5 = new Book("Ray Bradbury", "Fahrenheit 451", "Dystopian", 1953);
            Book book6 = new Book("Margaret Atwood", "The Handmaid's Tale", "Dystopian", 1985);

            Recommendation recommendation = new Recommendation("Young Adults");
            recommendation.addBook(book);
            recommendation.addBook(book2);
            recommendation.addBook(book3);

            Recommendation recommendation2 = recommendation.clone();
            recommendation2.addBook(book4);
            recommendation2.addBook(book5);
            recommendation2.setTargetAudience("copy of recommendation");
            Recommendation recommendation3 = recommendation.clone();
            recommendation3.addBook(book6);
            recommendation3.setTargetAudience("copy of recommendation 2");

            System.out.println("Recommendation 1:");
            System.out.println(recommendation);
            System.out.println("-------------------------");
            System.out.println("Recommendation 2:");
            System.out.println(recommendation2);
            System.out.println("-------------------------");
            System.out.println("Recommendation 3:");
            System.out.println(recommendation3);
        }

}
