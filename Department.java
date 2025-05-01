public class Department
{
    private String depName;
    private Course[] courses;
    private int numOfClass;
    private String[] instructors;

    public Department(String depName, Course[] courses, int numOfClass, String[] instuctors)
    {
        this.depName = depName;
        this.courses = courses;
        this.numOfClass = numOfClass;
        this.instructors = instructors;
    }

    public String getDepName(){return this.depName;}
    public void setDepName(String newDepName){this.depName = newDepName;}
    public Course[] getCourses(){return this.courses;}
    public int getNum(){return this.numOfClass;}
    public String[] getInstructors(){return this.instructors;}
    public void setNum(){this.numOfClass = this.courses.length;} //ensures that the number of classes is accurate

    public void updateInstr(String inst)
    {
        String[] tempLi = new String[this.courses.length + 1];
        for (int i = 0; i < this.courses.length; i++)
        {
            tempLi[i] = this.courses[i].getInstructor(); //we want specifacally the instructors
        }
        tempLi[this.courses.length -1] = inst;
        this.instructors = tempLi;
    }
    public void addCourse(Course newCor)
    { //same methodology as enroll() in Course
        if(numOfClass < 5 && numOfClass >= 0)//make sure its 0 <= x < 5
        {
            Course[] tempLi = new Course[this.courses.length +1];
            for(int i = 0; i< this.courses.length; i++)
            {
                tempLi[i] = this.courses[i];
            }
            tempLi[this.courses.length] = newCor;
            this.courses = tempLi;
            this.setNum();
            System.out.println("Course register updated.");
        }
        else
        {
            System.out.println("Course limit exceeded at this department.");
        }
    }

    public void showCouses() 
    {
        //same methodolgy as showRoster()
        System.out.println("all Courses in " + this.getDepName());
        for (int i = 0; i < this.numOfClass; i++)
        {
            System.out.println(this.courses[i].getCourseName());
        }
    }
}