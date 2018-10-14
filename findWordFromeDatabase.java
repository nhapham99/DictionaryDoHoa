/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2.pkg2;

import java.sql.SQLException;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class findWordFromeDatabase {
     public void findWord(String Word_find, JTable jTable2, conectDatabase mainConect) {
         try {
            mainConect.ps = mainConect.con.prepareStatement("select word from tbl_edict where word like '" + Word_find + "%'");
            mainConect.rs = mainConect.ps.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(mainConect.rs));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
}
