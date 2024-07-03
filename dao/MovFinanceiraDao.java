package dao;

import conection.Conexao;
import entities.MovFinanceira;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovFinanceiraDao {
    
    public boolean adiciona(MovFinanceira p) {

        String sql = "INSERT INTO MovFinanceira (valor,tipo,descricao, dataCriacaoMovFinanceira, dataModificacaoMovFinanceira) VALUES (?, ?, ?, now(), now())";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setDouble(1, p.getValor());
        ps.setInt(2, p.getTipo());
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
        String sql = "SELECT count(1) AS quantidade FROM MovFinanceira";
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

    public List<MovFinanceira> mostrarTodos() {
        String sql = "SELECT * FROM MovFinanceira";

        List<MovFinanceira> movFinanceiras = new ArrayList<>();

        try {
                PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Long id = rs.getLong("idMovFinanceira");
                    double valor = rs.getDouble("valor");
                    int tipo = rs.getInt("tipo");
                    String descricao = rs.getString("descricao");
                    java.sql.Date currentDate = rs.getDate("dataCriacaoMovFinanceira");
                    LocalDate dataCriacao = currentDate.toLocalDate();
                    java.sql.Date currentDateModify = rs.getDate("dataModificacaoMovFinanceira");
                    LocalDate dataModificacao = currentDateModify.toLocalDate();

                    MovFinanceira movFinanceira = new MovFinanceira();
                    movFinanceira.setId(id);
                    movFinanceira.setValor(valor);
                    movFinanceira.setTipo(tipo);
                    movFinanceira.setDescricao(descricao);
                    movFinanceira.setDataCriacao(dataCriacao);
                    movFinanceira.setDataModificacao(dataModificacao);
                    movFinanceiras.add(movFinanceira);
                }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return movFinanceiras;

    }
   
    public boolean remover(long id) {
        // Delete from academia where id like 3;
        String sql = "DELETE FROM MovFinanceira WHERE idMovFinanceira = ?";
        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setLong(1, id);
        boolean result = ps.execute();

        ps.close();
        return result;

    }catch (SQLException e)
    {
        e.printStackTrace();
        return false;
    }
    }

    public double valorTotal() {
        String sql = "SELECT * FROM MovFinanceira";

        double valorTotal = 0;

        try {
                PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    double valor = rs.getDouble("valor");

                    valorTotal += valor;
                }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return valorTotal;

    }

    public List<MovFinanceira> mostrarTodosPorMes(Long ano, Long mes) {
        String sql = "SELECT * FROM MovFinanceira WHERE YEAR(dataCriacaoMovFinanceira) = ? AND MONTH(dataCriacaoMovFinanceira) = ?";
        List<MovFinanceira> movFinanceiras = new ArrayList<>();

        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setLong(1, ano);
            stmt.setLong(2, mes);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("idMovFinanceira");
                    double valor = rs.getDouble("valor");
                    int tipo = rs.getInt("tipo");
                    String descricao = rs.getString("descricao");
                    java.sql.Date currentDate = rs.getDate("dataCriacaoMovFinanceira");
                    LocalDate dataCriacao = currentDate.toLocalDate();
                    java.sql.Date currentDateModify = rs.getDate("dataModificacaoMovFinanceira");
                    LocalDate dataModificacao = currentDateModify.toLocalDate();

                    MovFinanceira movFinanceira = new MovFinanceira();
                    movFinanceira.setId(id);
                    movFinanceira.setValor(valor);
                    movFinanceira.setTipo(tipo);
                    movFinanceira.setDescricao(descricao);
                    movFinanceira.setDataCriacao(dataCriacao);
                    movFinanceira.setDataModificacao(dataModificacao);

                    movFinanceiras.add(movFinanceira);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar movimentações financeiras por mês", e);
        }

        return movFinanceiras;
    }
}



