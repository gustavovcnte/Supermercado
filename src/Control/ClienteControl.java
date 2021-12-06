package Control;

import Model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ClienteControl {

    private final Cliente control;

    public ClienteControl() {
        this.control = new Cliente(); // Veja que control � um objeto vazio de Aluno
    }

    

    // Create 
    public boolean Cadastrar(String nome, String cpf, String rg, String endereco, Date datadenascimento, String email) throws SQLException {

        // AlunoControl recebe os dados da VIEW, cria um objeto COMPLETO e manda este objeto para aluno para inserir em (DAO)
        // Aluno CONTROL N�O DEVE ACESSAR DAO DIRETAMENTE. L� em aluno deve ter uma fun��o que acessa DAO para inserir. InsertAlunoBD()
        
        int id = control.maiorID() + 1; 
        Cliente objeto = new Cliente(nome, cpf, id, cpf, rg, endereco, datadenascimento, email);
        return control.InsertClienteBD(objeto);
    }

    // Update
    public boolean Editar(String nome, String cpf, int id, String rg, String endereco, Date datadenascimento, String email) {
        Cliente objeto = new Cliente(nome, cpf, id, rg, endereco, datadenascimento, email);
        return control.UpdateClienteBD(objeto);
    }

    // Delete
    public boolean Apagar(int id) {
        return control.DeleteClienteBD(id);
    }

    // Read
    public Cliente LoadCliente(int id) {
        // procurar o aluno com este id e retornar um objeto com TODOS OS DADOS.
        return control.carregaCliente(id);
    }

    // Read
    public ArrayList getMinhaLista() {
        return control.getMinhaLista();
    }
    
    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {
        
        ArrayList<Cliente> minhalista = control.getMinhaLista();
        int tamanho = minhalista.size();
        
        String MatrizCliente[][] = new String[tamanho][6];
        for (int i = 0; i < tamanho; i++) {
            MatrizCliente[i][0] = minhalista.get(i).getId() + "";
            MatrizCliente[i][1] = minhalista.get(i).getNome() + "";
            MatrizCliente[i][2] = minhalista.get(i).getCpf() + "";
            MatrizCliente[i][3] = minhalista.get(i).getRg() + "";
            MatrizCliente[i][4] = minhalista.get(i).getEndereco() + "";
            MatrizCliente[i][5] = minhalista.get(i).getDatadenascimento() + "";
            MatrizCliente[i][6] = minhalista.get(i).getEmail() + "";
        }        
        
        return MatrizCliente;        
    }

    public boolean Cadastrar(String nome, String cpf, String rg, String endereco, String datadenascimento, String email) throws SQLException {
         int id = control.maiorID() + 1; 
        Cliente objeto = new Cliente(nome, cpf, id, cpf, rg, endereco, datadenascimento, email);
        return control.InsertClienteBD(objeto);
    }
}
    
