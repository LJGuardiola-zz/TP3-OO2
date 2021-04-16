package ar.unrn.tp3;

import ar.unrn.tp3.bd.JdbcParticipantRepository;
import ar.unrn.tp3.ui.AddParticipantFrame;

import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(
                () -> new AddParticipantFrame(
                        new JdbcParticipantRepository()
                )
        );
    }
}
