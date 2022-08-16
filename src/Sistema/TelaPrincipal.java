package Sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Image img_logo = new ImageIcon(TelaPrincipal.class.getResource("Imagens/farmacia.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);

	private JPanel desktop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Farmácia Tudo de Bom");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/Imagens/d471b4f2ce7b4725607c504a1e8da094.jpg")));
		setResizable(false);
		setBounds(100, 100, 695, 524);
		
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu menCadastro = new JMenu("CADASTRO");
		menCadastro.setForeground(new Color(0, 139, 139));
		menCadastro.setFont(new Font("Dialog", Font.PLAIN, 13));
		menu.add(menCadastro);
		
		JMenuItem menCadCli = new JMenuItem("Cliente");
		menCadCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente telaCliente = new TelaCliente();
				telaCliente.setVisible(true);
				desktop.add(telaCliente);
			}
		});
		menCadastro.add(menCadCli);
		
		JMenu menRelatorio = new JMenu("HISTÓRICO");
		menRelatorio.setForeground(new Color(0, 139, 139));
		menRelatorio.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
		menu.add(menRelatorio);
		
		JMenuItem menRelEst = new JMenuItem("Consulta CPF");
		menRelatorio.add(menRelEst);
		
		JMenuItem menHistTrans = new JMenuItem("Todos os registros");
		menRelatorio.add(menHistTrans);
		
		JMenu menOpcoes = new JMenu("VENDAS");
		menOpcoes.setForeground(new Color(0, 139, 139));
		menOpcoes.setFont(new Font("Dialog", Font.PLAIN, 13));
		menu.add(menOpcoes);
		
		JMenuItem menOpAjuda = new JMenuItem("Ajuda");
		menOpAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menOpcoes.add(menOpAjuda);
		
		
		JMenuItem menOpSair = new JMenuItem("Sair");
		menOpSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION);
			if(sair==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			}
		});
		menOpcoes.add(menOpSair);
		
		JMenu mnNewMenu = new JMenu("MEDICAMENTOS");
		mnNewMenu.setForeground(new Color(0, 139, 139));
		mnNewMenu.setFont(new Font("Dialog", Font.PLAIN, 13));
		menu.add(mnNewMenu);
		desktop = new JPanel();
		desktop.setBackground(new Color(0, 128, 128));
		desktop.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(desktop);
		desktop.setLayout(null);
		
		JLabel lblMenu = new JLabel("New label");
		lblMenu.setBounds(161, 153, 250, 159);
		desktop.add(lblMenu);
		lblMenu.setIcon(new ImageIcon(img_logo));
	}
}
