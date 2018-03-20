/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcuniversity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 *
 */
public class DBOperations {

    String url = "jdbc:mysql://localhost:3306/abcuniversity";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean addStudent(Student em) {
        try {
            System.out.println("Add Student 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO studentdetails VALUES(?,?,?,?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            System.out.println("Add Student 2");

            pst.setInt(1, em.getRegId());
            pst.setString(2, em.getFirstName());
            pst.setString(3, em.getLastName());
            pst.setInt(4, em.getAge());
            pst.setString(5, em.getAddress());
            pst.setString(6, em.getGender());
            pst.setString(7, em.getFaculty());
            pst.setString(8, em.getDepartment());
            pst.setInt(9, em.getYearOfReg());

            System.out.println("Add Student 3");

            pst.executeUpdate();

            System.out.println("Add Student 4");

            return true;

        } catch (Exception e) {
            System.out.print("exe---> " + e);
            return false;
        }

    }

    ArrayList<Student> getStudent() {
        try {

            ArrayList<Student> list = new ArrayList<Student>();

            System.out.println("Get Student 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM studentdetails";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            System.out.println("Get Student 2");

            rs = pst.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setRegId(rs.getInt(1));
                s.setFirstName(rs.getString(2));
                s.setLastName(rs.getString(3));
                s.setAge(rs.getInt(4));
                s.setAddress(rs.getString(5));
                s.setGender(rs.getString(6));
                s.setFaculty(rs.getString(7));
                s.setDepartment(rs.getString(8));
                s.setYearOfReg(rs.getInt(9));
                list.add(s);
            }
            return list;

        } catch (Exception e) {
            System.out.print("exe---> " + e);
            return null;
        }
    }

    public boolean updateStudent(Student em) {
        try {
            System.out.println("Update Student 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE studentdetails SET firstname = '" + em.getFirstName() + "',lastname='" + em.getLastName() + "',age=" + em.getAge() + ",address='" + em.getAddress() + "',gender='" + em.getGender() + "',faculty='" + em.getFaculty() + "',department='" + em.getDepartment() + "',yearofreg=" + em.getYearOfReg() + " WHERE regid = " + em.getRegId();
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            System.out.println("Update Student 2");

            pst.executeUpdate();
            System.out.println("Update Student 3");
            return true;

        } catch (Exception e) {
            System.out.print("exe---> " + e);
            return false;
        }

    }

    public boolean deleteStudent(Student em) {
        try {
            System.out.println("delete Student 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM studentdetails WHERE regid="+em.getRegId();
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            System.out.println("delete Student 2");

            pst.executeUpdate();
            System.out.println("Update Student 4");
            return true;

        } catch (Exception e) {
            System.out.print("exe---> " + e);
            return false;
        }
    }
    
    
    public boolean addLecturer(Lecturer em) {
        try {
            System.out.println("Add Lecturer 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO lecturerdetails VALUES(?,?,?,?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            System.out.println("Add Lecturer 2");

            pst.setInt(1, em.getRegId());
            pst.setString(2, em.getFirstName());
            pst.setString(3, em.getLastName());
            pst.setInt(4, em.getAge());
            pst.setString(5, em.getAddress());
            pst.setString(6, em.getGender());
            pst.setString(7, em.getFaculty());
            pst.setString(8, em.getHighestQualification());
            pst.setInt(9, em.getYearOfServices());

            System.out.println("Add Lecturer 3");

            pst.executeUpdate();

            System.out.println("Add Lecturer 4");

            return true;

        } catch (Exception e) {
            System.out.print("exe---> " + e);
            return false;
        }

}
    
    ArrayList<Lecturer> getLecturer() {
        try {

            ArrayList<Lecturer> list1 = new ArrayList<Lecturer>();

            System.out.println("Get Lecturer 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM lecturerdetails";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            System.out.println("Get Lecturer 2");

            rs = pst.executeQuery();

            while (rs.next()) {
                Lecturer s = new Lecturer();
                s.setRegId(rs.getInt(1));
                s.setFirstName(rs.getString(2));
                s.setLastName(rs.getString(3));
                s.setAge(rs.getInt(4));
                s.setAddress(rs.getString(5));
                s.setGender(rs.getString(6));
                s.setFaculty(rs.getString(7));
                s.setHighestQualification(rs.getString(8));
                s.setYearOfServices(rs.getInt(9));
                list1.add(s);
            }
            return list1;

        } catch (Exception e) {
            System.out.print("exe---> " + e);
            return null;
        }
    }

    
     public boolean updateLecturer(Lecturer em) {
        try {
            System.out.println("Update Lecturer 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE lecturerdetails SET firstname = '" + em.getFirstName() + "',lastname='" + em.getLastName() + "',age=" + em.getAge() + ",address='" + em.getAddress() + "',gender='" + em.getGender() + "',faculty='" + em.getFaculty() + "',	highestqualification='" + em.getHighestQualification()+ "',yearofservices=" + em.getYearOfServices()+ " WHERE regid = " + em.getRegId();
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            System.out.println("Update Lecture 2");

            pst.executeUpdate();
            System.out.println("Update Lecturer 3");
            return true;

        } catch (Exception e) {
            System.out.print("exe---> " + e);
            return false;
        }

    }
     
       public boolean deleteLecturer(Lecturer em) {
        try {
            System.out.println("delete Lecturer 1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM lecturerdetails WHERE regid="+em.getRegId();
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            System.out.println("delete Lecturer 2");

            pst.executeUpdate();
            System.out.println("Update Lecturer 4");
            return true;

        } catch (Exception e) {
            System.out.print("exe---> " + e);
            return false;
        }
    }

}
