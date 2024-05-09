#Author: fabriciopereiraleao@gmail.com

@put @integration
Feature: Atualizar informacoes do livro
   Como QA
   Quero validar a funcionalidade de atualizacao de livro 
   Para verificar a API da E2E Library

  @positive
  Scenario: Atualizacao de livro com sucesso
 	 	Given que estou acessando a API de livros
    When que insira o id desejado e as informacoes validas para atualizacao do livro no body request
    Then validar o status code OK e as informacoes do livro atualizadas

  @negative
  Scenario: Atualizacao de livro com dados invalidos
 	 	Given que estou acessando a API de livros
    When que insira o id desejado e as informacoes invalidas para atualizacao do livro no body request
    Then validar o status code Bad Request 
    
  @negative
  Scenario: Atualizacao de livro com dados em branco
 	 	Given que estou acessando a API de livros
    When que insira o id desejado e mande os dados em branco no body request
    Then validar o status code Bad Request 
    
  @negative
  Scenario: Atualizacao de livro com dados de livro ja cadastrado
 	 	Given que estou acessando a API de livros
    When que insira o id desejado e mande dados de livro ja cadastrado no body request
    Then validar o status code Bad Request
    