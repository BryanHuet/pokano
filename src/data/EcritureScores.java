package src.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import src.model.PlateauPuzzle;

import java.io.*;

public class EcritureScores {

    public EcritureScores(PlateauPuzzle plateauPuzzle,String nomPartie,String nomJoueur){

        File f = new File(Config.PATH_SCORES);
        JSONObject saves = new JSONObject();
        if(f.exists()){
            JSONParser parser = new JSONParser();
            try(Reader reader = new FileReader(Config.PATH_SCORES)){
                saves = (JSONObject) parser.parse(reader);
            }catch(IOException | ParseException e){
                e.printStackTrace();
            }
        }

        JSONArray listeScore = new JSONArray();
        if(saves.containsKey(nomPartie)){
            listeScore = (JSONArray) saves.get(nomPartie);
        }

        JSONObject score = new JSONObject();
        score.put("nomJoueur", nomJoueur);
        score.put("score", plateauPuzzle.espaceOccupe());
        listeScore.add(score);
        saves.put(nomPartie,listeScore);
        //System.out.println(saves.toJSONString());
        try (FileWriter file = new FileWriter(Config.PATH_SCORES)) {
            file.write(saves.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}