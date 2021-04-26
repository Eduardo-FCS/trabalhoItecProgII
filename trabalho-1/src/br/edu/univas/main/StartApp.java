package br.edu.univas.main;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import br.edu.univas.vo.GeradorSenha;

public class StartApp {

	public static Scanner scanner = new Scanner(System.in);
	public static String senha = "";
	public static boolean temMaiuscula = false;
	public static boolean temMinuscula = false;
	public static boolean temEspecial = false;
	public static boolean temNumeros = false;

	public static void main(String[] args) throws IOException {

		GeradorSenha geradorSenha = new GeradorSenha();

		cadastrarSenha(geradorSenha);
		gerarSenha(geradorSenha);
		salvarArquivo();
		scanner.close();

	}

	public static void cadastrarSenha(GeradorSenha geradorSenha) {

		for (int i = 0;; i++) {

			int options;
			System.out.println("CRIADOR DE SENHA");
			System.out.println("Digite o tamanho m�nimo");
			geradorSenha.setMinSenha(lerInteiro());

			System.out.println("Digite o tamanho m�ximo");
			geradorSenha.setMaxSenha(lerInteiro());

			if (geradorSenha.getMaxSenha() > geradorSenha.getMinSenha()) {

				System.out.println("Deseja letras mai�sculas na senha ?" + "\n" + "1- True;" + "\n" + "2- False;");
				options = lerInteiro();

				if (options == 1 || options == 2) {
					if (options == 1) {
						temMaiuscula = true;
					}
				} else {
					opcaoInvalida(options);
					if(options == 1) {
						temMaiuscula = true;
					}
				}

				System.out.println("Deseja letras min�sculas na senha ?" + "\n" + "1- True;" + "\n" + "2- False;");
				options = lerInteiro();

				if (options == 1 || options == 2) {
					if (options == 1) {
						temMinuscula = true;
					}
				} else {
					opcaoInvalida(options);
					if (options == 1) {
						temMinuscula = true;
					}
				}

				System.out.println("Deseja n�meros na senha ?" + "\n" + "1- True;" + "\n" + "2- False;");
				options = lerInteiro();

				if (options == 1 || options == 2) {
					if (options == 1) {
						temNumeros = true;
					}
				} else {
					opcaoInvalida(options);
					if (options == 1) {
						temMinuscula = true;
					}
					
				}

				System.out.println("Deseja caracteres especiais na senha ?" + "\n" + "1- True;" + "\n" + "2- False;");
				options = lerInteiro();

				if (options == 1 || options == 2) {
					if (options == 1) {
						temEspecial = true;
						break;
					}
				} else {
					opcaoInvalida(options);
					if (options == 1) {
						temMinuscula = true;
					}
				}

			}

			else {

				System.out.println("Valor m�ximo e m�nimo n�o compat�veis!");

			}

		}

	}

	public static void gerarSenha(GeradorSenha geradorSenha) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		int intero = 0;
		int letra = geradorSenha.getCaracterMinusculo().length()-1;
		int especial = geradorSenha.getCaracterEspec().length()-1;
		int numero = geradorSenha.getNumero().length()-1;
		char s;

		int aleatorio = random.nextInt((geradorSenha.getMaxSenha() - geradorSenha.getMinSenha()) + 1)
				+ geradorSenha.getMinSenha();

		for (int i = 0; i < aleatorio; i++) {

			if (temMaiuscula == true) {
				sb.append(geradorSenha.getCaracterMaiusculo().charAt(random.nextInt(letra)));
				intero++;
				if (intero == aleatorio) {
					break;
				}
			}
			if (temMinuscula == true) {	
				sb.append(geradorSenha.getCaracterMinusculo().charAt(random.nextInt(letra)));
				intero++;
				if (intero == aleatorio) {
					break;
				}
			}
			if (temEspecial == true) {
				sb.append(geradorSenha.getCaracterEspec().charAt(random.nextInt(especial)));
				intero++;
				if (intero == aleatorio) {
					break;
				}
			}
			if (temNumeros == true) {
				sb.append(geradorSenha.getNumero().charAt(random.nextInt(numero)));
				intero++;
				if (intero == aleatorio) {
					break;
				}
			}

		}

		senha = sb.toString();
		System.out.println(senha);
	}

	public static int lerInteiro() {
		int valor = scanner.nextInt();
		scanner.nextLine();
		return valor;
	}
	
	public static void salvarArquivo() throws IOException {
		System.out.println("Digite abaixo o nome do local que deseja salvar o arquivo:");
		String arquivoSalvar = scanner.nextLine();
		arquivoSalvar+="\\secret_password.txt";
	
		FileWriter arquivo = new FileWriter(arquivoSalvar);
		PrintWriter imprimir = new PrintWriter(arquivo);
		imprimir.printf("%s", senha);
		arquivo.close();
		System.out.println("Arquivo criado com sucesso!");
		
	}
	
	public static int opcaoInvalida(int opcao) {
		boolean troca = false;
		while(troca == false) {
			System.out.println("Op��o inv�lida, por favor digite 1 ou 2:");
			opcao = lerInteiro();
			if(opcao == 1 || opcao == 2) {
				troca = true;
			}
		}
		return opcao;
	}

}