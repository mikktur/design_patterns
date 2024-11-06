package proxy;

public class Main {

    public static void main(String[] args) {
        User user = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        Library library = new Library();
        library.createProtectedDocument("Protected Content", user);
        library.createUnprotectedDocument("Unprotected Content");
        library.createProtectedDocument("Protected Content 2", user2);
        IDocument document = library.getDocument(1);
        IDocument document2 = library.getDocument(2);
        IDocument document3 = library.getDocument(3);


        // every user should be able to access every documents creation date
        System.out.println("User 1 should be able to access document 1 and 2");
        System.out.println("Document 1: "+document.getContent(user) +", Creation date: "+document.getCreatedDate());
        System.out.println("Document 2: "+document2.getContent(user) +", Creation date: "+document2.getCreatedDate());
        System.out.println("Document 3: "+document3.getContent(user) +", Creation date: "+document3.getCreatedDate());


        System.out.println("User 2 should be able to access document 2 and 3");
        System.out.println("Document 1: "+document.getContent(user2) +", Creation date: "+document.getCreatedDate());
        System.out.println("Document 2: "+document2.getContent(user2) +", Creation date: "+document2.getCreatedDate());
        System.out.println("Document 3: "+document3.getContent(user2) +", Creation date: "+document3.getCreatedDate());

        System.out.println();

        System.out.println("User 3 should be able to access document 2");
        System.out.println("Document 1: "+document.getContent(user3) +", Creation date: "+document.getCreatedDate());
        System.out.println("Document 2: "+document2.getContent(user3) +", Creation date: "+document2.getCreatedDate());
        System.out.println("Document 3: "+document3.getContent(user3) +", Creation date: "+document3.getCreatedDate());





    }
}
