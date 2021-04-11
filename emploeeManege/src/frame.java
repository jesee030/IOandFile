/**
 * █████▒█    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 * ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 * ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 * ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 * ░     ░ ░      ░  ░
 *
 * @author JESEE030
 * @webadress https://github.com/jesee030
 * @Version 1.0
 * @creat 2021-04-11-下午 10:05
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 *
 *   █████▒█    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 *  ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 *  ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 *  ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 *           ░     ░ ░      ░  ░

 @author JESEE030
 @ClassName IOandFile.java
 @Description TODE
 @webadress https://github.com/jesee030
 *@Date 2021/4/11 下午 10:05
 */
public class frame extends JFrame implements ActionListener {
    FileDialog sv, op;
    JButton button1, button2, button3, button4;
    JTextArea textArea ;

    frame() {
        super("工资管理系统");
        setLayout(null);
        setBackground(Color.cyan);
        setSize(1000, 800);
        setVisible(true);
        button1 = new JButton("打开");
        button2 = new JButton("保存");
        button3 = new JButton("关闭");
        button4 = new JButton("修改");
        textArea = new JTextArea("姓名\t工资\t津贴\n");
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(textArea);
        textArea.setBounds(30, 50, 460, 220);
        button1.setBounds(520, 60, 60, 30);
        button2.setBounds(520, 120, 60, 30);
        button3.setBounds(520, 180, 60, 30);
        button4.setBounds(520, 240, 60, 30);
        sv = new FileDialog(this, "保存", FileDialog.SAVE); //保存功能
        op = new FileDialog(this, "打开", FileDialog.LOAD);//打开功能
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        addWindowListener(new WindowAdapter() {//定义事件适配器实现图形界面窗口的关闭功能
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {//界面上的事件处理
        if (e.getSource() == button1) {
            String str;
            op.setVisible(true);
            try {//将文件打开读取到界面上的TextArea组件中显示出来
                File f1 = new File(op.getDirectory(), op.getFile());
                FileReader fr = new FileReader(f1);
                BufferedReader br = new BufferedReader(fr);
                textArea.setText("");
                while ((str = br.readLine()) != null) textArea.append(str + '\n');
                fr.close();
            } catch (Exception e1) {
            }
        }
        if (e.getSource() == button2) {//如果点击的是save按钮
            sv.setVisible(true);
            try {//将TextArea中的内容写入到文件中保存
                File fl = new File(sv.getDirectory(), sv.getFile());
                FileWriter fw = new FileWriter(fl);
                BufferedWriter bw = new BufferedWriter(fw);
                String gt = textArea.getText();
                bw.write(gt, 0, gt.length());
                bw.flush();
                fw.close();
            } catch (Exception e1) {
            }
        }
        if (e.getSource() == button3) {//如果点击的是close按钮
            System.exit(0);
        }
        if (e.getSource() == button4) {//如果点击的是修改按钮
            String gt = textArea.getText();
            String s[];
            //by table botton split
            s = gt.split("\t|\n");
            textArea.setText("姓名\t工资\t津贴\n");
            try {
                for (int i = 1; i < s.length; i++) {
                    s[3 * i + 1] = String.valueOf((int) (Integer.parseInt((s[3 * i + 1])) * 1.1));
                    textArea.append(s[3 * i + 0] + "\t");
                    textArea.append(s[3 * i + 1] + "\t");
                    textArea.append(s[3 * i + 2] + "\n");
                }
            } catch (Exception e1) {
            }
        }
    }

}
