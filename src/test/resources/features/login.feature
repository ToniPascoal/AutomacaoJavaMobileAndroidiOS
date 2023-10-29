Feature: Login
  @test
  Scenario: login com sucesso
    Given que aplicativo esta aberto
    When fizer login
    Then valido a home do aplicativo
