package br.edu.univas.vo;

import java.util.ArrayList;

public class GeradorSenha {

	private int maxSenha;
	private int minSenha;
	private String caracterMinusculo = "abcdefghijklmnopqrstuvwxyz";
	private String caracterMaiusculo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String numero = "123456789";
	private String caracterEspec = "!@#$%&";
	
	public int getMaxSenha() {
		return maxSenha;
	}
	public void setMaxSenha(int maxSenha) {
		this.maxSenha = maxSenha;
	}
	public int getMinSenha() { 
		return minSenha;
	}
	public void setMinSenha(int minSenha) {
		this.minSenha = minSenha;
	}
	public String getCaracterMinusculo() {
		return caracterMinusculo;
	}
	public void setCaracterMinusculo(String caracterMinusculo) {
		this.caracterMinusculo = caracterMinusculo;
	}
	public String getCaracterMaiusculo() {
		return caracterMaiusculo;
	}
	public void setCaracterMaiusculo(String caracterMaiusculo) {
		this.caracterMaiusculo = caracterMaiusculo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCaracterEspec() {
		return caracterEspec;
	}
	public void setCaracterEspec(String caracterEspec) {
		this.caracterEspec = caracterEspec;
	}
	

}
