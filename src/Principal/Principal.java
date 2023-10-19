package Principal;
import controle.controleConta;

import java.util.*;
import atributos.*;
public class Principal {

	public static void main(String[] args) {
	controleConta conta = new controleConta();
	
	conta.listaContas();
	conta.atualizar();
	conta.excluir();
	conta.procurar(0);
	conta.inserirConta();

	}	
}
