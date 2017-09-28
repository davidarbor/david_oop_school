import java.util.Scanner;
import java.util.*;
/**
 * Created by h205p2 on 9/19/17.
 */
public class Runner{
    public static void main(String[] args){
        ArrayList<Section> sectionsArray=new ArrayList<Section>();
        ArrayList<Student> studentsArray=new ArrayList<Student>();
        Scanner scan=new Scanner(System.in);
        Student paul=new Student(12, "Paul", "Joseph");
        Student yungDan=new Student(12, "Yung", "Dan");
        Teacher albinson=new Teacher(2, "Matt", "Albinson");
        Section compSci=new Section("Computer Science", 30, 0);
        compSci.teacher=albinson;
        sectionsArray.add(compSci);
        studentsArray.add(paul);
        studentsArray.add(yungDan);

        System.out.println("Hello, user. What would you like to do?");
        System.out.println("Type 's' to create a new section, 'a' to add a student to a section, or 'r' to remove a student from a section.");

        String userInput=scan.next();

        switch(userInput){
            case "s":
                System.out.println("What is the name of the section?");
                String sectionName=scan.next();
                System.out.println("Name of the section: "+sectionName+". What is the maximum size of the section?");
                int sectionSize=Integer.parseInt(scan.next());
                System.out.println("The maximum size of "+sectionName+" is "+sectionSize+".");
                Section brandNewSection=new Section(sectionName, sectionSize, 0);
                System.out.println("What would you like to do?");
                System.out.println("Type 's' to create a new section, 'a' to add a student to a section, or 'r' to remove a student from a section.");
                sectionsArray.add(brandNewSection);
                break;
            case "a":
                System.out.println("Search students by their ID to add them to a section.");
                int studentID=scan.nextInt();
                System.out.println("The ID you have searched for is "+studentID+".");
                for(int i=0; i<studentsArray.size(); i++){
                    if(studentsArray.get(i).id==studentID){
                        System.out.println("Student with this ID: "+studentsArray.get(i).firstName+" "+studentsArray.get(i).lastName+".");
                        System.out.println("What section would you like to add this student to?");

                    }
                }
                break;
            case "r":
                System.out.println("Search students by their ID to remove them from a section.");
                int otherID=scan.nextInt();
                System.out.println("The ID you have searched for is"+otherID+".");
                for(int i=0; i<studentsArray.size(); i++){
                    if(studentsArray.get(i).id==otherID){
                        System.out.println("Student with this ID: "+studentsArray.get(i).firstName+" "+studentsArray.get(i).lastName+".");
                        System.out.println("What section would you like to remove this student from?");
                    }
                }
                break;
        }
    }
}