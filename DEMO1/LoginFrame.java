
/*
import javax.swing.*;

public class LoginFrame {
	public static void main(String args[]){
		JFrame frame = new JFrame("Simple Frame");
		frame.setSize(350, 240);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
//LoginFrame 登陆窗口  功能 实现用户登陆 ,如果成功就跳转
//LoginFrame 继承于窗口类, 并实现ActionListener接口
public class LoginFrame extends JFrame implements ActionListener {
    // 申明需要的组件
    JButton jb1, jb2;//按钮
    JTextField jtf1;//文本框
    JPasswordField jpf1;//密码框
 
    public LoginFrame() {
        // 窗口属性的设置
        setTitle("登陆窗");// 窗口标题
        setSize(300, 180);// 窗口大小
        setLocationRelativeTo(null);// 窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭窗口则退出虚拟机
        setLayout(new FlowLayout());// 设置布局流式布局
 
        JPanel jp = new JPanel(new GridLayout(4, 1));// 设置面板为表格布局4行1列
        // 第一行
        JPanel jp1 = new JPanel();
        JLabel jl1 = new JLabel("账号 ");
        jtf1 = new JTextField(12);
        jp1.add(jl1);
        jp1.add(jtf1);
        jp.add(jp1);
        // 第二行
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("密码 ");
        jpf1 = new JPasswordField(12);
        jp2.add(jl2);
        jp2.add(jpf1);
        jp.add(jp2);
        // 第三行
        JPanel jp3 = new JPanel();
        jb1 = new JButton("登陆");
        jb1.addActionListener(this);// 添加动作响应器
        jb2 = new JButton("重置");
        jb2.addActionListener(this);// 添加动作响应器
        jp3.add(jb1);
        jp3.add(jb2);
        jp.add(jp3);
        // 第四行
        JPanel jp4 = new JPanel();
        JLabel jl3 = new JLabel("提示: 账号 admin 密码 123");
        jl3.setForeground(Color.DARK_GRAY);
        jp4.add(jl3);
        jp.add(jp4);
 
        add(jp);
 
    }
 
    // 动作响应
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();// 根据动作命令,来进行分别处理
        if (cmd.equals("登陆")) {
            String id = jtf1.getText();// 取得用户名
            String key = new String(jpf1.getPassword());// 取得密码
            if (id.equals("admin") && key.equals("123")) {// 判断是否登录成功
                // 如果登录成功
                setVisible(false);// 本窗口隐藏,
                new FrameWithPanel(id).setVisible(true);// 新窗口显示
                dispose();//本窗口销毁,释放内存资源
            } else {
                //如果登录失败  弹出提示
                JOptionPane.showMessageDialog(this, "用户名或者密码错误.", "通知", JOptionPane.ERROR_MESSAGE);
                clearText();//清空文本框 密码框的输入
            }
        } else if (cmd.equals("重置")) {
            clearText();
        }
 
    }
 
    private void clearText() {//清空文本框, 密码框的输入
        jtf1.setText("");
        jpf1.setText("");
    }
     
    //main方法, 程序的入口
    public static void main(String[] args) {
        new LoginFrame().setVisible(true);//创建登录窗口,并可见
    }
 
}
