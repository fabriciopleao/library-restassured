package librarye2e.restassured.objects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LibraryObjects {

	static String baseUrl = "http://localhost:8085/api/livros";

	public static Response cadastrarLivro(String titulo, String autor, int quantidadeEmEstoque, String editora, int anoPublicacao, String genero) {
		return RestAssured.given()
				.baseUri(baseUrl)
				.basePath("/cadastrar")
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
				.post();
	}

	public static Response listarLivros() {
		return RestAssured.given().baseUri(baseUrl).when().get();
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
