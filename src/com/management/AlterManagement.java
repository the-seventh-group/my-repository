package com.management;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
 
import com.database.DBConnection;
 
/**
 * �޸���Ϣ
 * @author Administrator
 *
 */
public class AlterManagement extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
 
	JLabel label = new JLabel("�޸���Ϣ",JLabel.CENTER);
	
	JLabel JLNumber = new JLabel("ѧ��");
	JTextField JTNumber = new JTextField();
	
	JLabel JLName = new JLabel("����");
	JTextField JTName = new JTextField();
	
	JLabel JLBirth = new JLabel("����");
	JTextField JTBirth = new JTextField();
	
	JLabel JLClass = new JLabel("�༶");
	JTextField JTClass = new JTextField();
	
	JLabel JLSex = new JLabel("�Ա�");
	//������ť�飬��������ť��ӵ���ť����
	ButtonGroup btnGroup = new ButtonGroup();
	//����������ѡ��ť
	JRadioButton radioBtn01 = new JRadioButton("��");
	JRadioButton radioBtn02 = new JRadioButton("Ů");
		
	
	JLabel JLAcademy = new JLabel("ѧԺ");
	JTextField JTAcademy = new JTextField();
	
	JButton ensureBtn = new JButton("ȷ��");
	JButton readdBtn = new JButton("����");
	JButton cancelBtn = new JButton("ȡ��");
	
	public AlterManagement() {
		this.setTitle("�޸���Ϣ");
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
		
		//�Ա�
		JLSex.setBounds(120,140,30,20);
		radioBtn01.setBounds(150, 140, 60, 20);
		radioBtn02.setBounds(210, 140, 60, 20);
		btnGroup.add(radioBtn01);
		btnGroup.add(radioBtn02);
		this.add(JLSex);
		this.add(radioBtn01);
		this.add(radioBtn02);
 
		//����
		JLBirth.setBounds(120, 180, 30, 20);
		JTBirth.setBounds(150, 180, 120, 25);
		this.add(JLBirth);
		this.add(JTBirth);
		
		//�༶
		JLClass.setBounds(120, 220, 30, 20);
		JTClass.setBounds(150, 220, 120, 25);
		this.add(JLClass);
		this.add(JTClass);
 
		//ѧԺ
		JLAcademy.setBounds(120, 260, 30, 20);
		JTAcademy.setBounds(150, 260, 120, 25);
		this.add(JLAcademy);
		this.add(JTAcademy);
		
		ensureBtn.setBounds(100, 320, 60, 25);
		readdBtn.setBounds(170, 320, 60, 25);
		cancelBtn.setBounds(240, 320, 60, 25);
		//��Ӽ���
		ensureBtn.addActionListener(this);
		readdBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		this.add(ensureBtn);
		this.add(readdBtn);
		this.add(cancelBtn);
		
		this.setVisible(true);	
		this.setSize(400, 400); //���ô��ڵĴ�С
		this.setLocationRelativeTo(null);//���������ʾ
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ensureBtn) {
			
			Integer snumber = Integer.parseInt(JTNumber.getText());
			String sname = JTName.getText();
			String ssex = "Ů";
			String sbirth = JTBirth.getText();
			String sclass = JTClass.getText();
			String sacademy = JTAcademy.getText();
				
			
			if(radioBtn01.isSelected()) {
				ssex = "��";
			}
			//����ѧ��
			String sql = "select * from students where id='"+snumber+"'";
			//�����ݿ����Ӳ�����Statement����
			try {
				Statement stm = DBConnection.getCon().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next()) {
					//����һ����¼
					sql = "update students set name ='"+sname+"',sex='"+ssex+"',birthday='"+sbirth+"',class='"+sclass+"',academy='"+sacademy+"'where id="+snumber;
					int i = stm.executeUpdate(sql);
					if(i>0) {
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
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
		
		if(e.getSource() == readdBtn) {
			JTNumber.setText(null);
			JTName .setText(null);
			JTClass.setText(null);
			JTAcademy.setText(null);
			JTBirth.setText(null);
		}
		
		if(e.getSource() == cancelBtn) {
			setVisible(false);
		}
		
	}
 
}
