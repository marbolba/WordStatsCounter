package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

        //testing reader
        WordReader readerForTau=new WordReader("tau_list_motywacyjny.txt");
        ArrayList<String> words=readerForTau.getWords();
        Dictionary slownik=new Dictionary();
        for(String w:words)
        {
            slownik.addWord(w);
        }
        slownik.printValues();

}


    public static void main(String[] args) {
        launch(args);
    }
}
