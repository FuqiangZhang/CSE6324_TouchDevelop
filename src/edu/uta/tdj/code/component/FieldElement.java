package edu.uta.tdj.code.component;

import java.awt.Color;
import java.awt.Graphics;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;

/**
 * 2015 2015��2��22��
 * @author Fuqiang Zhang
 */

public class FieldElement extends Element {

	private VariableDeclarationFragment vdf;
	
	public FieldElement(AST ast) {
		super(ast);
		vdf = ast.newVariableDeclarationFragment();
		astNode = ast.newFieldDeclaration(vdf);
		this.height = 20;
	}

	public void setName(String name) {
		vdf.setName(ast.newSimpleName(name));
		this.name = name;
	}

	public void setType(String type) {
		((FieldDeclaration)astNode).setType(ast.newSimpleType(ast.newSimpleName(type)));
	}

	@Override
	public void setModifiers(ModifierKeyword modifiers) {
		((FieldDeclaration)astNode).modifiers().add(ast.newModifier(modifiers));
	}

	public ASTNode getAstNode() {
		return astNode;
	}

	@Override
	public void draw(Graphics g) {
		this.width = toString().length()*5;
		super.draw(g);
		g.setColor(Color.red);
		g.drawString(toString(), x, y+20);
		g.setColor(Color.black);
	}

	public String toString() {
		return astNode.toString();
	}

	@Override
	public Element getSelectedElement(int x_in, int y_in) {
		if(this.isInelement(x_in, y_in))
			return this;
		return null;
	}

	@Override
	public void addChild(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeChild(Element element) {
		// TODO Auto-generated method stub
		
	}

}
