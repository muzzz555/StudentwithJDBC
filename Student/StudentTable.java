/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DatabaseHandler;

/**
 *
 * @author sarun
 */
public class StudentTable {
    public static int updateStudent(DatabaseHandler dbHandler, Student emp) {
        String sql = "update Student set name=?, GPA=? where id=?";
        int rowUpdated;
        try {
            rowUpdated = dbHandler.update(sql, emp.getName(), emp.getGPA(), emp.getId());
        }
        catch (SQLException ex ) {
            
            rowUpdated = 0;
        }
        
        return rowUpdated;
    }
     public static int removeStudent(DatabaseHandler dbHandler, Student emp) {
         String sql ="delete from Student where id = ?";
         
         int rowDeleted;
         try {
            rowDeleted = dbHandler.update(sql, emp.getId());
         }
         catch (SQLException ex ) {
             rowDeleted = 0;
         }
        return rowDeleted;
    }
    public static int insertStudent(DatabaseHandler dbHandler, Student emp) {
         String sql = "insert into Student (id, name, GPA)" + 
               " values (?,?,?)";
         
         int rowInserted;
         try {
             rowInserted = dbHandler.update(sql, emp.getId(), emp.getName(), emp.getGPA());
         }
         catch(SQLException ex ) {
             rowInserted = 0;
         }
         return rowInserted;
    } 
     public static Student findStudentById(DatabaseHandler dbHandler, int id) throws SQLException {
        String sql = "select * from Student where id = ?";
        ResultSet rs;
        Student stu = null;
        rs = dbHandler.query(sql, id);
        if (rs.next()) {
           stu = new Student();
           stu.setId(rs.getInt("id"));
           stu.setName(rs.getString("name"));
           stu.setGPA(rs.getDouble("GPA"));
       }
        return stu;
        
    }
    public static ArrayList<Student> findStudentByName(DatabaseHandler dbHandler, String name) throws SQLException {
        String sql = "select * from Student where name = ?";
        ResultSet rs;
        ArrayList<Student> stuList = null;
        rs = dbHandler.query(sql, name);
        stuList = extractStudent(rs);
        return stuList;
        
    } 
    public static ArrayList<Student> findAllStudent(DatabaseHandler dbHandler) throws SQLException {
        String sql = "select * from Student order by id";
        ResultSet rs; 
        ArrayList<Student> empList = null;
        rs = dbHandler.query(sql);
        empList = extractStudent(rs);
        return empList;
    }
    private static ArrayList<Student> extractStudent(ResultSet rs) {
        ArrayList<Student> stdList = new ArrayList<>();
        try {
            while(rs.next()) {
                Student Student = new Student();
                try {
                    Student.setId(rs.getInt("id"));
                    Student.setName(rs.getString("name"));
                    Student.setGPA(rs.getDouble("GPA"));
                } catch (SQLException ex) {
                    Logger.getLogger(StudentTable.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                stdList.add(Student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(stdList.size() == 0) {
            stdList = null;
        }
        return stdList;
    }
}
