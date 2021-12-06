package DAO;

import Model.Cliente;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {

    public static ArrayList<Cliente> MinhaLista = new ArrayList<Cliente>();

    public ClienteDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_clientes");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();
        } catch (SQLException ex) {

            return maiorID;
        }

    
    public Connection getConexao () {
        Connection connection = null; //instância da conexão
        try {
// Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
// Configurar a conexão
            String server = "localhost"; //caminho do MySQL
            String database = "db_supermercado";
            String url = "jdbc:mysql://" + server + ":3306/" + database
                    + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "";

// Conectando..
            connection = DriverManager.getConnection(url, user, password);
// Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;
        } catch (ClassNotFoundException e) { //Driver não encontrado
            System.out.println("O driver nao foi encontrado.");
            return null;
        }
    }

    // Retorna a Lista de Cliente(objetos)
    public ArrayList<Cliente> getMinhaLista() {

        MinhaLista.clear(); // Limpa nosso ArrayList
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_clientes");
            while (res.next()) {
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                int id = res.getInt("id");
                String rg = res.getString("rg");
                String endereco = res.getString("endereco");
                Date datadenascimento = res.getDate("datadenascimento");
                String email = res.getString("email");

                Cliente objeto = new Cliente(nome, cpf, id, rg, endereco, datadenascimento, email);
                MinhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex) {
        }
        return MinhaLista;
    }
    // Cadastra novo aluno

    public boolean InsertClienteBD(Cliente objeto) {
        String sql = "INSERT INTO tb_clientes(id,nome,cpf,rg,endereco,datadenascimento,email, VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getCpf());
            stmt.setString(4, objeto.getRg());
            stmt.setString(5, objeto.getEndereco());
            stmt.setString(6, objeto.getDatadenascimento());
            stmt.setString(7, objeto.getEmail());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteClienteBD(int id) {
        try {
            java.sql.Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_clientes WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateClienteBD(Cliente objeto) {

        String sql = "UPDATE tb_clientes set nome = ? ,cpf = ? ,rg = ? ,endereco = ?,datadenascimento =?,email =? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getCpf());
            stmt.setString(4, objeto.getRg());
            stmt.setString(5, objeto.getEndereco());
            stmt.setString(6, objeto.getDatadenascimento());
            stmt.setString(7, objeto.getEmail());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Cliente carregaCliente(int id) {

        Cliente objeto = new Cliente();
        objeto.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * id FROM tb_clientes WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setCpf(res.getString("cpf"));
            objeto.setRg(res.getString("rg"));
            objeto.setEndereco(res.getString("endereco"));
            objeto.setDatadeNascimento(res.getDate("datadenascimento"));
            objeto.setEmail(res.getString("email"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;

    }

}
