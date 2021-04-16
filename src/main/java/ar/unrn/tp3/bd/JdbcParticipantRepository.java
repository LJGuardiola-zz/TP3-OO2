package ar.unrn.tp3.bd;

import ar.unrn.tp3.modelo.Participant;
import ar.unrn.tp3.modelo.ParticipantRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcParticipantRepository implements ParticipantRepository {

    private final static JdbcConnectionManager CONNECTION_MANAGER = JdbcConnectionManager.getInstance();

    @Override
    public void save(Participant participant) {
        try (
                Connection connection = CONNECTION_MANAGER.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO PARTICIPANTS (NAME, PHONE, REGION) VALUES (?, ?, ?)"
                )
        ) {

            preparedStatement.setString(1, participant.getName());
            preparedStatement.setString(2, participant.getPhoneNumber());
            preparedStatement.setString(3, participant.getRegion());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("No se pudo registra al participante", e);
        }
    }

}
