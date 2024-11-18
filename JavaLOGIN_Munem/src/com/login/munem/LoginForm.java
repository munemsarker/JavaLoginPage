package com.login.munem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1407052947471674308L;
    private JTextField txt_username;
    private JPasswordField txt_password;
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginForm window = new LoginForm();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginForm() {
        initialize();
        conn = MySQLConnection.conn();
    }

    private void initialize() {
        setTitle("ইম্পেরিয়াল কলেজ অব ইঞ্জিনিয়ারিং - অ্যাডমিন প্যানেল");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Register registerWindow = new Register();
                registerWindow.setVisible(true);
                dispose();
        	}
        });
        btnRegister.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        btnRegister.setBounds(94, 159, 100, 30);
        getContentPane().add(btnRegister);
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setFont(new Font("Baloo Da 2", Font.BOLD, 16));
        lblUsername.setBounds(50, 70, 80, 25);
        getContentPane().add(lblUsername);
        txt_username = new JTextField();
        txt_username.setFont(new Font("Baloo Da 2", Font.PLAIN, 15));
        txt_username.setBounds(140, 70, 180, 25);
        getContentPane().add(txt_username);
        txt_username.setColumns(10);
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setFont(new Font("Baloo Da 2", Font.BOLD, 16));
        lblPassword.setBounds(50, 110, 80, 25);
        getContentPane().add(lblPassword);
        txt_password = new JPasswordField();
        txt_password.setFont(new Font("Baloo Da 2", Font.PLAIN, 15));
        txt_password.setBounds(140, 110, 180, 25);
        getContentPane().add(txt_password);
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        btnLogin.setBounds(220, 159, 100, 30);
        getContentPane().add(btnLogin);
        JLabel lblNewLabel = new JLabel("ইম্পেরিয়াল কলেজ অব ইঞ্জিনিয়ারিং (অ্যাডমিন প্যানেল)");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(28, 27, 335, 25);
        lblNewLabel.setFont(new Font("Li Ador Noirrit", Font.BOLD, 16));
        getContentPane().add(lblNewLabel);
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 364, 239);
        panel.setBackground(new Color(40, 111, 162));
        getContentPane().add(panel);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txt_username.getText();
                char[] password = txt_password.getPassword();
                String passwordStr = new String(password);
                try {
                    if (conn == null) {
                        JOptionPane.showMessageDialog(null, "Database connection is not established!");
                        return;
                    }

                    String sql = "SELECT * FROM user_information WHERE user_name = ? AND user_password = ?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, username);
                    pst.setString(2, passwordStr);
                    rs = pst.executeQuery();

                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
                    } else {
                        String name = rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);
                        JOptionPane.showMessageDialog(null, "Login Successful!");
                        dispose();
                        new CRUD().setVisible(true);
                        CRUD.lbl_message.setText("WELCOME to the dashboard " + name);
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
                } finally {
                    try {
                        if (pst != null) pst.close();
                        if (rs != null) rs.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
