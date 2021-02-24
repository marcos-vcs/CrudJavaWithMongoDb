import java.io.IOException;
import java.util.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		//variáveis
		int menu;

		do {
			Scanner input = new Scanner(System.in);
			Menu menu1 = new Menu();
			
			
			
			System.out.println("----------------| BEM VINDO AO GERENCIADOR DE ALUNOS |----------------");
			System.out.println("Qual Operação deseja fazer:");
			System.out.println("1) Cadastrar um novo aluno.");
			System.out.println("2) Listar alunos cadastrados.");
			System.out.println("3) Alterar um aluno cadastrado.");
			System.out.println("4) Excluir um aluno da base de dados.");
			System.out.println("0) SAIR.");
			
			menu = input.nextInt();
			while(menu > 4 || menu <0) {
				System.out.println("Informe uma Opção válida!");
				menu = input.nextInt();
			}
			
			
				
				switch(menu) {
				case 1:
					menu1.menuCadastrar();
					
					break;
				case 2:
					menu1.listar();
					
					break;
				case 3:
					menu1.alterar();
					
					break;
				case 4:
					menu1.apagar();
					break;
				
				}
		input.close();
		}while(menu != 0);
		
		
	}
	
}
