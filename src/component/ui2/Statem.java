package component.ui2;

import java.awt.Color;

import dialog.AddDialog;


public class Statem extends Eleme{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4195399475002564137L;
	
	public Statem(){
		super();
	}
	
	
	public String getText(){
		return toString();
	}
	
	public void showDialog(){
		System.out.println("show dialog");
		AddDialog.getInstance().setSource(this);
		AddDialog.getInstance().show(this,-50, -10);
	}


	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		isSelected = !isSelected;
		if(isSelected){
			this.setBackground(Color.DARK_GRAY);
		}else{
			this.setBackground(Color.white);
		}
		return isSelected;
		
	}


	@Override
	public void addEleme() {
		// TODO Auto-generated method stub
	}


	@Override
	public void addEleme(Eleme e, int n) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}


