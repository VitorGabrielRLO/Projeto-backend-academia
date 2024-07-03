package dao;

import conection.Conexao;
import entities.PagamentoRecorrente;
import entities.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagamentoRecorrenteDao {

    public boolean adiciona(PagamentoRecorrente p) {
        String sql = "INSERT INTO PAGAMENTORECORRENTE (ALUNO, DATA, CARTAODECREDITO, DATAINICIO, NUMEROMESES, VALOR, DATACRIACAOPAGAMENTORECORRENTE, DATAMODIFICACAOPAGAMENTORECORRENTE) VALUES (?, now(), ?, now(), ?, ?, now(), now())";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, p.getAluno().getId());
            ps.setString(2, p.getCartaoDeCredito());
            ps.setInt(3, p.getNumeroMeses());
            ps.setDouble(4, p.getValor());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    p.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ehVazio() {
        String sql = "SELECT count(1) AS quantidade FROM pagamentorecorrente";
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

    public List<PagamentoRecorrente> mostrarTodos() {
        String sql = "SELECT pr.id, pr.aluno, pr.data, pr.cartaoDeCredito, pr.dataInicio, pr.dataCriacaoPagamentoRecorrente, pr.numeroMeses, pr.valor, " +
                     "p.nomePessoa, p.sexoPessoa, p.loginPessoa, p.dataNascimento, p.dataCriacao " +
                     "FROM pagamentorecorrente pr " +
                     "INNER JOIN pessoa p ON pr.aluno = p.idPessoa";
    
        List<PagamentoRecorrente> pagamentoRecorrentes = new ArrayList<>();
    
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                Long id = rs.getLong("id");
                String alunoNome = rs.getString("aluno");
    
                java.sql.Date currentDate = rs.getDate("data");
                LocalDate data = (currentDate != null) ? currentDate.toLocalDate() : null;
    
                String cartaoDeCredito = rs.getString("cartaoDeCredito");
    
                java.sql.Date currentDate1 = rs.getDate("dataInicio");
                LocalDate dataInicio = (currentDate1 != null) ? currentDate1.toLocalDate() : null;
    
                java.sql.Date currentDate2 = rs.getDate("dataCriacaoPagamentoRecorrente");
                LocalDate dataCriacao = (currentDate2 != null) ? currentDate2.toLocalDate() : null;
    
                int numeroMeses = rs.getInt("numeroMeses");
                Double valor = rs.getDouble("valor");
    
                // Dados da Pessoa (aluno)
                String nomePessoa = rs.getString("nomePessoa");
                String sexoPessoa = rs.getString("sexoPessoa");
                String loginPessoa = rs.getString("loginPessoa");
                java.sql.Date dataNascimento = rs.getDate("dataNascimento");
                LocalDate dataNascimentoLocalDate = (dataNascimento != null) ? dataNascimento.toLocalDate() : null;
                java.sql.Date dataCriacaoPessoa = rs.getDate("dataCriacao");
                LocalDate dataCriacaoLocalDate = (dataCriacaoPessoa != null) ? dataCriacaoPessoa.toLocalDate() : null;
    
                // Criar objeto Pessoa
                Pessoa aluno = new Pessoa();
                aluno.setId(id); // ou rs.getLong("aluno"), dependendo do tipo de dado do id
    
                aluno.setNomePessoa(nomePessoa);
                aluno.setSexoPessoa(sexoPessoa);
                aluno.setLoginPessoa(loginPessoa);
                aluno.setDataNascimento(dataNascimentoLocalDate);
                aluno.setDataCriacao(dataCriacaoLocalDate);
    
                // Criar objeto PagamentoRecorrente
                PagamentoRecorrente pagamentoRecorrente = new PagamentoRecorrente();
                pagamentoRecorrente.setId(id);
                pagamentoRecorrente.setAluno(aluno);
                pagamentoRecorrente.setData(data);
                pagamentoRecorrente.setCartaoDeCredito(cartaoDeCredito);
                pagamentoRecorrente.setDataInicio(dataInicio);
                pagamentoRecorrente.setNumeroMeses(numeroMeses);
                pagamentoRecorrente.setValor(valor);
                pagamentoRecorrente.setDataCriacao(dataCriacao);
    
                pagamentoRecorrentes.add(pagamentoRecorrente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar pagamentos recorrentes", e);
        }
    
        return pagamentoRecorrentes;
    }
    

    public boolean alterarInfos(long id, Double novoValor, int novoNumeroMeses) {

        String sql = "UPDATE pagamentorecorrente SET valor = ?, numeroMeses = ?, dataModificacaoPagamentoRecorrente = now() WHERE id = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setDouble(1, novoValor);
            ps.setInt(2, novoNumeroMeses);
            ps.setLong(3, id);

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remover(long id) {
        String sql = "DELETE FROM pagamentorecorrente WHERE id = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setLong(1, id);

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
