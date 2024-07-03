package dao;

import conection.*;
import entities.AlunoPagamento;
import entities.MensalidadeAluno;
import entities.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoPagamentoDao {

    public boolean adiciona(AlunoPagamento p) {
        String sql = "INSERT INTO alunopagamento(valor, plano, aluno, modalidade, dataCriacao, dataModificacao, dataPagamento, dataVencimento) VALUES (?, ?, ?, ?, now(), NULL, NULL, date_add(now(), INTERVAL 30 day))";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setDouble(1, p.getValor());
            ps.setLong(2, p.getPlano().getId());
            ps.setLong(3, p.getAluno().getId());
            ps.setInt(4, p.getModalidade());
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
    String sql = "SELECT " +
                 "ap.*, " +
                 "ma.id AS plano_id, ma.plano, ma.valor AS plano_valor, ma.descricao AS plano_descricao, ma.dataCriacao AS plano_dataCriacao, ma.dataModificacao AS plano_dataModificacao, " +
                 "p.id AS aluno_id, p.nome AS aluno_nome " +
                 "FROM alunopagamento ap " +
                 "INNER JOIN mensalidadealuno ma ON ap.plano = ma.id " +
                 "INNER JOIN pessoa p ON ap.aluno = p.id";

    List<AlunoPagamento> alunoPagamentos = new ArrayList<>();
    try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            AlunoPagamento pagamento = new AlunoPagamento();
            pagamento.setId(rs.getLong("idAlunoPagamento"));
            pagamento.setValor(rs.getDouble("valor"));

            MensalidadeAluno plano = new MensalidadeAluno();
            plano.setId(rs.getLong("idMensalidadeAluno"));
            plano.setPlano(rs.getString("plano"));
            plano.setValor(rs.getDouble("valor"));
            plano.setDescricao(rs.getString("descricao"));
            plano.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
            plano.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
            pagamento.setPlano(plano);

            Pessoa aluno = new Pessoa();
            aluno.setId(rs.getLong("idPessoa"));
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

    public boolean alterarNome(String plano, String planoNome) {
        String sql = "UPDATE alunopagamento SET plano = ? WHERE plano = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, planoNome);
            ps.setString(2, plano);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public AlunoPagamento buscaPorNome(String plano) {
        String sql = "SELECT * FROM alunopagamento WHERE plano = ?";
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, plano);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                AlunoPagamento pagamento = new AlunoPagamento();

                Long id = rs.getLong("idMensalidadeAluno");
                String plano1 = rs.getString("plano");
                Double valor = rs.getDouble("valor");
                String descricao = rs.getString("descricao");
                LocalDate dataCriacao = rs.getDate("dataCriacaoMensalidadeAluno").toLocalDate();
                LocalDate dataModificacao = rs.getDate("dataModificacaoMensalidadeAluno").toLocalDate();
    
                MensalidadeAluno mensalidadeAluno = new MensalidadeAluno();
                mensalidadeAluno.setId(id);
                mensalidadeAluno.setPlano(plano1);
                mensalidadeAluno.setValor(valor);
                mensalidadeAluno.setDescricao(descricao);
                mensalidadeAluno.setDataCriacao(dataCriacao);
                mensalidadeAluno.setDataModificacao(dataModificacao);

                pagamento.setId(rs.getLong("id"));
                pagamento.setValor(rs.getDouble("valor"));
                pagamento.setPlano(mensalidadeAluno);
                
                Pessoa aluno = new Pessoa();
                aluno.setId(rs.getLong("aluno"));
                pagamento.setAluno(aluno);
                pagamento.setModalidade(rs.getInt("modalidade"));
                pagamento.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                pagamento.setDataModificacao(rs.getDate("dataModificacao") != null ? rs.getDate("dataModificacao").toLocalDate() : null);
                pagamento.setVencimento(rs.getDate("dataVencimento").toLocalDate());
                pagamento.setDataPagamento(rs.getDate("dataPagamento") != null ? rs.getDate("dataPagamento").toLocalDate() : null);
                return pagamento;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean remover(String plano) {
        String sql = "DELETE FROM alunopagamento WHERE plano = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, plano);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
