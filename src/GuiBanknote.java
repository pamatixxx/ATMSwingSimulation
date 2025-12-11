import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBanknote extends JFrame {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    static String  countBanknoteText = "";
    static Boolean checkCloseFrame = false;


    public GuiBanknote(){
        jFrame.add(jPanel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.weightx =0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridheight =  1;
        constraints1.gridwidth = 0;
        jPanel.add(new JLabel("Введите Сумму"),constraints1);


        GridBagConstraints constraints2 = new GridBagConstraints();
        JButton pressButoon1 = new JButton("1");
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 0;
        constraints2.gridy = 3;
        constraints2.gridheight = 1;
        constraints2.gridwidth = 1;
        jPanel.add(pressButoon1,constraints2);
        pressButoon1.addActionListener(new MyListener());
        pressButoon1.setActionCommand("1");

        GridBagConstraints constraints3 = new GridBagConstraints();
        JButton pressButoon2 = new JButton("2");
        constraints3.weightx = 0;
        constraints3.weighty = 0;
        constraints3.gridx = 1;
        constraints3.gridy = 3;
        constraints3.gridheight = 1;
        constraints3.gridwidth = 1;
        jPanel.add(pressButoon2,constraints3);
        pressButoon2.addActionListener(new MyListener());
        pressButoon2.setActionCommand("2");

        GridBagConstraints constraints4 = new GridBagConstraints();
        JButton pressButoon3 = new JButton("3");
        constraints4.weightx = 0;
        constraints4.weighty = 0;
        constraints4.gridx = 2;
        constraints4.gridy = 3;
        constraints4.gridheight = 1;
        constraints4.gridwidth = 1;
        jPanel.add(pressButoon3,constraints4);
        pressButoon3.addActionListener(new MyListener());
        pressButoon3.setActionCommand("3");

        GridBagConstraints constraints5 = new GridBagConstraints();
        JButton pressButoon4 = new JButton("4");
        constraints5.weightx = 0;
        constraints5.weighty = 0;
        constraints5.gridx = 0;
        constraints5.gridy = 4;
        constraints5.gridheight = 1;
        constraints5.gridwidth = 1;
        jPanel.add(pressButoon4,constraints5);
        pressButoon4.addActionListener(new MyListener());
        pressButoon4.setActionCommand("4");

        GridBagConstraints constraints6 = new GridBagConstraints();
        JButton pressButoon5 = new JButton("5");
        constraints6.weightx = 0;
        constraints6.weighty = 0;
        constraints6.gridx = 1;
        constraints6.gridy = 4;
        constraints6.gridheight = 1;
        constraints6.gridwidth = 1;
        jPanel.add(pressButoon5,constraints6);
        pressButoon5.addActionListener(new MyListener());
        pressButoon5.setActionCommand("5");

        GridBagConstraints constraints7 = new GridBagConstraints();
        JButton pressButoon6 = new JButton("6");
        constraints7.weightx = 0;
        constraints7.weighty = 0;
        constraints7.gridx = 2;
        constraints7.gridy = 4;
        constraints7.gridheight = 1;
        constraints7.gridwidth = 1;
        jPanel.add(pressButoon6,constraints7);
        pressButoon6.addActionListener(new MyListener());
        pressButoon6.setActionCommand("6");

        GridBagConstraints constraints8 = new GridBagConstraints();
        JButton pressButoon7 = new JButton("7");
        constraints8.weightx = 0;
        constraints8.weighty = 0;
        constraints8.gridx = 0;
        constraints8.gridy = 5;
        constraints8.gridheight = 1;
        constraints8.gridwidth = 1;
        jPanel.add(pressButoon7,constraints8);
        pressButoon7.addActionListener(new MyListener());
        pressButoon7.setActionCommand("7");

        GridBagConstraints constraints9 = new GridBagConstraints();
        JButton pressButoon8 = new JButton("8");
        constraints9.weightx = 0;
        constraints9.weighty = 0;
        constraints9.gridx = 1;
        constraints9.gridy = 5;
        constraints9.gridheight = 1;
        constraints9.gridwidth = 1;
        jPanel.add(pressButoon8,constraints9);
        pressButoon8.addActionListener(new MyListener());
        pressButoon8.setActionCommand("8");

        GridBagConstraints constraints10 = new GridBagConstraints();
        JButton pressButoon9 = new JButton("9");
        constraints10.weightx = 0;
        constraints10.weighty = 0;
        constraints10.gridx = 2;
        constraints10.gridy = 5;
        constraints10.gridheight = 1;
        constraints10.gridwidth = 1;
        jPanel.add(pressButoon9,constraints10);
        pressButoon9.addActionListener(new MyListener());
        pressButoon9.setActionCommand("9");

        GridBagConstraints constraints0 = new GridBagConstraints();
        JButton pressButoon0 = new JButton("0");
        constraints0.weightx = 0;
        constraints0.weighty = 0;
        constraints0.gridx = 0;
        constraints0.gridy = 6;
        constraints0.gridheight = 1;
        constraints0.gridwidth = 1;
        jPanel.add(pressButoon0,constraints0);
        pressButoon0.addActionListener(new MyListener());
        pressButoon0.setActionCommand("0");


        GridBagConstraints constraintsOk = new GridBagConstraints();
        JButton buttonOk = new JButton("  Далее ");
        constraintsOk.weightx = 0;
        constraintsOk.weighty = 0;
        constraintsOk.gridx = 1;
        constraintsOk.gridy = 6;
        constraintsOk.gridheight = 0;
        constraintsOk.gridwidth = 0;
        buttonOk.setBackground(Color.green);
        jPanel.add(buttonOk,constraintsOk);
        //закрытие фрейма по кнопке ОК
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                checkCloseFrame = true;
                System.out.println("Отправлена в обработку: " + countBanknoteText +" "+ GuiTypeBanknote.typeCurrency );
                ATMApplication.check(GuiBanknote.countBanknoteText);
            }
        });
        jPanel.revalidate();

    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(200,200,350,200);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        return jFrame;
    }



    public class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("1")) countBanknoteText +="1";
            else if (e.getActionCommand().equals("2")) countBanknoteText +="2";
            else if (e.getActionCommand().equals("3")) countBanknoteText +="3";
            else if (e.getActionCommand().equals("4")) countBanknoteText +="4";
            else if (e.getActionCommand().equals("5")) countBanknoteText +="5";
            else if (e.getActionCommand().equals("6")) countBanknoteText +="6";
            else if (e.getActionCommand().equals("7")) countBanknoteText +="7";
            else if (e.getActionCommand().equals("8")) countBanknoteText +="8";
            else if (e.getActionCommand().equals("9")) countBanknoteText +="9";
            else if (e.getActionCommand().equals("0")) countBanknoteText +="0";
            else {}

            //System.out.println(countBanknoteText);
        }
    }
}


