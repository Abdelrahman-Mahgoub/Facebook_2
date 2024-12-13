package Backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupDatabase {
    List<Group> groups;
    public GroupDatabase() {
        groups = new ArrayList<>();
        loadGroups();
    }

    private static final String Filename = "groups.json";

    public void loadGroups() {
       groups.clear();
        JSONParser parser = new JSONParser();
        try {
            FileReader read= new FileReader(Filename);
            JSONArray load = (JSONArray) parser.parse(read);
            for(int i=0 ; i<load.size();i++) {
                JSONObject object =(JSONObject) load.get(i);
            String name = (String) object.get("Name");
            String description= (String) object.get("Description");
            String primAdmin= (String) object.get("PrimaryAdmin");
                Group group = new Group(name, description, primAdmin);
                JSONArray normalUsersArray = (JSONArray) object.get("NormalUsers");
                if (normalUsersArray != null) {
                    for (Object user : normalUsersArray) {
                        group.addMember((String) user);
                    }
                }
                JSONArray adminsArray = (JSONArray) object.get("Admins");
                if (adminsArray != null) {
                    for (Object admin : adminsArray) {
                        group.addAdmin((String) admin);
                    }
                }
            groups.add(group);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

}
public void Save(){
    JSONArray jsonArray = new JSONArray();
    for(int i=0 ;i<groups.size();i++){

            JSONObject object = new JSONObject();
            object.put("Name", groups.get(i).getName());
            object.put("Description", groups.get(i).getDescription());
            object.put("PrimaryAdmin", groups.get(i).getPrimaryAdmin());


            JSONArray adminsArray = new JSONArray();

            adminsArray.addAll(groups.get(i).getAdmins());
            object.put("Admins", adminsArray);


            JSONArray normalUsersArray = new JSONArray();
            normalUsersArray.addAll(groups.get(i).getMembers());
            object.put("NormalUsers", normalUsersArray);
            jsonArray.add(object);
    }
    try {  FileWriter write = new FileWriter(Filename);
            write.write(jsonArray.toJSONString());
            write.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void addGroup(Group group) {
        groups.add(group);
        Save();
    }
    public void removeGroup(String groupName) {
       for (int i=0; i< groups.size();i++)  {
           if(groups.get(i).getName().equals(groupName)) {
               groups.remove(i);
               Save();
           } }}
    public List returnall(){
        return groups;
    }
}
