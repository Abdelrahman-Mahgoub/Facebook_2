package BackendFriends;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    private static final String Filename = "friends.json";
    private ArrayList<FriendRequest> requests;
    private ArrayList<Friend> friends;

    public Database() {
        this.requests = new ArrayList<FriendRequest>();
        this.friends = new ArrayList<Friend>();
        loadContent();
        loadfriends();
    }

    public void save(FriendRequest request) {
        requests.add(request);
        SaveRequests();
    }

    public void save(Friend friend) {
        friends.add(friend);
        SaveFriends();
    }
public void deletefriendreq(String from, String to){
    for (int i = 0; i < requests.size(); i++) {
        if (requests.get(i).getFromUserId().equals(from) && requests.get(i).getToUserId().equals(to) ) {
            requests.remove(requests.get(i));
            SaveRequests();
        }

}}
    public void SaveRequests() {
       JSONArray array = new JSONArray();
        for (int i = 0; i < requests.size(); i++) {
            JSONObject object = new JSONObject();
            object.put("from", requests.get(i).getFromUserId());
            object.put("to", requests.get(i).getToUserId());
            object.put("Status", requests.get(i).getStatus());
            array.add(object);

        }
        try (FileWriter writer = new FileWriter(Filename)) {
            writer.write(array.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SaveFriends() {
        JSONArray array = new JSONArray();
        for (int i = 0; i < friends.size(); i++) {
            JSONObject object = new JSONObject();
            object.put("user1", friends.get(i).getUserId());
            object.put("user2", friends.get(i).getFriendId());

            array.add(object);

        }
        try (FileWriter writer = new FileWriter("AreFriends.json")) {
            writer.write(array.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasfriendreq(String from, String to, String status) {
        for (int i = 0; i < requests.size(); i++) {
            if (requests.get(i).getFromUserId().equals(from) && requests.get(i).getToUserId().equals(to) ) {
                return true;
            }

        }
        return false;
    }
    public boolean arefriends(String from, String to) {
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).getUserId().equals(from) && friends.get(i).getFriendId().equals(to)) {
                return true;
            }

        }
        return false;
    }

    public void loadContent() {
        requests.clear();
        JSONParser parser = new JSONParser();
        try {
            FileReader read = new FileReader(Filename);
            JSONArray load = (JSONArray) parser.parse(read);
            for (int i = 0; i < load.size(); i++) {
                JSONObject object = (JSONObject) load.get(i);
                String From = (String) object.get("from");
                String to = (String) object.get("to");
                String content = (String) object.get("Status");

                FriendRequest friend = new FriendRequest(From, to);



                requests.add(friend);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public void loadfriends() {
        friends.clear();
        JSONParser parser = new JSONParser();
        try {
            FileReader read = new FileReader("AreFriends.json");
            JSONArray load = (JSONArray) parser.parse(read);
            for (int i = 0; i < load.size(); i++) {
                JSONObject object = (JSONObject) load.get(i);
                String From = (String) object.get("user1");
                String to = (String) object.get("user2");


                Friend friend = new Friend(From, to);



                friends.add(friend);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
