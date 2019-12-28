package gurinovich.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame
{
    private double mem1 = 0, mem2 = 0, mem3 = 0, Rez = 0;

    private int FormulaID = 1, MemID = 1;

    private JLabel img = new JLabel(new ImageIcon("D:/Projects/Java/Lab2/Formula1.png"));

    private double calculate1(double x, double y, double z)
    {
        return (Math.sin(Math.PI * y * y) + Math.log10(y * y))  / (Math.sin(Math.PI * z * z) + Math.sin(x) + Math.log10(z * z) + x * x + Math.exp(Math.cos(z * x)));
    }

    private double calculate2(double x, double y, double z)
    {
        return ( Math.sqrt(Math.sqrt(Math.cos(Math.exp(y))  + Math.exp(y * y) + Math.sqrt(1 / x))) ) / Math.pow(Math.cos(Math.PI * z * z * z) + 2 * Math.log10(1 + z), Math.sin(y));
    }

    private JRadioButton addRadioButton(String name, ButtonGroup group, final int ButtonID, String str)
    {
        JRadioButton button = new JRadioButton(name);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (str.equals("formula"))
                {
                    FormulaID = ButtonID;
                    img.setIcon(new ImageIcon("D:/Projects/Java/Lab2/Formula" + ButtonID + ".png"));
                }
                else if (str.equals("mem"))
                    MemID = ButtonID;
            }
        });

        group.add(button);
        return button;
    }

    public Main()
    {
        super("idk how to name it");
        setSize(640, 480);

        Toolkit kit = Toolkit.getDefaultToolkit();

        setLocation((kit.getScreenSize().width - 640) / 2, (kit.getScreenSize().height - 480) / 2);
///////////////////////////////////////////////////////////////////

        Box RadioButtons = Box.createHorizontalBox();

        ButtonGroup RadioButtonsGroup = new ButtonGroup();
        RadioButtons.add(addRadioButton("first", RadioButtonsGroup, 1, "formula"));
        RadioButtons.add(Box.createHorizontalStrut(15));
        RadioButtons.add(addRadioButton("second", RadioButtonsGroup, 2, "formula"));

        RadioButtonsGroup.setSelected(RadioButtonsGroup.getElements().nextElement().getModel(), true);

///////////

        //картинка

///////////

        Box Variables = Box.createHorizontalBox();

        Variables.add(new JLabel("X: "));
        JTextField XText = new JTextField("0", 10);
        XText.setMaximumSize(XText.getPreferredSize());
        Variables.add(XText);

        Variables.add(Box.createHorizontalStrut(15));

        Variables.add(new JLabel("Y: "));
        JTextField YText = new JTextField("0", 10);
        YText.setMaximumSize(YText.getPreferredSize());
        Variables.add(YText);

        Variables.add(Box.createHorizontalStrut(15));

        Variables.add(new JLabel("Z: "));
        JTextField ZText = new JTextField("0", 10);
        ZText.setMaximumSize(ZText.getPreferredSize());
        Variables.add(ZText);

///////////

        Box Mems = Box.createVerticalBox();

//---------
        Box MemsValue = Box.createHorizontalBox();

        MemsValue.add(new JLabel("mem1: "));
        JTextField mem1Text = new JTextField("0", 10);
        mem1Text.setMaximumSize(mem1Text.getPreferredSize());
        MemsValue.add(mem1Text);
//---------
        MemsValue.add(Box.createHorizontalStrut(15));
//---------
        MemsValue.add(new JLabel("mem2: "));
        JTextField mem2Text = new JTextField("0", 10);
        mem2Text.setMaximumSize(mem2Text.getPreferredSize());
        MemsValue.add(mem2Text);
//---------
        MemsValue.add(Box.createHorizontalStrut(15));
//---------
        MemsValue.add(new JLabel("mem3: "));
        JTextField mem3Text = new JTextField("0", 10);
        mem3Text.setMaximumSize(mem3Text.getPreferredSize());
        MemsValue.add(mem3Text);


        Mems.add(MemsValue);

//---------
        Box MemsRadioButtons = Box.createHorizontalBox();

        ButtonGroup MemRadioButtonsGroup = new ButtonGroup();
        MemsRadioButtons.add(addRadioButton("mem1", MemRadioButtonsGroup, 1, "mem"));
        MemsRadioButtons.add(Box.createHorizontalStrut(15));
        MemsRadioButtons.add(addRadioButton("mem2", MemRadioButtonsGroup, 2, "mem"));
        MemsRadioButtons.add(Box.createHorizontalStrut(15));
        MemsRadioButtons.add(addRadioButton("mem3", MemRadioButtonsGroup, 3, "mem"));

        MemRadioButtonsGroup.setSelected(MemRadioButtonsGroup.getElements().nextElement().getModel(), true);


        Mems.add(MemsRadioButtons);

//---------
        Box MemsButtons = Box.createHorizontalBox();

        JButton MC = new JButton("MC");

        MC.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (MemID == 1)
                {
                    mem1 = 0;
                    mem1Text.setText("0");
                }
                else if (MemID == 2)
                {
                    mem2 = 0;
                    mem2Text.setText("0");
                }
                else
                {
                    mem3 = 0;
                    mem3Text.setText("0");
                }
            }
        });

        MemsButtons.add(MC);
//---------
        JButton MP = new JButton("M+");

        MP.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (MemID == 1)
                {
                    mem1 += Rez;
                    mem1Text.setText(Double.toString(mem1));
                }
                else if (MemID == 2)
                {
                    mem2 += Rez;
                    mem2Text.setText(Double.toString(mem2));
                }
                else
                {
                    mem3 += Rez;
                    mem3Text.setText(Double.toString(mem3));
                }
            }
        });

        MemsButtons.add(MP);
//---------
        JButton MM = new JButton("M-");

        MM.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (MemID == 1)
                {
                    mem1 -= Rez;
                    mem1Text.setText(Double.toString(mem1));
                }
                else if (MemID == 2)
                {
                    mem2 -= Rez;
                    mem2Text.setText(Double.toString(mem2));
                }
                else
                {
                    mem3 -= Rez;
                    mem3Text.setText(Double.toString(mem3));
                }
            }
        });

        MemsButtons.add(MM);


        Mems.add(MemsButtons);

///////////

        Box Result = Box.createHorizontalBox();

        Result.add(new JLabel("Result: "));
        JTextField ResultText = new JTextField("0", 30);
        ResultText.setMaximumSize(ResultText.getPreferredSize());
        Result.add(ResultText);

///////////

        Box Buttons = Box.createHorizontalBox();

        JButton Calc = new JButton("Calculate");
        Calc.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try
                {
                    double X = Double.parseDouble(XText.getText());
                    double Y = Double.parseDouble(YText.getText());
                    double Z = Double.parseDouble(ZText.getText());
                    if (FormulaID == 1)
                    {
                        Rez = calculate1(X, Y, Z);
                        ResultText.setText(Double.toString(Rez));
                    }
                    else
                    {
                        Rez = calculate2(X, Y, Z);
                        ResultText.setText(Double.toString(Rez));
                    }
                }
                catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(Main.this, "No such number", "Error", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        Buttons.add(Calc);

        Buttons.add(Box.createHorizontalStrut(50));

        JButton Clear = new JButton("Clear");
        Clear.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                XText.setText("0");
                YText.setText("0");
                ZText.setText("0");
                ResultText.setText("0");
            }
        });
        Buttons.add(Clear);

        Buttons.add(Box.createHorizontalStrut(50));

        JButton Primer = new JButton("Primer");

        Primer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                XText.setText(Double.toString(mem1));
                YText.setText(Double.toString(mem2));
                ZText.setText(Double.toString(mem3));
            }
        });

        Buttons.add(Primer);


///////////////////////////////////////////////////////////////////
        Box All = Box.createVerticalBox();

        All.add(Box.createVerticalGlue());
        All.add(RadioButtons);
        All.add(Box.createVerticalGlue());
        All.add(Variables);
        All.add(Box.createVerticalGlue());
        All.add(Mems);
        All.add(Box.createVerticalGlue());
        All.add(Result);
        All.add(Box.createVerticalGlue());
        All.add(Buttons);
        All.add(Box.createVerticalGlue());


        getContentPane().add(img, BorderLayout.NORTH);

        getContentPane().add(All, BorderLayout.CENTER);

    }

    public static void main(String[] args)
    {
        Main frame = new Main();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
