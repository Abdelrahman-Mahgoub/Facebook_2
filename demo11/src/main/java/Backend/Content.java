package Backend;

import java.time.LocalDate;

public class Content {
    private String  contentID;
    private String authorID;
    private String Content;
    private LocalDate time;
private String image;

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Content(String contentID, String authorID, String content) {
        this.contentID = contentID;
        this.authorID = authorID;
        Content = content;
        this.time=LocalDate.now();

    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContentID() {
        return contentID;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getContent() {
        return Content;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }
}
