public class Student {

    int grade, cls;
    String firstName, lastName;

    Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        //
        int B = 31, hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Student another = (Student)o;
        return grade == another.grade &&
                cls == another.cls &&
                firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }
}
