package controller;

import java.io.*;
import javazoom.jl.player.*;
import dao.Conexao;
import dao.VotoDAO;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Chapa;
import view.Principal;


public class FXMLTeladeVotacaoController implements Initializable {   
    
    @FXML    
    private Label nome;
    @FXML
    private Pane pane;
    @FXML
    private TextField c1;
    @FXML
    private TextField c2;    
    String n1;
    String n2;
    String total;
    
    int branco = 0;
               
    public void initialize(URL url, ResourceBundle rb) {
        //Click no primeiro campo
        c1.requestFocus(); 
        c1.setOnKeyReleased((KeyEvent e) ->{ 
            if (e.getCode() == KeyCode.DECIMAL) {
                        limpar();
                        c1.setText("0");
                         c2.setText("0");
                            nome.setText("BRANCO");
                         
                         n1 = c1.getText();
                         n2 = (c2.getText() + "2");
                         total = (n1 + n2);
                         
            }
            
            if (c1.getLength() > 0) {
                    n1 = c1.getText();
                    c2.requestFocus();
            }
            
        });
        //Click no segundo campo
        c2.setOnKeyReleased((KeyEvent e) ->{
                    c2.setText(c2.getText().replace(",",""));
                    System.out.println(e.getCode());
                    c2.positionCaret(c2.getLength());
            if (c2.getLength() > 0) {
                    n2 = c2.getText();                    
            }
             total = n1 + n2;
            try {
                if(e.getCode() == KeyCode.BACK_SPACE/* || e.getCode() == KeyCode.DECIMAL*/){
                   limpar();
                   c1.requestFocus();
                }
                if(e.getCode() != KeyCode.BACK_SPACE/* || e.getCode() == KeyCode.DECIMAL*/) {
                    if(!total.equals("00")){
                    listar();
                    }
                }
                 if(e.getCode() == KeyCode.ENTER){                     
                   if(votar()){
                       limpar();
                       som();
                       Principal.trocaVotoFim();
                       c1.requestFocus();
                   } else{
                        System.out.println("não votou");
                   }                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLTeladeVotacaoController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        });
        pane.setOnKeyReleased((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                
            }else if(e.getCode() == KeyCode.BACK_SPACE){
                nome.setText("");
                c1.setText("");
                c2.setText("");
                c1.requestFocus();
            }
        });
    }
    
    
    public boolean votar(){
        VotoDAO dao = new VotoDAO();
        return dao.salvar(nome.getText());
    }
    public void limpar(){
        c1.setText("");
        c2.setText("");
        nome.setText("");
    }
    public void listar() throws SQLException{
       
        VotoDAO dao = new VotoDAO();
        Chapa chapa = new Chapa();        
        chapa = dao.listar(Integer.parseInt(total));
        c2.positionCaret(c2.getLength());
        nome.setText(chapa.getNome());
        
        
        
    }
    public boolean branco(){
        VotoDAO dao = new VotoDAO();
        Connection con = Conexao.abrirConexao();
        try {
                    int totalBranco = 0;
                    String sqlBranco = "SELECT TOTAL FROM CHAPA WHERE NUMERO = 2";            
                    PreparedStatement psBranco = con.prepareStatement(sqlBranco);
                    ResultSet rsBranco = psBranco.executeQuery();
                    if(rsBranco.next()){
                        totalBranco = rsBranco.getInt("TOTAL");
                        totalBranco++;
                        try {
                            String atualizar = "UPDATE CHAPA SET TOTAL = ? WHERE NUMERO = 2";
                            PreparedStatement ps1 = con.prepareStatement(atualizar);
                            ps1.setInt(1, totalBranco);
                            ps1.executeUpdate();
                            return true;
                        } catch (Exception e) {
                            return false;
                        }
                }
             } catch (Exception e) {
             }
        
        return false;   
    }
    public void som(){
        System.out.println("Chamou o som");
        try {
            File file = new File("src/util/som.mp3");
            FileInputStream fs = new FileInputStream(file);
            BufferedInputStream bf = new BufferedInputStream(fs);
            try {
                Player player = new Player(bf);
                player.play();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
}    

