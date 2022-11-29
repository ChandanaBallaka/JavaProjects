package practice;

class College {

    String name;
    Branch branches[]= new Branch[3];
    College(String name) {
        this.name = name;
       // this.branches = new Branch[3];
    }
    void addBranch(Branch branch) {
        branches.add(branch);
    }
    void addStudentToBranch(Student student, String branchName) {
        //search for the branch in the branch array
        for(int i = 0; i < branches.length; i++) {
            if(branches[i].name == branchName) {
                branches[i].addStudent(student);
            }
        }
    }
}
class Branch {
    String name;
    Student students[];
    Branch(String name) {
        this.name = name;
        students = new Student[3];
    }
    void addStudent( Student student) {
        students.add(student);
    }
}
class Student {
    String regNum;
    Student(String regNum){
        this.regNum=regNum;

    }
//Constructor
}
   public class Main{
        public static void main(String[] args) {

            College kvg = new College("KVG");

            Branch cs = new Branch("CSE");
            Branch ec = new Branch("ECE");
            Branch is = new Branch("ISE");

            Student s1 = new Student("101");
            Student s2 = new Student("102");
            Student s3 = new Student("103");

            kvg.addStudentToBranch(s1, "CSE");

            kvg.addBranch(cs);
            kvg.addBranch(ec);
            kvg.addBranch(is);

            kvg.addStudentToBranch(s1, "CSE");
            kvg.addStudentToBranch(s2, "CSE");
            kvg.addStudentToBranch(s3, "ECE");
            kvg.addStudentToBranch(s3, "ISE");
        }

    }