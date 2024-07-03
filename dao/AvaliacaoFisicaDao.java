package dao;

import conection.Conexao;
import entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoFisicaDao {

    public boolean adiciona(AvaliacaoFisica p) {
        String sql = "INSERT INTO avaliacaofisica (pessoa, ultimotreino, peso, altura, imc, indiceSatisfacao, dataCriacaoAvaliacaoFisica, dataModificacaoAvaliacaoFisica) VALUES (?, ?, ?, ?, ?, ?, now(), now())";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setLong(1, p.getPessoa().getId());
            ps.setLong(2, p.getUltimoTreino().getId());
            ps.setDouble(3, p.getPeso());
            ps.setDouble(4, p.getAltura());
            ps.setDouble(5, p.getIMC());
            ps.setDouble(6, p.getIndiceSatisfacao());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ehVazio() {
        String sql = "SELECT count(*) AS quantidade FROM avaliacaofisica";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int quantidade = rs.getInt("quantidade");
                return quantidade == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<AvaliacaoFisica> mostrarTodos() {
        String sql = " SELECT av.*, tr.idTreino, tr.dataInicio, tr.dataTermino, ex.nomeExercicio, p.nomePessoa\n" + //
                        "FROM avaliacaofisica av\n" + //
                        "INNER JOIN treino tr ON av.ultimoTreino = tr.idTreino\n" + //
                        "INNER JOIN exercicio ex ON tr.exercicio = ex.idExercicio\n" + //
                        "INNER JOIN pessoa p ON av.pessoa = p.idPessoa;";
    
        List<AvaliacaoFisica> avaliacoesFisicas = new ArrayList<>();
    
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    
                avaliacaoFisica.setId(rs.getLong("idAvaliacaoFisica"));
                avaliacaoFisica.setPeso(rs.getDouble("peso"));
                avaliacaoFisica.setAltura(rs.getDouble("altura"));
                avaliacaoFisica.setIMC(rs.getDouble("imc"));
                avaliacaoFisica.setIndiceSatisfacao(rs.getDouble("indiceSatisfacao"));
                avaliacaoFisica.setDataCriacao(rs.getDate("dataCriacaoAvaliacaoFisica").toLocalDate());
                avaliacaoFisica.setDataModificacao(rs.getDate("dataModificacaoAvaliacaoFisica").toLocalDate());
    
                Pessoa pessoa = new Pessoa();
                pessoa.setNomePessoa(rs.getString("nomePessoa"));
    
                avaliacaoFisica.setPessoa(pessoa);
                Treino treino = new Treino();
                treino.setId(rs.getLong("idTreino"));
                avaliacaoFisica.setUltimoTreino(treino);
                
    
                avaliacoesFisicas.add(avaliacaoFisica);
            }
    
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar avaliações físicas do banco de dados", e);
        }
    
        return avaliacoesFisicas;
    }

    public boolean alterarNome(long id, String novoNome) {
        String sql = "UPDATE avaliacaofisica SET nome = ? WHERE idAvaliacaoFisica = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, novoNome);
            ps.setLong(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public AvaliacaoFisica buscaPorNome(String nomePessoa) {
        String sql = "SELECT * FROM avaliacaofisica af INNER JOIN pessoa p ON af.pessoa = p.idPessoa WHERE p.nomePessoa = ?";
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, nomePessoa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
                avaliacaoFisica.setId(rs.getLong("idAvaliacaoFisica"));
                // Defina os demais atributos da avaliação física aqui
                return avaliacaoFisica;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar avaliação física por nome de pessoa", e);
        }
        return null;
    }


    public boolean remover(long id) {
        String sql = "DELETE FROM avaliacaofisica WHERE idAvaliacaoFisica = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setLong(1, id);
            boolean result = ps.execute();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
