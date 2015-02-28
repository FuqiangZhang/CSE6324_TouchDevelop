package edu.uta.tdj.ui.actions;

import java.awt.event.ActionEvent;

import edu.uta.tdj.code.component.ClassElement;
import edu.uta.tdj.code.component.ComplieUnitElement;
import edu.uta.tdj.code.component.MethodElement;
import edu.uta.tdj.code.project.ProjectElement;
import edu.uta.tdj.controller.CodeController;
import edu.uta.tdj.controller.ProjectController;
import edu.uta.tdj.factory.CodeFactory;
import edu.uta.tdj.ui.CodePanel;

public class AddMainMethodAction extends ButtonActions {

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		// CodeController.getSelectedElement().addChild(
		// CodeFactory.getInstance().createMainMethodElement());
		CodePanel cp = ProjectController.getInstance()
				.getSelectedProjectElement();
		ClassElement ce = (ClassElement) cp.getSelectListener()
				.getSelectedElement();

		MethodElement main = ((ComplieUnitElement) ce.getParent()).getPackage()
				.getProjectElement().getCodeFactory().createMainMethodElement();

		ce.addChild(main);

		((ComplieUnitElement) ce.getParent())
				.getPackage()
				.getProjectElement()
				.setMainClass(
						((ComplieUnitElement) ce.getParent()).getPackage()
								.getName()
								+ "."
								+ ((ComplieUnitElement) ce.getParent())
										.getName());
		((ComplieUnitElement) ce.getParent()).save();
		
	}
}