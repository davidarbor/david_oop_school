import java.util.*;
/**
 * Created by h205p2 on 9/21/17.
 */
public class Section{
    public String name;
    public int maxSize;
    public int currentSize;
    public ArrayList<Student> students;
    public Teacher teacher;
    public Section(String name, int maxSize, int currentSize){
        this.name=name;
        this.maxSize=maxSize;
        this.currentSize=currentSize;
        this.students=new ArrayList<Student>();
    }
    public void addStudent(Student student){
        students.add(student);
        currentSize++;
    }
    public void removeStudent(Student student){
        students.remove(student);
        currentSize--;
    }
    public void sectionSeatsRemaining(){
        System.out.println(currentSize);
        if(currentSize==maxSize){
            System.out.println(name+" is full.");
        }
    }
}