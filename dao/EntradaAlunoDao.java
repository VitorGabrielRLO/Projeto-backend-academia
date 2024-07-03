package dao;
import conection.Conexao;
import entities.EntradaAluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntradaAlunoDao {

    public boolean adiciona(EntradaAluno p) {

        String sql = "INSERT INTO entradaaluno (nome, dataHora) VALUES (?, now())";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, p.getNome());
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
        String sql = "SELECT count(1) AS quantidade FROM entradaaluno";
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

    public List<EntradaAluno> mostrarTodos() {
        String sql = "SELECT * FROM entradaaluno";

        List<EntradaAluno> entradaAlunos = new ArrayList<>();

        try (
                PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String nome = rs.getString("nome");
                    java.sql.Date currentDate = rs.getDate("dataHora");
                    LocalDate dataCriacao = currentDate.toLocalDate();

                    EntradaAluno entradaAluno = new EntradaAluno();
                    entradaAluno.setId(id);
                    entradaAluno.setNome(nome);
                    entradaAluno.setDataHora(dataCriacao);
                    entradaAlunos.add(entradaAluno);
                }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return entradaAlunos;

    }
}
