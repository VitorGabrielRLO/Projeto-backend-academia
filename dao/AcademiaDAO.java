package dao;

import conection.Conexao;
import entities.Academia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// import com.mysql.cj.x.protobuf.MysqlxCrud.*;


// import entities.Exercicio;

public class AcademiaDAO {


    public boolean adiciona(Academia p) {

        String sql = "INSERT INTO ACADEMIA (NOME,ENDERECO,DATACRIACAO,DATAMODIFICACAO) VALUES (?, ?, now(),now())";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getEndereco());
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

    public List<Academia> mostrarTodos() {
        String sql = "SELECT * FROM academia";
    
        List<Academia> academias = new ArrayList<>();
    
        try (
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = (currentDate != null) ? currentDate.toLocalDate() : null;
                java.sql.Date currentDate1 = rs.getDate("dataModificacao");
                LocalDate dataModificacao = (currentDate1 != null) ? currentDate1.toLocalDate() : null;
    
                Academia academia = new Academia();
                academia.setId(id);
                academia.setNome(nome);
                academia.setEndereco(endereco);
                academia.setDataCriacao(dataCriacao);
                academia.setDataModificacao(dataModificacao);
    
                academias.add(academia);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todas as academias", e);
        }
    
        return academias;
    }
    
   
    public boolean alterarNome(String nome, String novoNome) {
        
        String sql = "UPDATE academia  SET nome = ? ,dataModificacao = now() WHERE nome LIKE ?";
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

    public Academia buscaPorId(long id) {
        String sql = "SELECT * FROM academia WHERE id = ?";
    
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                String nomeAcademia = rs.getString("nome");
                String endereco = rs.getString("endereco");
                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                java.sql.Date currentDate1 = rs.getDate("dataModificacao");
                LocalDate dataModificacao = currentDate1.toLocalDate();
    
                Academia academia = new Academia();
                academia.setId(id);
                academia.setNome(nomeAcademia);
                academia.setEndereco(endereco);
                academia.setDataCriacao(dataCriacao);
                academia.setDataModificacao(dataModificacao);
    
                return academia;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
        return null; // Retorna null se não encontrar a academia com o ID especificado
    }
    
    public boolean remover(String nome) {
        String sql = "DELETE FROM academia WHERE nome = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, nome);
            int rowsAffected = ps.executeUpdate(); // Usamos executeUpdate para DELETE
    
            return rowsAffected > 0; // Retorna true se houver linhas afetadas
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void mostrarTodasAcademias() {
        List<Academia> pagamentos = mostrarTodos();
        for (Academia pagamento : pagamentos) {
            System.out.println(pagamento);
        }
    }


}

