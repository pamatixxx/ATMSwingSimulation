import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiTypeBanknote {

    //получаем фрейм
    static JFrame jFrame = getFrame();
    //создаем панель
    static JPanel jPanel = new JPanel();
    //определяем тип валюты
    static String typeCurrency = "";


    //блок выбора валюты - фрейм
    public GuiTypeBanknote() {
        jFrame.add(jPanel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);

        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton UAH = new JRadioButton("UAH");
        buttonGroup.add(UAH);
        jPanel.add(UAH);
        // UAH.setSelected(true);
        UAH.addActionListener(new MyListener());
        UAH.setActionCommand("UAH");

        JRadioButton RUR = new JRadioButton("RUR");
        jPanel.add(RUR);
        buttonGroup.add(RUR);
        RUR.addActionListener(new MyListener());
        RUR.setActionCommand("RUR");

        JRadioButton USD = new JRadioButton("USD");
        jPanel.add(USD);
        buttonGroup.add(USD);
        USD.addActionListener(new MyListener());
        USD.setActionCommand("USD");

        JButton button = new JButton("OK");
        jPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                System.out.println("Type currancy : " + typeCurrency);
                if (typeCurrency != "")
                    new GuiBanknote();
                // else System.out.println(Validation.msg);

            }
        });

    }

    //сам фрейм
    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {
        };
        jFrame.setVisible(true);
        jFrame.setBounds(200, 200, 350, 200);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }

    //слушатель
    public class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AbstractButton aButton = (AbstractButton) e.getSource();
            System.out.println("Selected: " + aButton.getText());
            // System.out.println(e);
            if (e.getActionCommand().equals("UAH")) typeCurrency = "UAH";
            else if (e.getActionCommand().equals("RUR")) typeCurrency = "RUR";
            else if (e.getActionCommand().equals("USD")) typeCurrency = "USD";
            else {
            }

        }
    }

}
