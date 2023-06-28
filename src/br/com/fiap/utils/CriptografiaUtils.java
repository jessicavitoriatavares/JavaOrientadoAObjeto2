package br.com.fiap.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografiaUtils {
	
	public static String criptografar(String senha) throws Exception {
		// Obtem a instância de um algoritimo
		MessageDigest md = MessageDigest.getInstance("MD5");
		//passa os dados a serem criptografados e estipula enconding padrão
		md.update(senha.getBytes("ISO-8859-1"));
		//gera a chave criptografada em array de Bytes para posterior hashing
		BigInteger hash = new BigInteger (1, md.digest());
		//retorna a senha criptografada
		return hash.toString();
		
	}

}
