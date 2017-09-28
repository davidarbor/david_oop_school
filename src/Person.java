import java.util.Scanner;
import java.util.*;
/**
 * Created by h205p2 on 9/21/17.
 */
public class Person{
    public static int nextInt=1;
    public int id;
    public String firstName;
    public String lastName;
    public Person(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        this.id=nextInt;
        nextInt++;
    }
}