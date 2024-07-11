package dao;

import conection.Conexao;
import entities.ExercicioAplicacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExercicioAplicacaoDao {

    public boolean adiciona(ExercicioAplicacao p) {
        String sql = "INSERT INTO ExercicioAplicacao (descricao, dataCriacaoExercicioAplicacao, dataModificacaoExercicioAplicacao) VALUES (?, now(), now())";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, p.getDescricao());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ehVazio() {
        String sql = "SELECT COUNT(*) AS quantidade FROM ExercicioAplicacao";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int quantidade = rs.getInt("quantidade");
                return quantidade == 0;
            }
            return true; // Retorna true se o ResultSet está vazio
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ExercicioAplicacao> mostrarTodos() {
        String sql = "SELECT * FROM ExercicioAplicacao";
        List<ExercicioAplicacao> exercicioAplicacaos = new ArrayList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Long id = rs.getLong("idExercicioAplicacao");
                String descricao = rs.getString("descricao");
                LocalDate dataCriacao = rs.getDate("dataCriacaoExercicioAplicacao").toLocalDate();
                LocalDate dataModificacao = rs.getDate("dataModificacaoExercicioAplicacao").toLocalDate();

                ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao();
                exercicioAplicacao.setId(id);
                exercicioAplicacao.setDescricao(descricao);
                exercicioAplicacao.setDataCriacao(dataCriacao);
                exercicioAplicacao.setDataModificacao(dataModificacao);
                exercicioAplicacaos.add(exercicioAplicacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os exercícios aplicação", e);
        }
        return exercicioAplicacaos;
    }

    public boolean remover(long id) {
        String sql = "DELETE FROM ExercicioAplicacao WHERE idExercicioAplicacao = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setLong(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterarDescricao(long id, String descricaoNovo) {
        String sql = "UPDATE ExercicioAplicacao SET descricao = ?, dataModificacaoExercicioAplicacao = now() WHERE idExercicioAplicacao = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, descricaoNovo);
            ps.setLong(2, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ExercicioAplicacao buscaPorId(Long idBuscado) {
    String sql = "SELECT * FROM exercicioaplicacao WHERE idExercicioaplicacao LIKE ?";

    try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
        stmt.setLong(1, idBuscado);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Long id = rs.getLong("idExercicioAplicacao");
                String descricao = rs.getString("descricao");
                LocalDate dataCriacao = rs.getDate("dataCriacaoExercicioAplicacao").toLocalDate();
                LocalDate dataModificacao = rs.getDate("dataModificacaoExercicioAplicacao").toLocalDate();

                ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao();
                exercicioAplicacao.setId(id);
                exercicioAplicacao.setDescricao(descricao);
                exercicioAplicacao.setDataCriacao(dataCriacao);
                exercicioAplicacao.setDataModificacao(dataModificacao);
                return exercicioAplicacao;
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return null; // return null if no matching record is found
}
}
