package controle;
import comandosSql.*;
import java.util.*;
import atributos.*;
public class controleConta {
	private Scanner sc = new Scanner(System.in);

	public void listaContas() {
		Comandos comando = new Comandos();
		ArrayList<Conta> listaDeContas = new ArrayList<>();
		
		listaDeContas =  comando.listar();
		
		for(int i = 0; i < listaDeContas.size(); i++) {
			System.out.println("id: "+ listaDeContas.get(i).getNumero() + " Nome: " + listaDeContas.get(i).getCliente_nome());
		}	
	}
	
	public void inserirConta() {
		Comandos comando = new Comandos();
		Conta conta = new Conta();
		
		System.out.print("Digite o numero do id -> ");
		conta.setNumero(sc.nextInt());
		
		sc.nextLine();
		
		System.out.print("Digite o nome do titular -> ");
		conta.setCliente_nome(sc.nextLine());;
		
		comando.inserir(conta);
	}
	
	public void atualizar() {
		Comandos comando = new Comandos();
		Conta conta = new Conta();
		
		System.out.print("Digite o numero do id -> ");
		conta.setNumero(sc.nextInt());
		
		sc.nextLine();
		
		System.out.print("Digite o nome do titular -> ");
		conta.setCliente_nome(sc.nextLine());;
		
		comando.atualizar(conta);
	}
	
	public void procurar(int codigo) {
		Comandos comando = new Comandos();
		Conta conta = comando.procurar(codigo);
		
		System.out.println(conta.getCliente_nome() + " " + conta.getNumero());
	}
	
	public void excluir() {
		Comandos comando = new Comandos();
		Conta conta = new Conta();
		
		System.out.print("Digite o numero da conta que deseja deletar -> ");
		int numero = sc.nextInt();
		
		conta = comando.procurar(numero);
		
		comando.excluir(conta);
	}
	
	
}