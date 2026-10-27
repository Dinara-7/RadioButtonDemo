import java.awt.*;
import java.io.File;
import javax.swing.*;

public class RadioButtonDemo extends JFrame {

    private JLabel picture;

    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        JLabel heading = new JLabel(
                "Choose Your Favourite Pet",
                SwingConstants.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading, BorderLayout.NORTH);

        String[] pets = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};

        JPanel petPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        ButtonGroup group = new ButtonGroup();

        picture = new JLabel(
                "Select a pet",
                SwingConstants.CENTER
        );
        picture.setPreferredSize(new Dimension(300, 230));

        for (String pet : pets) {
            JRadioButton button = new JRadioButton(pet);

            group.add(button);
            petPanel.add(button);

            button.addActionListener(e -> {
            File file = new File(
    "C:/Users/User/OneDrive/Desktop/RadioButtonDemo.java/"
    + pet + ".gif"
);

                System.out.println("Looking for: "
                        + file.getAbsolutePath());

                if (file.isFile()) {
                    ImageIcon icon = new ImageIcon(
                            file.getAbsolutePath()
                    );

                    Image image = icon.getImage()
                            .getScaledInstance(
                                    280, 220,
                                    Image.SCALE_SMOOTH
                            );

                    picture.setIcon(new ImageIcon(image));
                    picture.setText("");
                } else {
                    picture.setIcon(null);
                    picture.setText(
                            pet + ".gif not found!"
                    );
                }

                JOptionPane.showMessageDialog(
                        this,
                        "You selected: " + pet,
                        "Pet Selection",
                        JOptionPane.INFORMATION_MESSAGE
                );
            });
        }

        add(petPanel, BorderLayout.WEST);
        add(picture, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> new RadioButtonDemo()
        );
    }
}
