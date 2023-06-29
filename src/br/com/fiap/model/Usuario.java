package br.com.fiap.model;

import java.sql.Date;

import br.com.fiap.utils.CriptografiaUtils;

public class Usuario {
	
	 private long id;
	 private String nome, email;
	 private String senha; 
	 private Date data;
	 
	 public Usuario (String nome2, String email2, String senha2) {
	 }
	 
	public Usuario( String nome, String senha) {
		
		//this.id = id;
		this.nome = nome;
		this.email = email;
		setSenha(senha);
		this.data = new Date(System.currentTimeMillis());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha (String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public Date getDataCadastro() {
		return data;
	}

	public void setData(Date dataCadastro) {
		this.data = dataCadastro;
	}

}