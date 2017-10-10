import java.util.Scanner;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by h205p2 on 9/19/17.
 */
public class Runner{
    static Scanner scan=new Scanner(System.in);
    static ArrayList<Section> sectionsArray=new ArrayList<Section>();
    static ArrayList<Student> studentsArray=new ArrayList<Student>();
    static ArrayList<Teacher> teachersArray=new ArrayList<Teacher>();
    public static void main(String[] args) {
        Student paul=new Student(12, "Paul", "Joseph");
        Student yungDan=new Student(12, "Yung", "Dan");
        Teacher albinson=new Teacher("Matt", "Albinson");
        Section compSci=new Section("ComputerScience", 30, 0);
        compSci.teacher=albinson;
        sectionsArray.add(compSci);
        studentsArray.add(paul);
        studentsArray.add(yungDan);

        System.out.println("Hello, user. What would you like to do?");
        System.out.println("Command list:");
        System.out.println("s: create a section");
        System.out.println("c: create a student");
        System.out.println("t: create a teacher");
        System.out.println("a: add a student to a section");
        System.out.println("r: remove a student from a section");

        options(scan.next());
    }
    public static void options(String userInput){
        switch(userInput){
            case "s":
                createSection();
                checkAgain();
                break;
            case "c":
                createStudent();
                checkAgain();
                break;
            case "t":
                createTeacher();
                checkAgain();
                break;
            case "a":
                addAStudent();
                checkAgain();
                break;
            case "r":
                removeAStudent();
                checkAgain();
                break;
            default:
                System.out.println("That is not a command. Please enter a valid input.");
                options(scan.next());
                break;
        }
    }
    public static void createSection(){
        System.out.println("What is the name of the section? (DO NOT INCLUDE SPACES)");
        String sectionName=scan.next();
        System.out.println("Name of the section: "+sectionName+". What is the maximum size of the section?");
        int sectionSize=scan.nextInt();
        System.out.println("The maximum size of "+sectionName+" is "+sectionSize+".");
        Section brandNewSection=new Section(sectionName, sectionSize, 0);
        sectionsArray.add(brandNewSection);
    }
    public static void createStudent(){
        System.out.println("What is the student's first name?");
        String studentFirstName=scan.next();
        System.out.println("What is the student's last name?");
        String studentLastName=scan.next();
        System.out.println("The student's name is "+studentFirstName+" "+studentLastName+". What grade is this student in?");
        int studentGrade=scan.nextInt();
        System.out.println("The student is in grade "+studentGrade+".");
        Student brandNewStudent=new Student(studentGrade, studentFirstName, studentLastName);
        studentsArray.add(brandNewStudent);
    }

    public static void createTeacher(){
        System.out.println("What is the teacher's first name?");
        String teacherFirstName=scan.next();
        System.out.println("What is the teacher's last name?");
        String teacherLastName=scan.next();
        System.out.println("The teacher's name is "+teacherFirstName+" "+teacherLastName+".");
        Teacher brandNewTeacher=new Teacher(teacherFirstName, teacherLastName);
        teachersArray.add(brandNewTeacher);
        System.out.println("What section will they be teaching?");
        String sectionToTeach=scan.next();
        for(int i=0; i<sectionsArray.size(); i++){
            if(sectionsArray.get(i).name.equals(sectionToTeach)){
                sectionsArray.get(i).teacher=brandNewTeacher;
                System.out.println(teacherFirstName+" "+teacherLastName+" has been assigned to "+sectionToTeach+".");
            }
        }
    }

    public static void addAStudent(){
        System.out.println("Search students by their ID to add them to a section.");
        int studentID=scan.nextInt();
        System.out.println("The ID you have searched for is "+studentID+".");
        for(int i=0; i<studentsArray.size(); i++){
            if(studentsArray.get(i).id==studentID){
                System.out.println("Student with this ID: "+studentsArray.get(i).firstName+" "+studentsArray.get(i).lastName+".");
                System.out.println("Search again? Type 'y' for yes or 'n' for no.");
                if(scan.next().equals("y")){
                    addAStudent();
                }
                System.out.println("What section would you like to add this student to?");
                String sectionNameGuess=scan.next();
                for(int j=0; j<sectionsArray.size(); j++){
                    if(sectionsArray.get(j).name.equals(sectionNameGuess)){
                        System.out.println("Current size of this course: "+sectionsArray.get(j).students.size());
                        sectionsArray.get(j).addStudent(studentsArray.get(i));
                        System.out.println(studentsArray.get(i).firstName+" "+studentsArray.get(i).lastName+" has been added to "+sectionNameGuess+".");
                        System.out.println("Current size of this course: "+sectionsArray.get(j).students.size());
                    }
                }
            }
        }
    }
    public static void removeAStudent(){
        System.out.println("Search students by their ID to remove them from a section.");
        int otherID=scan.nextInt();
        System.out.println("The ID you have searched for is "+otherID+".");
        for(int i=0; i<studentsArray.size(); i++){
            if(studentsArray.get(i).id==otherID){
                System.out.println("Student with this ID: "+studentsArray.get(i).firstName+" "+studentsArray.get(i).lastName+".");
                System.out.println("Search again? Type 'y' for yes or 'n' for no.");
                if(scan.next().equals("y")){
                    removeAStudent();
                }
                System.out.println("What section would you like to remove this student from?");
                String sectionNameGuess=scan.next();
                for(int j=0; j<sectionsArray.size(); j++){
                    if(sectionsArray.get(j).name.equals(sectionNameGuess)){
                        if(!(sectionsArray.get(j).students.contains(studentsArray.get(i)))){
                            System.out.println("The student you searched for is not in this section.");
                        }
                        else {
                            System.out.println("Current size of this course: " + sectionsArray.get(j).students.size());
                            sectionsArray.get(j).removeStudent(studentsArray.get(i));
                            System.out.println(studentsArray.get(i).firstName + " " + studentsArray.get(i).lastName + " has been removed from " + sectionNameGuess + ".");
                            System.out.println("Current size of this course: " + sectionsArray.get(j).students.size());
                        }
                    }
                }
            }
        }
    }
    public static void checkAgain(){
        System.out.println("Type 'y' to continue.");
        if(scan.next().equals("y")){
            System.out.println("Command list:");
            System.out.println("s: create a section");
            System.out.println("c: create a student");
            System.out.println("t: create a teacher");
            System.out.println("a: add a student to a section");
            System.out.println("r: remove a student from a section");
            options(scan.next());
        }
    }
}