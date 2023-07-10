
package util;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class tabla extends JTable {
    private Color startColor;
    private Color endColor;

    public tabla(TableModel model) {
        super(model);
        startColor = new Color(63, 226, 184); // Color inicial del gradiente
        endColor = new Color(12, 64, 160);   // Color final del gradiente

        // Establecer el renderizador de celdas personalizado
        setDefaultRenderer(Object.class, new GradientCellRenderer());
    }

    // Renderizador de celdas personalizado para aplicar el gradiente de colores
    class GradientCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Calcular el gradiente de color
            int tableHeight = table.getHeight();
            int cellHeight = table.getRowHeight();

            float fraction = (float) row / (table.getRowCount() - 1);
            int red = (int) (startColor.getRed() * (1 - fraction) + endColor.getRed() * fraction);
            int green = (int) (startColor.getGreen() * (1 - fraction) + endColor.getGreen() * fraction);
            int blue = (int) (startColor.getBlue() * (1 - fraction) + endColor.getBlue() * fraction);

            Color gradientColor = new Color(red, green, blue);

            // Establecer el color de fondo del componente de la celda
            cellComponent.setBackground(gradientColor);

            return cellComponent;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (g instanceof Graphics2D) {
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gradientPaint = new GradientPaint(
                    0, 0, startColor,
                    0, getHeight(), endColor
            );
            g2d.setPaint(gradientPaint);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        } else {
            super.paintComponent(g);
        }
    }
}