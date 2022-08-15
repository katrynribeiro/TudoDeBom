import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Vendas extends JInternalFrame {
		
	private JPanel contentPane;
	private JTextField textCpf;
	private JTextField textCodigoProduto;
	private JTextField textQuantidade;
	private JTextField textRetorno;
	private String textCarrinho;
	private int quantEstoque;
	private static String cpf;
	
	

	public void setCpf(String cpf) {
		Vendas.cpf = cpf;
	}
	/**
	 * Launch the application.
	 */
	public void vendaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendas frame = new Vendas();
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
	public Vendas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("CPF do cliente: ");
		lblNome.setBounds(10, 27, 89, 14);
		contentPane.add(lblNome);
		
		
		textCpf = new JTextField(cpf);
		textCpf.setBounds(109, 24, 141, 20);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo do Produto");
		lblNewLabel.setBounds(10, 59, 89, 14);
		contentPane.add(lblNewLabel);
		
		textCodigoProduto = new JTextField();
		textCodigoProduto.setBounds(109, 56, 86, 20);
		contentPane.add(textCodigoProduto);
		textCodigoProduto.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsultasList consulta = new ConsultasList();
				
				
				int codigo = Integer.parseInt(textCodigoProduto.getText());
				consulta.consultaProduto(codigo);
				String nome = consulta.getNome();
				quantEstoque = consulta.getQuantidadeEstoque();
				double valor = consulta.getValor();
				
				textRetorno.setText(String.format("Produto: %s | Quantidade em Estoque: %d | Valor Unitario: %.2f", nome, quantEstoque, valor));
				
				textCarrinho = String.format("Produto: %s | Valor Unitario: %.2f", nome, valor);
				
			}
		});
		btnBuscar.setBounds(202, 55, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Produto");
		lblNewLabel_1.setBounds(191, 87, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setBounds(10, 135, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(80, 132, 26, 20);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JButton btnAdicionarCarrinho = new JButton("Adicionar ao carrinho");
		btnAdicionarCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pedidoQuantidade;
				cpf = textCpf.getText();
				
				while(true) {
					
					if(textCpf.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Digite o CPF!");
						break;
					}else if(textRetorno.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Selecione o produto;");
						break;
					}else if(textQuantidade.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Selecione a Quantidade;");
						break;
					}
					
					pedidoQuantidade = Integer.parseInt(textQuantidade.getText());
					
					if(pedidoQuantidade > quantEstoque) {
						JOptionPane.showMessageDialog(null, "Estoque Insuficiente;");
						break;
					}
					quantEstoque = quantEstoque - pedidoQuantidade;
					//instancia do objeto carrinho
					
					
					Carrinho carrinho = new Carrinho(textCpf.getText(), textCodigoProduto.getText(), textCarrinho , quantEstoque, pedidoQuantidade);
					
					
					// chamando função para adicionar no carrinho
					String adicionar = carrinho.adicionandoCarrinho();
					JOptionPane.showMessageDialog(null, adicionar);
					break;
				}
				
				
				
				
				
				
				
				
				
			}
		});
		btnAdicionarCarrinho.setBounds(10, 205, 149, 23);
		contentPane.add(btnAdicionarCarrinho);
		
		JButton btnVerCarrinho = new JButton("Visualizar Carrinho");
		btnVerCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarrinhoView.exibirCarrinho();
				dispose();
				
			}
		});
		btnVerCarrinho.setBounds(275, 205, 149, 23);
		contentPane.add(btnVerCarrinho);
		
		textRetorno = new JTextField();
		textRetorno.setBounds(10, 101, 459, 20);
		contentPane.add(textRetorno);
		textRetorno.setColumns(10);
		
		
	 
		
		
		
		
		
	}

}
