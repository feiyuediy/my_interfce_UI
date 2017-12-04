package com.xaa.Frame;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class ResultFrame extends JFrame {

    public ResultFrame(String result){
        super("结果");
        Container container = getContentPane();
        JScrollPane jScrollPane = new JScrollPane();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,1));

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setLocationRelativeTo(getOwner());

        JTextArea jTextArea = new JTextArea(result,30,30);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);

        jPanel.add(new JScrollPane(jTextArea));

        container.add(jPanel);
        setSize(365,540);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public  static void  main(String args[]){
        String s ="{\n" +
                "\"appid\":1,\n" +
                "\"appver\":1,\n" +
                "\"clientid\":\"TEST1234\",\n" +
                "\"lang\":\"cn\",\n" +
                "\"platform\":\"1\",\n" +
                "\"token\":\"token\",\n" +
                "\"ver\":1,\n" +
                "\"tk\":\"2fdd4ef1026fc6ed3863cc029b06c818\",\n" +
                "}";
        ResultFrame resultFrame = new ResultFrame(s);
        resultFrame.setVisible(true);
    }
}
