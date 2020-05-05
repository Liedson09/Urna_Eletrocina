/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author INF19
 */
public class Principal extends Application {
    public static Stage stage;
    public static Stage voto;
    public static Scene sceneVoto;
    public static Scene sceneTelaVoto;
    public static Scene sceneApuracao;
    public static Scene sceneLogin;
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent telaVoto = FXMLLoader.load(getClass().getResource("/view/FXMLTeladeVotacao.fxml"));
        Parent urna = FXMLLoader.load(getClass().getResource("FXMLFim.fxml"));
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
        Parent login = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        //Parent apuracao = FXMLLoader.load(getClass().getResource("FXMLApuracao.fxml"));
        Scene scene = new Scene(tela);
        sceneLogin = new Scene(login);
        sceneVoto = new Scene(urna);
        sceneTelaVoto = new Scene(telaVoto);
        //sceneApuracao = new Scene(apuracao);
        primaryStage.setTitle("Tela de Login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        stage = primaryStage;
        primaryStage.show();
        
        
        criarPalco();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private static void criarPalco() {        
        voto = new Stage();
        voto.setScene(sceneVoto);
        voto.setTitle("Tela de Votação");
        voto.setResizable(false);        
        voto.show();
        
    }
    
    public static void trocaVoto(){        
        voto.setScene(sceneTelaVoto);
        
    }
    
    public static void trocaVotoFim(){        
        voto.setScene(sceneVoto);        
    }
    
    public static void trocaApuracao(){        
        stage.setScene(sceneApuracao);
    }
    public static void sceneLogin(){
        stage.setScene(sceneLogin);
    }
    
    
}
