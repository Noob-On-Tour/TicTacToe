
/*
 *   TicTacToe Game 
 *   By Ahmed Lotfey Siam
 *   ID 4129
 *   Created On 8/3/2016
 */

package pkg;

/*
************************IMPORTS*****************************/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/************************** GAME CLASS ****************************/

public class TicTacToe {

    private ImageIcon X = new ImageIcon(this.getClass().getResource("X.png"));
    private ImageIcon O = new ImageIcon(this.getClass().getResource("O.png"));

    private JFrame frame;
    private JButton btn[] = new JButton[42];

    private MyActionListener listener = new MyActionListener();
    private GetWinner myGetWinner = new GetWinner();

    /******************************* MAIN *******************************/
    // Launch the application.
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                TicTacToe window = new TicTacToe();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    /*************************** GAME CONSTRUCTOR **********************/
    // Create the application && Initialize the content of the frame.
    private TicTacToe() {

        frame = new JFrame("Tic Tac Toe - By Ahmed Siam");

        frame.setMinimumSize(new Dimension(750, 650));
        frame.setBounds(200, 200, 750, 650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(6, 0, 5, 5));

		/*
         * add buttons to the frame
		 */

        for (int i = 0; i < 42; i++) {
            btn[i] = new JButton("");
            frame.getContentPane().add(btn[i]);
        }

		/*
		 * Buttons Action Listener !
		 */

        for (int i = 0; i < 42; i++) {
            btn[i].addActionListener(listener);
        }

    }

    private class MyActionListener implements ActionListener {

        private int moveCount = 0;
        private String btnName;

        // Respond to click action by the User

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            moveCount++;

            for (int i = 0; i < 42; i++) {
                if (e.getSource() == btn[i]) {

                    if (moveCount % 2 == 1) {
                        btnName = "X";
                        btn[i].setBackground(Color.CYAN);
                        btn[i].setIcon(X);
                        btn[i].setDisabledIcon(X);
                        btn[i].setEnabled(false);
                        // Set back-end grid in position(i) && by value "X"
                        myGetWinner.setField(i, btnName);
                        if (myGetWinner.getWinner(btnName) == 1) {
                            playAgain(btnName);
                        }
                        break;
                    } else if (moveCount % 2 == 0) {
                        btnName = "O";
                        btn[i].setBackground(Color.white);
                        btn[i].setIcon(O);
                        btn[i].setDisabledIcon(O);
                        btn[i].setEnabled(false);
                        myGetWinner.setField(i, btnName);
                        if (myGetWinner.getWinner(btnName) == 1) {
                            playAgain(btnName);
                        }
                        break;
                    }

                }
            }

            // Check if Draw !
            if (moveCount == 42) {
                playAgain(" Draw !");
            }

        }

    }

    private void playAgain(String playerName) {
        Object[] options = {"Play Again", "  Exit  "};
        if (playerName.charAt(0) == 'X' || playerName.charAt(0) == 'O') {
            int n = JOptionPane.showOptionDialog(null, playerName + " has WON ! ", "Status", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == 0) {
                frame.dispose();
                main(null);
            } else
                frame.dispose();
        } else {
            int n = JOptionPane.showOptionDialog(null, playerName, "Status", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == 0) {
                frame.dispose();
                main(null);
            } else
                frame.dispose();
        }

    }

}
