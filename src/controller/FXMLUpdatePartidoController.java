/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChapaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.PartidoTable;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class FXMLUpdatePartidoController implements Initializable {
private PartidoTable dados;
private ChapaDAO dao;
      @FXML
    private TextField codigo;

    @FXML
    private TextField nome;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      dados = FXMLPartidoController.dados;
      codigo.setText(String.valueOf(dados.getNumeroChapa()));
      nome.setText(dados.getNome());
    }

    @FXML
    void atualizar(ActionEvent event) {
        dao = new ChapaDAO();
        boolean result = dao.updateChapa(Integer.parseInt(codigo.getText()), nome.getText());
        if (result) {
            JOptionPane.showMessageDialog(null, "Chapa editada com sucesso!");
            FXMLPartidoController.stage.close();
        }else{
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }

}
