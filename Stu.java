/*
 * Author: Jordan Merriman
 * Date: 2/10/25
 * Assignment 2
 */
public class Stu
{
    class Student
    {
        //every variable used
        private String firstName;
        private String lastName;
        private String stuID;
        private int age;
        private double gpa;
        private String major;
        private int credits;

        public Student(String firstName, String lastName, String stuID, int age, double gpa, String major, int credits)
        {
            this.firstName = firstName; // your objects info is the info given
            this.lastName = lastName;
            this.stuID = stuID;
            this.age = age;
            this.gpa = gpa;
            this.major = major;
            this.credits = credits;
        }
        public String getFullName()
        {
            return firstName + " " + lastName;
        }

        public String getStudentDetails()
        { 
            //returns the students info in the order: ID, Name, age, gpa, major, credits
            return "Student ID: " + stuID + ", Name: "+ firstName+ " " + lastName + ", Age: " + age + ", GPA: " + gpa + ", Major: " + major + ", Total credits: " + credits; 
        }

        public boolean isHonorsStudent()
        {
            //gpa required for honors is 3.5
            if (gpa >= 3.5)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public boolean eligiableForGraduation()
        {
            //checking the eligibility excluding required classes
            if (credits >= 120)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public double updateGPA(double newGPA)
        {
            //updates the GPA returns the gpa
            this.gpa = newGPA;
            return gpa;
        }
        public String compareGPA(Student otherStudent)
        {
            // compares gpas and says which is better, if their the same print so
            if (this.gpa > otherStudent.gpa)
            {
                return this.getFullName() + " has the better GPA.";
            }
            else if (this.gpa < otherStudent.gpa)
            {
                return otherStudent.getFullName() + " has the better GPA.";
            }
            else
            {
                return "Both students have the same GPA.";
            }
        }

    }

    public static void main(String [] args)
    {
        Stu indianaTech = new Stu(); //creates the occurence of the first class so I can use it to create the objects
        Student x = indianaTech.new Student("Jordan", "Merriman", "720512014", 19, 4.0, "Computer Science", 55);
        Student y = indianaTech.new Student("Bill", "Kanegy", "512204158", 20, 2.8, "Buisness Administration", 121);
        Student z = indianaTech.new Student("Hayden", "Brownning", "123456789", 19, 3.6, "Mechanical Engineeering", 24);
        System.out.println(x.getStudentDetails() + ", Honors Student: " + x.isHonorsStudent());
        System.out.println(y.getStudentDetails() + ", Honors Student: " + y.isHonorsStudent());
        System.out.println(z.getStudentDetails() + ", Honors Student: " + z.isHonorsStudent());
        System.out.println(x.compareGPA(y));
        y.updateGPA(4.1);
        System.out.println(x.compareGPA(y));
        y.updateGPA(3.6);
        System.out.println(y.compareGPA(z));
        // show updated info
        System.out.println("New student info: \n" + y.getStudentDetails() + ", Honors Student: " + y.isHonorsStudent());
    }

}