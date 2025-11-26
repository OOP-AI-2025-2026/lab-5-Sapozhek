package ua.opnu;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[4];

        people[0] = new Student("Сапожнікова", "Ірина", 19, "AI-242", "ST12345");
        people[1] = new Student("Коваль", "Олена", 20, "AI-242", "ST54321");

        people[2] = new Lecturer("Петренко", "Ігор", 45, "Інформатики", 25000);
        people[3] = new Lecturer("Гнатюк", "Марія", 50, "Математики", 28000);

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}
