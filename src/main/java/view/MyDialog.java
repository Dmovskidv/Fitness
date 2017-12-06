package view;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class MyDialog {

    private static JPasswordField passwordField = new JPasswordField(10);
    private static JLabel label_login = new JLabel("Администратор");
    private static JLabel label_password = new JLabel("Пароль");
    private static String[] user = { "Дмовский Дмитрий", "Пашковец Екатерина", "Чика Кноповна" };
    private static JComboBox combo_users = new JComboBox(user);
    private static Object[] array = { label_login, combo_users, label_password, passwordField };
    private static HashMap<String, String> map;
    static String login = "";

    static void control_password() {

        int res = JOptionPane.showConfirmDialog(null, array, "Авторизация", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (res == JOptionPane.OK_OPTION) {

            login = (String) combo_users.getSelectedItem();
            char[] password = passwordField.getPassword();
            String s = "";
            for (char c : password) {
                s += c;
            }
            ;

            if (s.equals(getPassword(login))) {
                JOptionPane.showMessageDialog(null, "Добро пожаловать, " + login);
                passwordField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                passwordField.setText("");
                Main.setadminItem().setText(login);

            } else {
                passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
                passwordField.setToolTipText("Неверный пароль");
                passwordField.setText("");
                control_password();
            }

        } else if (res == JOptionPane.CANCEL_OPTION || res == JOptionPane.CLOSED_OPTION) {
            int res2 = JOptionPane.showConfirmDialog(null, "Выйти из приложения?", "Exit", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (res2 == 0) {
                System.exit(0);
            } else
                control_password();

            // System.out.println(res2);

        }

    }

    public static String getPassword(String name) {
        map = new HashMap();
        String pass = "";
        map.put(user[0], "12345");
        map.put(user[1], "67890");
        map.put(user[2], "11111");

        for (Map.Entry<String, String> element : map.entrySet()) {
            if (name.equals(element.getKey())) {
                pass = element.getValue();
            }
        }
        return pass;

    }



}
