package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    // ---- Конструктори ----

    // 0) Без аргументів – 0 год 0 хв
    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    // 1) Один аргумент – хвилини
    public TimeSpan(int minutes) {
        setFromTotalMinutes(minutes);
    }

    // 2) Два аргументи – години та хвилини
    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            // Некоректні дані – робимо 0:00
            this.hours = 0;
            this.minutes = 0;
        } else {
            int total = hours * 60 + minutes;
            setFromTotalMinutes(total);
        }
    }

    // 3) Один аргумент типу TimeSpan – конструктор копіювання
    public TimeSpan(TimeSpan other) {
        if (other == null) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = other.hours;
            this.minutes = other.minutes;
        }
    }

    // ---- Гетери ----

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // ---- Допоміжний метод нормалізації ----

    private void setFromTotalMinutes(int totalMinutes) {
        if (totalMinutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }

    private int getTotalMinutesInternal() {
        return hours * 60 + minutes;
    }

    // ---- add(...) – перевантаження ----

    // 1) add(години, хвилини)
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            return; // некоректні аргументи – нічого не міняємо
        }
        int total = getTotalMinutesInternal() + hours * 60 + minutes;
        setFromTotalMinutes(total);
    }

    // 2) add(хвилини)
    public void add(int minutes) {
        if (minutes < 0) {
            return;
        }
        int total = getTotalMinutesInternal() + minutes;
        setFromTotalMinutes(total);
    }

    // 3) add(TimeSpan)
    public void add(TimeSpan span) {
        if (span == null) {
            return;
        }
        add(span.getHours(), span.getMinutes());
    }

    // Старий метод з лаби 2 – залишимо як “alias” (на всяк випадок)
    public void addTimeSpan(TimeSpan span) {
        add(span);
    }

    // ---- subtract(...) – перевантаження ----

    // 1) subtract(години, хвилини)
    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            return;
        }
        int delta = hours * 60 + minutes;
        int current = getTotalMinutesInternal();

        if (delta > current) {
            return; // не дозволяємо піти в мінус – нічого не змінюємо
        }

        setFromTotalMinutes(current - delta);
    }

    // 2) subtract(хвилини)
    public void subtract(int minutes) {
        if (minutes < 0) {
            return;
        }
        int current = getTotalMinutesInternal();

        if (minutes > current) {
            return;
        }

        setFromTotalMinutes(current - minutes);
    }

    // 3) subtract(TimeSpan)
    public void subtract(TimeSpan span) {
        if (span == null) {
            return;
        }
        subtract(span.getHours(), span.getMinutes());
    }

    // ---- Інші методи з попередньої лаби ----

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return getTotalMinutesInternal();
    }

    public void scale(int factor) {
        if (factor <= 0) {
            return;
        }
        int total = getTotalMinutesInternal() * factor;
        setFromTotalMinutes(total);
    }

    @Override
    public String toString() {
        return String.format("%d:%02d", hours, minutes);
    }
}
