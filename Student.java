public class Student
{
    private int id;
    private String name;
    private double GPA;
    private String grade; //will be used in other functions to have grades in class
    
    public Student(int id, String  name, double GPA, String grade)
    {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
        this.grade = grade; //this doesn't mean anything at this level but the idea is that at the course level it can be used to update the average
    }
    
    public int getID(){return this.id;}
    public void setID(int newID){this.id = newID;}
    public String getName(){return this.name;}
    public void setName(String newName){this.name = newName;}
    public double getGPA(){return this.GPA;}
    public void setGPA(double newGPA){this.GPA = newGPA;}
    public String getGrade(){return this.grade;}
    public void setGrade(String newGrade){this.grade = newGrade;}
    
    @Override
    public String toString()
    {
        return "Student: " + this.getName() + " ID: " + this.getID() + " GPA: " + this.getGPA() + "\n"; //does not have grade because it is wouldn't make sense in this version
    }
}