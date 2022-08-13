import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CadastroCliente {
	private Connection conexao;

	public CadastroCliente(Connection conexao) {
		super();
		this.conexao = conexao;
	}
	
	public void cadastrarClientes(ClienteMod obj) {
		try {

			String sql = "insert int clientes (id_cliente, nome_cliente, email_cliente, cpf_cliente, data_nasc)"+"values(?????)";
			// preparar o SQL
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString (1, obj.getId_cliente());
			stmt.setString (2, obj.getNome_cliente());
			stmt.setString (3, obj.getEmail_cliente());
			stmt.setString (4, obj.getCpf_cliente());
			stmt.setString (5, obj.getData_nasc());
			 
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso");
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro!"+erro);
		}
	}
	
	
	// Listagem do cliente 
	public List<ClienteMod> listarClientes() {
		try {
			List<ClienteMod> lista = new ArrayList<>();
			
			String sql = "select * from clientes";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
			ClienteMod obj = new ClienteMod();
			obj.setId_cliente(rs.getNString("id_cliente"));
			obj.setId_cliente(rs.getNString("nome_cliente"));
			obj.setId_cliente(rs.getNString("email_cliente"));
			obj.setId_cliente(rs.getNString("cpf_cliente"));
			obj.setId_cliente(rs.getNString("data_nasc"));
			
			lista.add(obj);
			}
			return lista;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"erro"+e);
		}
		return null;
	}
	
}

