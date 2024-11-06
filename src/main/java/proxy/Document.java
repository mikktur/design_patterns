package proxy;


import java.util.Date;

public class Document implements IDocument {
    private final int id;
    private final String content;
    private final Date createdDate;
    private static int idCounter = 1;
    public Document(String content) {
        this.id = idCounter++;
        this.createdDate = new Date();

        this.content = content;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }
    @Override
    public String getContent(User user) {
        return content;
    }

    @Override
    public int getId()  {
        return id;
    }



}
