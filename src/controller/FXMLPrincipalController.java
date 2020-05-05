package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Principal;
import static view.Principal.stage;

/**
 * FXML Controller class
 *
 * @author INF19
 */
public class FXMLPrincipalController implements Initializable {

     @FXML
    void miSair() {
        stage.close();
    }
    @FXML
    void btChapa() throws IOException {
       Parent partidos = FXMLLoader.load(getClass().getResource("/view/FXMLPartido.fxml"));
       Scene scene = new Scene(partidos);
           stage = new Stage();
           stage.setScene(scene);
            stage.setTitle("Candidatos");
           stage.show();
   }
    @FXML
    void btMostrarChapa() throws IOException {
       Parent mostrarchapa = FXMLLoader.load(getClass().getResource("/view/Chapas.fxml"));
       Scene scene = new Scene(mostrarchapa);
       stage = new Stage();
      stage.setScene(scene);
        stage.setTitle("Chapas");
        stage.show();
    }

       @FXML
    void MiCadastrar() throws IOException {
        Parent cadpartidos = FXMLLoader.load(getClass().getResource("/view/FXMLCadpartido.fxml"));
        Scene scene = new Scene(cadpartidos);
        stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Cadastro de Chapa"); 
            stage.show();
    } 
    @FXML
    void btUrna() throws IOException {
        Principal.trocaVoto();
        /*Parent urna = FXMLLoader.load(getClass().getResource("/view/FXMLTeladeVotacao.fxml"));
        Scene scene = new Scene(urna);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Tela de Votação");
        stage.show();*/
    }

    @FXML
    void btCandidato() throws IOException {
        Principal.sceneLogin();
       // Principal.trocaApuracao();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
