package design.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Concrete Mediator角色
 * @author hason
 * @since 2023/6/28 00:37
 */
public class LoginFrame extends Frame implements ActionListener, Mediator {

    private ColleagueCheckBox checkGuest;

    private ColleagueCheckBox checkLogin;

    private ColleagueTextField textUser;

    private ColleagueTextField textPass;

    private ColleagueButton buttonOk;

    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        // 生成窗口
        setLayout(new GridLayout(4, 2));
        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("UserName:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        // 设置初始状态
        colleagueChanged();
        // 显示
        pack();
        show();
    }

    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckBox("Guest", g, true);
        checkLogin = new ColleagueCheckBox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        // 设置Mediator
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);
        // 设置listener
        // listener只会被点击事情或者前端的输入等操作触发 并不会根据setEnabled方法触发
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            textUser.setColleagueChangedEnabled(false);
            textPass.setColleagueChangedEnabled(false);
            buttonOk.setColleagueChangedEnabled(true);
        } else {
            textUser.setColleagueChangedEnabled(true);
            userpassChanged();
        }
    }

    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueChangedEnabled(true);
            if (textPass.getText().length() >= 4 && textPass.getText().length() >= 4) {
                buttonOk.setColleagueChangedEnabled(true);
            } else {
                buttonOk.setColleagueChangedEnabled(false);
            }
        } else {
            textPass.setColleagueChangedEnabled(false);
            textPass.setColleagueChangedEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
