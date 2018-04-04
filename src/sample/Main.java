package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        //for 1 file only
        /*WordReader readerForSingleFile=new WordReader("tau-list_motywacyjny.txt");
        ArrayList<String> wordsSingle=readerForSingleFile.getWords();
        Dictionary slownik=new Dictionary(wordsSingle);
        slownik.printValues();*/

        //for artist
        String artist="stachursky";
        WordReader readerForTau= new WordReader(new Artist(artist));     //madnatory
        ArrayList<String> words=readerForTau.getWords();
        Dictionary tauDict=new Dictionary(words,artist);
        tauDict.printValues();
}


    public static void main(String[] args) {
        launch(args);
    }
}
