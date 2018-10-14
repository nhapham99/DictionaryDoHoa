package dictionary2.pkg2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeleteWord {
    public void Delete_Word(String Word_find, conectDatabase mainConect, JTable jTable1) {
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
                PreparedStatement ps = mainConect.con.prepareStatement("delete from tbl_edict where word = ?");
                ps.setString(1, Word_find);
                int rs = ps.executeUpdate();
                if (rs != 0) JOptionPane.showMessageDialog(null, "Đã xóa từ thành công");
                else JOptionPane.showMessageDialog(null, "Bạn hãy chọn từ cần xóa");
                model.removeRow(jTable1.getSelectedRow());
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e);
            }
            
       
    }
}
