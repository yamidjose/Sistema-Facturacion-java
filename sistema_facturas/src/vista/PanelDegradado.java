package vista;

import java.awt.*;
import javax.swing.JPanel;

public class PanelDegradado extends JPanel {

    private Color color1 = Color.WHITE; // Azul
    private Color color2 = new Color(000033);           // Rojo

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
