package Sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
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

public class TelaPrincipal extends JFrame {

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
		
		JMenu menCadastro = new JMenu("Cadastro");
		menCadastro.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
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
		
		JMenu menRelatorio = new JMenu("Relatório");
		menRelatorio.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
		menu.add(menRelatorio);
		
		JMenuItem menRelEst = new JMenuItem("Estoque");
		menRelatorio.add(menRelEst);
		
		JMenuItem menHistTrans = new JMenuItem("Histórico de transações");
		menRelatorio.add(menHistTrans);
		
		JMenu menOpcoes = new JMenu("Opções");
		menOpcoes.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
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
		desktop = new JPanel();
		desktop.setBackground(new Color(102, 205, 170));
		desktop.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(desktop);
		desktop.setLayout(null);
	}
}
