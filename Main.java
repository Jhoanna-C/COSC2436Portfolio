
/*
Jhoanna Contreras
11/17/2023
Searching and Sorting SLO #3 & 5
This is a program that allows the user to enter, sort, shuffle, and reverse a list of numbers

*/
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Main extends JFrame{
    private final List<Integer> numberList = new LinkedList<>();
    private final JTextArea displayArea;

    private final JTextField inputField;

    public Main() {

        // Set up the Jframe
        super("SearchSortGUI");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        inputField = new JTextField();
        JButton addButton =  new JButton("Add number.");
        addButton.addActionListener(e -> inputNumbers());

        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(e -> displaySortedNumbers());

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(e -> shuffleNumbers());

        JButton reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(e -> reverseNumbers());

        // Add components to panels
        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(sortButton);
        buttonPanel.add(shuffleButton);
        buttonPanel.add(reverseButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set JFrame properties
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // This method inputs a number from the user and adds it to the numberList
    private void inputNumbers(){
        try{
            int number = Integer.parseInt(inputField.getText());
            if (numberList.size() < 15 && !numberList.contains(number)){
                numberList.add(number);
                displayArea.append(number + "\n");
                inputField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid. Number already exist.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input is invalid. Enter another number.");
        }
    }

    // This method sorts the numberList and displays it in the displayArea
    private void displaySortedNumbers(){
        List<Integer> sortedList = new LinkedList<>(numberList);
        sortedList.sort(Integer::compareTo);
        updateDisplayArea(sortedList);
    }

    // This method shuffles the numberList and displays it in the displayArea
    private void shuffleNumbers(){
        List<Integer> shuffledList = new LinkedList<>(numberList);
        java.util.Collections.shuffle(shuffledList);
        updateDisplayArea(shuffledList);
    }

    // Method that reverses the numberList and displays it in the displayArea
    private void reverseNumbers(){
        List<Integer> reversedList = new LinkedList<>(numberList);
        java.util.Collections.reverse(reversedList);
        updateDisplayArea(reversedList);
    }

    // Updates the displayArea with the given list of numbers
    private void updateDisplayArea(List<Integer> numbers){
        displayArea.setText("");
        for(Integer number : numbers) {
            displayArea.append(number + "\n");
        }
    }

    // The main method that creates an instance of the SearchSortGUI class
    public static void main(String[] args){
        SwingUtilities.invokeLater(Main:: new);
    }
}
