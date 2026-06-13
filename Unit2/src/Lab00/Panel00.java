package Lab00;

// Sheng-Luen Chung, slchung@mail.ntust.edu.tw
// Feb. 18, 2010

import javax.swing.*;
import java.awt.*;

public class Panel00 extends JPanel {
	public void paintComponent(Graphics g) // paintComponet(Graphics g) 原本是
											// JComponent 所定義的 method
	{ // JPanel extends JComponet
		// Panel00 extends JPanel，然後再 override paintComponent(Graphics g)
		g.setColor(Color.blue);

		g.fillRect(100, 50, 400, 100);
		g.setFont(new Font("Serif", Font.BOLD, 40));
		g.setColor(new Color(150, 150, 150));
		g.drawString("Daddy Love Is Great", 100, 110);

		g.fillRect(100, 200, 300, 100);
		g.setFont(new Font("ScanSerif", Font.ITALIC, 30));
		g.setColor(Color.red.darker());
		g.drawString("Teacher's love next.", 100, 260);

		g.fillRect(100, 350, 400, 50);
		g.setFont(new Font("Monospaced", Font.PLAIN, 20));
		g.setColor(Color.green);
		g.drawString("I am learning Java to be...", 100, 375);

		g.fillRect(100, 450, 400, 50);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Yi Michael's Java teacher.", 100, 480);
	}
}