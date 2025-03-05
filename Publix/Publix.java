public class publix
{

    public static class Student
    {
        private String firstName;
        private String lastName;
        private int age;

        public Student(String firstName, String lastName, int age)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        
        private String getFullName()
        {
            return this.firstName + " " + this.lastName;
        }
    
        public String getStudentDetails()
        {
            return "Student: " + this.firstName + " " + this.lastName + " is " + this.age + " years old.";
        }
    }
}
