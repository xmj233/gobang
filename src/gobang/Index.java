package gobang;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Index {
	private static JFrame frame = new JFrame();
	public Index() {
		frame.setTitle("五子棋");
		frame.setSize(518, 573);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		Button btn1 = new Button("人机对奕");
		Button btn2 = new Button("人人对奕");
		btn1.setFont(new Font("楷体", Font.BOLD, 18));
		btn1.setForeground(Color.black);
		btn2.setFont(new Font("楷体", Font.BOLD, 18));
		btn2.setForeground(Color.black);
		btn1.setBounds(200, 400, 100, 40);
		btn2.setBounds(200, 450, 100, 40);
		frame.add(btn1);
		frame.add(btn2);
		JLabel jl = new JLabel(new ImageIcon("image/2.jpg"));
		jl.setBounds(0, 0, 518, 573);
		frame.getContentPane().add(jl);
		frame.setVisible(true);
		btn1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				new man_machine.Ui();
				frame.setVisible(false);
			}
		});
		btn2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				new man_man.Ui();
				frame.setVisible(false);
			}
		});
	}
	public static JFrame getFrame() {
		return frame;
	}
}
