package util;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class Cbox extends JComboBox<String> {

    private static final Color BACKGROUND_COLOR = new Color(240, 240, 240);
    private static final Color BORDER_COLOR = new Color(200, 200, 200);
    private static final Color FOCUS_BORDER_COLOR = new Color(100, 149, 237);
    private static final Color SELECTION_BACKGROUND = new Color(176, 224, 230);
    private static final Color SELECTION_FOREGROUND = Color.BLACK;

    public Cbox() {
        super(new DefaultComboBoxModel<>(new String[]{}));
        setUI(new ModernComboBoxUI());
        setBackground(BACKGROUND_COLOR);
        setBorder(null);
        setFont(getFont().deriveFont(Font.PLAIN));
        setPreferredSize(new Dimension(150, getPreferredSize().height));

        // Agregar listener para cambiar el color del borde cuando el combo obtiene o pierde el foco
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(BorderFactory.createLineBorder(FOCUS_BORDER_COLOR));
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
            }
        });
    }

    private class ModernComboBoxUI extends BasicComboBoxUI {

        @Override
        protected JButton createArrowButton() {
            return new ModernArrowButton();
        }

        @Override
        public void paintCurrentValueBackground(Graphics g, java.awt.Rectangle bounds, boolean hasFocus) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(getBackground());
            g2d.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }

        @Override
        protected ComboPopup createPopup() {
            return new ModernComboPopup(comboBox);
        }

        @Override
        protected ListCellRenderer createRenderer() {
            return new ModernComboBoxRenderer();
        }
    }

    private class ModernArrowButton extends BasicArrowButton {

        public ModernArrowButton() {
            super(BasicArrowButton.SOUTH);
            setOpaque(false);
            setBackground(BACKGROUND_COLOR);
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(getForeground());
            int x = (getWidth() - 8) / 2;
            int y = (getHeight() - 5) / 2;
            int[] xs = {x, x + 4, x + 8};
            int[] ys = {y, y + 5, y};
            g2d.fillPolygon(xs, ys, 3);
        }
    }

    private class ModernComboPopup extends BasicComboPopup {

        public ModernComboPopup(JComboBox comboBox) {
            super(comboBox);
            setOpaque(true);
            setBackground(BACKGROUND_COLOR);
        }
    }

    private class ModernComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            label.setBackground(isSelected ? SELECTION_BACKGROUND : BACKGROUND_COLOR);
            label.setForeground(isSelected ? SELECTION_FOREGROUND : getForeground());
            return label;
        }
    }
}
