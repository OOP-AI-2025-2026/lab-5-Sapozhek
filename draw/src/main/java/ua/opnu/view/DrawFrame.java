package ua.opnu.view;

import ua.opnu.model.DrawShape;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Головне вікно програми. Фрейм (клас JFrame) є контейнером верхнього рівня
 */
public class DrawFrame extends JFrame {

    // Область для малювання фігур
    private PaintSurface surface;

    // У конструкторі створюємо GUI
    public DrawFrame(String title) {
        super(title);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(setButtonPanel(), BorderLayout.NORTH);

        surface = new PaintSurface();
        this.add(surface, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    /*
     * Верхня панель з кнопками.
     */
    private JPanel setButtonPanel() {

        JPanel buttonPanel = new JPanel(true);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));

        // 1. Rectangle
        BigTextButton rect = new BigTextButton("Rectangle");
        rect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_RECTANGLE));
        buttonPanel.add(rect);

        // 2. Rounded rect
        BigTextButton rounded_rect = new BigTextButton("Rounded rect.");
        rounded_rect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT));
        buttonPanel.add(rounded_rect);

        // 3. Ellipse
        BigTextButton ellipseButton = new BigTextButton("Ellipse");
        ellipseButton.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ELLIPSE));
        buttonPanel.add(ellipseButton);

        // 4. Clear (додатковий бал)
        BigTextButton clearButton = new BigTextButton("Clear");
        clearButton.addActionListener(e -> surface.clearShapes());
        buttonPanel.add(clearButton);

        return buttonPanel;
    }
}
