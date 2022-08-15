package Sistema;

import java.awt.BorderLayout;
import Sistema.BancoDeDados;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		conexao = BancoDeDados.conectar();
		setResizable(false);
		setTitle("TudoDeBom Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("USUÁRIO");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setBounds(177, 26, 59, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SENHA");
		lblNewLabel_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(189, 92, 46, 14);
		contentPane.add(lblNewLabel_1);

		textUsuario = new JTextField();
		textUsuario.setBounds(115, 51, 182, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnLogin.setBounds(166, 158, 89, 23);
		contentPane.add(btnLogin);

		JLabel lblStatus = new JLabel("status");
		lblStatus.setForeground(new Color(240, 255, 255));
		if (conexao != null) {
			lblStatus.setText("Banco de Dados: Conectado");
		} else {
			lblStatus.setText("Erro: Banco de Dados não está conectado");
		}
		lblStatus.setBounds(124, 193, 202, 14);
		contentPane.add(lblStatus);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(115, 117, 182, 20);
		contentPane.add(textSenha);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/d471b4f2ce7b4725607c504a1e8da094.jpg")));
		lblNewLabel_2.setBounds(0, 0, 412, 218);
		contentPane.add(lblNewLabel_2);
	}

	public void logar() {
		String sql = "select * from tbusuarios where login=? and senha =?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, textUsuario.getText());
			String captura = new String(textSenha.getPassword());
			pst.setString(2, captura);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				TelaPrincipal principal = new TelaPrincipal();
				principal.setVisible(true);
				this.dispose();
				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "usuário e/ou senha invalido(s)");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
