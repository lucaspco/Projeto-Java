package org.lucaspco.DAO;

import org.lucaspco.model.Agendamento;
import org.lucaspco.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AgendamentoDAO {

    private static final String INSERT_AGENDAMENTO = "INSERT INTO agendamento (data_hora, usuario_id, descricao) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_AGENDAMENTOS = "SELECT * FROM agendamento";
    private static final String SELECT_AGENDAMENTO_BY_ID = "SELECT * FROM agendamento WHERE id = ?";
    private static final String UPDATE_AGENDAMENTO = "UPDATE agendamento SET data_hora = ?, usuario_id = ?, descricao = ? WHERE id = ?";
    private static final String DELETE_AGENDAMENTO = "DELETE FROM agendamento WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Agendamento salvarAgendamento(Agendamento agendamento) {
        jdbcTemplate.update(INSERT_AGENDAMENTO, agendamento.getDataHora(), agendamento.getUsuario().getId(), agendamento.getDescricao());
        return agendamento;
    }

    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        jdbcTemplate.update(UPDATE_AGENDAMENTO, agendamento.getDataHora(), agendamento.getUsuario().getId(), agendamento.getDescricao(), agendamento.getId());
        return agendamento;
    }

    public void deletarAgendamento(int agendamentoId) {
        jdbcTemplate.update(DELETE_AGENDAMENTO, agendamentoId);
    }

    public Agendamento buscarAgendamentoPorId(int agendamentoId) {
        return jdbcTemplate.queryForObject(SELECT_AGENDAMENTO_BY_ID, new Object[]{agendamentoId}, new AgendamentoRowMapper());
    }

    public List<Agendamento> buscarTodosAgendamentos() {
        return jdbcTemplate.query(SELECT_ALL_AGENDAMENTOS, new AgendamentoRowMapper());
    }

    private static class AgendamentoRowMapper implements RowMapper<Agendamento> {
        @Override
        public Agendamento mapRow(ResultSet rs, int rowNum) throws SQLException {
            Agendamento agendamento = new Agendamento();
            agendamento.setId(rs.getInt("id"));
            agendamento.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("usuario_id")); // Assuming the user id is stored in the 'usuario_id' column
            agendamento.setUsuario(usuario);
            agendamento.setDescricao(rs.getString("descricao"));
            return agendamento;
        }
    }
}
