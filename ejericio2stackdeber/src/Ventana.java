import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JButton btnComprobar;
    private JLabel lblCodigo;
    private JTextArea txtMostar;

    private JTextArea txtTexto;

    private Pila data = new Pila();



    public Ventana() {
        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String codigo = txtTexto.getText();

                    if (codigo.trim().isEmpty()) {
                        throw new Exception("Debes ingresar un código antes de comprobar.");
                    }

                    Pila pilas = new Pila();

                    for (int i = 0; i <= codigo.length() - 1; i++) {
                        char caracter = codigo.charAt(i);
                        if (caracter == '(' || caracter == '{' || caracter == '[') {
                            pilas.insertar(String.valueOf(caracter));
                        } else {
                            if (caracter == ')') {
                                char salida = pilas.extraer().charAt(0);
                                if (salida != '(') {
                                    JOptionPane.showMessageDialog(null, "Código no balanceado");
                                    return;
                                }
                            } else if (caracter == '}') {
                                char salida = pilas.extraer().charAt(0);
                                if (salida != '{') {
                                    JOptionPane.showMessageDialog(null, "Código no balanceado");
                                    return;
                                }
                            } else if (caracter == ']') {
                                char salida = pilas.extraer().charAt(0);
                                if (salida != '[') {
                                    JOptionPane.showMessageDialog(null, "Código no balanceado");
                                    return;
                                }
                            }
                        }
                    }

                    if (pilas.esVacia()) {
                        JOptionPane.showMessageDialog(null, "Código balanceado");
                        data.insertar(codigo);
                        txtMostar.setText(data.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Código no balanceado");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
