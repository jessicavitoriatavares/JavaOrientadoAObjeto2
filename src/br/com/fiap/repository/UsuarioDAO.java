package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.Connection.ConnectionFactory;
import br.com.fiap.model.Usuario;

public class UsuarioDAO {

	private Connection conexao;

	public UsuarioDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}

	// métodos

	// insert
	public void insert(Usuario usuario) {
		String sql = "insert into usuario (nome, senha, dataCadastro) values (?,?,?,?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			// complemento da query
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setDate(4, usuario.getDataCadastro());
			// executar a query
			stmt.execute();
			// fechar a operação
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// selectAll --> caminho contrario do insert
	public List<Usuario> selectAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario order by nome";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) { 
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("Nome"));
				usuario.setEmail(rs.getString("Email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setData(rs.getDate("dataCadastro"));
				usuarios.add(usuario); // cada objeto usuario adicionado a lista de usuarios
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;

	}

	// selectById

	public Usuario selectById(long id) {
		Usuario usuario = null;
		String sql = "select * from usuario where id=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) { // enquanto tiver dados na tabela
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("Nome"));
				usuario.setEmail(rs.getString("Email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setData(rs.getDate("dataCadastro"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;

	}

	// update
	public void update(Usuario usuario) {
		String sql = "update usuario set nome=?, senha=?, email=? where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setLong(3, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// delete

	public void delete(long Id) {
		String sql = "delete from usuario where id=1";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, Id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
