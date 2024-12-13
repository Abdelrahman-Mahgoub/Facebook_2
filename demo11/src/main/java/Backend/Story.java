package Backend;

import java.time.LocalDate;


public class Story extends Content{
    public Story(String contentID, String authorID, String content) {
        super(contentID, authorID, content);
    }
    public boolean isexpired(){
        return this.getTime().plusDays(1).isBefore(LocalDate.now());
    }
}
