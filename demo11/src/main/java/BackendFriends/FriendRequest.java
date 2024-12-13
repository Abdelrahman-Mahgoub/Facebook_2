package BackendFriends;

public class FriendRequest {
    private String fromUserId;
    private String toUserId; 
    private String status; 

    public FriendRequest(String fromUserId, String toUserId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.status = "Pending";
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToUserId() {
        return toUserId;
    }

    public String getStatus() {
        return status;
    }

    
}
