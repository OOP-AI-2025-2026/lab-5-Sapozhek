package ua.opnu;

public abstract class GameShape {

    // Ім'я фігури (для виводу)
    public abstract String getName();

    @Override
    public String toString() {
        return getName();
    }
}
