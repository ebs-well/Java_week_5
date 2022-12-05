import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;


public class RockPaperScissors extends JFrame {
    JPanel panel = new JPanel(); //This will contain the compenents
    Font font = new Font(Font.SERIF,Font.BOLD, 100); //Sets the font for the X and O

    int AIScore = 0;
    int userScore = 0;
    int tieScore = 0;

    JButton btnRock = new JButton("Rock");
    JButton btnPaper = new JButton("Paper");
    JButton btnScissors = new JButton("Scissors");
    JButton btnReset = new JButton("RESET");

    JLabel Score = new JLabel("Player Score: " + userScore + " AI Score: "+ AIScore + " Tie Score: " + tieScore);






    public RockPaperScissors()
    {
        super("Rock Paper Scissors");
        setContentPane(panel); // Calls the compenent container built above
        panel.setVisible(true); // Needs this to be visible
        setSize(450,450); // How big the window is
        setVisible(true); // Needs this to be visible
        setLocation(500,500); // Initial location when opened
        setResizable(false); // Stops user from changing size of the application
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Closes the application when you hit the "X"
        setLayout(null); // Allows me to place the buttons into a specific position

        //Buttons
        btnRock.setBounds(0,0,150,150);
        btnRock.addActionListener(e -> MyClickEventHandler(e));
        add(btnRock);

        btnPaper.setBounds(150,0,150,150);
        btnPaper.addActionListener(e -> MyClickEventHandler(e));
        add(btnPaper);

        btnScissors.setBounds(300,0,150,150);
        btnScissors.addActionListener(e -> MyClickEventHandler(e));
        add(btnScissors);

        btnReset.setBounds(0, 300, 450, 150);
        btnReset.addActionListener(e -> resetGame(e));
        add(btnReset);

        //Panel
        Score.setBounds(100, 180, 450, 100);
        panel.add(Score);





    }

    //Event Handler for buttons

    public void MyClickEventHandler(ActionEvent e) {
        int AI_Choice = (int)(Math.random()*3) + 1;
        // 1 = Rock 
        // 2 = Paper 
        // 3 = Scissors
        //AI picks Rock
        if (AI_Choice == 1 && e.getSource() == btnRock)
        {
            tieScore += 1;
            System.out.println("Button works");
        }
        else if (AI_Choice == 1 && e.getSource() == btnPaper)
        {
            userScore += 1;
            System.out.println("Button works");
        }
        else if (AI_Choice == 1 && e.getSource() == btnScissors)
        {
            AIScore ++;
            System.out.println("Button works");
        }

        //AI picks Paper
        if (AI_Choice == 2 && e.getSource() == btnRock)
        {
            AIScore ++;
        }
        else if (AI_Choice == 2 && e.getSource() == btnPaper)
        {
            tieScore ++;
        }
        else if (AI_Choice == 2 && e.getSource() == btnScissors)
        {
            userScore += 1;
        }

        //AI picks Scissors
        if (AI_Choice == 3 && e.getSource() == btnRock)
        {
            userScore += 1;
        }
        else if (AI_Choice == 3 && e.getSource() == btnPaper)
        {
            AIScore ++;
        }
        else if (AI_Choice == 3 && e.getSource() == btnScissors)
        {
            tieScore ++;
        }
        Score.setText("Player Score: " + userScore + " AI Score: "+ AIScore + " Tie Score: " + tieScore);
    }

    public void resetGame(ActionEvent e)
    {
        int reset = 0;
        if (e.getSource() == btnReset)
        {
            userScore = reset;
            AIScore = reset;
            tieScore = reset;
            Score.setText("Player Score: " + userScore + " AI Score: "+ AIScore + " Tie Score: " + tieScore);
        }
    }

}