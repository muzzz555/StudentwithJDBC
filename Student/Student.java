/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

/**
 *
 * @author sarun
 */
public class Student {
    
    private int id;
    private String name;
    private double GPA;
    
    public Student() {
        
    }
    public Student(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }
    
    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
