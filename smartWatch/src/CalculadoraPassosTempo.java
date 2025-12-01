import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraPassosTempo extends JFrame {
    private JComboBox<String> cmbCalcado;
    private JTextField txtDistancia;
    private JComboBox<String> cmbUnidade;
    private JLabel lblResultadoPassos;
    private JLabel lblResultadoTempo;

    public CalculadoraPassosTempo() {
        setTitle("Calculadora de Passos e Tempo");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 5, 5));

        // definindo calçado
        add(new JLabel("Calçado BR:"));
        cmbCalcado = new JComboBox<>(new String[]{
                "37", "38", "39", "40", "41", "42", "43", "44"
        });
        add(cmbCalcado);

        // definindo distancia
        add(new JLabel("Distância:"));
        txtDistancia = new JTextField();
        add(txtDistancia);

        // definindo unidade de medida
        add(new JLabel("Unidade:"));
        cmbUnidade = new JComboBox<>(new String[]{"Metros", "Quilômetros"});
        add(cmbUnidade);

        // botões
        JButton btnCalcularPassos = new JButton("Calcular Passos");
        JButton btnCalcularTempo = new JButton("Calcular Tempo");

        add(btnCalcularPassos);
        add(btnCalcularTempo);

        // resultados
        lblResultadoPassos = new JLabel("Passos: ");
        lblResultadoTempo = new JLabel("Tempo: ");

        add(lblResultadoPassos);
        add(lblResultadoTempo);

        btnCalcularPassos.addActionListener(e -> calcularPassos());
        btnCalcularTempo.addActionListener(e -> calcularTempo());
    }

    // coloca o codigo aqui, apaga essa mensagem dps de dar commit

}