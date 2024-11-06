package proxy;


import java.util.HashMap;

public class Library {
    public HashMap<Integer, IDocument> documents = new HashMap<>();

    public Library() {
    }

    private void addDocument(IDocument document) {
        documents.put(document.getId(), document);
    }

    public IDocument getDocument(int id) {
        return documents.get(id);
    }
    public void createUnprotectedDocument(String content) {

        Document document = new Document(content);
        addDocument(document);
    }
    public void createProtectedDocument(String content, User user) {

        Document document = new Document(content);
        addDocument(new DocumentProxy(document));
        AccesControlService.getInstance().addPermission(document.getId(), user.getUsername());
    }
}
