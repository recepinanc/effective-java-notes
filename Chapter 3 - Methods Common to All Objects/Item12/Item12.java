public class Item12 {
    public static void main(String[] args) {
        Person p = new Person("Recep Inanc", 22);
        PersonOverridden p2 = new PersonOverridden("Recep Inanc", 22);

        System.out.println(p); // looks confusing

        System.out.println(p2); // more informative.
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class PersonOverridden {
    private String name;
    private int age;

    PersonOverridden(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person = {");
        sb.append("{ 'name' = ").append(name);
        sb.append(" },");
        sb.append("{ 'age' = ").append(age);
        sb.append(" }}");
        return sb.toString();
    }
}
