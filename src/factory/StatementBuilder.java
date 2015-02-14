package factory;

import java.util.Vector;

import component.ui2.*;
import controller.SelectController;

public class StatementBuilder {

	private Statem st = new Statem();

	private EditableTextField left_bracket = null;
	private EditableTextField right_bracket = null;
	private EditableTextField equal = null;

	private Vector<EditableTextField> al_beforeBracket = new Vector<EditableTextField>();
	private Vector<EditableTextField> al_inBracket = new Vector<EditableTextField>();

	public StatementBuilder addinBracket(String text) {
		EditableTextField etf = new EditableTextField(text);
		al_inBracket.add(etf);
		return this;
	}

	public StatementBuilder addBracket() {
		left_bracket = new EditableTextField("(");
		right_bracket = new EditableTextField(")");
		return this;
	}

	public StatementBuilder beforeBracket(String text) {
		EditableTextField etf = new EditableTextField(text);
		al_beforeBracket.add(etf);
		return this;
	}

	public StatementBuilder afterBracket() {
		return this;
	}

	public Statem create() {

		SelectController sc = new SelectController();
		st.addMouseListener(sc);
		for (EditableTextField etf : al_beforeBracket) {
			if (etf != null) {
				st.add(etf);
				etf.addMouseListener(sc);
			}
		}
		if (left_bracket != null)
			st.add(left_bracket);
		for (EditableTextField etf : al_inBracket) {
			if (etf != null) {
				st.add(etf);
				etf.addMouseListener(sc);
			}
		}
		if (right_bracket != null)
			st.add(right_bracket);

		return st;
	}
}
