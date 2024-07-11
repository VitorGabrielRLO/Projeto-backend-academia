package dao;

import conection.Conexao;
import entities.Exercicio;
import entities.ExercicioAplicacao;
import entities.Treino;
import entities.TreinoAplicacao;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinoAplicacaoDao {

    public boolean adiciona(TreinoAplicacao p) {
        String sql = "INSERT INTO treinoaplicacao (treino, exercicio, exercicioaplicacao, dataCriacaoTreinoAplicacao, dataModificacaoTreinoAplicacao) VALUES (?, ?, ?, now(), now())";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setLong(1, p.getTreino().getId());
            ps.setLong(2, p.getExercicio().getId());
            ps.setLong(3, p.getExercicioAplicacao().getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ehVazio() {
        String sql = "SELECT count(1) AS quantidade FROM treinoaplicacao";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("quantidade") == 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TreinoAplicacao> mostrarTodos() {
        String sql = "SELECT " +
                "ta.idTreinoAplicacao, " +
                "t.dataInicio, " +
                "t.dataTermino, " +
                "e.nomeExercicio, " +
                "ea.descricao " +
                "FROM treinoaplicacao ta " +
                "LEFT JOIN treino t ON ta.treino = t.idTreino " +
                "LEFT JOIN exercicio e ON ta.exercicio = e.idExercicio " +
                "LEFT JOIN exercicioaplicacao ea ON ta.exercicioaplicacao = ea.idExercicioAplicacao " ;
    
        List<TreinoAplicacao> treinoAplicacaos = new ArrayList<>();
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                TreinoAplicacao treinoAplicacao = new TreinoAplicacao();
    
                treinoAplicacao.setId(rs.getLong("idTreinoAplicacao"));
    
                Treino treino = new Treino();
                treino.setDataInicio(rs.getDate("dataInicio").toLocalDate());
                treino.setDataTermino(rs.getDate("dataTermino").toLocalDate());
    
                Exercicio exercicio = new Exercicio();
                exercicio.setNomeExercicio(rs.getString("nomeExercicio"));
                treinoAplicacao.setExercicio(exercicio);
    
                ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao();
                exercicioAplicacao.setDescricao(rs.getString("descricao"));
                treinoAplicacao.setExercicioAplicacao(exercicioAplicacao);

                treinoAplicacao.setTreino(treino);
    
                treinoAplicacaos.add(treinoAplicacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return treinoAplicacaos;
    }
    

    public boolean alterarNome(String nome, String novoNome) {
        String sql = "UPDATE treinoaplicacao SET nome = ? WHERE nome LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, novoNome);
            ps.setString(2, nome);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public TreinoAplicacao buscaPorId(Long id) {
        String sql = "SELECT " +
                "ta.idTreinoAplicacao, " +
                "t.dataInicio, " +
                "t.dataTermino, " +
                "e.nomeExercicio, " +
                "ea.descricao " +
                "FROM treinoaplicacao ta " +
                "LEFT JOIN treino t ON ta.treino = t.idTreino " +
                "LEFT JOIN exercicio e ON ta.exercicio = e.idExercicio " +
                "LEFT JOIN exercicioaplicacao ea ON ta.exercicioaplicacao = ea.idExercicioAplicacao WHERE idTreinoAplicacao = ?" ;
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    TreinoAplicacao treinoAplicacao = new TreinoAplicacao();
    
                treinoAplicacao.setId(rs.getLong("idTreinoAplicacao"));
    
                Treino treino = new Treino();
                treino.setDataInicio(rs.getDate("dataInicio").toLocalDate());
                treino.setDataTermino(rs.getDate("dataTermino").toLocalDate());
    
                Exercicio exercicio = new Exercicio();
                exercicio.setNomeExercicio(rs.getString("nomeExercicio"));
                treinoAplicacao.setExercicio(exercicio);
    
                ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao();
                exercicioAplicacao.setDescricao(rs.getString("descricao"));
                treinoAplicacao.setExercicioAplicacao(exercicioAplicacao);

                treinoAplicacao.setTreino(treino);
                    return treinoAplicacao;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean remover(String nome) {
        String sql = "DELETE FROM treinoaplicacao WHERE nome LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
}
