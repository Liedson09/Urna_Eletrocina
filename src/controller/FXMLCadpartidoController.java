package controller;

import dao.ChapaDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Chapa;
public class FXMLCadpartidoController implements Initializable {

        Chapa chapa;
        ChapaDAO chapaDAO;
    
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtNumero;
        @FXML
    private Button btCadastrar;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtNumero.setOnKeyReleased((KeyEvent e)->{
            if (e.getCode() != KeyCode.BACK_SPACE || KeyCode.DELETE != e.getCode()) {
                if (txtNumero.getLength() >= 2) {
                    txtNumero.setText(txtNumero.getText().substring(0,2));
                }
            }mascaraChapa(e);
        });
        btCadastrar.setOnKeyReleased((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {  
                try {
                    btCadastrar();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    @FXML
    void btCadastrar() throws IOException{
        chapa = new Chapa();
       chapaDAO = new ChapaDAO();
       chapa.setCodigo(Integer.parseInt(txtNumero.getText()));
       chapa.setNome(txtNome.getText());       
       chapaDAO.salavar(chapa);
       txtNome.setText("");
       txtNumero.setText("");
    }
     public void mascaraChapa(KeyEvent e){
            if (e.getCode() != KeyCode.BACK_SPACE || KeyCode.DELETE != e.getCode()) {
                if (txtNumero.getLength() > 2) {
                    txtNumero.setText(txtNumero.getText().substring(0,2));
                }
                    txtNumero.positionCaret(txtNumero.getLength());
            }   
    }
}
