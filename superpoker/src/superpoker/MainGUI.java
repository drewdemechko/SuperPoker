
package superpoker;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author mk
 */
public class MainGUI extends JFrame {
    JButton[] deck;

    public MainGUI() {
        super("Super Poker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        setLayout(new BorderLayout());

        //North Panel
        JPanel northPanel = new JPanel();
        northPanel.setBorder(BorderFactory.createTitledBorder("Game Type"));
        JButton localGame = new JButton("Local Game");
        JButton serverGame = new JButton("Server Game");

        northPanel.add(localGame, BorderLayout.NORTH);
        northPanel.add(serverGame, BorderLayout.NORTH);

        //Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4,13));
        centerPanel.add(new JButton("test"));
        
        //South Panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));

        JLabel solutionLabel = new JLabel("Solution");
        solutionLabel.setAlignmentY(JLabel.LEFT_ALIGNMENT);

        JTextField solution = new JTextField();
        solution.setEditable(false);
        solution.setColumns(20);

        JPanel gameButtonsPanel = new JPanel();
        JButton newGame = new JButton("New Game");
        JButton exitGame = new JButton("Exit Game");

        gameButtonsPanel.add(newGame, BorderLayout.SOUTH);
        gameButtonsPanel.add(exitGame, BorderLayout.SOUTH);

        southPanel.add(solutionLabel);
        southPanel.add(solution);
        southPanel.add(gameButtonsPanel);

        //Center
        JPanel gameModePanel = new JPanel();
        CardLayout gameModeLayout = new CardLayout();
        gameModePanel.setLayout(gameModeLayout);

        gameModePanel.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED));

        //Local GUI
        JPanel localGamePanel = new JPanel();
        localGamePanel.setLayout(new GridLayout(4,13));
        
        //Card visuals
        String[] cardDescriptions = {"Ace of clubs", "2 of clubs", "3 of clubs", "4 of clubs", "5 of clubs", 
            "6 of clubs", "7 of clubs", "8 of clubs", "9 of clubs", "10 of clubs", "Jack of clubs", 
            "Queen of clubs", "King of clubs", "Ace of diamonds", "2 of diamonds", "3 of diamonds", 
            "4 of diamonds", "5 of diamonds", "6 of diamonds", "7 of diamonds", "8 of diamonds", 
            "9 of diamonds", "10 of diamonds", "Jack of diamonds", "Queen of diamonds", "King of diamonds",
            "Ace of hearts", "2 of hearts", "3 of hearts", "4 of hearts", "5 of hearts", "6 of hearts", 
            "7 of hearts", "8 of hearts", "9 of hearts", "10 of hearts", "Jack of hearts", 
            "Queen of hearts", "King of hearts", "Ace of spades", "2 of spades", "3 of spades", 
            "4 of spades", "5 of spades", "6 of spades", "7 of spades", "8 of spades", "9 of spades", 
            "10 of spades", "Jack of spades", "Queen of spades", "King of spades"
        };
        int[] cardValues = {1,2,3,4,5,6,7,8,9,10,11,12,13,
            1,2,3,4,5,6,7,8,9,10,11,12,13,
            1,2,3,4,5,6,7,8,9,10,11,12,13,
            1,2,3,4,5,6,7,8,9,10,11,12,13
        };
        javax.swing.border.Border emptyBorder = BorderFactory.createEmptyBorder();
        deck = new JButton[52];                
        deck[0] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/aofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[1] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/2ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[2] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/3ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[3] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/4ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[4] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/5ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[5] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/6ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[6] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/7ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[7] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/8ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[8] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/9ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[9] =  new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/10ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[10] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/jofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[11] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/qofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[12] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/kofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[13] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/aofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[14] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/2ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[15] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/3ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[16] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/4ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[17] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/5ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[18] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/6ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[19] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/7ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[20] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/8ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[21] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/9ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[22] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/10ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[23] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/jofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[24] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/qofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[25] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/kofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[26] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/aofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[27] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/2ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[28] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/3ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[29] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/4ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[30] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/5ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[31] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/6ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[32] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/7ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[33] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/8ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[34] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/9ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[35] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/10ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[36] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/jofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[37] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/qofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[38] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/kofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[39] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/aofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[40] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/2ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[41] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/3ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[42] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/4ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[43] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/5ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[44] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/6ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[45] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/7ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[46] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/8ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[47] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/9ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[48] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/10ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[49] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/jofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[50] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/qofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[51] = new JButton(new ImageIcon(new ImageIcon(this.getClass().getResource("images/kofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        
        //when card image gets clicked
        ActionListener cardClick = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int cardsSelected = 0;
                for(int i = 0; i < 52; i++)
                    if(e.getSource() == deck[i])
                    {
                        deck[i].setEnabled(false);
                        System.out.print(cardDescriptions[i] + " " + cardValues[i]);
                    }
                
                for(int i = 0; i < 52; i++)
                    if(deck[i].isEnabled() == false)
                        cardsSelected++;
                
                if(cardsSelected == 4)
                {
                    //tracks cards ABCD
                    List<String> tempCardDescriptions = new ArrayList<>();
                    List<Integer> tempCardValues = new ArrayList<>();
                    for(int i = 0; i < 52; i++)
                        if(deck[i].isEnabled())
                        {
                            deck[i].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/backofcard.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH))); 
                            deck[i].setEnabled(false);
                        }
                        else
                        {
                            tempCardDescriptions.add(cardDescriptions[i]);
                            tempCardValues.add(cardValues[i]); 
                        }
                OperatorTree operatorTree = new OperatorTree(new Card(tempCardDescriptions.get(0), tempCardValues.get(0)),
                        new Card(tempCardDescriptions.get(1), tempCardValues.get(1)), 
                        new Card(tempCardDescriptions.get(2), tempCardValues.get(2)), 
                        new Card(tempCardDescriptions.get(3), tempCardValues.get(3)));

                solution.setText(operatorTree.findSolution());
                }
            }
        };
        
        for(int i = 0; i < 52; i++){
            deck[i].setBackground(Color.WHITE);
            deck[i].setBorder(emptyBorder);
            deck[i].addActionListener(cardClick);
            localGamePanel.add(deck[i]);
        }
        


        JTextField cardSelection = new JTextField();
        cardSelection.setColumns(20);

        JButton send = new JButton("Send");

        //localGamePanel.add(cardSelection);
        //localGamePanel.add(send);

        //Server GUI
        JPanel serverGamePanel = new JPanel();
        serverGamePanel.setLayout(
                new BoxLayout(serverGamePanel, BoxLayout.Y_AXIS));

        JTextArea serverInfo = new JTextArea();
        serverInfo.append("Connecting to server...");
        JScrollPane scrollPane = new JScrollPane(serverInfo);

        serverGamePanel.add(scrollPane);

        gameModePanel.add(localGamePanel, "Local Game");
        gameModePanel.add(serverGamePanel, "Server Game");

        //Set the card layout
        gameModeLayout.first(gameModePanel);

        //MainGUI
        add(northPanel, BorderLayout.NORTH);
        add(gameModePanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        //Action listeners
        localGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameModeLayout.first(gameModePanel);
            }
        });
        
        serverGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameModeLayout.last(gameModePanel);
            }
        });

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solution.setText("");
                newGame(deck);
            }
        });
        setVisible(true);
    }
    
    public void newGame(JButton[] deck)
    {
        deck[0].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/aofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[1].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/2ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[2].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/3ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[3].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/4ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[4].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/5ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[5].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/6ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[6].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/7ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[7].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/8ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[8].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/9ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[9].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/10ofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[10].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/jofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[11].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/qofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[12].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/kofclubs.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[13].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/aofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[14].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/2ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[15].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/3ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[16].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/4ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[17].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/5ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[18].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/6ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[19].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/7ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[20].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/8ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[21].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/9ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[22].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/10ofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[23].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/jofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[24].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/qofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[25].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/kofdiamonds.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[26].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/aofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[27].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/2ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[28].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/3ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[29].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/4ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[30].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/5ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[31].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/6ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[32].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/7ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[33].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/8ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[34].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/9ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[35].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/10ofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[36].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/jofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[37].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/qofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[38].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/kofhearts.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[39].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/aofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[40].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/2ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[41].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/3ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[42].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/4ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[43].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/5ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[44].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/6ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[45].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/7ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[46].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/8ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[47].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/9ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[48].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/10ofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        deck[49].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/jofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[50].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/qofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));
        deck[51].setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("images/kofspades.png")).getImage().getScaledInstance(27, 56, java.awt.Image.SCALE_SMOOTH)));        
        for(int i = 0; i < 52; i++)
            deck[i].setEnabled(true);
        
    }
}
//-----Example using the OperatorTree class to find solution
//        OperatorTree tree = new OperatorTree(new Card("Ace",1), new Card("3",3), new Card("5",5), new Card("2",2));
//        System.out.println(tree.findSolution());

