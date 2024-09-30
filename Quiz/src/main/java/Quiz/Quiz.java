package Quiz;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Quiz implements ActionListener, QuizInterface {

    ArrayList<String> images = new ArrayList<>(Arrays.asList(
            "src/main/resources/Andromeda_1.jpg",
            "src/main/resources/Andromeda_2.jpg",
            "src/main/resources/Andromeda_3.jpg",
            "src/main/resources/Assassin_1.jpg",
            "src/main/resources/Assassin_2.jpg",
            "src/main/resources/Assassin_3.jpg",
            "src/main/resources/Batman_1.jpg",
            "src/main/resources/Batman_2.jpg",
            "src/main/resources/Batman_3.jpg",
            "src/main/resources/Call_of_Duty_1.jpg",
            "src/main/resources/Call_of_Duty_2.jpg",
            "src/main/resources/Call_of_Duty_3.jpg",
            "src/main/resources/Dishonored_1.jpg",
            "src/main/resources/Dishonored_2.jpg",
            "src/main/resources/Dishonored_3.jpg",
            "src/main/resources/Far_Cry_1.jpg",
            "src/main/resources/Far_Cry_2.jpg",
            "src/main/resources/Far_Cry_3.jpg",
            "src/main/resources/Forza_1.jpg",
            "src/main/resources/Forza_2.jpg",
            "src/main/resources/Forza_3.jpg",
            "src/main/resources/God_of_War_1.jpg",
            "src/main/resources/God_of_War_2.jpg",
            "src/main/resources/God_of_War_3.jpg",
            "src/main/resources/Ninja_1.jpg",
            "src/main/resources/Ninja_2.jpg",
            "src/main/resources/Ninja_3.jpg",
            "src/main/resources/Ori_1.jpg",
            "src/main/resources/Ori_2.jpg",
            "src/main/resources/Ori_3.jpg",
            "src/main/resources/Rapture_1.jpg",
            "src/main/resources/Rapture_2.jpg",
            "src/main/resources/Rapture_3.jpg",
            "src/main/resources/Read_Dead_1.jpg",
            "src/main/resources/Read_Dead_2.jpg",
            "src/main/resources/Read_Dead_3.jpg",
            "src/main/resources/Seasons_1.jpg",
            "src/main/resources/Seasons_2.jpg",
            "src/main/resources/Seasons_3.jpg",
            "src/main/resources/Skyrim_1.jpg",
            "src/main/resources/Skyrim_2.jpg",
            "src/main/resources/Skyrim_3.jpg",
            "src/main/resources/Sniper_1.jpg",
            "src/main/resources/Sniper_2.jpg",
            "src/main/resources/Sniper_3.jpg",
            "src/main/resources/Spec_Ops_1.jpg",
            "src/main/resources/Spec_Ops_2.jpg",
            "src/main/resources/Spec_Ops_3.jpg",
            "src/main/resources/Styx_1.jpg",
            "src/main/resources/Styx_2.jpg",
            "src/main/resources/Styx_3.jpg",
            "src/main/resources/Unravel_1.jpg",
            "src/main/resources/Unravel_2.jpg",
            "src/main/resources/Unravel_3.jpg",
            "src/main/resources/Witcher_1.jpg",
            "src/main/resources/Witcher_2.jpg",
            "src/main/resources/Witcher_3.jpg",
            "src/main/resources/Woolfe_1.jpg",
            "src/main/resources/Woolfe_2.jpg",
            "src/main/resources/Woolfe_3.jpg",
            "src/main/resources/Zoo_1.jpg",
            "src/main/resources/Zoo_2.jpg",
            "src/main/resources/Zoo_3.jpg"
    ));

    ArrayList<ArrayList<String>> answerOptions = new ArrayList<>(
            Arrays.asList(
                    new ArrayList<>(Arrays.asList("Mass Effect: Andromeda", "Star Wars Battlefront II", "Call of Duty: Advanced Warfare", "Ori and the Blind Forest")),
                    new ArrayList<>(Arrays.asList("Far Cry 4", "Assassin's Creed Unity", "God of War", "Max Payne 3")),
                    new ArrayList<>(Arrays.asList("The Witcher 3: Wild Hunt", "The Elder Scrolls V", "Batman: Arkham Knight", "Tomb Raider")),
                    new ArrayList<>(Arrays.asList("Max Payne 3", "Call of Duty: Advanced Warfare", "Deus Ex: Mankind Divided", "Star Wars Battlefront II")),
                    new ArrayList<>(Arrays.asList("Everybody's Gone to the Rapture", "Far Cry 3", "Mark of the Ninja", "Dishonored")),
                    new ArrayList<>(Arrays.asList("Far Cry 4", "Assassin's Creed Origins", "Max Payne 3", "Read Dead Redemption 2")),
                    new ArrayList<>(Arrays.asList("Planet zoo", "Forza Horizon 4", "Grand Theft Auto V", "Far Cry 3")),
                    new ArrayList<>(Arrays.asList("God of War", "The Witcher 3: Wild Hunt", "Mass Effect: Andromeda", "Read Dead Redemption 2")),
                    new ArrayList<>(Arrays.asList("Shu", "Mark of the Ninja", "Everybody's Gone to the Rapture", "The Elder Scrolls V")),
                    new ArrayList<>(Arrays.asList("Ori and the Blind Forest", "RiME", "Far Cry 3", "Forza Horizon 4")),
                    new ArrayList<>(Arrays.asList("Grand Theft Auto V", "Far Cry 3", "Planet Zoo", "Everybody's Gone to the Rapture")),
                    new ArrayList<>(Arrays.asList("Far Cry 4", "Assassin's Creed Syndicate", "Read Dead Redemption 2", "Max Payne 3")),
                    new ArrayList<>(Arrays.asList("Planet zoo", "Seasons after Fall", "Forza Horizon 4", "Hue")),
                    new ArrayList<>(Arrays.asList("Everybody's Gone to the Rapture", "The Elder Scrolls V", "Tomb Raider", "Dragon Age Inquisition")),
                    new ArrayList<>(Arrays.asList("Far Cry 3", "Assassin's Creed Syndicate", "Max Payne 3", "Sniper Elite V2")),
                    new ArrayList<>(Arrays.asList("Spec Ops: The Line", "Battlefield 4", "Grand Theft Auto V", "Far Cry 3")),
                    new ArrayList<>(Arrays.asList("Everybody's Gone to the Rapture", "Styx: Master of Shadows", "Middle-earth: Shadow of Mordor", "Dishonored")),
                    new ArrayList<>(Arrays.asList("Planet zoo", "Magicka 2", "Unravel", "Far Cry 3")),
                    new ArrayList<>(Arrays.asList("Everybody's Gone to the Rapture", "Far Cry 4", "Planet Zoo", "The Witcher 3: Wild Hunt")),
                    new ArrayList<>(Arrays.asList("Unravel", "Tomb Raider", "Woolfe - The Red Hood Diaries", "Read Dead Redemption 2")),
                    new ArrayList<>(Arrays.asList("Planet zoo", "Forza Horizon 4", "Trine 2", "Far Cry 3"))
            )
    );

    ArrayList<String> correctAnswers = new ArrayList<>(Arrays.asList(
            "Mass Effect: Andromeda", "Assassin's Creed Unity", "Batman: Arkham Knight", "Call of Duty: Advanced Warfare", "Dishonored", "Far Cry 4", "Forza Horizon 4", "God of War", "Mark of the Ninja", "Ori and the Blind Forest", "Everybody's Gone to the Rapture", "Read Dead Redemption 2", "Seasons after Fall", "The Elder Scrolls V", "Sniper Elite V2", "Spec Ops: The Line", "Styx: Master of Shadows", "Unravel", "The Witcher 3: Wild Hunt", "Woolfe - The Red Hood Diaries", "Planet zoo"
    ));

    ArrayList<Integer> selectedQuestions = new ArrayList<>();

    Integer correctGuesses = 0;
    Integer bestPossibleResult = correctAnswers.size();
    Integer seconds = 30;
    Integer imageIndex = 0;
    Integer questionIndex = 0;

    JFrame frame = new JFrame();
    JTextField titleField = new JTextField();
    JTextArea instructionsArea = new JTextArea();
    JButton startButton = new JButton();
    JLabel secondsLeft = new JLabel();
    JButton[] answersButtons = new JButton[4];
    JLabel imageArea = new JLabel();
    JTextField resultArea = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                displayCorrectAnswer();
            }
        }
    });

    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(25, 25, 25));
        frame.setLayout(null);

        titleField.setBounds(0, 0, 1400, 100);
        titleField.setBackground(new Color(25, 25, 25));
        titleField.setForeground(new Color(220, 220, 220));
        titleField.setFont(new Font("Serif", Font.BOLD, 30));
        titleField.setBorder(null);
        titleField.setHorizontalAlignment(JTextField.CENTER);
        titleField.setCaretColor(new Color(25, 25, 25));
        titleField.setEditable(false);
        titleField.setText("Quiz");

        instructionsArea.setBounds(310, 200, 770, 200);
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        instructionsArea.setBackground(new Color(25, 25, 25));
        instructionsArea.setForeground(new Color(220, 220, 220));
        instructionsArea.setFont(new Font("Serif", Font.BOLD, 18));
        instructionsArea.setBorder(null);
        instructionsArea.setEditable(false);
        instructionsArea.setText("To start the game, press the ‘Start’ button. On the next page you will see a frame of the game. You will have to guess the name of the game  and choose the correct answer . If you succeed, you will get 3 points, if not, you will see another frame from the same game. If you succeed this time, you will get 2 points, if not, you will see the last frame and be able to get 1 point. If you fail, the quiz will automatically move on to the next frame/question after 30 seconds. May the Force be with you.\n");

        startButton.setBounds(624, 500, 150, 60);
        startButton.setFont(new Font("Serif", Font.BOLD, 20));
        startButton.setFocusable(false);
        startButton.setText("Start");
        startButton.addActionListener(this);

        secondsLeft.setBounds(1250, 30, 100, 50);
        secondsLeft.setBackground(new Color(25, 25, 25));
        secondsLeft.setForeground(new Color(220, 220, 220));
        secondsLeft.setFont(new Font("Serif", Font.BOLD, 26));
        secondsLeft.setBorder(null);
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));
        secondsLeft.setBorder(new LineBorder(new Color(220, 220, 220), 1, true));

        frame.add(secondsLeft);
        frame.add(startButton);
        frame.add(instructionsArea);
        frame.add(titleField);
        frame.setVisible(true);

    }

    @Override
    public void startQuiz() {
        frame.getContentPane().removeAll();
        frame.repaint();

        ArrayList<Integer> allQuestions = new ArrayList<>();
        for (int index = 0; index < correctAnswers.size(); index++){
            allQuestions.add(index);
        }

        Collections.shuffle(allQuestions);
        selectedQuestions.addAll(allQuestions.subList(0,7));

        imageArea.setBounds(300, 10, 800, 580);
        frame.add(imageArea);

        JPanel answersPanel = new JPanel();
        answersPanel.setBounds(400, 600, 600, 150);
        answersPanel.setBackground(new Color(25, 25, 25));
        answersPanel.setForeground(new Color(220, 220, 220));
        answersPanel.setLayout(new GridLayout(2, 2, 20, 20));

        for (int index = 0; index < 4; index++) {
            answersButtons[index] = new JButton();
            answersButtons[index].setFont(new Font("Serif", Font.PLAIN, 16));
            answersButtons[index].setFocusable(false); // Disable focus for the button
            answersButtons[index].setFocusPainted(false);
            answersButtons[index].addActionListener(this);
            answersPanel.add(answersButtons[index]);
        }

        frame.add(answersPanel);
        frame.add(secondsLeft);

        loadQuestion();
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void loadQuestion() {
        if (questionIndex > selectedQuestions.size()) {
            result();
        } else {

            Integer randomQuestionIndex = selectedQuestions.get(questionIndex);
            String imagePath = images.get(randomQuestionIndex * 3 + imageIndex);
            ImageIcon originalImage = new ImageIcon(imagePath);
            Image image = originalImage.getImage();
            Image scaledImage = image.getScaledInstance(imageArea.getWidth(), imageArea.getHeight(), Image.SCALE_SMOOTH);
            imageArea.setIcon(new ImageIcon(scaledImage));

            ArrayList<String> options = answerOptions.get(randomQuestionIndex);
            for (int index = 0; index < 4; index++) {
                answersButtons[index].setText(options.get(index));
                answersButtons[index].setEnabled(true);
                answersButtons[index].setForeground(Color.black);
            }

            timer.start();
        }
    }

    @Override
    public void processAnswer(String selectedAnswer) {
        timer.stop();

        String correctAnswer = correctAnswers.get(selectedQuestions.get(questionIndex));
        boolean isCorrect = selectedAnswer.equals(correctAnswer);

        if (imageIndex == 2) {
            for (JButton answerButton : answersButtons) {
                if (answerButton.getText().equals(correctAnswer)) {
                    answerButton.setForeground(Color.green);
                } else {
                    answerButton.setForeground(Color.red);
                }
            }
        } else {
            for (JButton answerButton : answersButtons) {
                if (answerButton.getText().equals(selectedAnswer)) {
                    if (isCorrect) {
                        answerButton.setForeground(Color.green);
                    } else {
                        answerButton.setForeground(Color.red);
                    }
                }
            }
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton answerButton : answersButtons) {
                    answerButton.setForeground(Color.black);
                }

                seconds = 30;
                secondsLeft.setText(String.valueOf(seconds));

                if (isCorrect) {
                    if (imageIndex == 0) {
                        correctGuesses += 3;
                    } else if (imageIndex == 1) {
                        correctGuesses += 2;
                    } else {
                        correctGuesses += 1;
                    }

                    questionIndex++;
                    imageIndex = 0;
                } else {
                    imageIndex++;
                }

                if (imageIndex == 3) {
                    questionIndex++;
                    imageIndex = 0;
                }


                if (questionIndex < selectedQuestions.size()) {
                    loadQuestion();
                } else {
                    result();
                }
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    @Override
    public void displayCorrectAnswer() {
        processAnswer("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton answersButton : answersButtons) {
            if (e.getSource() == answersButton) {
                String selectedAnswer = answersButton.getText();
                processAnswer(selectedAnswer);
                break;
            }
        }

        if (e.getSource() == startButton) {
            startQuiz();
        }
    }

    @Override
    public void result() {
        for (JButton answerButtons : answersButtons) {
            answerButtons.setEnabled(false);
        }

        frame.getContentPane().removeAll();
        frame.repaint();

        resultArea.setBounds(400, 100, 600, 500);
        resultArea.setBackground(new Color(25, 25, 25));
        resultArea.setForeground(new Color(220, 220, 220));
        resultArea.setFont(new Font("Serif", Font.BOLD, 40));
        resultArea.setBorder(null);
        resultArea.setHorizontalAlignment(JTextField.CENTER);
        resultArea.setEditable(false);
        resultArea.setText("Your score: " + correctGuesses + "/" + bestPossibleResult);

        frame.add(resultArea);
        frame.revalidate();
        frame.repaint();
    }
}
