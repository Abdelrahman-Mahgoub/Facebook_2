package BackendFriends;

public class Friend {

    private String userId;
    private String user1Id;
    private String user2Id;
    private String friendId;
private String Status;

    public String getStatus() {
        return Status;
    }

    public Friend(String userId, String friendId) {
        this.userId = userId;
        
        
        this.friendId = friendId;
        this.Status="Accepted";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}

    