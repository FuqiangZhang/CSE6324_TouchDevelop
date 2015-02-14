package component.ui2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class EditableTextField extends JTextField implements MouseListener {
	private static final long serialVersionUID = -3996533656556699625L;

	private static final int DEFAULT_COLUMNS = 0;

	private boolean editable = true;

	public EditableTextField(int columns) {
		super(columns);
		this.setFont(new Font("ËÎÌו",Font.BOLD,18));
		this.setEditable(false);
		this.addMouseListener(this);
		this.setOpaque(false);
		setColumns();
	}

	public EditableTextField() {
		this(DEFAULT_COLUMNS, " ");
	}

	public EditableTextField(int columns, String text) {
		this(columns);
		this.setText(text);
	}

	public EditableTextField(String text) {
		this();
		this.setText(text);
		setColumns();
	}

	private void setColumns() {
		int column = this.getText().length();
		if (column == 0)
			column = 2;
		this.setColumns(0);
		this.setBackground(null);
		this.setBorder(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getClickCount() == 2 && editable) {
			this.requestFocus();
			this.setEditable(true);
			this.setBackground(Color.blue);
		}
		final JTextField text = (JTextField) e.getSource();
		text.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					text.setEditable(false);
					setColumns();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		text.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				setColumns();
				text.setEditable(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
