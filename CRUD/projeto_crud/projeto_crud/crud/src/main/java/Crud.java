import java.io.IOException;
import java.util.*;

import org.bson.Document;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;

public class Crud {
	// variaveis
	private String id = null;
	private String nome = null;
	private String aniversario = null;
	private String sala = null;
	private String nivelEscolar = null;
	private int serie = 0;

	Scanner input = new Scanner(System.in);

	// conex�o com o banco de dados mongo atlas
	MongoClientURI uri = new MongoClientURI(
			"mongodb://marcos:6janeiro2002@cluster0-shard-00-00.ujgj3.mongodb.net:27017,cluster0-shard-00-01.ujgj3.mongodb.net:27017,cluster0-shard-00-02.ujgj3.mongodb.net:27017/escola?ssl=true&replicaSet=atlas-d72rzx-shard-0&authSource=admin&retryWrites=true&w=majority");
	MongoClient cliente = new MongoClient(uri);// conecta no banco localhost
	MongoDatabase bancoDeDados = cliente.getDatabase("escola");// definimos nosso database como sendo escola
	MongoCollection<org.bson.Document> alunos = bancoDeDados.getCollection("alunos");// colocamos a collection alunos
																						// dentro da variavel alunos

	public void create(String nome, String id, String aniversario, String sala, String nivelEscolar, int serie)
			throws IOException {

		this.nome = nome;
		this.id = id;
		this.aniversario = aniversario;
		this.nivelEscolar = nivelEscolar;
		this.serie = serie;
		this.sala = sala;

		Document novoAluno = new Document("nome", this.nome).append("_id", this.id)
				.append("aniversario", this.aniversario).append("nivelEscolar", this.nivelEscolar)
				.append("serie", this.serie).append("sala", this.sala);

		alunos.insertOne(novoAluno);

		System.out.println("Aluno inserido com sucesso!\nPressione qualquer tecla para continuar . . .");
		System.in.read();
		cliente.close();
	}

	public void read() throws IOException {
		MongoCursor<Document> cursor = alunos.find().iterator();

		try {
			while (cursor.hasNext()) {
				String cursorString = cursor.next().toString();// conversaoo de Document para string
				String[] cursorSeparado = cursorString.split(",");// sempre que a função achar uma virgula ela vai
																	// quebrar a string e separar ela em uma nova casa
																	// do array
				cursorSeparado[5] = cursorSeparado[5].substring(0, 11);// isso apagar as chaves da resposta do banco de
																		// dados.
				cursorSeparado[0] = cursorSeparado[0].substring(11, 18);

				// replaceAll troca um caracter por outro como = por :
				System.out.print(" ||| " + cursorSeparado[0].replaceAll("=", " : "));
				System.out.print(" |||" + cursorSeparado[1].replaceAll("=", " : "));
				System.out.print(" |||" + cursorSeparado[2].replaceAll("=", " : "));
				System.out.print(" |||" + cursorSeparado[3].replaceAll("=", " : "));
				System.out.print(" |||" + cursorSeparado[4].replaceAll("=", " : "));
				System.out.println(" |||" + cursorSeparado[5].replaceAll("=", " : ") + " |||");

			}

		} finally {

			cliente.close();
		}

	}

	public void readPesquisa(String id) throws IOException {
		// filtro pesquisa por id
		Document third = alunos.find(Filters.eq("_id", id)).first();

		String cursorString = third.toString();
		String[] cursorSeparado = cursorString.split(",");

		cursorSeparado[5] = cursorSeparado[5].substring(0, 11);
		cursorSeparado[0] = cursorSeparado[0].substring(11, 18);

		// replaceAll troca um caracter por outro como = por :
		System.out.print(" ||| " + cursorSeparado[0].replaceAll("=", " : "));
		System.out.print(" |||" + cursorSeparado[1].replaceAll("=", " : "));
		System.out.print(" |||" + cursorSeparado[2].replaceAll("=", " : "));
		System.out.print(" |||" + cursorSeparado[3].replaceAll("=", " : "));
		System.out.print(" |||" + cursorSeparado[4].replaceAll("=", " : "));
		System.out.println(" |||" + cursorSeparado[5].replaceAll("=", " : ") + " |||");

		System.out.println("\n\n\n");

		cliente.close();
	}

	public void updateNome(String id, String novoNome) {
		this.id = id;
		this.nome = novoNome;

		alunos.updateOne(Filters.eq("_id", this.id), Updates.set("nome", this.nome));

		cliente.close();
	}

	public void updateNiver(String id, String novoNiver) {
		this.id = id;
		this.aniversario = novoNiver;

		alunos.updateOne(Filters.eq("_id", this.id), Updates.set("aniversario", this.aniversario));

		cliente.close();
	}

	public void updateEscolaridade(String id, String nivelEscolar, int serie) {
		this.id = id;
		this.nivelEscolar = nivelEscolar;
		this.serie = serie;

		alunos.updateOne(Filters.eq("_id", this.id), Updates.set("nivelEscolar", this.nivelEscolar));
		alunos.updateOne(Filters.eq("_id", this.id), Updates.set("serie", this.serie));

		cliente.close();
	}

	public void updateSala(String id, String sala) {
		this.id = id;
		this.sala = sala;

		alunos.updateOne(Filters.eq("_id", this.id), Updates.set("sala", this.sala));

		cliente.close();
	}

	public void delete(String id) {
		this.id = id;

		alunos.deleteOne(Filters.eq("_id", id));

		cliente.close();
	}

}