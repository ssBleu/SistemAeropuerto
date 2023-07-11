package util;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Convertir el valor en un ImageIcon y establecerlo en un JLabel para mostrarlo en la celda
        if (value instanceof ImageIcon) {
            setIcon((ImageIcon) value);
        }
        return this;
    }
}