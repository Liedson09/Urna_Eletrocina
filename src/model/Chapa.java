
package model;

public class Chapa {

    public static boolean size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int codigo;
    private String nome;
    private int total;
    

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    

    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }
    
    
    
    
    
}
