package librarye2e.restassured.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import librarye2e.restassured.objects.LibraryObjects;
import librarye2e.restassured.validations.APIValidations;

public class ExcluirSteps {

	Response response;

	@When("que insira o id do livro desejado")
	public void queInsiraOIdDoLivroDesejado() {
	    response = LibraryObjects.excluirLivro("9");
	}
	@Then("validar o status code No Content")
	public void validarOStatusCodeNoContent() {
	    APIValidations.validarStatusCode(response, 204);
	}

	@When("que insira o id de um livro nao cadastrado")
	public void queInsiraOIdDeUmLivroNaoCadastrado() {
	    response = LibraryObjects.excluirLivro("400");
	}




	
}
