package org.lucaspco.DAO;

import org.lucaspco.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioDAO {

    private static String INSERT_CLI = "insert into usuario (nome) values (?)";
    private static String SELECT_ALL = "select * from usuario";
    private static String SELECT_BY_NOME = "select * from usuario where nome like ? ";
    private static String UPDATE = "update usuario set nome = ? where id = ?";
    private static String DELETE = "delete from usuario where id = ?";

    @Autowired
    private JdbcTemplate jdbcConexao;

    public Usuario salvarUsuario(Usuario usuario) {
        jdbcConexao.update(INSERT_CLI, new Object[]{usuario.getNome()});
        return usuario;
    }

    public Usuario atualizarUsuario(Usuario usuario){
        jdbcConexao.update(UPDATE, new Object []{
                usuario.getNome(),usuario.getId()});
        return usuario;
    }

    public Usuario deletarUsuario(Usuario usuario){
        jdbcConexao.update(DELETE, new Object []{usuario.getId()});
        return usuario;
    }

    public List<Usuario> obterUsuarioByNome(String nome){
        return jdbcConexao.query(SELECT_BY_NOME , new Object[]{"%"+nome+"%"} , new RowMapper<Usuario>() {
            @Override
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer idC = rs.getInt("id");
                String nomeC = rs.getString("nome");
                return new Usuario(idC, nomeC);
            }
        });
    }

    public List<Usuario> obterTodos(){
        return jdbcConexao.query(SELECT_ALL, new RowMapper<Usuario>() {
            @Override
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer idC = rs.getInt("id");
                String nomeC = rs.getString("nome");
                return new Usuario(idC, nomeC);
            }
        });
    }
}
