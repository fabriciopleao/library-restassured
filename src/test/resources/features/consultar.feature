#Author: fabriciopereiraleao@gmail.com

@get @integration
Feature: Consultar lista de livros
   Como QA
   Quero validar a funcionalidade de consulta de livro 
   Para verificar a API da E2E Library

  @positive
  Scenario: Consulta de livro com sucesso
 	 	Given que estou acessando a API de livros
    When que informe o endpoint livros
    Then validar o status code OK e as informacoes recebidas
    
  @positive  
  Scenario: Consulta de livro por id
 		Given que estou acessando a API de livros
    When que informe o endpoint livros com id do livro desejado
    Then validar o status code OK e as informacoes recebidas por id
    
  @negative 
  Scenario: Consulta de livro inexistente por id
 		Given que estou acessando a API de livros
    When que informe o endpoint livros com id de livro inexistente
    Then validar o status code Not Found
    
  
    
  