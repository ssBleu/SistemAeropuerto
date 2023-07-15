
package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panelSlider extends JPanel {
    private JPanel menuPanel;
    private JPanel contentPanel;
    private boolean isExpanded;

    public panelSlider() {
        setLayout(new BorderLayout());

        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(40, 40));
        menuPanel.setBackground(Color.BLUE);
        menuPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleMenu();
            }
        });
        add(menuPanel, BorderLayout.WEST);

        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(0, 40));
        contentPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.setVisible(false);
        add(contentPanel, BorderLayout.CENTER);

        isExpanded = false;
    }

    private void toggleMenu() {
        if (isExpanded) {
            // Contraer el menú
            contentPanel.setVisible(false);
            menuPanel.setPreferredSize(new Dimension(40, 40));
            isExpanded = false;
        } else {
            // Expandir el menú
            contentPanel.setVisible(true);
            menuPanel.setPreferredSize(new Dimension(0, 40));
            isExpanded = true;
        }

        revalidate();
        repaint();
    }

    public void addContentComponent(Component component) {
        contentPanel.add(component);
    }
}
