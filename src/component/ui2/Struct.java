package component.ui2;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;

import factory.StatementBuilder;
import test.MainTest;

public class Struct extends Eleme {
	public Struct() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	private EditableTextField left = new EditableTextField("{");
	private EditableTextField right = new EditableTextField("}");

	public void addBefore(Statem st) {
		this.add(st);
		this.add(left);
		this.add(right);
	}

	public void addStatement(Statem st) {
		this.remove(right);
		this.add(st);
		this.add(right);
	}

	@Override
	public void showDialog() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		isSelected = !isSelected;
		this.setBackground(Color.darkGray);
		System.out.println("is selected");
		return isSelected;
	}

	public void addEleme() {

	}

	@Override
	public void addEleme(Eleme e, int n) {
		// TODO Auto-generated method stub
		if (e == null) {
			StatementBuilder builder;
			builder = new StatementBuilder();
			builder.beforeBracket(" ");
			e = builder.create();
		}
		this.add(e, 2);
		MainTest.getInstance().repaint();
	}
}
