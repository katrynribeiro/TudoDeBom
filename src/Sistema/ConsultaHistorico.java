package Sistema;

public class ConsultaHistorico {
	private String idPedido;
	private String cpf;
	private String nome;
	private String valorTotal;
	
	

	public String getIdPedido() {
		return idPedido;
	}



	public ConsultaHistorico(String idPedido, String cpf, String nome, String string) {
		super();
		this.idPedido = idPedido;
		this.cpf = cpf;
		this.nome = nome;
		this.valorTotal = string;
	}



	@Override
	public String toString() {
		return "ID-Pedido=" + idPedido + "|  CPF: " + cpf + "| Nome: " + nome + "| valorTotal ="
				+ valorTotal;
	}



	
}
