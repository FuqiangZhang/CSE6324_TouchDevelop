package edu.uta.tdj.code.component;
/**
 * 2015 2015��2��22��
 * @author Fuqiang Zhang
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import edu.utd.tdj.code.proposal.ProposalComputer;

/**
 * For a class
 * 
 * */

public class ClassElement extends Element {

	private TypeDeclaration astNode;
	private ArrayList<FieldElement> fieldList;
	private ArrayList<MethodElement> methodList;

	private String modifiedString = "";

	public ClassElement(AST ast, String name) {
		super(ast);
		this.astNode = ast.newTypeDeclaration();
		setName(name);

		fieldList = new ArrayList<FieldElement>();
		methodList = new ArrayList<MethodElement>();

		this.setX(50);
		this.setY(50);

		this.height = 20;
	}

	public void setName(String name) {
		this.name = name;
		this.width = name.length() * 5;
		astNode.setName(ast.newSimpleName(name));
	}

	public void addContructor(ModifierKeyword modifiers) {
		MethodElement me = new MethodElement(ast);
		me.setName(this.getName());
		me.createBlock();
		me.setModifiers(modifiers);
		astNode.bodyDeclarations().add(me.getAstNode());
	}

	public void addMethod(MethodElement me) {
		me.setX(x + 20);
		me.setY(y + height - 20);
		astNode.bodyDeclarations().add(me.getAstNode());
		methodList.add(me);
	}

	public void addMethod(String name, Type returnType,
			ModifierKeyword modifiers) {
		MethodElement me = new MethodElement(ast);
		me.setName(name);
		me.createBlock();
		me.setModifiers(modifiers);
		me.setReturnType(ast.newPrimitiveType(PrimitiveType.VOID));
		this.addMethod(me);
	}

	/**
	 * add field
	 * 
	 * 
	 * */
	public void addField(FieldElement fe) {
		fe.setX(x + 20);
		fe.setY(y + (fieldList.size() + 1) * 20);
		astNode.bodyDeclarations().add(fe.getAstNode());
		fieldList.add(fe);
	}

	public void addField(String name, String type, ModifierKeyword modifiers) {
		FieldElement fe = new FieldElement(ast);
		fe.setName(name);
		fe.setType(type);
		fe.setModifiers(modifiers);
		addField(fe);
	}

	/**
	 * should be changed and split into parts
	 * */
	@Override
	public void setModifiers(ModifierKeyword modifiers) {
		astNode.modifiers().add(ast.newModifier(modifiers));
		modifiedString = modifiedString + " " + modifiers.toString();
	}

	@Override
	public void accept(ProposalComputer pcComputer) {
		// TODO Auto-generated method stub
		super.accept(pcComputer);
	}

	@Override
	public ASTNode getAstNode() {
		// TODO Auto-generated method stub
		return astNode;
	}

	public void computeHeight() {
		height = 50;
		int i = 1;
		for (FieldElement ef : fieldList) {
			height = height + ef.getHeight();
			ef.setY(i * 20 + y);
			i++;
		}
		int lastHeight = i * 20;

		for (MethodElement me : methodList) {
			height = height + me.getHeight();
			me.setY(lastHeight + y);
			me.notifyObservers();
			lastHeight = me.getHeight() + lastHeight;
			i++;
		}
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		computeHeight();
		
		g.drawString(this.toString(), x, y+20);

		for (FieldElement ef : fieldList) {
			ef.draw(g);
		}

		for (MethodElement me : methodList) {
			me.draw(g);
		}
		g.drawString("}", x, this.height+y-10);
		
	}

	public String toString() {
		return this.modifiedString + "  class  " + name + "  {";
	}

	@Override
	public Element getSelectedElement(int x_in, int y_in) {
		// TODO Auto-generated method stub
		if (this.isInelement(x_in, y_in)) {
			return this;
		} else {
			for (FieldElement fe : fieldList) {
				Element element = fe.getSelectedElement(x_in, y_in);
				if ( element!= null)
					return element;
			}

			for (MethodElement me : methodList) {
				Element element = me.getSelectedElement(x_in, y_in);
				if ( element!= null)
					return element;
			}
		}
		return null;
	}

	@Override
	public void unSelected() {
		this.setSelected(false);
		for (FieldElement fe : fieldList) {
			fe.unSelected();
		}

		for (MethodElement me : methodList) {
			me.unSelected();
		}
	}

}
