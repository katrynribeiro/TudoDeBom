import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaCompleta extends JInternalFrame {
	private List<Carrinho> lista;
	/**
	 * Launch the application.
	 */
	public static void listaCompleta() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCompleta frame = new ListaCompleta();
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
	public ListaCompleta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 222);
		getContentPane().add(scrollPane);
		

		HistoricoBancoDados bd =  new HistoricoBancoDados();
		lista = new ArrayList<>(bd.getProdutoRetorno());
		DefaultListModel<Carrinho> model = new DefaultListModel<Carrinho>();
		
		for (int i = 0; i < lista.size(); i++) {
		     model.addElement(lista.get(i));
		    
		    
		}
		JList<Carrinho> list = new JList<Carrinho>(model);
		
		
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaDetalhesPedidos.detalhesPedidos();
			}
		});
		btnNewButton.setBounds(335, 244, 89, 23);
		getContentPane().add(btnNewButton);

	}

}
