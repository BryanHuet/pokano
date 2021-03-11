package src.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import src.model.PlateauPuzzle;
import src.model.piece.Piece;

import java.io.*;

public class EcritureParties {

    private PlateauPuzzle plateauPuzzle;
    private String nomPartie;
    private String nomJoueur;

    public EcritureParties(PlateauPuzzle plateauPuzzle,String nomPartie,String nomJoueur){
        File f = new File(Config.PATH_PARTIES);
        JSONObject saves = null;
        if(f.exists()){
            JSONParser parser = new JSONParser();
            try(Reader reader = new FileReader(Config.PATH_PARTIES)){
                saves = (JSONObject) parser.parse(reader);
                saves.remove(this.nomPartie); //Permet d'écraser une partie si on entre le même nom
            }catch(IOException | ParseException e){
                e.printStackTrace();
            }
        }
        if(saves==null){
            saves=new JSONObject();
        }
        this.plateauPuzzle = plateauPuzzle;
        this.nomPartie = nomPartie;
        this.nomJoueur = nomJoueur;
        JSONObject partie = new JSONObject();
        partie.put("nomJoueur",this.nomJoueur);
        partie.put("tailleX",this.plateauPuzzle.getTaille()[0]);
        partie.put("tailleY",this.plateauPuzzle.getTaille()[1]);
        JSONArray plateau = new JSONArray();
        for( Piece value : this.plateauPuzzle.getEnsemblePiece()){
            JSONObject piece = new JSONObject();
            piece.put("classe",value.toString());
            piece.put("positionX",value.getPosition()[0]);
            piece.put("positionY",value.getPosition()[1]);
            piece.put("hauteur",value.getHauteur());
            piece.put("largeur",value.getLargeur());
            piece.put("rotation",value.getSensRotation());
            /*JSONArray tableau = new JSONArray();
            for(int i = 0;i<value.getRange().size();i++){
                tableau.add(value.getRange().get(i));
            }
            piece.put("range",tableau);*/
            plateau.add(piece);
        }
        partie.put("plateau",plateau);
        saves.put(this.nomPartie,partie);
        try (FileWriter file = new FileWriter(Config.PATH_PARTIES)) {

            file.write(saves.toJSONString());
            file.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}