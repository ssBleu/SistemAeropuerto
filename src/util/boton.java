package util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class boton extends javax.swing.JButton {

    private Color Linea = Color.yellow;
    private Color colorLinea = new Color(0, 0, 255);
    private java.awt.Color Color1 = new java.awt.Color(255, 0, 0);
    private java.awt.Color Color2 = new java.awt.Color(0, 255, 0);
    private float alpha = 1.0f;

    public boton() {
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(100, 30));
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setFont(new Font("Tahoma", 0, 18));
        this.setForeground(Color.black);
        this.setText("");
        addMouseListener(new Adaptador());
    }

    @Override
    protected void paintComponent(java.awt.Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradient = new GradientPaint(0.0F, 0.0F, this.Color1, 0.0F, getHeight(), this.Color2, false);
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
                        Linea = colorLinea;
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
                        Linea = Color.yellow;
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
                        Linea = Color.yellow;
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