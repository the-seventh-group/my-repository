package com.management;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
import com.database.DBConnection;
 
/**
 * ɾ����Ϣ
 * @author Administrator
 *
 */
public class DeleteManagement extends JFrame implements ActionListener {
 
	private static final long serialVersionUID = 1L;
 
	JLabel label = new JLabel("ɾ����Ϣ",JLabel.CENTER);
	
	JLabel JLNumber = new JLabel("ѧ��");
	JTextField JTNumber = new JTextField();
	
	JLabel JLName = new JLabel("����");
	JTextField JTName = new JTextField();
	
	JButton ensureBtn = new JButton("ȷ��");
	JButton nextBtn = new JButton("����");
	JButton cancelBtn = new JButton("ȡ��");
	
	public DeleteManagement() {
		this.setTitle("ɾ����Ϣ");
		this.setLayout(null);
		label.setBackground(Color.red);  //labelǰ��ɫΪ��ɫ
		label.setFont(new Font("����", Font.HANGING_BASELINE, 19));
		label.setBounds(170, 20, 100, 20);
		this.add(label);
		//ѧ��
		JLNumber.setBounds(120, 60, 30, 25);
		JTNumber.setBounds(150, 60, 120, 25);
		this.add(JLNumber);
		this.add(JTNumber);
		
		//����
		JLName.setBounds(120, 100, 30, 20);
		JTName.setBounds(150, 100, 120, 25);
		this.add(JLName);
		this.add(JTName);
		
		
		ensureBtn.setBounds(100, 320, 60, 25);
		nextBtn.setBounds(170, 320, 60, 25);
		cancelBtn.setBounds(240, 320, 60, 25);
		//����¼�����
		ensureBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		this.add(ensureBtn);
		this.add(nextBtn);
		this.add(cancelBtn);
		
		this.setVisible(true);	
		this.setSize(400, 400); //���ô��ڵĴ�С
		this.setLocationRelativeTo(null);//���������ʾ
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ensureBtn) {
			
			Integer snumber = Integer.parseInt(JTNumber.getText());
			
			//����ѧ��
			String sql = "select * from students where id='"+snumber+"'";
			//�����ݿ����Ӳ�����Statement����
			try {
				Statement stm = DBConnection.getCon().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next()) {
					//ɾ��һ����¼
					sql = "delete from students where id ='"+snumber+"'";
					int i = stm.executeUpdate(sql);
					if(i>0) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "���˺Ų����ڣ�", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);					
				}
				stm.close();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == nextBtn) {
			JTNumber.setText(null);
			JTName .setText(null);
		}
		
		if(e.getSource() == cancelBtn) {
			setVisible(false);
		}
		
	}
 
}
