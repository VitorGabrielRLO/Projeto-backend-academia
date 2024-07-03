package dao;
import conection.Conexao;
import entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// import entities.Pessoa;


public class MensalidadeVigenteDao {
    public boolean adiciona(MensalidadeVigente p) {
        String sql = "INSERT INTO MensalidadeVigente (valor, inicio, termino, dataCriacao, dataModificacao) VALUES (?, ?, ?, now(), now())";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setDouble(1, p.getValor());
            
            LocalDate dataInicio = p.getInicio();
            java.sql.Date dateBegin = java.sql.Date.valueOf(dataInicio);
            ps.setDate(2, dateBegin);
            
            LocalDate dataTermino = p.getTermino();
            java.sql.Date dateFinish = java.sql.Date.valueOf(dataTermino);
            ps.setDate(3, dateFinish);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ehVazio() {
        String sql = "SELECT count(1) AS quantidade FROM MensalidadeVigente";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next() && rs.getInt("quantidade") == 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MensalidadeVigente> mostrarTodos() {
        String sql = "select * from mensalidadevigente";

        List<MensalidadeVigente> mensalidadeVigentes = new ArrayList<>();

        try (
                PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Long id = rs.getLong("idMensalidadeVigente");
                    double valor = rs.getDouble("valor");
                    java.sql.Date dateBegin = rs.getDate("inicio");
                    LocalDate dataInicio = dateBegin.toLocalDate();
                    java.sql.Date dateFinish = rs.getDate("termino");
                    LocalDate dataTermino = dateFinish.toLocalDate();
                    java.sql.Date currentDate = rs.getDate("dataCriacao");
                    LocalDate dataCriacao = currentDate.toLocalDate();
                    java.sql.Date modifyDate = rs.getDate("dataModificacao");
                    LocalDate dataModificacao = modifyDate.toLocalDate();

                    MensalidadeVigente mensalidadeVigente = new MensalidadeVigente();
                    mensalidadeVigente.setId(id);
                    mensalidadeVigente.setValor(valor);
                    mensalidadeVigente.setInicio(dataInicio);
                    mensalidadeVigente.setTermino(dataTermino);
                    mensalidadeVigente.setDataCriacao(dataCriacao);
                    mensalidadeVigente.setDataModificacao(dataModificacao);
                    mensalidadeVigentes.add(mensalidadeVigente);
                }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return mensalidadeVigentes;

    }
   
    public boolean alterarValor(Long id, double novoValor) {
        String sql = "UPDATE mensalidadevigente SET valor = ? WHERE idMensalidadeVigente = ?";
        
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setDouble(1, novoValor);
            ps.setLong(2, id);
            int rowsAffected = ps.executeUpdate(); // Melhor prática: verificar o número de linhas afetadas
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public MensalidadeVigente buscaPorId(Long id) {
    String sql = "SELECT * FROM pessoa WHERE nomePessoa LIKE ?";

    try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
        stmt.setLong(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Long id1 = rs.getLong("idMensalidadeVigente");
                double valor = rs.getDouble("valor");
                java.sql.Date dateBegin = rs.getDate("inicio");
                LocalDate dataInicio = dateBegin.toLocalDate();
                java.sql.Date dateFinish = rs.getDate("termino");
                LocalDate dataTermino = dateFinish.toLocalDate();
                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                java.sql.Date modifyDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = modifyDate.toLocalDate();

                MensalidadeVigente mensalidadeVigente = new MensalidadeVigente();
                mensalidadeVigente.setId(id1);
                mensalidadeVigente.setValor(valor);
                mensalidadeVigente.setInicio(dataInicio);
                mensalidadeVigente.setTermino(dataTermino);
                mensalidadeVigente.setDataCriacao(dataCriacao);
                mensalidadeVigente.setDataModificacao(dataModificacao);
                return mensalidadeVigente;
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return null; // return null if no matching record is found
}

public boolean remover(Long id) {
    String sql = "DELETE FROM mensalidadevigente WHERE idMensalidadeVigente = ?";
    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setLong(1, id);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}
