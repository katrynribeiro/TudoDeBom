import java.util.HashMap;



public class ConsultasList {
	private String nome;
	private int quantidadeEstoque;
	private double valor;
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void consultaProduto(int codigo) {
			HistoricoBancoDados bd = new HistoricoBancoDados();
			
			HashMap<Integer, produto> listaProdutos = new HashMap<>(bd.getListaProdutos());
			
			
			
			
			nome = listaProdutos.get(codigo).getNome_remedio();
			quantidadeEstoque =  listaProdutos.get(codigo).getQuantEstoque();
			
			valor = listaProdutos.get(codigo).getValor_remedio();
			
			
			
			
		}
}
