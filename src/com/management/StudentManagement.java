package com.management;
 
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.*;
 
public class StudentManagement extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JMenuBar menubar = new JMenuBar(); //�����˵�������
	//һ���˵�
	JMenu informationMenu = new JMenu("��Ϣ");		
	JMenu searchMenu = new JMenu("��ѯ");	
	JMenu otherMenu = new JMenu("����");	
	
	JMenuItem addMenu = new JMenuItem("������Ϣ");
	JMenuItem deleteMenu = new JMenuItem("ɾ����Ϣ");
	JMenuItem alterMenu = new JMenuItem("�޸���Ϣ");
	
	JMenuItem searchInforMenu = new JMenuItem("��Ϣ��ѯ");
	JMenuItem searchGradeMenu = new JMenuItem("�ɼ���ѯ");
	
	JMenuItem quitMenu = new JMenuItem("�˳�");
	JLabel label = new JLabel();
	
	
	public StudentManagement() {
		this.setTitle("ѧ��������Ϣ");
		this.setLayout(new CardLayout());
		this.setJMenuBar(menubar);	//���˵��������ӵ�����
		this.setResizable(false);	//���ô��ڴ�С���ɱ�
		//this.setUndecorated(true);   //����frame�߿򲻿ɼ�
		//һ���˵���ӵ��˵������¼�����
		menubar.add(informationMenu);
		menubar.add(searchMenu);
		menubar.add(otherMenu);
		informationMenu.addActionListener(this);
		searchMenu.addActionListener(this);
		otherMenu.addActionListener(this);
		
		
		//�����˵���Ӽ��¼�����
		informationMenu.add(addMenu);
		informationMenu.add(deleteMenu);
		informationMenu.add(alterMenu);
		addMenu.addActionListener(this);
		deleteMenu.addActionListener(this);
		alterMenu.addActionListener(this);
		
		searchMenu.add(searchInforMenu);
		searchMenu.add(searchGradeMenu);
		searchInforMenu.addActionListener(this);
		searchGradeMenu.addActionListener(this);
		
		otherMenu.add(quitMenu);
		quitMenu.addActionListener(this);
		
		label.setIcon(new ImageIcon("images/������.jpg"));
		this.add(label);
		
		this.setVisible(true);
		this.setSize(580, 400); //���ô��ڵĴ�С
		this.setLocationRelativeTo(null);//���������ʾ
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
		
	}
	
	@Override
	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		
		//������Ϣ
		if(e.getSource() == addMenu) {
			new AddManagement();
		}
		//ɾ����Ϣ
		if(e.getSource() == deleteMenu) {
			new DeleteManagement();
		}
		//�޸���Ϣ
		if(e.getSource() == alterMenu) {
			new AlterManagement();
		}
		//��ѯ������Ϣ
		if(e.getSource() == searchInforMenu) {
			new SearchManagement();
		}
		
		//��ѯ�ɼ�
		if(e.getSource() == searchGradeMenu) {
			new SearchGrade();
		}
		
		//�˳�
		if(e.getSource() == quitMenu) {
			System.exit(0);
			//new UsingExit().setVisible(true);
		}
	}
	
}
