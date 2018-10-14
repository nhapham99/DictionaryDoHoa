package dictionary2.pkg2;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addWord {
    public void addword(JTextField jTextField3, JTextField jTextField4, JComboBox jComboBox, conectDatabase mainConect) {
        try {
            mainConect.ps = mainConect.con.prepareStatement("insert into tbl_edict(word,detail)values(?, ?)");
            mainConect.ps.setString(1, jTextField3.getText());
            String detail = "<" + (String)jComboBox.getSelectedItem()+ ">" + jTextField4.getText();
            mainConect.ps.setString(2, detail);
            int check = mainConect.ps.executeUpdate();
            if (!jTextField3.getText().equals("") && !detail.equals("")) JOptionPane.showMessageDialog(null,"Đã thêm từ mới!");
            else JOptionPane.showMessageDialog(null,"Bạn hãy nhập những thông tin cần thiết!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
