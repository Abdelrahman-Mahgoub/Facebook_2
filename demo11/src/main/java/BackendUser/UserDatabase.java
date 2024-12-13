package BackendUser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static final String DATABASE_FILE = "users.json";
    private final List<User> users;
    private final Gson gson;


    public UserDatabase() {
        gson = new Gson();
        users = loadUsers();
    }
    public List<User> loadUsers() {
        System.out.println("Loading users from: " + new File(DATABASE_FILE).getAbsolutePath());
        try (Reader reader = new FileReader(DATABASE_FILE)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            return gson.fromJson(reader, userListType);
        } catch (IOException e) {
            System.out.println("Database file not found. Starting new database.");
            return new ArrayList<>();
        }
    }

    public void save() {
        try (Writer writer = new FileWriter(DATABASE_FILE)) {
            gson.toJson(users, writer);
            System.out.println("Users saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(String email, String username, String hashedPassword) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        User newUser = new User(email, username, hashedPassword);
        users.add(newUser);
        save();
        System.out.println("User list size after adding: " + users.size());
        return true;
    }

    public User authenticate(String email, String hashedPassword) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getEmail().equals(email) && user.getPassword().equals(hashedPassword)) {
                user.setStatus("online");
                save();
                return user;
            }
        }
        return null;
    }
    public void logout(User user) {
        for(int i=0 ;i<users.size();i++){
            if(users.get(i).equals(user)){
                users.get(i).setStatus("offline");
            }
        }
        save();
    }
    public User getUser(String email){
        for (int i=0 ;i<users.size();i++){
            if(email.equals(users.get(i).email)){
                return users.get(i);
            }
        }
        return null;
    }
    public List<User> returnall(){
        return users;
    }
}
