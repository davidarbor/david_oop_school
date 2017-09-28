import java.util.Scanner;
import java.util.*;
/**
 * Created by h205p2 on 9/21/17.
 */
public class Student extends Person{
    public int grade;
    public Student(int grade, String firstName, String lastName) {
        super(firstName, lastName);
        this.grade=grade;
    }
}