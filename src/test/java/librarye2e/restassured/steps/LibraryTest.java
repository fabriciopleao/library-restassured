package librarye2e.restassured.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.restassured.response.Response;
import librarye2e.restassured.objects.LibraryObjects;

public class LibraryTest {

	Response response;
	
	/*@Test
	public void cadastrarLivro() {
		response = LibraryObjects.cadastrarLivro("E2E", "Fabricio", 10, "teste", 0, "teste");
		assertEquals(201, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}*/
	
	@Test
	public void consultarLivros() {
		response = LibraryObjects.listarLivros();
		assertEquals(200, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}
	
	/*@Test
	public void atualizarLivro() {
		response = LibraryObjects.atualizarLivro("4","Você é demais!", "Fabricio Leão", 10, "Amazon", 2020, "Motivacional");
		assertEquals(200, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}
	
	@Test
	public void excluirLivro() {
		response = LibraryObjects.excluirLivro("3");
		assertEquals(204, response.getStatusCode());
	}*/
	
	
}
