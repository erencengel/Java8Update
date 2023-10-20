package day1_generic.students;

public class Runner {

    public static void main(String[] args) {

        //unprotected type
        Batch b5 = new Batch("B5");
        b5.addStudent(new SdetStudent("Eren"));
        b5.addStudent(new SdetStudent("Salma"));
        b5.addStudent(new SdetStudent("Eduard"));
        b5.addStudent(new SdetStudent("Sviatlana"));
        b5.addStudent(new SdetStudent("Val"));
        b5.addStudent(new JavaDevStudent("Ahmet"));
        b5.addStudent(new CyberSecurityStudent("Mehmet"));

        //protected type
        Batch<SdetStudent> b6 = new Batch<>("B6");
        b6.addStudent(new SdetStudent("Eren"));
        b6.addStudent(new SdetStudent("Salma"));
        b6.addStudent(new SdetStudent("Eduard"));
        b6.addStudent(new SdetStudent("Sviatlana"));
        b6.addStudent(new SdetStudent("Val"));

        //will not work
        //b6.addStudent(new JavaDevStudent("Vall"));
        //b6.addStudent(new CyberSecurityStudent("Vall"));

        Batch<CyberSecurityStudent> cB6 = new Batch<>("B6");
        cB6.addStudent(new CyberSecurityStudent("Jen"));
        cB6.addStudent(new CyberSecurityStudent("Lena"));

        //this two do not work after adding <B extends Student> because now only subclasses of Student can be defined as
        //Batch<String> a;
        //Batch<Integer> b;

    }
}
