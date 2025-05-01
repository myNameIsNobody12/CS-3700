public class Course
{
    private String courseName;
    private String instructor;
    private Student[] stuList;
    private double avgGrade;
    private int maxSize; //I know this should be done in the main method but I feel it would be better to handle at this level, plus it can be scaled to allow different sizes of course

    //the humble constructor
    public Course(String courseName, String instructor, Student[] stuList, double avgGrade, int maxSize)
    {
        this.courseName = courseName;
        this.instructor =instructor;
        this.stuList = (stuList == null) ? new Student[0] : stuList; //if I give a null list make it a blank array instead
        this.avgGrade = avgGrade;
        this.maxSize = maxSize;
    }

    //your average getters
    public String getCourseName()
    {
        if(this.courses[i] != null) //added protection from null
        {
            return this.courseName;
        }
    }
    public void setCourseName(String cor){this.courseName = cor;}
    public String getInstructor(){return this.instructor;}
    public void setInstructor(String inst){this.instructor = inst;}
    public Student[] getStudents(){return this.stuList;}
    public double getAvg(){return this.avgGrade;}
    public int getMax(){return this.maxSize;}
    public int getRemaningSeats(){return (this.maxSize - this.stuList.length);}

    public void setAvgGrade() //bit different from the average setter
    {
        double gradeSum = 0;
        for(int i = 0; i < this.stuList.length; i++)
        {
            if(this.stuList[i].getGrade().toUpperCase().equals("A"))
            {
                gradeSum = gradeSum + 100;
            }
            else if(this.stuList[i].getGrade().toUpperCase().equals("B"))
            {
                gradeSum = gradeSum + 89;
            }
            else if(this.stuList[i].getGrade().toUpperCase().equals("C"))
            {
                gradeSum = gradeSum + 79;
            }
            else if(this.stuList[i].getGrade().toUpperCase().equals("D"))
            {
                gradeSum = gradeSum + 69;
            }
            else
            {
                gradeSum = gradeSum + 0; //just so this won't raise an error
            }
        }
        gradeSum = gradeSum / this.stuList.length;
        this.avgGrade = gradeSum; // sum/n = avg
    }

    public void enroll(Student stu)
    {
        if(this.getRemaningSeats() > 0) //greater than so if a class somehow overfills it can't reoccur
        { //Java arrays list size isn't mutable if I remember corecctly so I create a copy of the array with the new course and save that as the updated registers
            Student[] tempLi = new Student[this.stuList.length + 1];
            for (int i=0; i<this.stuList.length; i++)
            {
                tempLi[i] = this.stuList[i]; //for each element of the original array copy to the temporary one

            }
            tempLi[this.stuList.length] = stu; // add new element
            this.stuList = tempLi; // make the official list what the temporary one was
            System.out.println("Course register updated.");
        }
        else
        {
            System.out.println("This class is already full.");
        }
    }

    public void showRoster()
    {
        System.out.println("Names of students in this class:");
        for (int i=0; i<this.stuList.length; i++)
        {
            System.out.println(this.stuList[i].toString());
        }
    }
}