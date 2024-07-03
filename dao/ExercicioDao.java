package dao;
import conection.Conexao;
import entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class ExercicioDao {

    public boolean adiciona(Exercicio p) {

        String sql = "INSERT INTO exercicio (NOMEEXERCICIO,DESCRICAOFOTO,AREA,DATACRIACAOEXERCICIO,DATAMODIFICACAOEXERCICIO) VALUES (?, ?,? , now(),now())";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, p.getNomeExercicio());
        ps.setString(2, p.getDescricaoFoto());
        ps.setString(3, p.getAreaAfetada());
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
        String sql = "SELECT count(1) AS quantidade FROM exercicio";
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

    public List<Exercicio> mostrarTodos() {
        String sql = "SELECT * FROM exercicio";
    
        List<Exercicio> exercicios = new ArrayList<>();
    
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
    
            while (rs.next()) {
                Long id = rs.getLong("idExercicio");
                String nomeExercicio = rs.getString("nomeExercicio");
                String descricaoFoto = rs.getString("descricaoFoto");
                String area = rs.getString("area");
    
                java.sql.Date currentDate = rs.getDate("dataCriacaoExercicio");
                LocalDate dataCriacao = (currentDate != null) ? currentDate.toLocalDate() : null;
    
                java.sql.Date currentDate1 = rs.getDate("dataModificacaoExercicio");
                LocalDate dataModificacao = (currentDate1 != null) ? currentDate1.toLocalDate() : null;
    
                Exercicio exercicio = new Exercicio();
                exercicio.setId(id);
                exercicio.setNomeExercicio(nomeExercicio);
                exercicio.setDescricaoFoto(descricaoFoto);
                exercicio.setAreaAfetada(area);
                exercicio.setDataCriacao(dataCriacao);
                exercicio.setDataModificacao(dataModificacao);
    
                exercicios.add(exercicio);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return exercicios;
    }
   
    public boolean alterarNome(String nomeExercicio, String novoNomeExercicio) {
        
        String sql = "UPDATE exercicio  SET nomeExercicio = ?,dataModificacaoExercicio = now() WHERE nomeExercicio LIKE ?";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, novoNomeExercicio);
        ps.setString(2, nomeExercicio);
        ps.execute();
        ps.close();
        return true;

    }catch (SQLException e)
    {
        e.printStackTrace();
        return false;
    }
    }

    public Exercicio buscaPorNome(String nome) {
        String sql = "SELECT * FROM exercicio WHERE nomeExercicio LIKE ?";
    
        try {
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%"); // Adiciona o wildcard para a busca com LIKE
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) { // Verifica se há resultados
                Long id = rs.getLong("idExercicio");
                String nomeExercicio = rs.getString("nomeExercicio");
                String descricaoFoto = rs.getString("descricaoFoto");
                String area = rs.getString("area");
    
                java.sql.Date currentDate = rs.getDate("dataCriacaoExercicio");
                LocalDate dataCriacao = (currentDate != null) ? currentDate.toLocalDate() : null;
    
                java.sql.Date currentDate1 = rs.getDate("dataModificacaoExercicio");
                LocalDate dataModificacao = (currentDate1 != null) ? currentDate1.toLocalDate() : null;
    
                Exercicio exercicio = new Exercicio();
                exercicio.setId(id);
                exercicio.setNomeExercicio(nomeExercicio);
                exercicio.setDescricaoFoto(descricaoFoto);
                exercicio.setAreaAfetada(area);
                exercicio.setDataCriacao(dataCriacao);
                exercicio.setDataModificacao(dataModificacao);
    
                return exercicio;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remover(String nome) {
        String sql = "DELETE FROM exercicio WHERE nomeExercicio LIKE ?";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            boolean result = ps.execute();
    
            ps.close();
            return result;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
