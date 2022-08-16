package Sistema;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import javax.swing.JFormattedTextField;
import javax.swing.JTable;



public class Vendas extends JInternalFrame {
		
	private JPanel contentPane;
	private JTextField textCpf;
	private JTextField textCodigoProduto;
	private JTextField textQuantidade;
	private JTextField textRetorno;
	private String textCarrinho;
	private int quantEstoque;
	private static String cpf;
	private static String nome;
	private static String email;
	
	private static double valor;
	private static JTextField textField_nome;
	private static JTextField textField_email;
	private JTextField textField_carrinho;
	
	
	

	public static void setNome(String nome) {
		Vendas.textField_nome.setText(nome);
	}
	public static void setEmail(String email) {
		Vendas.textField_email.setText(email);
	}
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

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 342);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 551);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("CPF do  cliente:");
		lblNome.setBounds(10, 27, 89, 14);
		contentPane.add(lblNome);
		
		
		textCpf = new JTextField(cpf);
		textCpf.setBounds(109, 24, 141, 20);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo do Produto");
		lblNewLabel.setBounds(10, 130, 89, 14);
		contentPane.add(lblNewLabel);
		
		textCodigoProduto = new JTextField();
		textCodigoProduto.setBounds(109, 127, 86, 20);
		contentPane.add(textCodigoProduto);
		textCodigoProduto.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto consulta = new Produto();
				
				
				int codigo = Integer.parseInt(textCodigoProduto.getText());
				consulta.consultaProduto(codigo);
				String nome = consulta.getNome_remedio();
				quantEstoque = consulta.getQuantEstoque();
				double valorSemDesonto = consulta.getValor_remedio();
				int idGenerico = consulta.getFlag_generico();
				String valorDesconto = "Não se aplica!";
				double valorDescontoReal = 0;
				
				if(idGenerico == 1) {
					valorDescontoReal = valorSemDesonto * 0.80;
					valorDesconto = String.format("%.2f", valorDescontoReal);
					valor = valorDescontoReal;
					
					
				}else {
					valor = valorSemDesonto;
				}
				
				
				
				textRetorno.setText(String.format("Produto: %s | Quantidade em Estoque: %d | Valor Unitario: %.2f | Valor com Desconto:%s ", nome, quantEstoque, valorSemDesonto, valorDesconto));
				
				textCarrinho = String.format("Produto: %s | Valor Unitario: %.2f", nome, valor);
				
				
			}
		});
		btnBuscar.setBounds(205, 126, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Produto");
		lblNewLabel_1.setBounds(323, 161, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setBounds(10, 211, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(80, 208, 26, 20);
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
					
					
					Carrinho carrinho = new Carrinho(textCpf.getText(), textCodigoProduto.getText(), textCarrinho , quantEstoque, pedidoQuantidade, valor);
					
					
					// chamando função para adicionar no carrinho
					String adicionar = carrinho.adicionandoCarrinho();
					textField_carrinho.setText(String.valueOf(Carrinho.getCarrinho().size()));
					JOptionPane.showMessageDialog(null, adicionar);
					break;
				}
				
				
				
				
				
				
				
				
				
			}
		});
		btnAdicionarCarrinho.setBounds(10, 255, 149, 23);
		contentPane.add(btnAdicionarCarrinho);
		
		JButton btnVerCarrinho = new JButton("Visualizar Carrinho");
		btnVerCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarrinhoView.exibirCarrinho();
				dispose();
				
			}
		});
		btnVerCarrinho.setBounds(320, 255, 149, 23);
		contentPane.add(btnVerCarrinho);
		
		textRetorno = new JTextField();
		textRetorno.setEditable(false);
		textRetorno.setBounds(10, 180, 638, 20);
		contentPane.add(textRetorno);
		textRetorno.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoBancoDados bd = new HistoricoBancoDados();
				String cpfFormato = textCpf.getText().substring(0, 3) + "." + textCpf.getText().substring(3, 6) + "." + textCpf.getText().substring(6, 9) + "-" +textCpf.getText().substring(9, 11);
				
				bd.conectar();
				bd.baixandoCliente();
				bd.baixandoProdutos();
				
				
				List<String> cpf = new ArrayList<String>(HistoricoBancoDados.getListaCpf());
				
				boolean teste = false;
				for(int i =0; i < cpf.size(); i++) {
					if(cpf.get(i).equals(cpfFormato)) {
						
						bd.buscarCliente(cpfFormato);
						JLabel lblemail = new JLabel();
						lblemail.setText(email);
						lblemail.setBounds(53, 77, 197, 14);
						contentPane.add(lblemail);
						teste = true;
						break;
					}
				}
				
				if(teste == false) {
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
				}
				
			}
			
		});
		btnNewButton.setBounds(260, 23, 109, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Nome: ");
		lblNewLabel_3.setBounds(10, 52, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		lblNewLabel_4.setBounds(10, 77, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_nome = new JTextField();
		textField_nome.setEditable(false);
		textField_nome.setBounds(46, 49, 323, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setEditable(false);
		textField_email.setBounds(46, 74, 323, 20);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		textField_carrinho = new JTextField();
		textField_carrinho.setEditable(false);
		textField_carrinho.setBounds(264, 256, 46, 20);
		contentPane.add(textField_carrinho);
		textField_carrinho.setColumns(10);
		
		
		//ultima implatação
	 
		
		
		
		
		
	}
}
