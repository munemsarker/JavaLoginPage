package com.login.munem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CRUD extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static JLabel lbl_message = new JLabel();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CRUD frame = new CRUD();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CRUD() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lbl_message.setBackground(new Color(255, 255, 255));
        lbl_message.setForeground(new Color(255, 255, 255));
        lbl_message.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_message.setFont(new Font("Baloo Da 2", Font.BOLD, 20));
        lbl_message.setBounds(10, 90, 414, 76);
        contentPane.add(lbl_message);
        
                JLabel lblImage = new JLabel();
                lblImage.setBounds(10, 11, 62, 62);
                contentPane.add(lblImage);
                lblImage.setIcon(new ImageIcon("D:\\\\Java Project\\\\images\\\\imperial.png"));
                
                JLabel lblNewLabel = new JLabel("Home");
                lblNewLabel.setForeground(new Color(255, 255, 255));
                lblNewLabel.setBackground(new Color(255, 255, 255));
                lblNewLabel.setFont(new Font("Baloo Da 2", Font.BOLD, 12));
                lblNewLabel.setBounds(82, 29, 46, 14);
                contentPane.add(lblNewLabel);
                
                JLabel lblFaculty = new JLabel("Faculty");
                lblFaculty.setForeground(new Color(255, 255, 255));
                lblFaculty.setBackground(new Color(255, 255, 255));
                lblFaculty.setFont(new Font("Baloo Da 2", Font.BOLD, 12));
                lblFaculty.setBounds(138, 28, 46, 14);
                contentPane.add(lblFaculty);
                
                JLabel lblTeachers = new JLabel("Teachers");
                lblTeachers.setForeground(new Color(255, 255, 255));
                lblTeachers.setBackground(new Color(255, 255, 255));
                lblTeachers.setFont(new Font("Baloo Da 2", Font.BOLD, 12));
                lblTeachers.setBounds(194, 28, 62, 14);
                contentPane.add(lblTeachers);
                
                JLabel lblContact = new JLabel("Contact");
                lblContact.setForeground(new Color(255, 255, 255));
                lblContact.setBackground(new Color(255, 255, 255));
                lblContact.setFont(new Font("Baloo Da 2", Font.BOLD, 12));
                lblContact.setBounds(266, 29, 46, 14);
                contentPane.add(lblContact);
                
                JLabel lblGallary = new JLabel("Gallary");
                lblGallary.setForeground(new Color(255, 255, 255));
                lblGallary.setBackground(new Color(255, 255, 255));
                lblGallary.setFont(new Font("Baloo Da 2", Font.BOLD, 12));
                lblGallary.setBounds(328, 29, 46, 14);
                contentPane.add(lblGallary);
                
                JLabel lblNewLabel_1 = new JLabel("কম্পিউটার বিজ্ঞান ও প্রযুক্তি বিভাগে আপনাকে স্বাগতম!");
                lblNewLabel_1.setForeground(new Color(255, 255, 255));
                lblNewLabel_1.setBackground(new Color(255, 255, 255));
                lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_1.setFont(new Font("Li Ador Noirrit Light", Font.BOLD, 14));
                lblNewLabel_1.setBounds(10, 165, 414, 38);
                contentPane.add(lblNewLabel_1);
                
                JLabel lblNewLabel_2 = new JLabel("Created By");
                lblNewLabel_2.setForeground(new Color(255, 255, 255));
                lblNewLabel_2.setBackground(new Color(255, 255, 255));
                lblNewLabel_2.setBounds(328, 214, 62, 14);
                contentPane.add(lblNewLabel_2);
                
                JLabel lblNewLabel_2_1 = new JLabel("Munem Sarker");
                lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
                lblNewLabel_2_1.setBackground(new Color(255, 255, 255));
                lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_2_1.setFont(new Font("Baloo Da 2", Font.BOLD, 15));
                lblNewLabel_2_1.setBounds(322, 227, 102, 23);
                contentPane.add(lblNewLabel_2_1);
                
                JPanel panel = new JPanel();
                panel.setBackground(new Color(40, 111, 162));
                panel.setBounds(10, 11, 414, 239);
                contentPane.add(panel);
    }
}
