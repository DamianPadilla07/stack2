import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JLabel lblCodigo;

    public Ventana() {
        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              try {
                  Pila pilas = new Pila();
                  String codigo = txtCodigo.getText();
                  for (int i = 0; i <= codigo.length()-1; i++) {
                      char c = codigo.charAt(i);
                      if (c == '(' || c== '{' || c=='[') {
                          pilas.insertar(String.valueOf(c));
                      } else {
                          if (c == ')') {
                              char salida = pilas.extraer().charAt(0);
                              if (salida != '(') {
                                  JOptionPane.showMessageDialog(null, "codigo no balanceado");
                                  return;
                              }
                          }else{
                              if (c == '}') {
                                  char salida = pilas.extraer().charAt(0);
                                  if (salida != '{') {
                                      JOptionPane.showMessageDialog(null, "codigo no balanceado");
                                      return;
                                  }
                              }else{
                                  if (c == ']') {
                                      char salida = pilas.extraer().charAt(0);
                                      if (salida != '[') {
                                          JOptionPane.showMessageDialog(null, "codigo no balanceado");
                                          return;
                                      }
                                  }
                              }
                          }

                      }

                  }
                  if (pilas.esVacia())
                      JOptionPane.showMessageDialog(null, "Codigo balanceado");
                  else
                      JOptionPane.showMessageDialog(null, "Codigo no balanceado");
              } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null,ex.getMessage());
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
