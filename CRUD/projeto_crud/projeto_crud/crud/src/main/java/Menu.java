import java.io.IOException;
import java.util.*;


public class Menu {
	private String id = null;
	
	private String nome = null;

	private char salaLetra;
	private int salaNumero = 0;
	
	private String salaInsert = null;
	
	private String aniversario = null;
	private int serie = 0;
	private int nivelEscolarNumero = 0;
	private String nivelEscolarTexto = null;
	
	private int menuRead = 0;
	
	
	
	Scanner input = new Scanner(System.in);
	Crud crud = new Crud();

	private int opUpdate;
	
	 public void menuCadastrar() throws IOException {
		System.out.println("----------------| CADASTRO DE ALUNOS |----------------");
		System.out.println("Deseja continuar ? [S/N]");
		char resposta = input.next().charAt(0);
			while(resposta != 's' && resposta != 'S' && resposta != 'n' && resposta != 'N') {
				System.out.println("Informe uma opção válida!");
				resposta = input.next().charAt(0);
			}
			//se for s entra na condicional e se for n passa reto, diferente disso fica preso no while
			
		if(resposta == 's' || resposta == 'S') {
//====================================================================================
			System.out.println("Informe o nome do aluno: ");
			this.nome = input.next();
			
//====================================================================================
			
			System.out.println("Informe o número de inscrição do aluno: (4 dígitos)");
			this.id = input.next();
			while(this.id.length() != 4) {//limita o tamanho em 4
				System.out.println("Informe um valor válido: ");
				this.id = input.next();
			}
			
//====================================================================================

			
			System.out.println("Informe a data de aniversário do aluno: (DIA-MÊS-ANO)");
			this.aniversario = input.next();
			
//====================================================================================
			
			System.out.println("O aluno está no ensino médio ou fundamental?");
			System.out.println("1) Ensino médio.");
			System.out.println("0) Ensino Fundamental.");
			this.nivelEscolarNumero = input.nextInt();
				while(this.nivelEscolarNumero < 0 || this.nivelEscolarNumero > 1) {
					System.out.println("Informe uma opção válida!");
					this.nivelEscolarNumero = input.nextInt();
				}
				if(this.nivelEscolarNumero == 1) {
					this.nivelEscolarTexto = "ensino médio";
				}else {
					this.nivelEscolarTexto = "ensino fundamental";
				}
				
//====================================================================================
			
			System.out.println("Informe a serie do aluno:");
			this.serie = input.nextInt();
				if(this.nivelEscolarNumero == 1){//se o aluno estiver no ensino médio então...
					while(this.serie < 0 || this.serie > 3) {
						System.out.println("Informe uma série entre o 1º e o 3º ano!");
						this.serie = input.nextInt();
					}
				}else {//ensino fundamental...
					while(this.serie < 0 && this.serie > 9){
						System.out.println("Informe uma série entre o 1º e o 9º ano!");
						this.serie = input.nextInt();
					}
				}
				
			
//====================================================================================		
				
			System.out.println("Informe a sala do aluno: (LETRA(A ... B) - NÚMERO(1 ... 9)");
			this.salaLetra = input.next().charAt(0);
				while(this.salaLetra != 'a' && this.salaLetra != 'A' && this.salaLetra != 'b' && this.salaLetra != 'B') {
					System.out.println("Informe uma sala válida!");
					this.salaLetra = input.next().charAt(0);
				}
			System.out.println(" - ");
			this.salaNumero = input.nextInt();
				while(this.salaNumero < 0 || this.salaNumero > 9) {
					System.out.println("Informe um número de sala válido!");
					this.salaNumero = input.nextInt();
				}
				this.salaInsert = String.valueOf(this.salaLetra);//conversão de char para String
				this.salaInsert = this.salaInsert.concat(" - ").concat(Integer.toString(this.salaNumero)); //concatenação de strings e conversão de int para String
			
//====================================================================================
			
			crud.create(this.nome, this.id, this.aniversario, this.salaInsert, this.nivelEscolarTexto, this.serie);
       
			
		}
		
	
		
	}
	
		public void listar() throws IOException {
			System.out.println("Informe a opção desejada: ");
			System.out.println("1) Listar todos os alunos cadastrados");
			System.out.println("2) Pesquisar pelo número de inscrição");
			System.out.println("0) Voltar para o menu");
			this.menuRead = input.nextInt();
				while(this.menuRead < 0 || this.menuRead > 2) {
					System.out.println("Informe uma opção válida");
					this.menuRead = input.nextInt();
				}
			
			switch(this.menuRead) {
			case 1:
				System.out.println("----------------| LISTA DE ALUNOS CADASTRADOS |----------------");
				crud.read();
				System.out.println("Pressione qualquer tecla para voltar ao menu!!!");
				System.in.read();//system("pause"). do java
				break;
			case 2:
				System.out.println("Informe o número de inscrição do aluno: (4 dígitos)");
				this.id = input.next();
				while(this.id.length() != 4) {//limita o tamanho em 4
					System.out.println("Informe um valor válido: ");
					this.id = input.next();
				}
				
				crud.readPesquisa(this.id);
				break;
			}
		
		}
		
//====================================================================================

		
		public void alterar() throws IOException {
				
				System.out.println("----------------| ATUALIZAR DADOS DE ALUNOS |----------------");
				System.out.println("QUAL DAS OPÇÕES DESEJA ATUALIZAR?");
				System.out.println("1) atualizar nome");
				System.out.println("2) atualizar data de aniversário");
				System.out.println("3) atualizar dados de escolaridade");
				System.out.println("4) atualizar sala");
				System.out.println("0) voltar ao menu principal");
				this.opUpdate = input.nextInt();
				
					while(this.opUpdate < 0 || this.opUpdate > 6) {
						System.out.println("Informe uma opção válida!");
						this.opUpdate = input.nextInt();
					}
				switch(this.opUpdate) {
				case 0:
					System.out.println("Para voltar ao menu pressione qualquer tecla!");
					System.in.read();
					break;
				case 1:
					//atualizar nome
					System.out.println("Informe o número de inscrição do aluno: ");
					this.id = input.next();
					while(this.id.length() != 4) {//limita o tamanho em 4
						System.out.println("Informe um valor válido: ");
						this.id = input.next();
					}
					
					System.out.println("Informe o novo Nome do aluno");
					this.nome = input.next();
					
					crud.updateNome(this.id,this.nome);
					
					break;
				case 2:
					//atualizar data de aniversário
					System.out.println("Informe o número de inscrição do aluno: ");
					this.id = input.next();
					while(this.id.length() != 4) {//limita o tamanho em 4
						System.out.println("Informe um valor válido: ");
						this.id = input.next();	
					}
					
					System.out.println("Informe a NOVA data de aniversário do aluno: (DIA-MÊS-ANO)");
					this.aniversario = input.next();
					
					crud.updateNiver(this.id, this.aniversario);
					
					break;
				case 3:
					//atualizar escolaridade
					System.out.println("Informe o número de inscrição do aluno: ");
					this.id = input.next();
					while(this.id.length() != 4) {//limita o tamanho em 4
						System.out.println("Informe um valor válido: ");
						this.id = input.next();	
					}
					

					System.out.println("O aluno está no ensino médio ou fundamental?");
					System.out.println("1) Ensino médio.");
					System.out.println("0) Ensino Fundamental.");
					this.nivelEscolarNumero = input.nextInt();
						while(this.nivelEscolarNumero < 0 || this.nivelEscolarNumero > 1) {
							System.out.println("Informe uma opção válida!");
							this.nivelEscolarNumero = input.nextInt();
						}
						if(this.nivelEscolarNumero == 1) {
							this.nivelEscolarTexto = "ensino médio";
						}else {
							this.nivelEscolarTexto = "ensino fundamental";
						}
				
					System.out.println("Informe a nova serie do aluno:");
					this.serie = input.nextInt();
						if(this.nivelEscolarNumero == 1){//se o aluno estiver no ensino médio então...
							while(this.serie < 0 || this.serie > 3) {
								System.out.println("Informe uma série entre o 1º e o 3º ano!");
								this.serie = input.nextInt();
						}}else {
							while(this.serie < 0 && this.serie > 9){
								System.out.println("Informe uma série entre o 1º e o 9º ano!");
								this.serie = input.nextInt();
								}
							}
						
					crud.updateEscolaridade(this.id, this.nivelEscolarTexto, this.serie);
					
					
					break;
				case 4:
					//atualizar a sala do aluno
					System.out.println("Informe o número de inscrição do aluno: ");
					this.id = input.next();
					while(this.id.length() != 4) {//limita o tamanho em 4
						System.out.println("Informe um valor válido: ");
						this.id = input.next();	
					}
					
					System.out.println("Informe a nova sala do aluno: (LETRA(A ... B) - NÚMERO(1 ... 9)");
					this.salaLetra = input.next().charAt(0);
						while(this.salaLetra != 'a' && this.salaLetra != 'A' && this.salaLetra != 'b' && this.salaLetra != 'B') {
							System.out.println("Informe uma sala válida!");
							this.salaLetra = input.next().charAt(0);
						}
					System.out.println(" - ");
					this.salaNumero = input.nextInt();
						while(this.salaNumero < 0 || this.salaNumero > 9) {
							System.out.println("Informe um número de sala válido!");
							this.salaNumero = input.nextInt();
						}
						this.salaInsert = String.valueOf(this.salaLetra);//conversão de char para String
						this.salaInsert = this.salaInsert.concat(" - ").concat(Integer.toString(this.salaNumero));
						
						crud.updateSala(id, salaInsert);
					
					break;	
				
				}
			
			
		}
		
		public void apagar() {
			System.out.println("----------------| APAGAR DADOS DE ALUNOS |----------------");
			System.out.println("Informe o número de inscrição do aluno: ");
			this.id = input.next();
			while(this.id.length() != 4) {//limita o tamanho em 4
				System.out.println("Informe um valor válido: ");
				this.id = input.next();	
			}
			
			crud.delete(id);
			
		}
		 
	 

}
