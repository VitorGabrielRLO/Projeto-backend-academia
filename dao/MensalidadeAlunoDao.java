package dao;
import conection.Conexao;
import entities.MensalidadeAluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class MensalidadeAlunoDao {
     public boolean adiciona(MensalidadeAluno p) {

        String sql = "INSERT INTO MENSALIDADEALUNO (PLANO,VALOR,DESCRICAO,DATACRIACAOMENSALIDADEALUNO,DATAMODIFICACAOMENSALIDADEALUNO) VALUES (?, ?, ?, now(),now())";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, p.getPlano());
        ps.setDouble(2, p.getValor());
        ps.setString(3, p.getDescricao());
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
        String sql = "SELECT count(1) AS quantidade FROM MENSALIDADEALUNO";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
    
            if (rs.next()) {
                int quantidade = rs.getInt("quantidade");
                return quantidade == 0;
            }
            return true; // Caso o ResultSet esteja vazio, retorna true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<MensalidadeAluno> mostrarTodos() {
        String sql = "SELECT * FROM mensalidadealuno";
        List<MensalidadeAluno> MensalidadeAlunos = new ArrayList<>();
    
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                Long id = rs.getLong("idMensalidadeAluno");
                String plano = rs.getString("plano");
                Double valor = rs.getDouble("valor");
                String descricao = rs.getString("descricao");
                LocalDate dataCriacao = rs.getDate("dataCriacaoMensalidadeAluno").toLocalDate();
                LocalDate dataModificacao = rs.getDate("dataModificacaoMensalidadeAluno").toLocalDate();
    
                MensalidadeAluno mensalidadeAluno = new MensalidadeAluno();
                mensalidadeAluno.setId(id);
                mensalidadeAluno.setPlano(plano);
                mensalidadeAluno.setValor(valor);
                mensalidadeAluno.setDescricao(descricao);
                mensalidadeAluno.setDataCriacao(dataCriacao);
                mensalidadeAluno.setDataModificacao(dataModificacao);
                MensalidadeAlunos.add(mensalidadeAluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return MensalidadeAlunos;
    }
    
   
    public boolean alterarValor(Long id, Double novoValor,String novoPlano) {
        
        String sql = "UPDATE MENSALIDADEALUNO  SET valor = ?,plano = ? WHERE idMensalidadeAluno LIKE ?";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setDouble(1, novoValor);
        ps.setString(2, novoPlano);
        ps.setLong(3, id);
        ps.execute();
        ps.close();
        return true;

    }catch (SQLException e)
    {
        e.printStackTrace();
        return false;
    }
    }

    public MensalidadeAluno buscaPorId(Long id) {
        String sql = "SELECT * FROM MENSALIDADEALUNO WHERE idMensalidadeAluno = ?";
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String plano = rs.getString("plano");
                    Double valor = rs.getDouble("valor");
                    String descricao = rs.getString("descricao");
                    LocalDate dataCriacao = rs.getDate("dataCriacaoMensalidadeAluno").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacaoMensalidadeAluno").toLocalDate();
    
                    MensalidadeAluno mensalidadeAluno = new MensalidadeAluno();
                    mensalidadeAluno.setId(id);
                    mensalidadeAluno.setPlano(plano);
                    mensalidadeAluno.setValor(valor);
                    mensalidadeAluno.setDescricao(descricao);
                    mensalidadeAluno.setDataCriacao(dataCriacao);
                    mensalidadeAluno.setDataModificacao(dataModificacao);
                    return mensalidadeAluno;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se não encontrar nenhum plano com o ID especificado
    }
    

    public boolean remover(Long id) {
        String sql = "DELETE FROM MENSALIDADEALUNO WHERE idMensalidadeAluno LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setLong(1, id);
            int result = ps.executeUpdate();
            return result > 0; // Retorna true se ao menos uma linha foi afetada
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
