package comandosSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexãoBanco.*;
import atributos.*;

public class Comandos {
	private Connection conn;
	

	public Comandos() {
		try{
			this.conn = Conexao.getConnection();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}


	public ArrayList listar() {
		PreparedStatement ps = null;
		Connection connL = null;
		ResultSet rs = null;
		ArrayList lista = new ArrayList();

		try{
			String SQL = "SELECT * FROM conta";
			connL = this.conn;

			ps = connL.prepareStatement(SQL);
			rs = ps.executeQuery();

			while( rs.next()){
				int id = rs.getInt("numero");
				String nome_med = rs.getString("cliente_nome");

				lista.add(new Conta(id, nome_med)); 
			}
		}catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		finally{
			Conexao.close(connL,ps);
		}

		return lista;
	}

	public void inserir(Conta conta) {         
		PreparedStatement ps = null;
		Connection connL = null;        
		if (conta == null){
			System.out.println("O objeto conta não pode ser nulo.");
		}
		try{
			String SQL = "INSERT INTO conta (numero, cliente_nome) " +
					"values (?,?)";
			connL = this.conn;
			ps = connL.prepareStatement(SQL);
			ps.setInt(1, conta.getNumero());
			ps.setString(2, conta.getCliente_nome());
			ps.executeUpdate();

		}catch(SQLException sqle){
			System.out.println("Erro ao inserir uma nova conta " + sqle);
		}
		finally{
			Conexao.close(connL,ps);
		}
	}

	public void atualizar(Conta conta) {
		PreparedStatement ps = null;
		Connection connL = null;
		if (conta == null){
			System.out.println("O objeto conta não pode ser nulo.");
		}

		try{
			String SQL = "UPDATE conta set cliente_nome=? WHERE numero=?";
			connL = this.conn;
			ps = connL.prepareStatement(SQL); 
			ps.setString(1, conta.getCliente_nome());
			ps.setInt(2, conta.getNumero());
			ps.executeUpdate();

		}catch(SQLException sqle){
			System.out.println("Erro ao editar a conta " + sqle);
		}
		finally{
			Conexao.close(connL,ps);
		}
	}


	public Conta procurar(int codigo) {
		PreparedStatement ps = null;
		Connection connL = null;
		ResultSet rs = null;
		Conta conta = new Conta();
		conta = null;

		try{
			String SQL = "SELECT numero, cliente_nome FROM conta WHERE numero = ?";
			connL = this.conn;
			ps = connL.prepareStatement(SQL);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();


			while( rs.next()){
				int numero = rs.getInt("numero");
				String cliente_nome = rs.getString("cliente_nome");

				conta = new Conta(numero, cliente_nome); 
			}

		}catch(SQLException sqle){
			System.out.println("Erro ao procurar conta " + sqle);
		}
		finally{
			// ConexaoAulaDAO.close(connL,ps);
		}
		return conta;
	}   

	public void excluir(Conta conta){
		PreparedStatement ps = null;
		Connection connL = null;
		if (conta == null){
			System.out.println("O objeto conta não pode ser nulo.");
		}

		try{
			String SQL = "DELETE FROM conta WHERE numero=?";
			connL = this.conn;

			ps = connL.prepareStatement(SQL);
			ps.setInt(1, conta.getNumero());
			ps.executeUpdate();
		}catch(SQLException sqle){
			System.out.println("Erro ao excluir a conta " + sqle);
		}
		finally{
			Conexao.close(connL,ps);
		}
	}
}
