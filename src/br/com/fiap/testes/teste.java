package br.com.fiap.testes;

import java.util.List;

import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioDAO;

public class teste {

	public static void main(String[] args) {
		
		UsuarioDAO dao = new UsuarioDAO();
	    Usuario Joao = new Usuario("Joao", "ABC123");
		Usuario Larissa = new Usuario("Larissa", "ABC123");

		dao.insert(Joao);
		dao.insert(Larissa);
		
		List<Usuario> usuarios = dao.selectAll();
		
	//	dao.delete(5);	
		
		for (Usuario usuario : usuarios) {
		System.out.println("ID: " + usuario.getId());System.out.println();
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Data de cadastro: " + usuario.getDataCadastro());
		}
		
		Usuario usuario = dao.selectById(5);
		Joao.setNome("Jessica Tavares");
		usuario.setSenha("abcd123");
		
		dao.update(Joao);
		
		

	//System.out.println(dao.selectById(1));
	//System.out.println(usuario.getId());
   // System.out.println(usuario.getNome());
	//System.out.println(usuario.getDataCadastro());
		
		
	}

}