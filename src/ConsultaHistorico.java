
public class ConsultaHistorico {
	private String idPedido;
	private String cpf;
	private String nome;
	
	public ConsultaHistorico(String idPedido, String cpf, String nome) {
		super();
		this.idPedido = idPedido;
		this.cpf = cpf;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "consultHistorico [idPedido=" + idPedido + ", cpf=" + cpf + ", nome=" + nome + "]";
	}
}
