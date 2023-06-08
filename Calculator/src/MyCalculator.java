import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(200, 300, 600, 140, Color.white, true);
    }

    public int add(int i, int j) {
        return i + j;
    }

    public int mul(int i, int j){
        return i*j;
    }
}


class Calculator extends Frame{
    static int id = 0;
    TextField textField1, textField2, textField3;
    public Calculator(int x , int y, int w, int h, Color color, boolean resizeable){
        super("我的计算器窗口" + (++id));
        setBounds(x, y, w, h);
        setResizable(resizeable);
        setVisible(true);
        setBackground(color);
        windowClose(this);

        textField1 = new TextField(10);
        textField2 = new TextField(10);
        textField3 = new TextField(20);

        Button button1 = new Button("clear");
        Label label1 = new Label("=");

        MyPanel myPanel = new MyPanel(0,0,10,50,Color.GRAY);
        myPanel.setLayout(new GridLayout(4,1));
        Button button_A = new Button("+");
        Button button_B = new Button("-");
        Button button_C = new Button("*");
        Button button_D = new Button("/");
        myPanel.add(button_A);
        myPanel.add(button_B);
        myPanel.add(button_C);
        myPanel.add(button_D);

        setLayout(new FlowLayout());
        add(textField1);
        add(myPanel);
        add(textField2);
        add(label1);
        add(textField3);
        add(button1);

        button1.addActionListener(new MyCalculatorListener1(this));
        button_A.addActionListener(new MyCalculatorListener2(this));
        button_B.addActionListener(new MyCalculatorListener2(this));
        button_C.addActionListener(new MyCalculatorListener2(this));
        button_D.addActionListener(new MyCalculatorListener2(this));

    }
    static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}

class MyCalculatorListener1 implements ActionListener {
    Calculator calculator = null;
    public MyCalculatorListener1(Calculator calculator){
        this.calculator = calculator;
    }
    public void actionPerformed(ActionEvent e){
        calculator.textField3.setText("");
        calculator.textField1.setText("");
        calculator.textField2.setText("");
    }

}

class MyCalculatorListener2 implements ActionListener {
    Calculator calculator = null;
    public MyCalculatorListener2(Calculator calculator){
        this.calculator = calculator;
    }
    public void actionPerformed(ActionEvent e){
        int n1 = Integer.parseInt(calculator.textField1.getText());
        int n2 = Integer.parseInt(calculator.textField2.getText());
        String str = e.getActionCommand();
        if(str.equals("+")){
            calculator.textField3.setText("" + (n1+n2));
        }
        else if(str.equals("-")){
            calculator.textField3.setText("" + (n1-n2));
        }
        else if(str.equals("*")){
            calculator.textField3.setText("" + (n1*n2));
        }
        else{
            if(n2 != 0){
                calculator.textField3.setText(""+(n1/n2));
            }
            else{
                calculator.textField3.setText("ERROR");
                new MyDialog().init();
            }
        }
    }
}

class MyDialog extends JDialog {
    public void init(){
        this.setBounds(300,200,300,200);
        this.setVisible(true);
        Container container = this.getContentPane();
        container.setBackground(Color.CYAN);
        JLabel jLabel = new JLabel("除数不能为零!");
        this.add(jLabel, BorderLayout.CENTER);
    }
}

class MyPanel extends Panel{
    MyPanel(int x, int y, int w, int h, Color color){
        setBounds(x, y, w, h);
        setBackground(color);
    }
}

