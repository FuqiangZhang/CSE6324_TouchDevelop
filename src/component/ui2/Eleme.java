package component.ui2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class Eleme extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2976333738035606612L;
	protected boolean isSelected = false;
	public Eleme(){
		this.setOpaque(true);
		this.setBackground(Color.white);
	}
	
	public String toString(){
		int n = this.getComponentCount();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<n;i++){
			Component c = this.getComponents()[i];
			if(c instanceof EditableTextField){
				sb.append(((EditableTextField)c).getText());
			}else{
				sb.append(((Eleme)c).toString());
			}
			sb.append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public abstract boolean isSelected();
	public abstract void addEleme();
	public abstract void addEleme(Eleme e, int n);
	
	public abstract void showDialog();
}

//	@Override
//	protected void paintComponent(Graphics g) {
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		
//		g2d.setColor(new Color(255,255,255,140));
//		g2d.fillRoundRect(3, 3, getWidth()-7, getHeight()-7, 20, 20);
//		
//		g2d.setClip(0, 0, getWidth(), 30);
//		g2d.setColor(Color.WHITE);
//		g2d.fillRoundRect(1, 3, getWidth()-2, getHeight()-1, 20, 20);
//		g2d.setClip(null);
//		
//		g2d.setColor(Color.darkGray);
//		g2d.setStroke(new BasicStroke(6));
//		g2d.drawRoundRect(3, 3, getWidth()-7, getHeight()-7, 20, 20);
//		
//		g2d.setFont(new Font("Arial", Font.BOLD, 16));
//		g2d.setColor(Color.DARK_GRAY);
//		g2d.drawString("Swing UI Test", 15, 24);
//	}