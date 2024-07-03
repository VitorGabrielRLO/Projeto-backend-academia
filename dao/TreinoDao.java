package dao;

import conection.Conexao;
import entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinoDao {

    public boolean adiciona(Treino treino) {
        String sql = "INSERT INTO treino (exercicio, divisaoTreino,dataInicio, dataTermino, dataCriacaoTreino, dataModificacaoTreino) VALUES (?, ?, ?, ?, now(), now())";
        
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setLong(1, treino.getExercicio().getId());
            ps.setLong(2, treino.getDivisaoTreino().getId());
            ps.setDate(3, java.sql.Date.valueOf(treino.getDataInicio()));
            ps.setDate(4, java.sql.Date.valueOf(treino.getDataTermino()));
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ehVazio() {
        String sql = "SELECT count(*) AS quantidade FROM treino";
        
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                int quantidade = rs.getInt("quantidade");
                return quantidade == 0;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }

    public List<Treino> mostrarTodos() {
        String sql ="SELECT tr.*, ex.nomeExercicio, dt.nome FROM treino tr \n" + 
                    "Inner JOIN  exercicio ex ON tr.exercicio = ex.idExercicio\n" +
                    "INNER JOIN divisaotreino dt on tr.divisaoTreino = dt.idDivisaoTreino;";
        List<Treino> treinos = new ArrayList<>();

        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Treino treino = new Treino();
                Exercicio exercicio = new Exercicio();
                DivisaoTreino divisaoTreino = new DivisaoTreino();

                divisaoTreino.setNome(rs.getString("nome"));
                exercicio.setNomeExercicio(rs.getString("nomeExercicio"));


                treino.setId(rs.getLong("idTreino"));
                treino.setExercicio(exercicio);
                treino.setDivisaoTreino(divisaoTreino);
                treino.setDataInicio(rs.getDate("dataInicio").toLocalDate());
                treino.setDataTermino(rs.getDate("dataTermino").toLocalDate());
                treino.setDataCriacao(rs.getDate("dataCriacaoTreino").toLocalDate());
                treino.setDataModificacao(rs.getDate("dataModificacaoTreino").toLocalDate());

                treinos.add(treino);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar treinos do banco de dados", e);
        }

        return treinos;
    }


    public Treino buscaPorId(long id) {
        String sql = "SELECT tr.*, ex.nomeExercicio, dt.nome FROM treino tr \n" + 
                    "Inner JOIN  exercicio ex ON tr.exercicio = ex.idExercicio\n" +
                    "INNER JOIN divisaotreino dt on tr.divisaoTreino = dt.idDivisaoTreino WHERE idTreino = ?";
        
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Treino treino = new Treino();
                    Exercicio exercicio = new Exercicio();
                    DivisaoTreino divisaoTreino = new DivisaoTreino();

                    divisaoTreino.setNome(rs.getString("nome"));
                    exercicio.setNomeExercicio(rs.getString("nomeExercicio"));

                    treino.setId(rs.getLong("idTreino"));
                    treino.setExercicio(exercicio);
                    treino.setDivisaoTreino(divisaoTreino);
                    treino.setDataInicio(rs.getDate("dataInicio").toLocalDate());
                    treino.setDataTermino(rs.getDate("dataTermino").toLocalDate());
                    treino.setDataCriacao(rs.getDate("dataCriacaoTreino").toLocalDate());
                    treino.setDataModificacao(rs.getDate("dataModificacaoTreino").toLocalDate());
                    return treino;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar treino por ID no banco de dados", e);
        }
        
        return null;
    }

    public boolean remover(long id) {
        String sql = "DELETE FROM treino WHERE idTreino = ?";
        
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setLong(1, id);
            
            boolean result = ps.execute();
            return result;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Treino buscaUltimoTreinoPorPessoa(long pessoaId) {
        String sql = "SELECT tr.*, ex.nomeExercicio, dt.nome FROM treino tr \n" + 
                    "Inner JOIN  exercicio ex ON tr.exercicio = ex.idExercicio\n" +
                    "INNER JOIN divisaotreino dt on tr.divisaoTreino = dt.idDivisaoTreino WHERE idTreino = ?";
        
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setLong(1, pessoaId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Treino treino = new Treino();
                    Exercicio exercicio = new Exercicio();
                    DivisaoTreino divisaoTreino = new DivisaoTreino();

                    exercicio.setNomeExercicio(rs.getString("nomeExercicio"));
                    divisaoTreino.setNome(rs.getString("nomeDivisaoTreino"));

                    treino.setId(rs.getLong("idTreino"));
                    treino.setExercicio(exercicio);
                    treino.setDivisaoTreino(divisaoTreino);
                    treino.setDataInicio(rs.getDate("dataInicio").toLocalDate());
                    treino.setDataTermino(rs.getDate("dataTermino").toLocalDate());
                    treino.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    treino.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                    return treino;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o último treino por pessoa no banco de dados", e);
        }
        
        return null;
    }

    public void mostrarTodasTreinos() {
        List<Treino> pagamentos = mostrarTodos();
        for (Treino pagamento : pagamentos) {
            System.out.println(pagamento);
        }
    }
}
