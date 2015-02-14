package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import component.ui2.EditableTextField;
import component.ui2.Eleme;

public class SelectController implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 1){
			Object o = e.getSource();
			Eleme es = null;
			if(o instanceof EditableTextField){
				es = (Eleme) ((EditableTextField)o).getParent();
			}else{
				es = (Eleme) e.getSource();
			}
			es.showDialog();
			es.isSelected();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
