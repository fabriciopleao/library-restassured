package librarye2e.restassured.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import librarye2e.restassured.objects.LibraryObjects;
import librarye2e.restassured.validations.APIValidations;

public class ConsultarSteps {

Response response;
	

	@When("que informe o endpoint livros")
	public void queInformeOEndpointLivros() {
	    response = LibraryObjects.listarLivros();
	}
	@Then("validar o status code OK e as informacoes recebidas")
	public void validarOStatusCodeOKEAsInformacoesRecebidas() {
	    APIValidations.validarStatusCode(response, 200);
	}

	@When("que informe o endpoint livros com id do livro desejado")
	public void queInformeOEndpointLivrosComIdDoLivroDesejado() {
	    response = LibraryObjects.listarLivroId("2");
	}

	@Then("validar o status code OK e as informacoes recebidas por id")
	public void validarOStatusCodeOKEAsInformacoesRecebidasPorId() {
		APIValidations.validarStatusCode(response, 200);
		APIValidations.validarLivroCadastrado(response, "Hello World da Galera", "Fabricio Leão", 10, "Saraiva", 2024, "Tecnologia");
	}

	@When("que informe o endpoint livros com id de livro inexistente")
	public void queInformeOEndpointLivrosComIdDeLivroInexistente() {
	    response = LibraryObjects.listarLivroId("0");
	}
	
	@Then("validar o status code Not Found")
	public void validarOStatusCodeNotFound() {
		APIValidations.validarStatusCode(response, 404);
	}







}
