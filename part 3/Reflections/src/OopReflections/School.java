package OopReflections;


public class School {
    private String name;
    private String level;
    private String address;
    private String[] students;
    private int studentCount;

    public School(String name, String level, String address) {
        this.name         = name;
        this.level        = level;
        this.address      = address;
        this.students     = new String[200];
        this.studentCount = 0;
    }

    public void enrol(String studentName) {
        if (studentCount < students.length) {
            students[studentCount] = studentName;
            studentCount++;
            System.out.println(studentName + " has been enrolled at " + name + ".");
        } else {
            System.out.println("School is full — cannot enrol " + studentName + ".");
        }
    }

    public void holdClass(String subject) {
        System.out.println(name + " is now holding a " + subject
                + " class for " + studentCount + " student(s).");
    }

    public int getNumStudents() { return studentCount; }
    public String getName()     { return name; }
    public String getLevel()    { return level; }
    public String getAddress()  { return address; }

    @Override
    public String toString() {
        return level + " school '" + name + "' with " + studentCount + " students";
    }
}