package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Apuracao;
import model.Chapa;
import model.Voto;

/**
 *
 * @author Aluno
 */
public class VotoDAO {
    Connection con = null;
    public VotoDAO() {
        con = Conexao.abrirConexao();        
    }
    public boolean salvar(String nome){
        Chapa chapa = new Chapa();
       try {
            String sql = "INSERT INTO v(nome) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, nome);
            if(ps.executeUpdate() > 0){                
                con.close();
                 return true;
            }
        } catch (Exception e) {
        }
       return true;
    }
    public Chapa listar(int numero){        
        Chapa chapa = new Chapa();
        try {
            try (
                Connection con = Conexao.abrirConexao()) {
                String sql = "SELECT NOME FROM chapa WHERE NUMERO = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, numero);
                ResultSet rs =  ps.executeQuery();                
                     while(rs.next()){   
                            chapa.setNome(rs.getString("nome"));                         
                          System.out.println(chapa.getNome());
                          return chapa;
                        }
                
                chapa.setNome("NULO");
                return chapa;
               
               
            }            
        } catch (Exception e) {
            return chapa;
        }    
    }
    public ArrayList<Apuracao> getResult(Chapa chapa){
        if(Chapa.size() ){
             ArrayList<Apuracao> result = new ArrayList<>();
            
             {
                 String sql = "select count(total) as total, AS NOME FROM CHAPA WHERE NOME = ?";
                 try {
                     PreparedStatement ps = con.prepareStatement(sql);
                     ps.setInt(1, codigo());
                     ResultSet rs = ps.executeQuery();
                     while(rs.next()){
                         Voto votos = new Voto();
                         System.out.println(rs.getString("total"));
                         votos.setVoto(rs.getInt("total"));
                         Apuracao apuracao = new Apuracao();
                         apuracao.setVoto(votos);
                         result.add(apuracao);
                     }
                 } catch (SQLException ex) {
                     Logger.getLogger(VotoDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
            return result;
        }
        return null;
    }
    
    public boolean branco(int quantidade){
        Connection con = Conexao.abrirConexao();
        PreparedStatement stmt;
        String sql = "UPDATE CHAPA SET TOTAL = ? where numero = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            System.out.println("entra");
            quantidade++;
            stmt.setInt(1, quantidade);
            stmt.setInt(2, 2);
            stmt.executeUpdate();
        }catch(SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    
    
    public void teste(){   
       
       
        
       
        try {
                      
            
            String nome = "ISRAEL";
            String sql = "SELECT COUNT(NOME) AS NOME FROM V WHERE NOME = ?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, nome);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){   
                    System.out.println(rs.getString("NOME"));                        
                     
              }
        } catch (Exception e) {
        }
    
    }

    private int codigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

