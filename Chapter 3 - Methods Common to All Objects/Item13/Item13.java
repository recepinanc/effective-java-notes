public class Item13 {
    public static void main(String[] args) {
        PersonC p = new PersonC("Recep Inanc", 22);
        // p.clone(); calling this before adding a public clone method inside PersonC class
        // will not compile and warn us : .clone() method has protected access in java.lang.Object
        // because we add "implements Cloneable".

        try {
            PersonC pCloned = (PersonC) p.clone();
            System.out.println(pCloned);
            System.out.println(pCloned == p); // not the exact same objects so, false
            System.out.println(pCloned.equals(p)); // logically the same objects acc. to our equals() implementation so, true
            System.out.println(pCloned.getClass() == p.getClass()); // one of the requirements of clone contract.
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        PersonC pCloned2 = new PersonC(p); // no need to handle exception
        System.out.println(pCloned2 == p); // not the exact same objects so, false
        System.out.println(pCloned2.equals(p)); // logically the same objects acc. to our equals() implementation so, true
        System.out.println(pCloned2.getClass() == p.getClass()); // one of the requirements of clone contract.

    }
}

class PersonC implements Cloneable {
    private String name;
    private int age;

    PersonC(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructors are a better alternative to the fragile and complex clone methods.
    PersonC(PersonC objectToCopy) {
        this.name = objectToCopy.getName();
        this.age = objectToCopy.getAge();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) // to ensure x.equals(x) is always true
            return true;
        if (!(obj instanceof PersonC))
            return false;
        PersonC that = (PersonC) obj;

        return that.age == this.age && that.name.equals(this.name);
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
