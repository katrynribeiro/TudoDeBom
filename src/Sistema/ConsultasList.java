package Sistema;
import java.util.HashMap;



public class ConsultasList extends Produto {
	

	public void consultaProduto(int codigo) {
		HistoricoBancoDados bd = new HistoricoBancoDados();
		
		HashMap<Integer, Produto> listaProdutos = new HashMap<>(bd.getListaProdutos());
		String nome;
		int quantidadeEstoque;
		
		
		
		nome = listaProdutos.get(codigo).getNome_remedio();
		quantidadeEstoque =  listaProdutos.get(codigo).getQuantEstoque();
		
		double valor = listaProdutos.get(codigo).getValor_remedio();
		
		
		
		
	}
}
