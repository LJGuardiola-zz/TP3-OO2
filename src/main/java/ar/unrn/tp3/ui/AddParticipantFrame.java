package ar.unrn.tp3.ui;

import ar.unrn.tp3.modelo.Participant;
import ar.unrn.tp3.modelo.ParticipantRepository;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

public class AddParticipantFrame extends JFrame {

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField regionField;

    private final ParticipantRepository participantRepository;

    public AddParticipantFrame(ParticipantRepository participantRepository) {

        this.participantRepository = participantRepository;

        JPanel contentPane = new JPanel();
        setupUIComponents(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setVisible(true);
        pack();

    }

    private void setupUIComponents(JPanel contentPane) {

        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JLabel("Nombre: "));
        nameField = new JTextField(10);
        contentPane.add(nameField);

        contentPane.add(new JLabel("Teléfono: "));
        phoneField = new JTextField(10);
        contentPane.add(phoneField);

        contentPane.add(new JLabel("Región: "));
        regionField = new JTextField(10);
        contentPane.add(regionField);

        JButton submitButton = new JButton("Cargar");
        submitButton.addActionListener(e -> submit());
        contentPane.add(submitButton);

    }

    private void submit() {
        try {
            Participant participant = new Participant(
                    nameField.getText(),
                    phoneField.getText(),
                    regionField.getText()
            );
            participantRepository.save(participant);
            JOptionPane.showMessageDialog(this, "Participante registrado con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

}
