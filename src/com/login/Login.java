package com.login;
 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.database.*;
import com.management.StudentManagement;
 
import javax.swing.*;
 
/**
 * ��¼
 * @author Administrator
 *
 */
public class Login extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;
	//��¼��¼����
	private int flag = 0;
	//������ǩ���ı�����������
	JPanel panel = new JPanel();
	JLabel JLUserName = new JLabel("�û�����");
	JLabel JLUserPaw = new JLabel("��    �룺");
	JTextField JTUserName = new JTextField();
	JPasswordField JTUserPaw = new JPasswordField();
	
	//������ť����
	JButton login = new JButton("��¼");
	JButton cancle = new JButton("ȡ��");
	JLabel identity = new JLabel("��    �ݣ�");
	//���������б�����
	JComboBox<String> JC = new JComboBox<String>();
	
	public Login() {
		this.setTitle("����ϵͳʾ��1.0����ɾ�Ĳ飩");
		this.setLayout(null);
		
		this.setResizable(false);    //��ֹ�ı䴰�ڴ�С
 
		//����
		JLUserName.setBounds(100, 50, 60, 20);
		JTUserName.setBounds(200, 50, 100, 20);
		this.add(JLUserName);
		this.add(JTUserName);
		
		//����
		JLUserPaw.setBounds(100, 100, 60, 20);
		JTUserPaw.setBounds(200, 100, 100, 20);
		this.add(JLUserPaw);
		this.add(JTUserPaw);
		
		//���
		identity.setBounds(100, 150, 60, 20);
		JC.setBounds(200, 150, 100, 20);
		JC.addItem(new String("ѧ��"));
		JC.addItem(new String("��ʦ"));
		this.add(identity);
		this.add(JC);
		
		//��¼��ȡ��
		login.setBounds(100, 200, 60, 20);
		cancle.setBounds(240, 200, 60, 20);
		login.addActionListener(this);
		cancle.addActionListener(this);
		this.add(login);
		this.add(cancle);
		
		this.setVisible(true);
		this.setSize(400, 250); //���ô��ڵĴ�С
		this.setLocationRelativeTo(null);//���������ʾ
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
		
	}
 
	//�����֤
	private boolean logindb(String password, String sql) {
		//��ѯ���ݿ�
		ResultSet rs = null;
 
		//��֤�û����Ƿ����
		try {
			rs = DBConnection.getCon().createStatement().executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//��֤�����Ƿ����
		try {
			if(rs.next()&&rs.getString(1).equals(password)) {
				rs.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//�����¼�¼�
		if(e.getSource() == login) {
			
			//���ı����а������ı������ַ���name
			String name = JTUserName.getText();
			String password = new String(JTUserPaw.getPassword());
			
			//����ǰ��ѡ����ַ���box
			String box = (String)JC.getSelectedItem();
			String loginsql = null;
			
			if(box.equals("ѧ��")) {
				loginsql ="select password from students where name ='"+name+"'";
				
				//��¼�ɹ�����룬���򷵻���ʾ��Ϣ
				if(logindb(password,loginsql)) {
					this.setVisible(false);
					new StudentManagement();
					System.out.println("ѧ����¼�ɹ���");
				}else {
					flag++;
					if(flag >= 3) {
						JOptionPane.showMessageDialog(this, "�������δ����˳���¼��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
					
					JOptionPane.showMessageDialog(this, "�����������������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
					
			}
			else if(box.equals("��ʦ")) 
			{
				loginsql ="select password from students where name ='"+name+"'";
				if(logindb(password,loginsql))
					System.out.println("��ʦ��¼�ɹ���");
			}
			
		}
		
		//����ȡ���¼�
		if(e.getSource() == cancle) {
			System.out.println("�˳��ɹ���");
			System.exit(0);
		}
		
	}
	
 
	public static void main(String[] args) {
		//new Login();
		new StudentManagement();
	}
	
}
