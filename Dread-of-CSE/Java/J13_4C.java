class Course {
  private String code;
  private double credit;
  private double mark;
  private double gpa;
  Course(String code, double mark, double gpa, double credit) {
    this.code = code;
    this.credit = credit;
    this.mark = mark;
    this.gpa = gpa;
  }
  public String getCode() {
    return code;
  }
  public double getMark() {
    return mark;
  }
  public double getGpa() {
    return gpa;
  }
  public double getCredit() {
    return credit;
  }
}
class Student {
  private Course[] courses;
  private String name;
  private long reg;
  private String dept;
  Student() {

  }
  Student(long reg, String name, String dept) {
    this.reg = reg;
    this.name = name;
    this.dept = dept;
  }
  public long getReg() {
    return reg;
  }
  public void setReg(long reg) {
    this.reg = reg;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDept() {
    return dept;
  }
  public void setDept(String dept) {
    this.dept = dept;
  }
  public String getInfo() {
    return "Name : " + getName() + ", REG : " + getReg() + ", DEPT : " + getDept();
  }
  public void setCourses(Course[] courses) {
    this.courses = courses;
  }
  public double getAvgMarks() {
    double sum = 0;
    for(int i = 0; i < courses.length; i++) sum += courses[i].getMark();
    return (sum / courses.length);
  }
  public double getCGPA() {
    double totalCredit = 0;
    double ownCredit = 0;
    for(int i = 0; i < courses.length; i++) {
      totalCredit += courses[i].getCredit();
      ownCredit += (courses[i].getGpa() * courses[i].getCredit());
    }
    return ownCredit / totalCredit;
  }
}

class J13_4C {
  public static void main(String[] args) {
    Course j = new Course("CSE233", 76.5, 3.75, 3.0);
    System.out.println("Code : " + j.getCode() + ", Credit : " + j.getCredit() + ", Mark : " + j.getMark() + ", GPA : " + j.getGpa());
    Course c = new Course("CSE133", 72.5, 3.5, 2.0);
    Student std = new Student(2020331093, "A", "CSE");
    Course courses[] = new Course[2];
    courses[0] = j; 
    courses[1] = c;
    std.setCourses(courses);
    System.out.println("NAME : " + std.getName() + ", REG : " + std.getReg() + ", DEPT : " + std.getDept() + "\nAVG Marks : " + std.getAvgMarks() + ", CGPA : " + std.getCGPA());
    std.setName("B");
    std.setReg(2020331093); 
    std.setDept("EEE");
    System.out.println(std.getInfo());
    std = new Student();
    System.out.println(std.getInfo());
  }
}
