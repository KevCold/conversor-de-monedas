package kevcold.alura.challengeconversor.modelos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraDeCargaOptionPane {

    public void mostrarBarraDeCarga(String mensaje, int tiempo) {
        // Crear una barra de progreso indeterminada
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true); // Indeterminado para mostrar que está trabajando

        // Crear un cuadro de diálogo con la barra de progreso
        JOptionPane optionPane = new JOptionPane(progressBar, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
        JDialog dialog = optionPane.createDialog(null, mensaje);

        // Configurar el diálogo para que no bloquee otras operaciones
        dialog.setModal(false);

        // Configurar un temporizador para cerrar automáticamente el diálogo después del tiempo especificado
        Timer timer = new Timer(tiempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Cerrar el diálogo
            }
        });
        timer.setRepeats(false); // Detener el temporizador después de ejecutarse una vez
        timer.start(); // Iniciar el temporizador

        // Mostrar el diálogo
        dialog.setVisible(true);
    }
}
