package src.data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Objects;

public class Suppression {

    public Suppression(String nameSave){
        File f = new File(Config.PATH_PARTIES);
        JSONObject saves=null;
        if(f.exists()){
            JSONParser parser = new JSONParser();
            try(Reader reader = new FileReader(Config.PATH_PARTIES)){
                saves = (JSONObject) parser.parse(reader);
                saves.remove(nameSave);
            }catch(IOException | ParseException e){
                e.printStackTrace();
            }
        }
        try (FileWriter file = new FileWriter(Config.PATH_PARTIES)) {
            file.write(Objects.requireNonNull(saves).toJSONString());
            file.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}