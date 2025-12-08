import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraPassosTempo extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

    private double getDistanciaMetros() {
        double distancia = Double.parseDouble(txtDistancia.getText());
        String unidade = (String) cmbUnidade.getSelectedItem();

        if (unidade.equals("Quilômetros")) {
            distancia *= 1000;
        }
        return distancia;
    }

    //codigo 3 aq

    // Código 4
    private void calcularTempo() {
        try {
            double distancia = getDistanciaMetros();

            // Velocidade média: 5 km/h = 5000 m / 1h=3600s
            double velocidade = 5000.0 / 3600.0; //vai dar ±1.39
            double tempoSegundos = distancia / velocidade;

            int horas = (int) (tempoSegundos / 3600);
            int minutos = (int) ((tempoSegundos % 3600) / 60);
            int segundos = (int) (tempoSegundos % 60);

            lblResultadoTempo.setText(
                    String.format("Tempo: %02dh %02dm %02ds", horas, minutos, segundos)
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Insira valores válidos!");
        }
    }
}