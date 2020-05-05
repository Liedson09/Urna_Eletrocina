
package dao;


import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author INF19
 */
public class Conexao {
       public static Connection abrirConexao(){
           Connection con = null;
           try {
               Class.forName("com.mysql.jdbc.Driver");
               String url = "jdbc:mysql://localhost:3306/urna_db";
               con = DriverManager.getConnection(url, "root", "");
               System.out.println("Conectado com sucesso");
           } catch (Exception e) {
               System.out.println(e.getMessage());
               return null;
           }
           
           return con;
       } 
     
    

}



