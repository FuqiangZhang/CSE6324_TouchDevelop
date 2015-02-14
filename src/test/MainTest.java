package test;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import component.ui2.EditableTextField;
import component.ui2.Statem;
import component.ui2.Struct;
import factory.StatementBuilder;

public class MainTest extends JFrame {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainTest.getInstance();
	}
	
	private EditableTextField etf = new EditableTextField(1);
	private JButton jb_test = new JButton("GO");
	
	private static MainTest instanceMainTest;
	
	private MainTest(){
		initUI();
	}
	
	public static MainTest getInstance(){
		if(instanceMainTest == null)
			instanceMainTest = new MainTest();
		return instanceMainTest;
	}
	
	
	
	
	public void initUI() {
		this.setSize(600, 400);
		this.setLayout(new FlowLayout());

		Statem st = null;

		StatementBuilder builder = new StatementBuilder();
		builder.addBracket().beforeBracket("public ").beforeBracket("void ")
				.beforeBracket("main").addinBracket("String[]")
				.addinBracket("args");
		st = builder.create();
		builder = new StatementBuilder();
		builder.addBracket().beforeBracket("void ").beforeBracket("main")
				.addinBracket("String[]").addinBracket("a");
		Struct struct = new Struct();
		struct.addBefore(st);
		Struct struct2 = new Struct();
		st = builder.create();
		struct2.addBefore(st);

		builder = new StatementBuilder();
		builder.addBracket().beforeBracket("void ").beforeBracket("main")
				.addinBracket("String[]").addinBracket("a");
		st = builder.create();
		struct.addStatement(st);

		Struct structall = new Struct();
		structall.add(struct2);
		structall.add(struct);
		
//		setUndecorated(true);
//		setBackground(new Color(0,0,0,0));
//		
		this.repaint();
		this.add(structall);
		System.out.println(structall.toString());
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
	}
	
	public void repaint(){
		System.out.println("repaint");
		this.setSize(getWidth()+1,getHeight()+1 );
		this.setSize(getWidth()-1,getHeight()-1 );
		super.repaint();
	}
}
