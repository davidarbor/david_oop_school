import java.util.Scanner;
import java.util.*;
/**
 * Created by h205p2 on 9/21/17.
 */
public class Teacher extends Person{
    public static int id;
    public String subject;
    public Teacher(int id, String firstName, String lastName) {
        super(firstName, lastName);
        this.id=id;
    }
}