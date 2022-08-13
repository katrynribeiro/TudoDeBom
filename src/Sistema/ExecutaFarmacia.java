package Sistema;
import java.util.Scanner;
public class ExecutaFarmacia {

	public static void main(String[] args) {
		Cliente sistema1 = new Cliente();

		sistema1.conectar();

		if (sistema1.estaConectado()) {
			System.out.println("Conexão com o banco de dados com exito!");
			sistema1.AtualizarClientes("Marcos André",4);

		} else {
			System.out.println("Não foi possível conectar ao Banco de Dados");
		}

	}

}
