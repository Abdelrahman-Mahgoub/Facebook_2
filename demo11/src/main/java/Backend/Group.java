package Backend;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private String description;
    private String admin;
    private String primaryAdmin;
    private String image;
    private List<String> members;
    private List<String> admins;

    public String getPrimaryAdmin() {
        return primaryAdmin;
    }

    public void setPrimaryAdmin(String primaryAdmin) {
        this.primaryAdmin = primaryAdmin;
    }

    public List<String> getAdmins() {
        return admins;
    }

    public void setAdmins(List<String> admins) {
        this.admins = admins;
    }

    public Group(String name, String description, String primaryadmin) {
        this.name = name;
        this.description = description;
        this.primaryAdmin = primaryadmin;
        this.members=new ArrayList<>();
        this.members.add(primaryadmin);
        this.image=null;
        this.admins= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean addAdmin(String username) {
        if (primaryAdmin.equals(username)) return false;
        return admins.add(username);
    }
    public boolean removeAdmin(String username) {
        if (primaryAdmin.equals(username)) return false;
        return admins.remove(username);
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public void clearImage(String image){
    this.image=null;
    
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

public boolean searchMember(String username){
for(int i=0 ;i<members.size();i++){
    if(username.equals(members.get(i))){
        return true;
    }
}
return false;
}
    public boolean searchAdmin(String username){
        for(int i=0 ;i<admins.size();i++){
            if(username.equals(admins.get(i))){
                return true;
            }
        }
        return false;
    }


    
   public void addMember(String username){    
       if(!members.contains(username)){
           members.add(username);
   }}
   public void removeMember(String username){
       members.remove(username);
   }
}
