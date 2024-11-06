package proxy;

import java.util.Date;

public interface IDocument {
    int getId();
    Date getCreatedDate();
    String getContent(User user);
}
