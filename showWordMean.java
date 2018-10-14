package dictionary2.pkg2;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;

public class showWordMean {
    public void showMean(JTable jTable2, conectDatabase mainConect, JTextField jTextField1, String Word_mean) {
         try {
            int row = jTable2.getSelectedRow();
            String str = (jTable2.getModel().getValueAt(row, 0).toString());
            System.out.println(str);
            mainConect.ps = mainConect.con.prepareStatement("select * from tbl_edict where word = '" + str + "'");
            mainConect.rs = mainConect.ps.executeQuery();

            while(mainConect.rs.next()) {
               String out = mainConect.rs.getString("detail");
               Word_mean = out;
               jTextField1.setText(out);
               jTextField1.setEditable(false);
            }
        } catch(SQLException ex) {
            ex.getMessage();
        }
    }
}
