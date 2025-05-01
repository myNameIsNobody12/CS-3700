/* Final project CS 3700
* Goal of this project was to create a basic university management system
* Code will begin by asking for a student, course, and department so that the base function can start, from there the system will allow the user to edit as needed
* Author: Jordan Merriman
* Date 4/26/2025
*/
import java.util.Scanner;
public class University
{
    private String name;
    private Department[] deps;
    private Student[] stu; // total registry of students
    private String[] ins; //instructor list, i'm lazy and don't want to type everytime

    public University(String name, Department[] deps,  Student[] stu, String[] ins)
    {
        this.name = name;
        this.deps = deps;
        this.stu = stu;
        this.ins = ins;
    }

    public String getName(){return this.name;}
    public void setName(String newName){this.name = newName;}
    public Department[] getDepartments(){return this.deps;}
    public void addDep(Department newDep)
    {
        if(this.deps.length <= 3) //same idea as every other add to list function
        {
            Department[] temp = new Department[this.deps.length +1];
            for(int i = 0; i< this.deps.length; i++)
            {
                temp[i] = this.deps[i];
            }
            temp[this.deps.length] = newDep;
            this.deps = temp;
        }
        else
        {
            System.out.println("This university can not support another department, to create this department remove another. We are sorry for this inconvienence");
        }
    }
    public void rmDep(String remove) //no longer used
    {
        Department[] temp = new Department[this.deps.length -1]; //minus one so it won't have extra space
        for(int i = 0; i < this.deps.length; i++)
        {
            if(this.deps[i].toUpperCase() != remove)
            {
                temp[i] = this.deps[i];
            }
        }
        this.deps = temp;
    }

    public Student[] getStu(){ return this.stu;}
    public void addStu(Student st)
    {
        boolean contains = false; //so we won't get doubles
        for(int i = 0; i<this.stu.length; i++)
        {
            if(st.getName().equals(this.stu[i].getName()))
            {
                contains = true;
                System.out.println("Student is already in the system.");
            }
        }
        if(contains == false)
        {
        Student[] tempLi = new Student[this.stu.length + 1];
            for (int i=0; i<this.stu.length; i++)
            {
                tempLi[i] = this.stu[i]; 

            }
        tempLi[this.stu.length] = st; 
        this.stu = tempLi; 
        System.out.println("Updated.");
        }
    }
    public String[] getIns(){return this.ins;}
    public void addIns(String nIns) //don't check if the new instructor is in yet, this will be done before this is called
    {
        String[] temp = new String[this.ins.length +1];
        for(int i = 0; i < this.ins.length; i++)
        {
            temp[i] = this.ins[i];
        }
        temp[temp.length -1] = nIns;
        this.ins = temp;
    }




    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);// there is going to be a lot of inputs
        System.out.println("Welcome to Admin, to begin we must first set up some background info\nCreate a Student\nName:");
        String sName = input.nextLine();
        System.out.println("ID:");
        int sID = input.nextInt();
        System.out.println("GPA: ");
        double sGPA = input.nextDouble();
        Student s1 = new Student(sID, sName, sGPA, "");//no grade for original student
        input.nextLine(); // buffer
        System.out.println("\nNow create a Course this student is in:\nCourse Name:");
        String cName = input.nextLine();
        System.out.println("an Instructor for this course:");
        String cIns = input.nextLine();
        System.out.println("Give your student a grade for this class ex.) A, B, etc:");
        String sGrade = input.nextLine().toUpperCase();
        s1.setGrade(sGrade);
        Student[] stu = {s1}; //done this so I can put it into course
        Course c1 = new Course(cName, cIns, stu, 0.0, 10); //first course created
        c1.setAvgGrade();

        System.out.println("\ncreate the department this course is in\nName:");
        String dName = input.nextLine();
        Course[] cors = {c1};
        String[] i = {c1.getInstructor()};
        Department d1 = new Department(dName, cors, cors.length, i);
        System.out.println("\nFinally give the university a name:");
        String uName = input.nextLine();
        Department d2 = new Department("Placeholder", null, 0, null);
        Department d3 = new Department("Placeholder", null, 0, null);
        Department[] d = {d1, d2, d3};
        University uni = new University(uName, d, stu, i);
        System.out.println("Setup complete, now initiating system.");

        while(true)
        {//the plan is simple, multiple loops so that if you choose a directory you stay until you wish to go back a level
            System.out.println("Welcome to " + uni.getName() + "'s Admin system, what would you like to do?\n1.) Access " + uni.getDepartments()[0].getDepName()+ "\n2.) Access " + uni.getDepartments()[1].getDepName() + "\n3.) Access " + uni.getDepartments()[2].getDepName() +"\n4.)Exit\n");
            int choice = input.nextInt();
            int deppy;
            boolean runner = false;
            deppy = choice - 1;
            if(choice >= 4)
            {
                System.out.println("Thank you for using our service!");
                input.close();
                System.exit(0);
            }
            else
            {runner = true;}
                while(runner == true) //affectively this is a file directory so users may move in and out of each "file", I thought this might be the most intuitive way for a user to think
                {
                    System.out.println(uni.getName() + " > " + uni.getDepartments()[deppy].getDepName()+ "\n");

                    System.out.println("What would you like to do?\n1.) Change this departments name\n2.) Add a new course \n3.) Access existing course\n4.) Show all courses\n5.) Back");
                    int dew = input.nextInt();

                    switch(dew)
                    {
                        case 1:
                        System.out.println("What would you like the new name to be?:");
                        input.nextLine(); //buffer time... again
                        String newName = input.nextLine();
                        uni.getDepartments()[deppy].setDepName(newName);
                        break;

                        case 2:
                        System.out.println("Adding new course\nName:");
                        input.nextLine();// buffer
                        cName = input.nextLine();
                        System.out.print("Instructor: ");
                        cIns = input.nextLine();
                        Course newCourse = new Course(cName, cIns, null, 0.0, 10);
                        uni.getDepartments()[deppy].addCourse(newCourse);
                        uni.getDepartments()[deppy].updateInstr(cIns);
                        uni.addIns(cIns);
                        System.out.println("Updated");
                        break;

                        case 3:
                        System.out.println("Which Course would you like to access?\n1.)Return to " + uni.getDepartments()[deppy].getDepName());
                        for(int e = 2; e< (uni.getDepartments()[deppy].getCourses().length + 2); e++) // only shows the Courses that exist while also allowing this list to grow
                        {
                            System.out.println(e + ".) " + uni.getDepartments()[deppy].getCourses()[e-2].getCourseName());  
                        }
                        int courey = input.nextInt() - 2;
                        if(courey >=0 && courey <uni.getDepartments()[deppy].getCourses().length)
                        {
                            while(true)
                            {
                                System.out.println(uni.getName() + " > " + uni.getDepartments()[deppy].getDepName()+ ">" + uni.getDepartments()[deppy].getCourses()[courey].getCourseName() + "\n");
                                System.out.println("What would you like to do?\n1.) Enroll student\n2.) Show Roster\n3.) Show average grade\n4.) Back (any other input)");
                                int ch = input.nextInt();
                                if(ch == 1)
                                {
                                    System.out.println("Name: ");
                                    input.nextLine();
                                    sName = input.nextLine();
                                    System.out.println("ID: ");
                                    sID = input.nextInt();
                                    System.out.println("GPA: ");
                                    sGPA = input.nextDouble();
                                    System.out.println("Grade (for this class): ");
                                    input.nextLine(); //buffer
                                    sGrade = input.nextLine();
                                    Student newStudent = new Student(sID, sName, sGPA, sGrade);
                                    uni.getDepartments()[deppy].getCourses()[courey].enroll(newStudent);
                                    uni.addStu(newStudent);
                                    System.out.println("updated.");
                                }
                                else if(ch == 2)
                                {
                                    uni.getDepartments()[deppy].getCourses()[courey].showRoster();
                                }
                                else if(ch == 3)
                                {
                                    System.out.println("Average grade (%): " + uni.getDepartments()[deppy].getCourses()[courey].getAvg());
                                }
                                else
                                {
                                    break;
                                }
                            }
                        }
                        break;

                        case 4:
                        uni.getDepartments()[deppy].showCouses();
                        break;

                        case 5:
                        runner = false;
                        break;
                    }
                    

                }
        }
    }
}