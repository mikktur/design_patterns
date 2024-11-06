package proxy;



import java.util.Date;

public class DocumentProxy implements IDocument {

    private final Document document;
    public DocumentProxy(Document document) {
        this.document = document;

    }
    @Override
    public String getContent(User user) {
        try {
            AccesControlService.isAllowed(user.getUsername(), document.getId());
            return document.getContent(user);
        } catch (AccessDeniedException e) {
            return e.getMessage();
        }
    }
    @Override
    public Date getCreatedDate() {
        return document.getCreatedDate();
    }

    @Override
    public int getId() {
        return document.getId();
    }
}
