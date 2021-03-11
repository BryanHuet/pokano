package src.data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class LectureScores {

    HashMap<String, Integer> tableauScores = new HashMap<>();
    List<String> parties = new ArrayList<>();

    public LectureScores(){
        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader(Config.PATH_SCORES)){
            JSONObject saves = (JSONObject) parser.parse(reader);
            saves.keySet().forEach(keyStr -> this.parties.add((String) keyStr));
        }catch(IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public List<String> getParties(){
        return this.parties;
    }

    public HashMap<String, Integer> getTableauScores(String nomPartie){
        JSONParser parser = new JSONParser();
        this.tableauScores.clear();
        try(Reader reader = new FileReader(Config.PATH_SCORES)){
            JSONObject saves = (JSONObject) parser.parse(reader);
            JSONArray cible = (JSONArray) saves.get(nomPartie); //On récupère la sauvegarde de la partie
            if(cible!=null){
                for (JSONObject jsonObject : (Iterable<JSONObject>) cible) {
                    String nomJoueur = (String) ((JSONObject) jsonObject).get("nomJoueur");
                    Integer score = Math.toIntExact((Long) ((JSONObject) jsonObject).get("score"));
                    tableauScores.put(nomJoueur, score);
                }
            }
        }catch(IOException | ParseException e){
            e.printStackTrace();
        }
        return tableauScores;
    }

}