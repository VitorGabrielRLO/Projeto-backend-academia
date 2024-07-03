package dao;

import conection.Conexao;
import entities.DivisaoTreino;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DivisaoTreinoDao {

    public boolean adiciona(DivisaoTreino p) {

        String sql = "INSERT INTO divisaotreino (nome, nomeDetalhado, dataCriacaoDivisaoTreino, dataModificacaoDivisaoTreino) VALUES (?, ?, now(), now())";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getNomeDetalhado());
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
        String sql = "SELECT count(1) AS quantidade FROM divisaotreino";
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

    public List<DivisaoTreino> mostrarTodos() {
        String sql = "select * from divisaotreino";

        List<DivisaoTreino> divisaoTreinos = new ArrayList<>();

        try (
                PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Long id = rs.getLong("idDivisaoTreino");
                    String nome = rs.getString("nome");
                    String nomeDetalhado = rs.getString("nomeDetalhado");
                    java.sql.Date currentDate = rs.getDate("dataCriacaoDivisaoTreino");
                    LocalDate dataCriacao = currentDate.toLocalDate();
                    java.sql.Date currentDate1 = rs.getDate("dataModificacaoDivisaoTreino");
                    LocalDate dataModificacao = currentDate1.toLocalDate();

                    DivisaoTreino divisaoTreino = new DivisaoTreino();
                    divisaoTreino.setId(id);
                    divisaoTreino.setNome(nome);
                    divisaoTreino.setNomeDetalhado(nomeDetalhado);
                    divisaoTreino.setDataCriacao(dataCriacao);
                    divisaoTreino.setDataModificacao(dataModificacao);
                    divisaoTreinos.add(divisaoTreino);
                }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return divisaoTreinos;

    }
   
    public boolean alterarNome(String nome, String novoNome) {
        
        String sql = "UPDATE divisaotreino  SET nome = ?, dataModificacaoDivisaoTreino = now() WHERE nome LIKE ?";
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

    public DivisaoTreino buscaPorNome(String nome) {
    String sql = "SELECT * FROM divisaotreino WHERE nome LIKE ?";

    try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
        stmt.setString(1, nome);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Long id = rs.getLong("idDivisaoTreino");
                String nome1 = rs.getString("nome");
                String nomeDetalhado = rs.getString("nomeDetalhado");
                java.sql.Date currentDate = rs.getDate("dataCriacaoDivisaoTreino");
                LocalDate dataCriacao = currentDate.toLocalDate();
                java.sql.Date currentDate1 = rs.getDate("dataModificacaoDivisaoTreino");
                LocalDate dataModificacao = currentDate1.toLocalDate();

                DivisaoTreino divisaoTreino = new DivisaoTreino();
                divisaoTreino.setId(id);
                divisaoTreino.setNome(nome1);
                divisaoTreino.setNomeDetalhado(nomeDetalhado);
                divisaoTreino.setDataCriacao(dataCriacao);
                divisaoTreino.setDataModificacao(dataModificacao);
                return divisaoTreino;
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return null; // return null if no matching record is found
}


    public boolean remover(String nome) {
        // Delete from academia where id like 3;
        String sql = "DELETE FROM divisaotreino WHERE nome LIKE ?";
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
