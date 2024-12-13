package BackendUser;

import java.util.UUID;

public class User {

    public    String userId; // Gson will now handle this field

    public    String email;

    public String username;

    public String password;


    public String status;



    public User(String email, String username, String password) {
        this.email = email;
        this.userId= UUID.randomUUID().toString();
        this.username = username;
        this.password = password;

        this.status = "offline";
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



    public String getStatus() {
        return status;
    }
}
