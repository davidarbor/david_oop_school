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
    public static void main(String[] args) {
        Student paul = new Student(12, "Paul", "Joseph");
        Student yungDan = new Student(12, "Yung", "Dan");
        Teacher albinson = new Teacher(2, "Matt", "Albinson");
        Section compSci = new Section("ComputerScience", 30, 0);
        compSci.teacher = albinson;
        sectionsArray.add(compSci);
        studentsArray.add(paul);
        studentsArray.add(yungDan);
        compSci.addStudent(yungDan);

        System.out.println("Hello, user. What would you like to do?");
        System.out.println("Type 's' to create a new section, 'a' to add a student to a section, or 'r' to remove a student from a section.");

        options(scan.next());
    }
    public static void options(String userInput){
        switch(userInput){
            case "s":
                createSection();
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
        }
    }
    public static void createSection(){
        System.out.println("What is the name of the section? (DO NOT INCLUDE SPACES)");
        String sectionName=scan.next();
        System.out.println("Name of the section: "+sectionName+". What is the maximum size of the section?");
        int sectionSize=Integer.parseInt(scan.next());
        System.out.println("The maximum size of "+sectionName+" is "+sectionSize+".");
        Section brandNewSection=new Section(sectionName, sectionSize, 0);
        sectionsArray.add(brandNewSection);
    }
    public static void addAStudent(){
        System.out.println("Search students by their ID to add them to a section.");
        int studentID=scan.nextInt();
        System.out.println("The ID you have searched for is "+studentID+".");
        for(int i=0; i<studentsArray.size(); i++){
            if(studentsArray.get(i).id==studentID){
                System.out.println("Student with this ID: "+studentsArray.get(i).firstName+" "+studentsArray.get(i).lastName+".");
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
                System.out.println("What section would you like to remove this student from?");
                String sectionNameGuess=scan.next();
                for(int j=0; j<sectionsArray.size(); j++){
                    if(sectionsArray.get(j).name.equals(sectionNameGuess)){
                        System.out.println("Current size of this course: "+sectionsArray.get(j).students.size());
                        sectionsArray.get(j).removeStudent(studentsArray.get(i));
                        System.out.println(studentsArray.get(i).firstName+" "+studentsArray.get(i).lastName+" has been removed from "+sectionNameGuess+".");
                        System.out.println("Current size of this course: "+sectionsArray.get(j).students.size());
                    }
                }
            }
        }
    }
    public static void checkAgain(){
        System.out.println("Type 'y' to continue.");
        if(scan.next().equals("y")){

        }
    }
}