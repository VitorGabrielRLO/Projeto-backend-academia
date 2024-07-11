package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import conection.Conexao;
import entities.AlunoPagamento;
import entities.MensalidadeAluno;
import entities.Pessoa;

public class AlunoPagamentoDao {

    public boolean adiciona(AlunoPagamento p) {
        String sql = "INSERT INTO alunopagamento(valor, planoId, aluno, modalidade, dataCriacao, dataModificacao, dataPagamento, dataVencimento) VALUES (?, ?, ?, ?, now(), now(), now(), ?)";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setDouble(1, p.getValor());
            ps.setLong(2, p.getPlano().getId());
            ps.setLong(3, p.getAluno().getId());
            ps.setInt(4, p.getModalidade());
            LocalDate data = p.getVencimento();
             java.sql.Date totalDias = java.sql.Date.valueOf(data);
            ps.setDate(5, totalDias);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ehVazio() {
        String sql = "SELECT count(1) AS quantidade FROM alunopagamento";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt("quantidade") == 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<AlunoPagamento> mostrarTodos() {
    String sql = "SELECT ap.*, p.nomePessoa , ma.plano FROM alunopagamento ap INNER JOIN pessoa p ON ap.aluno = p.idPessoa INNER JOIN mensalidadealuno ma ON ap.planoId = ma.idMensalidadeAluno";

    List<AlunoPagamento> alunoPagamentos = new ArrayList<>();
    try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            AlunoPagamento pagamento = new AlunoPagamento();
            pagamento.setId(rs.getLong("idAlunoPagamento"));
            pagamento.setValor(rs.getDouble("valor"));

            MensalidadeAluno plano = new MensalidadeAluno();
            plano.setPlano(rs.getString("plano"));
            pagamento.setPlano(plano);

            Pessoa aluno = new Pessoa();
            aluno.setNomePessoa(rs.getString("nomePessoa"));
            pagamento.setAluno(aluno);

            pagamento.setModalidade(rs.getInt("modalidade"));
            pagamento.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
            pagamento.setDataModificacao(rs.getDate("dataModificacao") != null ? rs.getDate("dataModificacao").toLocalDate() : null);
            pagamento.setVencimento(rs.getDate("dataVencimento").toLocalDate());
            pagamento.setDataPagamento(rs.getDate("dataPagamento") != null ? rs.getDate("dataPagamento").toLocalDate() : null);
            
            alunoPagamentos.add(pagamento);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return alunoPagamentos;
}

    public boolean deletarPorId(long id) {
        String sql = "DELETE FROM alunopagamento WHERE idalunopagamento = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public LocalDate buscaPorNomePessoa(String nomeBuscado){
        String sql = "SELECT ap.*, p.nomePessoa FROM alunopagamento ap " +
                        "INNER JOIN pessoa p ON ap.aluno = p.idPessoa WHERE nomePessoa = ? ;";

        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
        stmt.setString(1, nomeBuscado);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {

                java.sql.Date currentDate1 = rs.getDate("dataVencimento");
                LocalDate vencimento = currentDate1.toLocalDate();

                return vencimento;
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return null;
    }
}
