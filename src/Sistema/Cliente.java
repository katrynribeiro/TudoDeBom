package Sistema;
public class Cliente extends BancoDeDados{
	
	/**
	 * Método que atualiza as informações dos clientes cadastrados.
	 * @author Katryn
	 */
	
	public void AtualizarClientes(String nome, int id) {
		try {
			String query = "update clientes set nome_cliente='"+nome+"' where id_cliente="+id+";";
			System.out.println(query);
			super.getStatement().executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	/**
	 * Método que deleta clientes cadastrados.
	 * @author Katryn
	 */
	
	public void DeleteClientes(String nome, int id) {
		try {
			String query = "delete clientes where id_cliente=%"+id+";";
			System.out.println(query);
			super.getStatement().executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
