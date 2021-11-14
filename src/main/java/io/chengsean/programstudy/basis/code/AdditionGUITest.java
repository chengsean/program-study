package io.chengsean.programstudy.basis.code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

/**
 * description
 *
 * @author 程绍壮
 * @dateTime 2021-11-14 12:52
 */
public class AdditionGUITest {
    public static void main(String[] args) throws FileNotFoundException {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("加法运算");
        JPanel jPanel = new JPanel();
        handlePanel(jPanel);
        frame.setContentPane(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private static void handlePanel(JPanel jPanel) {
        // 添加第一个text field
        JTextField input1 = new JTextField(8);
        jPanel.add(input1);
        // 添加'+'符号
        JLabel plusLabel = new JLabel(" + ");
        jPanel.add(plusLabel);
        // 添加第二个text field
        JTextField input2 = new JTextField(8);
        jPanel.add(input2);
        // 添加'='符号button
        JButton resultBtn = new JButton(" = ");
        jPanel.add(resultBtn);
        // 添加第三个text field
        JTextField result = new JTextField(10);
        jPanel.add(result);
        final Pattern intPattern = Pattern.compile("\\d+");
        // 处理输入是否合法
        final InputVerifier verifier = new InputVerifier() {
            @Override public boolean verify(javax.swing.JComponent c){
                JTextField input = (JTextField) c;
                return intPattern.matcher(input.getText()).matches();
            }
        };
        input1.setInputVerifier(verifier);
        input2.setInputVerifier(verifier);
        result.setEditable(false);
        resultBtn.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                if (this.isNumber(input1.getText(), input2.getText())) {
                    result.setText(Long.toString(Integer.parseInt(input1.getText()) + Integer.parseInt(input2.getText())));
                } else {
                    result.setText(null);
                    input2.setText(null);
                }
            }
            private boolean isNumber(String numStr1, String numStr2) {
                if (numStr1 == null || numStr1.length() == 0 || numStr2 == null || numStr2.length() == 0) {
                    return false;
                }
                return intPattern.matcher(numStr1).matches() && intPattern.matcher(numStr2).matches();
            }
        });
    }
}
