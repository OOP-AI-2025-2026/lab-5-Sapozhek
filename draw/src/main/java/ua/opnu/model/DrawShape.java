package ua.opnu.model;

import java.awt.*;

/*
 * Клас "Фігура для малювання".
 * Клас містить початкову та кінцеву точку, а також різні методи
 */
public class DrawShape {

    // Константи для типів фігур
    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;
    public static final int SHAPE_ELLIPSE = 2;

    // Фабричний метод створення фігури потрібного типу
    public static DrawShape newInstance(int shapeType) {
        if (shapeType == SHAPE_RECTANGLE) {
            return new Rectangle();
        } else if (shapeType == SHAPE_ROUNDED_RECT) {
            return new RoundedRectangle();
        } else if (shapeType == SHAPE_ELLIPSE) {
            return new Ellipse();
        } else {
            // на всякий випадок — прямокутник за замовчуванням
            return new Rectangle();
        }
    }

    // Початкова та кінцева точки
    private Point startPoint;
    private Point endPoint;

    // Конструктор без параметрів
    public DrawShape() {
        this(new Point(0, 0), new Point(0, 0));
    }

    // Конструктор з початковими координатами
    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // Метод повертає фігуру, яку можна намалювати
    public Shape getShape() {
        return this.getShape(startPoint, endPoint);
    }

    // Базова реалізація — для нащадків, тут нічого
    public Shape getShape(Point startPoint, Point endPoint) {
        return null;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
