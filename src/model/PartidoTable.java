/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author INF19
 */
public class PartidoTable {
    private String nome, canditado, funcao;
    private int numero, numeroChapa;

    public int getNumeroChapa() {
        return numeroChapa;
    }

    public void setNumeroChapa(int numeroChapa) {
        this.numeroChapa = numeroChapa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCanditado() {
        return canditado;
    }

    public void setCanditado(String canditado) {
        this.canditado = canditado;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
