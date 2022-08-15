import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




public class CarrinhoView extends JInternalFrame {
	
	private JPanel contentPane;
	private static List<Carrinho> carrinho;
	public boolean fecharJanela;
	/**
	 * Launch the application.
	 */
	public static void exibirCarrinho() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarrinhoView frame = new CarrinhoView();
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
	public CarrinhoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carrinho do cliente");
		lblNewLabel.setBounds(180, 11, 234, 35);
		contentPane.add(lblNewLabel);
		//baixando lista de carrinho da classe carrinho
		Carrinho lista = new Carrinho();
		carrinho = new  ArrayList<Carrinho>(lista.getCarrinho());
		
		DefaultListModel<Carrinho> model = new DefaultListModel<Carrinho>();
		

		
		for (int i = 0; i < carrinho.size(); i++) {
		     model.addElement(carrinho.get(i));
		    
		    
		}
		JList<Carrinho> list = new JList<Carrinho>(model);
		
		JPanel panel = new JPanel();
		panel.setBounds(66, 108, 688, 284);
		contentPane.add(panel);
		
		
		panel.add(list);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.remove(list.getSelectedIndex());
				carrinho.clear();
				
				for(int i = 0; i < model.size(); i++) {
					carrinho.add(model.get(i));
					
				}
				lista.setCarrinho(carrinho);
				//lista.removerProduto(list.getSelectedIndex());
				
				list.setModel(model);
				
			}
		});
		btnNewButton.setBounds(66, 74, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adicionar mais produtos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendas vd = new Vendas();
				vd.vendaTela();
				dispose();
			}
		});
		btnNewButton_1.setBounds(265, 74, 179, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Finalizar compra");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoBancoDados bd = new HistoricoBancoDados();
				bd.conectar();
				
				JOptionPane.showMessageDialog(null, "Finalizando Compra...");
				
				bd.inserirInformacoes(carrinho.get(0).getCpf(), carrinho);
				bd.atualizarEstoque(carrinho);
				JOptionPane.showMessageDialog(null, "Compra Finalizada com Sucesso.");
				carrinho.clear();
				lista.setCarrinho(carrinho);
				fecharJanela = true;
				dispose();
				
				Vendas vd = new Vendas();
				vd.vendaTela();
				
				
			}
		});
		btnNewButton_2.setBounds(583, 74, 150, 23);
		contentPane.add(btnNewButton_2);
	}

	public static List<carrinho> getCarrinho() {
		return carrinho;
	}

}
