package man_man;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import gobang.Chessboard;
import gobang.IsWin;
import gobang.Location;

public class Ui {
	private JFrame frame = new JFrame();
	private Chessboard chessboard = new Chessboard();
	private IsWin iw = new IsWin();
	private int owner = 1;
	public Ui() {
		frame.setTitle("人人对奕");
		frame.setSize(518, 573);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(chessboard);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menu = new JMenu("游戏");
		menuBar.add(menu);
		JMenuItem item1 = new JMenuItem("返回主界面");
		JMenuItem item2 = new JMenuItem("重新开始");
		menu.add(item1);
		menu.add(item2);
		frame.setVisible(true);
		
		chessboard.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				play(e);
				
			}
		});
		
		item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chessboard.init();
				frame.dispose();
				gobang.Index.getFrame().setVisible(true);
			}
		});
		
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chessboard.init();
//				frame.setVisible(false);
//				frame.dispose();
				owner = 1;
				chessboard.repaint();
			}
		});
		
		
	}
	private void play(MouseEvent e) {
		int cellsize = chessboard.getCellsize();
		int x = (e.getX()-5)/cellsize;
		int y = (e.getY()-5)/cellsize;
		if ( chessboard.isLegal(x, y) ) {
			chessboard.addChess(new Location(x, y, owner));
			chessboard.addLocation(x, y, owner);
			//黑白子交替落棋
			if ( owner==1 )
				owner = -1;
			else if ( owner==-1 )
				owner = 1;
		} else {
			JOptionPane.showMessageDialog(frame, "此处有棋子","消息",JOptionPane.PLAIN_MESSAGE);
			return;
		}
		if ( iw.isWin(x, y, 1) ) {
			JOptionPane.showMessageDialog(frame, "黑子获胜", "消息", JOptionPane.PLAIN_MESSAGE);
		} else if ( iw.isWin(x, y, -1) ) {
			JOptionPane.showMessageDialog(frame, "白子获胜", "消息", JOptionPane.PLAIN_MESSAGE);
		}
		
	}

}
