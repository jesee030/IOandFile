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
 * @creat 2021-04-11-下午 9:39
 */

import java.awt.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


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
 *@Date 2021/4/11 下午 9:39
 */
public class frame  extends Frame implements ActionListener {

    FileDialog sv,op;//定义文件对话框对象sv，op
    Button btn1,btn2,btn3;
    TextArea tarea;
    frame(){
    super("打开和保存文件");
    setLayout(null);
    setBackground(Color.cyan);
    setSize(600,300);
    setVisible(true);
    btn1=new Button("Open");
    btn2=new Button("Save");
    btn3=new Button("Close");
    tarea=new TextArea("");
    add(btn1); add(btn2); add(btn3); add(tarea);
    tarea.setBounds(30,50,460,220);
    btn1.setBounds(520,60,50,30);
    btn2.setBounds(520,120,50,30);
    btn3.setBounds(520,180,50,30);
    sv=new FileDialog(this,"保存",FileDialog.SAVE); //保存功能
    op=new FileDialog(this,"打开",FileDialog.LOAD); //打开功能
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);
    addWindowListener //定义事件适配器实现图形界面窗口的关闭功能
            (
                    new WindowAdapter()
                    {
                        public void windowClosing(WindowEvent e)
                        {
                            System.exit(0);
                        }
                    }
            );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //i,plementing ActionEven interface and respond even
        if (e.getSource() == btn1)
        {
            String str;
            op.setVisible(true);
            try //将文件打开读取到界面上的TextArea组件中显示出来
            {
                File fl=new File(op.getDirectory(),op.getFile());
                FileReader fr=new FileReader(fl);
                BufferedReader br = new BufferedReader(fr);
                tarea.setText("");
                while((str=br.readLine())!=null)tarea.append(str+'\n');
                fr.close();
            }
            catch(Exception e1)
            {
            }
        }
        if(e.getSource()==btn2) //如果点击的是save按钮
        {
            sv.setVisible(true);
            try //将TextArea中的内容写入到文件中保存
            {
                File fl=new File(sv.getDirectory(),sv.getFile());
                FileWriter fw=new FileWriter(fl);
                BufferedWriter bw = new BufferedWriter(fw);
                String gt=tarea.getText();
                bw.write(gt,0,gt.length());
                bw.flush();
                fw.close();
            }
            catch(Exception e1)
            {
            }
        }
        if(e.getSource()==btn3) //如果点击的是close按钮
        {
            System.exit(0);
        }
    }

    }

