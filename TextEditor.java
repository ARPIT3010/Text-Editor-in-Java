import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor implements ActionListener, WindowListener {
	JFrame f;
	JTextArea area;

	TextEditor() {
		f = new JFrame("Text Editor");
		area = new JTextArea();

		// menu bars and menu items
		JMenu menu1, menu2, font;
		JMenuItem neww, open1, save, clear, copy, paste;
		JMenuBar mb = new JMenuBar();

		// menu1 and its menu item
		menu1 = new JMenu("File");
		neww = new JMenuItem("New");
		open1 = new JMenuItem("Open");
		save = new JMenuItem("Save");

		menu1.add(neww);
		menu1.add(open1);
		menu1.add(save);
		mb.add(menu1);

		// menu2 and its menu item
		menu2 = new JMenu("Edit");
		clear = new JMenuItem("Clear");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		menu2.add(clear);
		menu2.add(copy);
		menu2.add(paste);
		mb.add(menu2);

		// menu3 and its menu item
		JMenuItem close = new JMenuItem("Close");
		mb.add(close);
		f.setJMenuBar(mb);

		// add action listener for tha TextEditort
		neww.addActionListener(this);
		open1.addActionListener(this);
		save.addActionListener(this);
		clear.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		close.addActionListener(this);

		// f.pack();
		f.setSize(2000, 1000);
		area.setBounds(0, 0, f.getWidth(), f.getHeight());
		f.add(area);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if (s.equals("New")) {
			area.setText("");
		} else if (s.equals("Open")) {
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsOpenDialog function to show the save dialog
			int r = j.showOpenDialog(null);

			// If the user selects a file
			if (r == JFileChooser.APPROVE_OPTION) {
				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// String
					String s1 = "", sl = "";

					// File reader
					FileReader fr = new FileReader(fi);

					// Buffered reader
					BufferedReader br = new BufferedReader(fr);

					// Initialize sl
					sl = br.readLine();

					// Take the input from the file
					while ((s1 = br.readLine()) != null) {
						sl = sl + "\n" + s1;
					}

					// Set the text
					area.setText(sl);
				} catch (Exception evt) {
					JOptionPane.showMessageDialog(f, evt.getMessage());
				}
			}

		} else if (s.equals("Save")) {
			JFileChooser j = new JFileChooser("f:");
			int r = j.showOpenDialog(null);
			if (r == JFileChooser.APPROVE_OPTION) {
				File f1 = new File(j.getSelectedFile().getAbsolutePath());

				try {
					FileWriter wr = new FileWriter(f1);
					BufferedWriter w = new BufferedWriter(wr);
					w.write(area.getText());
					w.close();
					w.flush();
				} catch (Exception evt) {
					JOptionPane.showMessageDialog(f, evt.getMessage());
				}
			}
		} else if (s.equals("Clear")) {
			area.cut();
		} else if (s.equals("Copy")) {
			area.copy();
		} else if (s.equals("Paste")) {
			area.paste();
		} else if (s.equals("Close")) {
			f.setVisible(false);
		}
	}

	public void windowClosing(WindowEvent e) {
		int a = JOptionPane.showConfirmDialog(f, "Are you sure?");
		if (a == JOptionPane.YES_OPTION) {
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	public static void main(String[] args) {
		new TextEditor();
	}

	// implementation of the methods that belongs to the WindowListener Interface
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}