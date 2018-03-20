/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcuniversity.Student;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class LecturerDetail extends AbstractTableModel  {
    
    private static final String[] COLUMN_NAMES = {"Reg ID", "First Names", "Last Name", "Faculty"};
    private static ArrayList<Lecturer> list1;

    LecturerDetail(ArrayList<Lecturer> leList) {
        list1 = leList;
    }

    @Override
    public int getRowCount() {
            return list1.size();
    }
    
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }
    
    @Override
    public int getColumnCount() {
            return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list1.get(rowIndex).getRegId();
            case 1:
                return list1.get(rowIndex).getFirstName();
            case 2:
                return list1.get(rowIndex).getLastName();
            case 3:
                return list1.get(rowIndex).getFaculty();
            
            default:
                return "Error";
        }
       
    }

    
}
