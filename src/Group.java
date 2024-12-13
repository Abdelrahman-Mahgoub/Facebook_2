import java.util.*;
public class Group {
    private String name;
    private String description;
    private String admin;
    private String image;
    private List<String> members;
    

    public Group(String name, String description, String admin) {
        this.name = name;
        this.description = description;
        this.admin = admin;
        this.members=new ArrayList<>();
        this.members.add(admin);
        this.image=null;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
public void dispalyGroupInfo(){
    System.out.println("Group name "+name);
    System.out.println("Description"+description);
    System.out.println("Admin"+admin);
    System.out.println("Members"+members);
    System.out.println("Group Image"+(image !=null?image:"NO IMAGE"));

}
public boolean searchMember(String username){

return members.stream()
.anyMatch( (var member)->member.equalsIgnoreCase(username));
}


    
   public void addMember(String username){    
       if(!members.contains(username)){
           members.add(username);
   }}
   public void removeMember(String username){
       members.remove(username);
   }
}
