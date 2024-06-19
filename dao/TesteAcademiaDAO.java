package dao;

import conection.Conexao;
import entities.Academia;
import java.sql.PreparedStatement;
import java.sql.SQLException;


// import entities.Exercicio;

public class TesteAcademiaDAO {

    public void cadastrarAcademia(Academia academia)
    {
        String sql = "INSERT INTO ACADEMIA (NOME,ENDERECO) VALUES (?, ?)";

        PreparedStatement ps = null;
    try
    {
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, academia.getNome());
        ps.setString(2, academia.getEndereco());

        ps.execute();
        ps.close();

    }catch (SQLException e)
    {
        e.printStackTrace();
    }
    }



   
}
