package com.lele;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Test{
	public static void main(String args[])throws IOException {
		My_Windows mw = new My_Windows();
		mw.creat();
	}
}

public class My_Windows {
	
	public void creat() {
		JFrame f =new JFrame("wc");            //创建窗口
		//创建三个画板
		JPanel p1 = new JPanel();				
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,6));
		JPanel p3 = new JPanel();
		p3.setLayout(null);
		Font ft1 = new Font("宋体",Font.BOLD,16);
		Font ft2 = new Font("宋体",Font.BOLD,20);
		
		//创建组件
		//p1中的组件
		JLabel l1 = new JLabel("  文件路径：       ");
		l1.setPreferredSize(new Dimension(200, 50));
		l1.setFont(ft1);
		final JTextField road = new JTextField(50);
		road.setFont(ft1);
		road.setPreferredSize(new Dimension(1000, 40));
		Button b1 = new Button("  确定     ");		
		b1.setFont(ft1);
		b1.setPreferredSize(new Dimension(150, 40));
		
		//p2中的组件
		final JTextArea center=new JTextArea(10,10);
		JScrollPane js = new JScrollPane(center);
		js.setBounds(50,30 , 900, 700);	
		center.setFont(ft1);
		
		//p3中的组件
		Button b2 = new Button("  计算字符数     ");
		b2.setFont(ft1);
		b2.setPreferredSize(new Dimension(150, 50));
		Button b3 = new Button("  计算单词数     ");
		b3.setFont(ft1);
		b3.setPreferredSize(new Dimension(150, 50));
		Button b4 = new Button("  计算行数     ");
		b4.setFont(ft1);
		b4.setPreferredSize(new Dimension(150, 50));
		final JTextField tf1 = new JTextField(5);
		tf1.setFont(ft2);
		final JTextField tf2 = new JTextField(5);
		tf2.setFont(ft2);
		final JTextField tf3 = new JTextField(5);
		tf3.setFont(ft2);
		
		//设置顶级容器的基本信息
		f.setResizable(false);				//窗体大小可以改变
		f.setLocation(600,10);		//窗体出现位置
		f.setSize(1000,900);			//窗体大小
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//点关闭时，退出程序
		f.setLayout(new BorderLayout());
		
		//添加组件
		f.add(p1, BorderLayout.NORTH);
		f.add(p2, BorderLayout.SOUTH);
		f.add(p3,BorderLayout.CENTER);
		p3.add(js);
		p1.add(l1);
		p1.add(road);
		p1.add(b1);
		p2.add(b2);
		p2.add(tf1);
		p2.add(b3);
		p2.add(tf2);
		p2.add(b4);
		p2.add(tf3);
		
		f.setVisible(true);			 //窗体可视化
		
		//b1添加监听器
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Fileio fe = new Fileio();
				String st = new String();
				if("a"==fe.start1(road.getText())){
					try {
						fe.outputString();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					String str = new String(fe.sb);
					center.setText(str);
				} else {
					st = fe.start1(road.getText());
					center.setText(st);
				}
				
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Total a = new Total();
				String str = new String(a.toChar(center.getText()));
				tf1.setText(str);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Total a = new Total();
				String str = new String(a.toWord(center.getText()));
				tf2.setText(str);
			}
		});
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Total a = new Total();
				String str = new String(a.toline(center.getText()));
				tf3.setText(str);
			}
		});
		
	
	}
	
	
		
		
	
}
