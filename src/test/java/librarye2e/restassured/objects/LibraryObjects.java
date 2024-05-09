package librarye2e.restassured.objects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LibraryObjects {

	static String baseUrl = "http://localhost:8085/api/livros";

	public static Response cadastrarLivro(String titulo, String autor, int qtdEstoque, String editora, int anoPublicacao, String genero) {
		return RestAssured.given()
				.baseUri(baseUrl)
				.basePath("/cadastrar")
				.contentType("application/json")
				.body("{\r\n"
			            + "    \"titulo\": \"" + titulo + "\",\r\n"
			            + "    \"autor\": \"" + autor + "\",\r\n"
			            + "    \"quantidadeEmEstoque\": " + qtdEstoque + ",\r\n"
			            + "    \"editora\": \"" + editora + "\",\r\n"
			            + "    \"anoPublicacao\": " + anoPublicacao + ",\r\n"
			            + "    \"genero\": \"" + genero + "\"\r\n"
			            + "}")
				.when()
				.post();
	}
	
	public static Response cadastrarLivroEmMassa(String titulo1, String autor1, int quantidadeEmEstoque1, String editora1, int anoPublicacao1, String genero1, 
												 String titulo2, String autor2, int quantidadeEmEstoque2, String editora2, int anoPublicacao2, String genero2,
												 String titulo3, String autor3, int quantidadeEmEstoque3, String editora3, int anoPublicacao3, String genero3, 
												 String titulo4, String autor4, int quantidadeEmEstoque4, String editora4, int anoPublicacao4, String genero4) {
				return RestAssured.given()
				.baseUri(baseUrl)
				.basePath("/cadastrar-em-massa")
				.contentType("application/json")
				.body("[\r\n" +
					    "    {\r\n" +
					    "        \"titulo\": \"" + titulo1 + "\",\r\n" +
					    "        \"autor\": \"" + autor1 + "\",\r\n" +
					    "        \"quantidadeEmEstoque\": " + quantidadeEmEstoque1 + ",\r\n" +
					    "        \"editora\": \"" + editora1 + "\",\r\n" +
					    "        \"anoPublicacao\": " + anoPublicacao1 + ",\r\n" +
					    "        \"genero\": \"" + genero1 + "\"\r\n" +
					    "    },\r\n" +
					    "    {\r\n" +
					    "        \"titulo\": \"" + titulo2 + "\",\r\n" +
					    "        \"autor\": \"" + autor2 + "\",\r\n" +
					    "        \"quantidadeEmEstoque\": " + quantidadeEmEstoque2 + ",\r\n" +
					    "        \"editora\": \"" + editora2 + "\",\r\n" +
					    "        \"anoPublicacao\": " + anoPublicacao2 + ",\r\n" +
					    "        \"genero\": \"" + genero2 + "\"\r\n" +
					    "    },\r\n" +
					    "    {\r\n" +
					    "        \"titulo\": \"" + titulo3 + "\",\r\n" +
					    "        \"autor\": \"" + autor3 + "\",\r\n" +
					    "        \"quantidadeEmEstoque\": " + quantidadeEmEstoque3 + ",\r\n" +
					    "        \"editora\": \"" + editora3 + "\",\r\n" +
					    "        \"anoPublicacao\": " + anoPublicacao3 + ",\r\n" +
					    "        \"genero\": \"" + genero3 + "\"\r\n" +
					    "    },\r\n" +
					    "    {\r\n" +
					    "        \"titulo\": \"" + titulo4 + "\",\r\n" +
					    "        \"autor\": \"" + autor4 + "\",\r\n" +
					    "        \"quantidadeEmEstoque\": " + quantidadeEmEstoque4 + ",\r\n" +
					    "        \"editora\": \"" + editora4 + "\",\r\n" +
					    "        \"anoPublicacao\": " + anoPublicacao4 + ",\r\n" +
					    "        \"genero\": \"" + genero4 + "\"\r\n" +
					    "    }\r\n" +
					    "]")
				.when()
				.post();
	}

	public static Response listarLivros() {
		return RestAssured
				.given()
				.baseUri(baseUrl)
				.when()
				.get();
	}
	
	public static Response listarLivroId(String id) {
		return RestAssured
				.given()
				.baseUri(baseUrl)
				.basePath("/" + id)
				.when()
				.get();
	}

	public static Response atualizarLivro(String id, String titulo, String autor, int quantidadeEmEstoque, String editora, int anoPublicacao, String genero) {
		return RestAssured.given()
				.baseUri(baseUrl)
				.basePath("/" + id)
				.contentType("application/json")
				.body("{\r\n"
			            + "    \"titulo\": \"" + titulo + "\",\r\n"
			            + "    \"autor\": \"" + autor + "\",\r\n"
			            + "    \"quantidadeEmEstoque\": " + quantidadeEmEstoque + ",\r\n"
			            + "    \"editora\": \"" + editora + "\",\r\n"
			            + "    \"anoPublicacao\": " + anoPublicacao + ",\r\n"
			            + "    \"genero\": \"" + genero + "\"\r\n"
			            + "}")
				.when()
				.put();
	}
	
	public static Response excluirLivro(String id) {
		return RestAssured.given()
				.baseUri(baseUrl)
				.basePath("/" + id)
				.when()
				.delete();
	}
	

}
