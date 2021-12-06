/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class Cliente {
    
//Atributos
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private Date datanascimento;
    private String email;
    private String senha;
    private final ClienteDAO dao;

    public Cliente() {
        this.dao = new ClienteDAO(); //inicializado não importa em qual construtor
    }
    
    //metodo construtor
    public Cliente(int id, String nome, String cpf, String rg, String endereco, Date datanascimento, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.datanascimento = datanascimento;
        this.email = email;
        this.senha = senha;
        this.dao = new ClienteDAO();
    }

    public Cliente(String nome, String cpf, int id, String rg, String endereco, Date datadenascimento, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cliente(String nome, String cpf, int id, String cpf0, String rg, String endereco, String datadenascimento, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cliente(String nome, String cpf, int id, String cpf0, String rg, String endereco, Date datadenascimento, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //metodos get e set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // Override necess�rio para poder retornar os dados de Pessoa no toString para aluno.
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Cpf: " + this.getCpf()
                + "\n RG: " + this.getRg()
                + "\n Endereco:" + this.getEndereco()
                + "\n DatadeNascimento:" + this.getDatadenascimento()
                + "\n Email:" + this.getEmail()
                + "\n -----------";
    }

   // ABAIXO OS M
    //�TODOS PARA USO JUNTO COM O DAO

    
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    // Cadastra novo aluno
    public boolean InsertClienteBD(Cliente objeto) {
        dao.InsertClienteBD(objeto);
        return true;
    }

    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteClienteBD(int id) {
        dao.DeleteClienteBD(id);
        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateClienteBD(Cliente objeto) {
        dao.UpdateClienteBD(objeto);
        return true;
    }

    // carrega dados de um aluno espec�fico pelo seu ID
    public Cliente carregaCliente(int id) {
        dao.carregaCliente(id);
        return null;
    }

    // retorna o maior ID da nossa base de dados
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }

    public void setDatadeNascimento(java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDatadenascimento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}