import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class HistoricoBancoDados extends BancoDeDados {
	private List<Carrinho> produto = new ArrayList<>();
	private static List<ConsultaHistorico> listaHistorico = new ArrayList<>();
	
	private static HashMap<Integer, Produto> listaProdutos = new HashMap<>();
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;
	 
	
	public HashMap<Integer, Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	

	public static List<ConsultaHistorico> getListaHistorico() {
		return listaHistorico;
	}
	
	public void inserirInformacoes(String cpf, List<Carrinho> listaCarrinho) {
		try {
			String query = String.format("insert into historico_transacoes (historico_cpf) values ('%s')", cpf);
			
			this.statement.executeUpdate(query);
			
			String retornoId = "SELECT LAST_INSERT_ID()";
			
			this.resultset = this.statement.executeQuery(retornoId);
			this.statement=this.connection.createStatement();
			
			if(resultset != null && resultset.next()){
				retornoId = resultset.getString("LAST_INSERT_ID()");
            }
			
			query = "create table pedido_"+retornoId+ "(id_item int not null auto_increment primary key, produto_lista varchar(200) not null);";
			
			this.statement.executeUpdate(query);
			
			for(int i =0; i < listaCarrinho.size(); i++) {
				String item = String.format("%s | Quantidade: %d", listaCarrinho.get(i).getProduto(), listaCarrinho.get(i).getQuantPedido());
				String queryPedido = String.format("insert into pedido_%s (produto_lista) values ('%s')",retornoId,item );
				this.statement.executeUpdate(queryPedido);
			}
			
			System.out.println("Adicionado");
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
public void baixandoProdutos() {
		
		try {
			
			String query = "select * from remedio";
			this.resultset = this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			
			while(this.resultset.next()) {
				
				
				
				String meuID = resultset.getString("id_remedio");
				String nomeP= resultset.getString("nome_remedio");
				
				String quant = resultset.getString("quantidade_remedio");
				double valor= resultset.getDouble("valor_unitario");
				int id = Integer.parseInt(meuID);
				int quantEstoque = Integer.parseInt(quant);
				
				
				
				listaProdutos.put(id, new Produto(nomeP, quantEstoque,valor ));
				
				
				
			}
			}catch(Exception e ) {
				System.out.println("Erro"+e.getMessage());
			}
	}
	public void atualizarEstoque(List<Carrinho> carrinho) {
		
		
		try {
			
			for(int i = 0; i < carrinho.size(); i++) {
				
				String query = String.format("update remedio set quantidade_remedio = %s where id_remedio in(%s)", carrinho.get(i).getQuantidadeRestante(), carrinho.get(i).getIdProduto());
				System.out.println(query);
				this.statement.executeUpdate(query);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void consultarHistorio() {
try {
			
			String query = "select p.id_pedido, p.historico_cpf, m.nome_cliente from historico_transacoes as p inner join cliente as m on(p.historico_cpf = m.cpf_cliente);";
			this.resultset = this.statement.executeQuery(query);
			this.statement=this.connection.createStatement();
			
			while(this.resultset.next()) {
				
				
				
				String meuID = resultset.getString("id_pedido");
				String cpf= resultset.getString("historico_cpf");
				
				String nome = resultset.getString("nome_cliente");
				
				
				listaHistorico.add(new ConsultaHistorico(meuID, cpf, nome));
				
				
				
				
				
				
				}
			}catch(Exception e ) {
				System.out.println("Erro"+e.getMessage());
			}
	}
}
