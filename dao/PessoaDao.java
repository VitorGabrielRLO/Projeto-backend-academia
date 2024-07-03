package dao;

import conection.Conexao;
import entities.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class PessoaDao {

    public boolean adiciona(Pessoa p) {

        String sql = "INSERT INTO PESSOA (nomePessoa, sexoPessoa, dataNascimento, loginPessoa, senhaPessoa, tipoUsuarioPessoa, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, ?, ?, now(), now())";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, p.getNomePessoa());
        ps.setString(2, p.getSexoPessoa());
        LocalDate data = p.getDataNascimento();
        java.sql.Date date = java.sql.Date.valueOf(data);
        ps.setDate(3, date);
        ps.setString(4, p.getLoginPessoa());
        ps.setString(5, p.getSenhaPessoa());
        ps.setInt(6, p.getTipoUsuarioPessoa());
        ps.execute();
        ps.close();
        return true;

    }catch (SQLException e)
    {
        e.printStackTrace();
        return false;
    }

    }

    public boolean ehVazio() {
        String sql = "SELECT count(1) AS quantidade FROM PESSOA";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.getResultSet();
        
        ps.close();
        if (rs.getInt("quantidade") == 0) {
            rs.close();
            return true;
        }
        else{
            rs.close();
            return false;
        }

    }catch (SQLException e)
    {
        e.printStackTrace();
        return false;
    }
    }

    public List<Pessoa> mostrarTodos() {
        String sql = "SELECT * FROM pessoa";

        List<Pessoa> Pessoas = new ArrayList<>();

        try {
                PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Long id = rs.getLong("idPessoa");
                    String nome = rs.getString("nomePessoa");
                    String sexo = rs.getString("sexoPessoa");
                    java.sql.Date currentDateBorn = rs.getDate("dataNascimento");
                    LocalDate dataNascimento = currentDateBorn.toLocalDate();
                    String login = rs.getString("loginPessoa");
                    String senha = rs.getString("senhaPessoa");
                    int tipoUsuarioPessoa= rs.getInt("tipoUsuarioPessoa");
                    java.sql.Date currentDate = rs.getDate("dataCriacao");
                    LocalDate dataCriacao = currentDate.toLocalDate();
                    java.sql.Date currentDateModify = rs.getDate("dataModificacao");
                    LocalDate dataModificacao = currentDateModify.toLocalDate();

                    Pessoa Pessoa = new Pessoa();
                    Pessoa.setId(id);
                    Pessoa.setNomePessoa(nome);
                    Pessoa.setSexoPessoa(sexo);
                    Pessoa.setDataNascimento(dataNascimento);
                    Pessoa.setLoginPessoa(login);
                    Pessoa.setSenhaPessoa(senha);
                    Pessoa.setTipoUsuarioPessoa(tipoUsuarioPessoa);
                    Pessoa.setDataCriacao(dataCriacao);
                    Pessoa.setDataModificacaoPessoa(dataModificacao);
                    Pessoas.add(Pessoa);
                }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return Pessoas;

    }
   
    public boolean alterarNome(String nome, String novoNome) {
        
        String sql = "UPDATE PESSOA  SET nomePessoa = ?, dataModificacao = now() WHERE nomePessoa LIKE ?";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, novoNome);
        ps.setString(2, nome);
        ps.execute();
        ps.close();
        return true;

    }catch (SQLException e)
    {
        e.printStackTrace();
        return false;
    }
    }

    public Pessoa buscaPorNome(String nome) {
    String sql = "SELECT * FROM pessoa WHERE nomePessoa LIKE ?";

    try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
        stmt.setString(1, nome);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Long id = rs.getLong("idPessoa");
                String nome1 = rs.getString("nomePessoa");
                String sexo = rs.getString("sexoPessoa");
                java.sql.Date currentDateBorn = rs.getDate("dataNascimento");
                LocalDate dataNascimento = currentDateBorn.toLocalDate();
                String login = rs.getString("loginPessoa");
                String senha = rs.getString("senhaPessoa");
                int tipoUsuarioPessoa = rs.getInt("tipoUsuarioPessoa");
                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                java.sql.Date currentDateModify = rs.getDate("dataModificacao");
                LocalDate dataModificacao = currentDateModify.toLocalDate();

                Pessoa pessoa = new Pessoa();
                pessoa.setId(id);
                pessoa.setNomePessoa(nome1);
                pessoa.setSexoPessoa(sexo);
                pessoa.setDataNascimento(dataNascimento);
                pessoa.setLoginPessoa(login);
                pessoa.setSenhaPessoa(senha);
                pessoa.setTipoUsuarioPessoa(tipoUsuarioPessoa);
                pessoa.setDataCriacao(dataCriacao);
                pessoa.setDataModificacaoPessoa(dataModificacao);
                return pessoa;
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return null; // return null if no matching record is found
}

public boolean remover(String nome) {
    String sql = "DELETE FROM PESSOA WHERE nomePessoa LIKE ?";
    PreparedStatement ps = null;
    try {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, nome);
        int linhasAfetadas = ps.executeUpdate(); // Use executeUpdate() para operações de DELETE
        ps.close();
        return linhasAfetadas > 0; // Retorna true se pelo menos uma linha foi deletada
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    public Pessoa buscaLogin(String login){
        String sql = "select * from PESSOA";

        List<Pessoa> Pessoas = new ArrayList<>();
        try{
        PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
            
                while (rs.next()) {
                    Long id = rs.getLong("idPessoa");
                    String nome = rs.getString("nomePessoa");
                    String sexo = rs.getString("sexoPessoa");
                    java.sql.Date currentDateBorn = rs.getDate("dataNascimento");
                    LocalDate dataNascimento = currentDateBorn.toLocalDate();
                    String login3 = rs.getString("loginPessoa");
                    String senha = rs.getString("senhaPessoa");
                    int tipoUsuarioPessoa= rs.getInt("tipoUsuarioPessoa");
                    java.sql.Date currentDate = rs.getDate("dataCriacao");
                    LocalDate dataCriacao = currentDate.toLocalDate();
                    java.sql.Date currentDateModify = rs.getDate("dataModificacao");
                    LocalDate dataModificacao = currentDateModify.toLocalDate();

                    Pessoa Pessoa = new Pessoa();
                    Pessoa.setId(id);
                    Pessoa.setNomePessoa(nome);
                    Pessoa.setSexoPessoa(sexo);
                    Pessoa.setDataNascimento(dataNascimento);
                    Pessoa.setLoginPessoa(login3);
                    Pessoa.setSenhaPessoa(senha);
                    Pessoa.setTipoUsuarioPessoa(tipoUsuarioPessoa);
                    Pessoa.setDataCriacao(dataCriacao);
                    Pessoa.setDataModificacaoPessoa(dataModificacao);
                    Pessoas.add(Pessoa);
                }
        }catch (SQLException e) {
             throw new RuntimeException(e);

        }
        for(Pessoa pessoa : Pessoas){
            if (pessoa.getLoginPessoa().equals(login) ) {
                return pessoa;   
            }
        }
        return null;
    }

    public void mostrarTodasPessoas() {
        List<Pessoa> pagamentos = mostrarTodos();
        for (Pessoa pagamento : pagamentos) {
            System.out.println(pagamento);
        }
    }
}