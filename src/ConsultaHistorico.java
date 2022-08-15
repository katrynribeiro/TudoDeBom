
public class ConsultaHistorico {
	private String idPedido;
	private String cpf;
	private String nome;
	private double valorTotal;
	
	

	public String getIdPedido() {
		return idPedido;
	}



	public ConsultaHistorico(String idPedido, String cpf, String nome, double valorTotal) {
		super();
		this.idPedido = idPedido;
		this.cpf = cpf;
		this.nome = nome;
		this.valorTotal = valorTotal;
	}



	@Override
	public String toString() {
		return "ID-Pedido=" + idPedido + "|  CPF: " + cpf + "| Nome: " + nome + "| valorTotal ="
				+ valorTotal;
	}



	
}
