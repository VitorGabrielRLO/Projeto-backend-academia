// package dao; // Definindo qual pacote esta classe pertence

// import conection.Conexao;
// import entities.Academia;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
// public class FichaTreinoDao {

//     public boolean adiciona(Academia p) {

//         String sql = "INSERT INTO ACADEMIA (NOME,ENDERECO,DATACRIACAO) VALUES (?, ?, now())";
//         PreparedStatement ps = null;
//     try
//     {
//         ps = Conexao.getConexao().prepareStatement(sql);
//         ps.setString(1, p.getNome());
//         ps.setString(2, p.getEndereco());
//         ps.execute();
//         ps.close();
//         return true;

//     }catch (SQLException e)
//     {
//         e.printStackTrace();
//         return false;
//     }

//     }

//     public boolean ehVazio() {
//         String sql = "SELECT count(1) AS quantidade FROM academia";
//         PreparedStatement ps = null;
//     try
//     {
//         ps = Conexao.getConexao().prepareStatement(sql);
//         ResultSet rs = ps.getResultSet();
        
//         ps.close();
//         if (rs.getInt("quantidade") == 0) {
//             rs.close();
//             return true;
//         }
//         else{
//             rs.close();
//             return false;
//         }

//     }catch (SQLException e)
//     {
//         e.printStackTrace();
//         return false;
//     }
//     }

//     public List<Academia> mostrarTodos() {
//         String sql = "select * from academia";

//         List<Academia> academias = new ArrayList<>();

//         try (
//                 PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
//                 ResultSet rs = stmt.executeQuery(sql)) {

//                 while (rs.next()) {
//                     Long id = rs.getLong("id");
//                     String nome = rs.getString("nome");
//                     String endereco = rs.getString("endereco");
//                     java.sql.Date currentDate = rs.getDate("dataCriacao");
//                     LocalDate dataCriacao = currentDate.toLocalDate();

//                     Academia academia = new Academia();
//                     academia.setId(id);
//                     academia.setNome(nome);
//                     academia.setEndereco(endereco);
//                     academia.setDataCriacao(dataCriacao);
//                     academias.add(academia);
//                 }
//         } catch (SQLException e) {
//              throw new RuntimeException(e);
//         }
//         return academias;

//     }
   
//     public boolean alterarNome(String nome, String novoNome) {
        
//         String sql = "UPDATE academia  SET nome = ? WHERE nome LIKE ?";
//         PreparedStatement ps = null;
//     try
//     {
//         ps = Conexao.getConexao().prepareStatement(sql);
//         ps.setString(1, novoNome);
//         ps.setString(2, nome);
//         ps.execute();
//         ps.close();
//         return true;

//     }catch (SQLException e)
//     {
//         e.printStackTrace();
//         return false;
//     }
//     }

//     Academia buscaPorNome(String nome) {
//         // SELECT * FROM academia where nome like 'Leonardo';
//         String sql = "SELECT * FROM academia WHERE nome LIKE ?";

//         try (
//                 PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
//                 ResultSet rs = stmt.executeQuery(sql)) {

               
//                     Long id = rs.getLong("id");
//                     String nomeAcademia = rs.getString("nome");
//                     String endereco = rs.getString("endereco");
//                     java.sql.Date currentDate = rs.getDate("dataCriacao");
//                     LocalDate dataCriacao = currentDate.toLocalDate();

//                     Academia academia = new Academia();
//                     academia.setNome(nomeAcademia);
//                     academia.setEndereco(endereco);
//                     academia.setDataCriacao(dataCriacao);
//                     return academia;
                
//         } catch (SQLException e) {
//              throw new RuntimeException(e);
//         }
        

//     }

//     public boolean remover(String nome) {
//         // Delete from academia where id like 3;
//         String sql = "DELETE FROM academia WHERE nome LIKE ?";
//         PreparedStatement ps = null;
//     try
//     {
//         ps = Conexao.getConexao().prepareStatement(sql);
//         ps.setString(1,nome);
//         boolean result = ps.execute();

//         ps.close();
//         return result;

//     }catch (SQLException e)
//     {
//         e.printStackTrace();
//         return false;
//     }
//     }
// }
