package dao;
import conection.Conexao;
import entities.TreinoAplicacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class TreinoAplicacaoDao {

    public boolean adiciona(TreinoAplicacao p) {

        String sql = "INSERT INTO treinoaplicacao (treino, exercicio, exercicioaplicacao, divisaoTreino, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, now(), NULL)";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setLong(1, p.getTreino().getId());
        ps.setLong(2, p.getExercicio().getId());
        ps.setLong(3, p.getExercicioAplicacao().getId());
        ps.setLong(4, p.getDivisaoTreino().getId());
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
        String sql = "SELECT count(1) AS quantidade FROM academia";
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

    public List<TreinoAplicacao> mostrarTodos() {
        String sql = "select * from treinoaplicacao";

        List<TreinoAplicacao> treinoAplicacaos = new ArrayList<>();

        try (
                PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String nome = rs.getString("nome");
                    String endereco = rs.getString("endereco");
                    java.sql.Date currentDate = rs.getDate("dataCriacao");
                    LocalDate dataCriacao = currentDate.toLocalDate();

                    TreinoAplicacao treinoAplicacao = new TreinoAplicacao();
                    treinoAplicacao.setId(id);
                    treinoAplicacao.setNome(nome);
                    treinoAplicacao.setEndereco(endereco);
                    treinoAplicacao.setDataCriacao(dataCriacao);
                    treinoAplicacaos.add(treinoAplicacao);
                }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return treinoAplicacaos;

    }
   
    public boolean alterarNome(String nome, String novoNome) {
        
        String sql = "UPDATE academia  SET nome = ? WHERE nome LIKE ?";
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

    Academia buscaPorNome(String nome) {
        // SELECT * FROM academia where nome like 'Leonardo';
        String sql = "SELECT * FROM academia WHERE nome LIKE ?";

        try (
                PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

               
                    Long id = rs.getLong("id");
                    String nomeAcademia = rs.getString("nome");
                    String endereco = rs.getString("endereco");
                    java.sql.Date currentDate = rs.getDate("dataCriacao");
                    LocalDate dataCriacao = currentDate.toLocalDate();

                    Academia academia = new Academia();
                    academia.setNome(nomeAcademia);
                    academia.setEndereco(endereco);
                    academia.setDataCriacao(dataCriacao);
                    return academia;
                
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        

    }

    public boolean remover(String nome) {
        // Delete from academia where id like 3;
        String sql = "DELETE FROM academia WHERE nome LIKE ?";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1,nome);
        boolean result = ps.execute();

        ps.close();
        return result;

    }catch (SQLException e)
    {
        e.printStackTrace();
        return false;
    }
    }

}
