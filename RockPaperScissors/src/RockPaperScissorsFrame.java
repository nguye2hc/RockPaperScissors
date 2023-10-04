import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {

        JPanel mainPnl;
        JPanel statsPnl;
        JPanel displayPnl;
        JPanel controlPnl;
        JScrollPane scroller;
        JTextArea gameTA;
        JLabel statLbl;
        JTextField WinCount;
        JTextField LoseCount;
        JTextField TieCount;
        JLabel WinLbl;
        JLabel LoseLbl;
        JLabel TieLbl;

        JButton quitBtn;
        JButton RockBtn;
        JButton PaperBtn;
        JButton ScissorsBtn;
        int playerWinCount = 0;
        int playerLoseCount = 0;
        int playerTieCount = 0;
        ArrayList<String> RockPaperScissors = new ArrayList<>();

        public RockPaperScissorsFrame()
        {

            //Adding fortunes
            RockPaperScissors.add("Rock");
            RockPaperScissors.add("Paper");
            RockPaperScissors.add("Scissors");

            mainPnl = new JPanel();
            mainPnl.setLayout(new BorderLayout());


            createStatPanel();
            createDisplayPanel();
            createControlPanel();


            mainPnl.add(statsPnl, BorderLayout.NORTH);
            mainPnl.add(displayPnl, BorderLayout.CENTER);
            mainPnl.add(controlPnl, BorderLayout.SOUTH);
            add(mainPnl);
            pack();
        }

    private void createDisplayPanel() {
        displayPnl = new JPanel();
        //create text area
        gameTA = new JTextArea(15, 40);
        gameTA.setFont(new Font("Arial", Font.PLAIN, 20));
        gameTA.setEditable(false);

        scroller = new JScrollPane(gameTA);
        displayPnl.add(scroller);
    }

        private void createStatPanel()
        {
            statsPnl = new JPanel();
            statsPnl.setLayout(new GridLayout(3,2));
            statsPnl.setLayout(new FlowLayout(FlowLayout.CENTER));

            WinLbl = new JLabel("Player won: ");
            WinCount = new JTextField();
            WinCount.setText(String.valueOf(playerWinCount));
            WinCount.setEditable(false);

            LoseLbl = new JLabel("Player lose: ");
            LoseCount = new JTextField();
            LoseCount.setText(String.valueOf(playerLoseCount));
            LoseCount.setEditable(false);


            TieLbl = new JLabel("Tie: ");
            TieCount = new JTextField(playerTieCount);
            TieCount.setText(String.valueOf(playerTieCount));
            TieCount.setEditable(false);

            statsPnl.add(WinLbl);
            statsPnl.add(WinCount);

            statsPnl.add(LoseLbl);
            statsPnl.add(LoseCount);

            statsPnl.add(TieLbl);
            statsPnl.add(TieCount);
        }


        private void createControlPanel()
        {
            controlPnl = new JPanel();
            controlPnl.setLayout(new GridLayout(1, 4));

            ImageIcon rock = new ImageIcon("src/rock.png");
            Image rockImg = rock.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING);
            rock = new ImageIcon(rockImg);

            ImageIcon paper = new ImageIcon("src/paper.png");
            Image paperImg = paper.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING);
            paper = new ImageIcon(paperImg);

            ImageIcon scissors = new ImageIcon("src/scissors.png");
            Image scissorsImg = scissors.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING);
            scissors = new ImageIcon(scissorsImg);

            RockBtn = new JButton();
            PaperBtn = new JButton();
            ScissorsBtn = new JButton();
            quitBtn = new JButton("Quit");

            RockBtn.setIcon(rock);
            PaperBtn.setIcon(paper);
            ScissorsBtn.setIcon(scissors);


            //Making buttons perform functionally
            RockBtn.addActionListener(e -> {
                int lastIndex = -1;
                int index;
                Random rand = new Random();

                index = rand.nextInt(RockPaperScissors.size());
                lastIndex = index;
                boolean done = false;

                do {
                    index = rand.nextInt(RockPaperScissors.size());
                }while(done);

                if(index == 0)
                {
                    playerTieCount++;
                    TieCount.setText(String.valueOf(playerTieCount));
                    gameTA.append("Rock vs Rock, that is a tie" + "\n");
                }
                else if (index == 1)
                {
                    playerLoseCount++;
                    LoseCount.setText(String.valueOf(playerLoseCount));
                    gameTA.append("Paper covers Rock, player 2 win" + "\n");
                }
                else if (index == 2)
                {
                    playerWinCount++;
                    WinCount.setText(String.valueOf(playerWinCount));
                    gameTA.append("Rock breaks Scissors, player 1 win" + "\n");
                }

            });

            PaperBtn.addActionListener(e -> {
                int lastIndex = -1;
                int index;
                Random rand = new Random();

                index = rand.nextInt(RockPaperScissors.size());
                lastIndex = index;
                boolean done = false;

                do {
                    index = rand.nextInt(RockPaperScissors.size());
                }while(done);

                if(index == 0)
                {
                    playerWinCount++;
                    WinCount.setText(String.valueOf(playerWinCount));
                    gameTA.append("Paper covers Rock, player 1 win"+ "\n");
                }
                else if (index == 1)
                {

                    playerTieCount++;
                    TieCount.setText(String.valueOf(playerTieCount));
                    gameTA.append("Paper vs Paper, that is a tie" + "\n");
                }
                else if (index == 2)
                {
                    playerLoseCount++;
                    LoseCount.setText(String.valueOf(playerLoseCount));
                    gameTA.append("Scissors cuts Paper, player 2 win" + "\n");
                }

            });

            ScissorsBtn.addActionListener(e -> {
                int lastIndex = -1;
                int index;
                Random rand = new Random();

                index = rand.nextInt(RockPaperScissors.size());
                lastIndex = index;
                boolean done = false;

                do {
                    index = rand.nextInt(RockPaperScissors.size());
                }while(done);

                if(index == 0)
                {
                    playerLoseCount++;
                    LoseCount.setText(String.valueOf(playerLoseCount));
                    gameTA.append("Rock breaks Scissors, player 2 win." + "\n");
                }
                else if (index == 1)
                {
                    playerWinCount++;
                    WinCount.setText(String.valueOf(playerWinCount));
                    gameTA.append("Scissors cut Paper, player 1 win" + "\n");
                }
                else if (index == 2)
                {
                    playerTieCount++;
                    TieCount.setText(String.valueOf(playerTieCount));
                    gameTA.append("Scissors vs Scissors, that is a tie" + "\n");
                }

            });

            quitBtn.addActionListener(e -> System.exit(0));



            controlPnl.add(RockBtn);
            controlPnl.add(PaperBtn);
            controlPnl.add(ScissorsBtn);
            controlPnl.add(quitBtn);
        }


    }

