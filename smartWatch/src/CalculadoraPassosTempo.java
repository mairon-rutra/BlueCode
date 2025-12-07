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
private double getTamanhoPeCm(String calcado) {
    switch (calcado) {
        case "37": return 24.5;
        case "38": return 25.0;
        case "39": return 25.5;
        case "40": return 26.0;
        case "41": return 27.0;
        case "42": return 28.0;
        case "43": return 29.0;
        case "44": return 30.0;
        default: return 25.0;
    }
}

}