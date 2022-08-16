package Sistema;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ListaDetalhesPedidos extends JInternalFrame {
	
	private JPanel contentPane;
	private List<ConsultaHistorico> lista;
	/**
	 * Launch the application.
	 */
	public static void detalhesPedidos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDetalhesPedidos frame = new ListaDetalhesPedidos();
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
	public ListaDetalhesPedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 242, 441, -194);
		contentPane.add(scrollPane);
		
		HistoricoBancoDados bd =  new HistoricoBancoDados();
		
		bd.consultarHistorio();
		lista = new ArrayList<>(bd.getListaHistorico());
		DefaultListModel<ConsultaHistorico> model = new DefaultListModel<ConsultaHistorico>();
		
		for (int i = 0; i < lista.size(); i++) {
		     model.addElement(lista.get(i));
		    
		    
		}
		JList<ConsultaHistorico> list = new JList<ConsultaHistorico>(model);
		
		list.setBounds(22, 38, 441, 236);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Exibir Detalhes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoBancoDados bd = new HistoricoBancoDados();
				String id = model.get(list.getSelectedIndex()).getIdPedido();
				bd.exibirDetalhesCompleto(id);
				ListaCompleta.listaCompleta();
				
			}
		});
		btnNewButton.setBounds(323, 11, 140, 23);
		contentPane.add(btnNewButton);
		
		

	}
}
