
public class Produto {
	private String nome_remedio;
	private int quantEstoque;
	private double valor_remedio;
	
	public Produto(String nome_remedio, int quantEstoque, double valor_remedio) {
		super();
		
		this.nome_remedio = nome_remedio;
		this.quantEstoque = quantEstoque;
		this.valor_remedio = valor_remedio;
	}

	@Override
	
	public String toString() {
		String format = String.format("produto [nome_remedio=" + nome_remedio + ", quantEstoque=" + quantEstoque + ", valor_remedio="
				+ valor_remedio + "]");
		return format;
	}

	public String getNome_remedio() {
		return nome_remedio;
	}

	public int getQuantEstoque() {
		return quantEstoque;
	}

	public double getValor_remedio() {
		return valor_remedio;
	}
	
}
