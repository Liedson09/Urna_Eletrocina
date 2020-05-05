/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.ChapaDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.PartidoTable;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class ChapasController implements Initializable {
  @FXML
    private TableColumn<PartidoTable, Integer> numeroChapa;

    @FXML
    private TextField tfNumeroDeletar;

    @FXML
    private TableView<PartidoTable> tvMostrarChapa;

    @FXML
    private TableColumn<PartidoTable, String> nome;
    @FXML
    private Button delete;

    @FXML
    void btDeletar(ActionEvent event) {
        PartidoTable dados = tvMostrarChapa.getSelectionModel().getSelectedItem();
        chapaDAO = new ChapaDAO();
      try {
          System.out.println(dados.getNumeroChapa());
          chapaDAO.deletar(dados.getNumeroChapa());
          tvMostrarChapa.getItems().remove(0, tvMostrarChapa.getItems().size());
            chapaDAO = new ChapaDAO();
            ArrayList<PartidoTable> result = chapaDAO.todas();
            ObservableList dadoss = FXCollections.observableArrayList(result);
            tvMostrarChapa.setItems(dadoss);
          
      } catch (Exception ex) {
          Logger.getLogger(ChapasController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    /**
     * Initializes the controller class.
     */
    private ChapaDAO chapaDAO;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNome()));
        numeroChapa.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNumeroChapa()));
        chapaDAO = new ChapaDAO();
        ArrayList<PartidoTable> result = chapaDAO.todas();
        ObservableList dados = FXCollections.observableArrayList(result);
        tvMostrarChapa.setItems(dados);
        tvMostrarChapa.setOnMouseClicked((MouseEvent)->{
            delete.setVisible(true);
        });
        }; 
    
}
