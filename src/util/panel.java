package util;

import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class panel extends javax.swing.JPanel {

    private java.awt.Color Color1 = new java.awt.Color(153, 162, 199);//claro arriba
    //private java.awt.Color Color0 = new java.awt.Color(88, 143, 244);
    private java.awt.Color Color2 = new java.awt.Color(12, 64, 160);//oscuro abajo
    private float alpha = 1.0f;

    public panel() {
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(100, 30));
    }

    @Override
    protected void paintComponent(java.awt.Graphics grphcs) {
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0.0F, 0.0F, this.Color1, 0.0F, getHeight(), this.Color2, false);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }
}