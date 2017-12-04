package com.xaa.Frame;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import com.xaa.Utils.HttpUtilHaha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static com.xaa.Utils.Native2AsciiUtils.ascii2Native;

public class MainFrame extends JFrame {
    private int i = 0;
    JTextField url;
    public MainFrame(String token){
        super("小爱爱接口");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setLocationRelativeTo(getOwner());
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayout(20,2,3,3));


        jPanel1.add(new JLabel("接口"));
        url = new JTextField(16);
        jPanel1.add(url);


        //参数列表
        jPanel2.add(new JLabel("参数列表"));
        JButton add = new JButton("add");

        JTextField[] parm = new JTextField[10];
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel3.add(new JLabel("key:"));
                parm[i] = new JTextField(20);
                jPanel3.add(parm[i]);

                jPanel3.add(new JLabel("vaule："));
                parm[i+1] = new JTextField(20);
                jPanel3.add(parm[i+1]);
                i = i+2;
                revalidate();
            }
        });
        jPanel2.add(add);

        //发送按钮
        JButton send = new JButton("发送");
        jPanel1.add(send);
        HashMap<String,String> parmMap = new HashMap<>();

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ulr1 = url.getText();
                System.out.println("url:"+ulr1);
                for(int j=0;j<i;j=j+2){
                    String key = parm[j].getText();
                    String parmString = parm[j+1].getText();
                    parmMap.put(key,parmString);

                }
                String result = HttpUtilHaha.postRuestForUI(ulr1,parmMap,token);
//                JOptionPane.showMessageDialog(MainFrame.this,ascii2Native(result));
                ResultFrame resultFrame = new ResultFrame(ascii2Native(result));
                resultFrame.setVisible(true);
                System.out.println("result:"+result);

            }
        });

        add(jPanel1);
        add(jPanel2);
        add(jPanel3);
        setSize(360,400);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args){
        new MainFrame("DDDDD");
    }
}
