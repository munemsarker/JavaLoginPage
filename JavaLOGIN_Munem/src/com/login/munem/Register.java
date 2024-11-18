package com.login.munem;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;

public class Register extends JFrame {

    private static final long serialVersionUID = -4000194254179882652L;
    private JPanel contentPane;
    private JTextField txt_username;
    private JPasswordField txt_password;
    private JPasswordField txt_passwordc;
    private JTextField idno;
    private JTextField txt_fname;
    private JTextField txt_mname;
    private JTextField txt_lname;
    private Connection conn;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 374, 442);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        conn = MySQLConnection.conn();

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(10, 33, 116, 22);
        lblNewLabel.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        contentPane.add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(10, 84, 116, 22);
        lblPassword.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        contentPane.add(lblPassword);

        JLabel lblConfirmPassword = new JLabel("Confirm Password: ");
        lblConfirmPassword.setForeground(new Color(255, 255, 255));
        lblConfirmPassword.setBounds(10, 127, 168, 22);
        lblConfirmPassword.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        contentPane.add(lblConfirmPassword);

        JLabel lblNewLabel_3 = new JLabel("Phone Number:");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(10, 174, 116, 22);
        lblNewLabel_3.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("First Name:");
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setBounds(10, 215, 116, 22);
        lblNewLabel_4.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        contentPane.add(lblNewLabel_4);

        txt_username = new JTextField();
        txt_username.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        txt_username.setBounds(161, 30, 182, 30);
        contentPane.add(txt_username);
        txt_username.setColumns(10);

        txt_password = new JPasswordField();
        txt_password.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        txt_password.setBounds(161, 81, 182, 30);
        contentPane.add(txt_password);

        txt_passwordc = new JPasswordField();
        txt_passwordc.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        txt_passwordc.setBounds(161, 124, 182, 30);
        contentPane.add(txt_passwordc);

        JLabel lblNewLabel_4_1 = new JLabel("Middle Name:");
        lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_4_1.setBounds(10, 256, 116, 22);
        lblNewLabel_4_1.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        contentPane.add(lblNewLabel_4_1);

        idno = new JTextField();
        idno.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        idno.setBounds(161, 171, 182, 30);
        idno.setColumns(10);
        contentPane.add(idno);

        txt_fname = new JTextField();
        txt_fname.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        txt_fname.setBounds(161, 212, 182, 30);
        txt_fname.setColumns(10);
        contentPane.add(txt_fname);

        txt_mname = new JTextField();
        txt_mname.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        txt_mname.setBounds(161, 253, 182, 30);
        txt_mname.setColumns(10);
        contentPane.add(txt_mname);

        JButton btnNewButton = new JButton("Register");
        btnNewButton.setBounds(240, 362, 108, 30);
        btnNewButton.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txt_username.getText();
                String password = new String(txt_password.getPassword());
                String confirmPassword = new String(txt_passwordc.getPassword());
                String firstName = txt_fname.getText();
                String middleName = txt_mname.getText();
                String lastName = txt_lname.getText();

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ||
                    firstName.isEmpty() || lastName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required!");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!");
                } else {
                    try {
                        String sql = "INSERT INTO user_information (user_name, user_password, user_firstname, user_middlename, user_lastname) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, username);
                        pst.setString(2, password);
                        pst.setString(3, firstName);
                        pst.setString(4, middleName);
                        pst.setString(5, lastName);

                        int rowsInserted = pst.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "User registered successfully!");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error registering user: " + ex.getMessage());
                    }
                }
            }
        });

        JButton btnExit = new JButton("EXIT");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
        btnExit.setBounds(103, 362, 93, 30);
        btnExit.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        contentPane.add(btnExit);

        txt_lname = new JTextField();
        txt_lname.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        txt_lname.setColumns(10);
        txt_lname.setBounds(161, 300, 182, 30);
        contentPane.add(txt_lname);

        JLabel lblNewLabel_4_1_1 = new JLabel("Last Name:");
        lblNewLabel_4_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_4_1_1.setFont(new Font("Baloo Da 2", Font.BOLD, 14));
        lblNewLabel_4_1_1.setBounds(10, 303, 116, 22);
        contentPane.add(lblNewLabel_4_1_1);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(40, 111, 162));
        panel.setBounds(0, 0, 358, 403);
        contentPane.add(panel);
    }
}
