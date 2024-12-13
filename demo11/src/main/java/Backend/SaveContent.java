package Backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class SaveContent {
    private ArrayList <Content> contents;
    private static final String Filename="content.json";

    public SaveContent() {

contents= new ArrayList<Content>();
loadContent();
    }

    public void save(Content content){
        contents.add(content);
SaveContent();

    }
    public void removeExpired(){
        Iterator<Content> iterator = contents.iterator();
        while(iterator.hasNext()){
            Content content= iterator.next();
            if(content instanceof Story && ((Story) content).isexpired()){
                iterator.remove();

            }


        }

    }
    public void SaveContent(){
        JSONArray array = new JSONArray();
       for(int i=0; i<contents.size();i++){
           JSONObject object= new JSONObject();
           if(contents.get(i) instanceof Story){
               object.put("Type ", "Story");
           }
           else{
               object.put("Type ", "Post");
           }
           object.put("Content id" , contents.get(i).getContentID());
        object.put("author id" , contents.get(i).getAuthorID());
        object.put("Content" , contents.get(i).getContent());
        object.put("Image", contents.get(i).getImage());
        String date = String.valueOf(contents.get(i).getTime());

        object.put("date" ,date );

        array.add(object);
    }
    try{
        FileWriter write = new FileWriter(Filename);
        write.write(array.toJSONString());
        write.close();

    }catch (IOException e){
        e.printStackTrace();
    }
    }
    public void loadContent(){
        contents.clear();
        JSONParser parser= new JSONParser();
        try {
            FileReader read= new FileReader(Filename);
            JSONArray load = (JSONArray) parser.parse(read);
            for(int i=0 ; i<load.size();i++){
                JSONObject object =(JSONObject) load.get(i);
                String contentID = (String) object.get("Content id");
                String authorID = (String) object.get("author id");
                String content = (String) object.get("Content");
                String date = (String) object.get("date");
                String type = (String) object.get("Type ");
                String image = (String) object.get("Image");
                Content oldContents;
                if(type.equals("Story")){
                    oldContents = new Story(contentID,authorID,content);
                    oldContents.setImage(image);
                }
                else{
                    oldContents = new Posts(contentID,authorID,content);
                    oldContents.setImage(image);
                }
                contents.add(oldContents);
                oldContents.setTime(LocalDate.parse(date));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
e.printStackTrace();
        }

    }
    public ArrayList<Content> returnall(){
        return contents;
    }
}
