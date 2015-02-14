package dialog;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import component.ui2.Eleme;
import component.ui2.Statem;
import factory.StatementBuilder;

public class AddDialog extends JPopupMenu {
	
	
	
	private AddDialog(){
		JMenuItem jm1 = new JMenuItem("ADD");
		JMenuItem jm2 = new JMenuItem("ADD");
		jm1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Eleme parentEleme = (Eleme) eleme.getParent();
				parentEleme.addEleme(null, 0);
			}
			
		});
		this.add(jm1);
		this.add(jm2);
	}
	
	private Eleme eleme;
	
	public void setSource(Eleme eleme){
		this.eleme = eleme;
	}
	
	private static AddDialog instance;
	
	public static AddDialog getInstance(){
		if(instance == null)
			instance = new AddDialog();
		return instance;
	}

}	
