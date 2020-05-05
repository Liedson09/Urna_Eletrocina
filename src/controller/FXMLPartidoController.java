package controller;

import dao.ChapaDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Chapa;
import model.PartidoTable;

/**
 * FXML Controller class
 *
 * @author INF19
 */
public class FXMLPartidoController implements Initializable {
        Chapa chapa;
        ChapaDAO chapaDAO;
        @FXML
        private Button btUpdate;
     @FXML
    private TableColumn<PartidoTable, String> funcao;

    @FXML
    private TableColumn<PartidoTable, Integer> numero;

    @FXML
    private TableColumn<PartidoTable, String> canditado;

    @FXML
    private TableColumn<PartidoTable, String> nome;
     @FXML
    private TableColumn<PartidoTable, Integer> numeroChapa;

    @FXML
    private TableView<PartidoTable> tvChapas;
    @FXML
    private TextField tfNumeroDeletar;
    protected static  PartidoTable dados;

    @FXML
    void btDeletar() throws Exception {
        dados = tvChapas.getSelectionModel().getSelectedItem();
        chapa = new Chapa();
       chapaDAO = new ChapaDAO();
       chapa.setCodigo(tvChapas.getSelectionModel().getSelectedItem().getNumero());
       
       chapaDAO.deletar(chapa);
        tvChapas.setItems(null);
        dao = new ChapaDAO();
        ArrayList<PartidoTable> result = dao.allChapas();
        ObservableList dados = FXCollections.observableArrayList(result);
        tvChapas.setItems(dados);

    }
    protected static  Stage stage;
    @FXML
    public void btUpdate(){
        if (tvChapas.getSelectionModel().isSelected(tvChapas.getSelectionModel().getSelectedIndex())) {
           dados = tvChapas.getSelectionModel().getSelectedItem();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLUpdatePartido.fxml"));
                Scene scene = new Scene(root);
                stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Atualizar");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLPartidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private ChapaDAO dao;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNome()));
        numeroChapa.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNumeroChapa()));
        canditado.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getCanditado()));
        funcao.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getFuncao()));
        numero.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNumero()));
        dao = new ChapaDAO();
        ArrayList<PartidoTable> result = dao.allChapas();
        ObservableList dados = FXCollections.observableArrayList(result);
        tvChapas.setItems(dados);
        tvChapas.setOnMouseClicked((MouseEvent e)->{
            btUpdate.setVisible(true);
        });
    }
    }



