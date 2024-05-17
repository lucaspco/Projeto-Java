package org.lucaspco.DAO;

import org.lucaspco.model.Prontuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProntuarioDAO {

    private static final String INSERT_PRONTUARIO = "INSERT INTO prontuario (prontuario) VALUES (?)";
    private static final String SELECT_ALL_PRONTUARIOS = "SELECT * FROM prontuario";
    private static final String SELECT_PRONTUARIO_BY_ID = "SELECT * FROM prontuario WHERE id = ?";
    private static final String UPDATE_PRONTUARIO = "UPDATE prontuario SET prontuario = ? WHERE id = ?";
    private static final String DELETE_PRONTUARIO = "DELETE FROM prontuario WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Prontuario salvarProntuario(Prontuario prontuario) {
        jdbcTemplate.update(INSERT_PRONTUARIO, prontuario.getProntuario());
        return prontuario;
    }

    public Prontuario atualizarProntuario(Prontuario prontuario) {
        jdbcTemplate.update(UPDATE_PRONTUARIO, prontuario.getProntuario(), prontuario.getId());
        return prontuario;
    }

    public void deletarProntuario(int prontuarioId) {
        jdbcTemplate.update(DELETE_PRONTUARIO, prontuarioId);
    }

    public Prontuario buscarProntuarioPorId(int prontuarioId) {
        return jdbcTemplate.queryForObject(SELECT_PRONTUARIO_BY_ID, new Object[]{prontuarioId}, new ProntuarioRowMapper());
    }

    public List<Prontuario> buscarTodosProntuarios() {
        return jdbcTemplate.query(SELECT_ALL_PRONTUARIOS, new ProntuarioRowMapper());
    }

    private static class ProntuarioRowMapper implements RowMapper<Prontuario> {
        @Override
        public Prontuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Prontuario prontuario = new Prontuario();
            prontuario.setId(rs.getInt("id"));
            prontuario.setProntuario(rs.getString("prontuario"));
            return prontuario;
        }
    }
}