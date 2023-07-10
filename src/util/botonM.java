
package util;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class botonM extends JButton {

    private Color lineColor = new Color(0, 153, 255);
    private Color colorLine = new Color(51, 102, 255);
    private Color color1 = new Color(51, 153, 255);
    private Color color2 = new Color(0, 204, 255);
    private float alpha = 1.0f;

    public botonM() {
        setOpaque(true);
        setPreferredSize(new Dimension(100, 30));
        setFocusPainted(false);
        setContentAreaFilled(false);
        setFont(getFont().deriveFont(18f));
        setForeground(Color.white);
        setText("");
        addMouseListener(new Adaptador());
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradient = new GradientPaint(0.0F, 0.0F, color1, 0.0F, getHeight(), color2, false);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        super.paintComponent(g2);
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    public class Adaptador extends MouseAdapter {
        @Override
        public void mouseExited(MouseEvent me) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (float i = 1f; i >= .7f; i -= .03f) {
                        setAlpha(i);
                        lineColor = colorLine;
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                        }
                    }
                }
            }).start();
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (float i = .7f; i <= 1f; i += .03f) {
                        setAlpha(i);
                        lineColor = new Color(255, 255, 255);
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                        }
                    }
                }
            }).start();
        }

        @Override
        public void mousePressed(MouseEvent me) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (float i = 1f; i >= 0.7f; i -= .1f) {
                        setAlpha(i);
                        lineColor = new Color(255, 255, 255);
                        try {
                            Thread.sleep(1);
                        } catch (Exception e) {
                        }
                    }
                }
            }).start();
        }
    }
}
