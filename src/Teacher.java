import java.util.Scanner;
import java.util.*;
/**
 * Created by h205p2 on 9/21/17.
 */
public class Teacher extends Person{
    public static int nextInt=1;
    public int id;
    public int grade;
    public String subject;
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        this.id=nextInt;
        nextInt++;
    }
}