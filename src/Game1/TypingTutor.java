package Game1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TypingTutor extends JFrame implements ActionListener,KeyListener {
	private JLabel lbltimer;
	private JLabel lblscore;
	private JLabel lblword;
	private JTextField txtword;
	private JButton start;
	private JButton end;

	private Timer wordtimer;
	private Timer clocktimer;
	private int score = 0;
	private int timeremaining = 0;
	private boolean running = false;
	private String[] words = null;

	public TypingTutor(String[] args) {
		words = args;
		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);

		Font font = new Font("Comic Sans MS", 1, 100);

		lbltimer = new JLabel("Time");
		lbltimer.setFont(font);
		super.add(lbltimer);

		lblscore = new JLabel("score");
		lblscore.setFont(font);
		super.add(lblscore);

		lblword = new JLabel("Word");
		lblword.setFont(font);
		super.add(lblword);

		txtword = new JTextField("");
		txtword.setFont(font);
		txtword.addKeyListener(this);
		super.add(txtword);

		start = new JButton("Start");
		start.setFont(font);
		start.addActionListener(this);
		super.add(start);

		end = new JButton("End");
		end.setFont(font);
		end.addActionListener(this);
		super.add(end);

		setupgame();

		super.setTitle("Typing Tutor");
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setVisible(true);
	}

	private void setupgame() {
		clocktimer = new Timer(1000,this);
		clocktimer.setInitialDelay(0);
		
		wordtimer = new Timer(5000, this);
		wordtimer.setInitialDelay(0);
		
		score = 0;
		timeremaining = 100;
		running = false;

		lblscore.setText("Score: " + score);
		lbltimer.setText("Timer: " + timeremaining);
		lblword.setText("");
		txtword.setText("");
		start.setText("Start");
		end.setText("Stop");

		txtword.setEnabled(false);
		end.setEnabled(false);

	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			handlestart();
		} else if (e.getSource() == end) {
			handlestop();
		} else if (e.getSource() == wordtimer) {
			hadlewordtimer();
		}else if(e.getSource() == clocktimer){
			hancleclocktimer();
		}

	}

	private void hancleclocktimer() {
		timeremaining--;
		lbltimer.setText("Timer: " + timeremaining);
		
		if(timeremaining == 0){
			handlestop();
		}
		
	}

	private void hadlewordtimer() {
		String actual = txtword.getText();
		String expected = lblword.getText();
		if(expected.length()>0 && actual.equals(expected)){
			score++;
		}
		lblscore.setText("Score: " + score);
		int ridx = (int)(Math.random() * words.length);
		lblword.setText(words[ridx]);
		txtword.setText("");
		
		if(timeremaining == 0){
			handlestop();
		}
	}

	private void handlestop() {
		clocktimer.stop();
		wordtimer.stop();
		
		int choice = JOptionPane.showConfirmDialog(this, "replay?");
		
		if(choice == JOptionPane.YES_OPTION){
			clocktimer.start();
		}else if(choice == JOptionPane.NO_OPTION){
			JOptionPane.showConfirmDialog(this,"Final Score:" + score);
			setupgame();
		}
		else if(choice == JOptionPane.CANCEL_OPTION){
			if(timeremaining == 0){
				setupgame();
			}else{
				clocktimer.start();
			}
		}
		
	}

	private void handlestart() {
		if (running == false) {
			clocktimer.start();
			
			wordtimer.start();
			
			running = true;
			start.setText("Pause");

			txtword.setEnabled(true);
			txtword.setFocusCycleRoot(true);
			super.nextFocus();
			end.setEnabled(true);

		} else {
			clocktimer.stop();
			wordtimer.stop();
			running = false;
			start.setText("Start");

			txtword.setEnabled(false);
			end.setEnabled(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String actual = txtword.getText();
		String expected = lblword.getText();
		if(expected.length()>0 && actual.equals(expected)){
			score++;
			
			lblscore.setText("Score: " + score);
			int ridx = (int)(Math.random() * words.length);
			lblword.setText(words[ridx]);
			txtword.setText("");
			
			if(timeremaining == 0){
				handlestop();
			}
			
			wordtimer.restart();
		}
	}

}
