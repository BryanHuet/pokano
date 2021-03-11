package src.view;

import src.data.Config;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.*; //Text, TextAlignment, Font
import javafx.scene.paint.Color;
import javafx.geometry.*; //Insets, Pos

public class Credits extends VBox {

    private static Text text, textDate;
    private static Label labelSignature;

    public Credits(String titre){
        text = new Text("Projet Méthodes de Conception\n" + titre);
        setMargin(text, new Insets(10));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font("Verdana", 30));
        text.setFill(Color.web(Config.COLOR_TEXT));
        
        String bHuet = "Bryan HUET - 21701042";
        String mAcuna = "Mithian ACUNA - 21805281";
        String aBournonville = "Aurélien BOURNONVILLE - 21802829";
        String mTani = "Matteo TANI - 21807118";
        labelSignature = new Label(bHuet + "\n" + mAcuna + "\n" + aBournonville + "\n" + mTani);
        setMargin(labelSignature, new Insets(10));
        labelSignature.setTextAlignment(TextAlignment.CENTER);
        labelSignature.setTextFill(Color.web(Config.COLOR_TEXT));
        
        textDate = new Text("L3 Info 2020/2021 - Université de Caen");
        setMargin(textDate, new Insets(10));
        textDate.setFont(Font.font("Verdana", null, FontPosture.ITALIC, 11));
        textDate.setFill(Color.web(Config.COLOR_TEXT));

        this.getChildren().addAll(text, labelSignature, textDate);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: " + Config.COLOR_INTERFACE + ";");
    }

    public static void styleMisAJour(){
        text.setFill(Color.web(Config.COLOR_TEXT));
        labelSignature.setTextFill(Color.web(Config.COLOR_TEXT));
        textDate.setFill(Color.web(Config.COLOR_TEXT));
    }
}
