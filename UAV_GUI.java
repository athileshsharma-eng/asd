import javax.swing.*;
import java.awt.*;

public class UAV_GUI extends JFrame {

    UAV drone = new UAV();

    JLabel altitudeLabel;
    JLabel batteryLabel;
    JLabel flyingLabel;
    JTextArea logArea;

    public UAV_GUI() {

        setTitle("UAV Ground Control System");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel statusPanel = new JPanel(new GridLayout(3,1));

        altitudeLabel = new JLabel("Altitude: 0 m");
        batteryLabel = new JLabel("Battery: 100%");
        flyingLabel = new JLabel("Flying: false");

        statusPanel.add(altitudeLabel);
        statusPanel.add(batteryLabel);
        statusPanel.add(flyingLabel);

        add(statusPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2,2));

        JButton takeoffBtn = new JButton("Take Off");
        JButton landBtn = new JButton("Land");
        JButton incAltBtn = new JButton("Increase Altitude");
        JButton decAltBtn = new JButton("Decrease Altitude");

        buttonPanel.add(takeoffBtn);
        buttonPanel.add(landBtn);
        buttonPanel.add(incAltBtn);
        buttonPanel.add(decAltBtn);

        add(buttonPanel, BorderLayout.CENTER);

        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.SOUTH);

        takeoffBtn.addActionListener(e -> update(drone.takeOff()));
        landBtn.addActionListener(e -> update(drone.land()));
        incAltBtn.addActionListener(e -> update(drone.increaseAltitude()));
        decAltBtn.addActionListener(e -> update(drone.decreaseAltitude()));

        setVisible(true);
    }

    public void update(String message) {
        altitudeLabel.setText("Altitude: " + drone.getAltitude() + " m");
        batteryLabel.setText("Battery: " + drone.getBattery() + "%");
        flyingLabel.setText("Flying: " + drone.isFlying());
        logArea.append(message + "\n");
    }

    public static void main(String[] args) {
        new UAV_GUI();
    }
}
