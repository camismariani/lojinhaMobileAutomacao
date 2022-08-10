# Lojinha MOBILE Automação
Esse é um repositório que contém a automação de alguns testes Mobile do software denominado Lojinha. Esse software foi utilizado durante os testes feitos no curso Programa de Testes e Qualidade de Software, ministrado pelo Júlio de Lima.

## Tecnologias utilizadas
- Java
- JUnit
- Appium
- Maven

## Testes automatizados
Testes para validar as partições de equiavalência relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7.000,01.

## Notas gerais
- Sempre utilizamos a anotação Before Each para abrir o aplicativo antes de cada teste.
- Utilizamos também a anotação AfterEach para fechar o aplicativo após a finalização de cada teste.
- Utilizamos Page Objects, design pattern utilizado para desenvolver classes de testes com princípios da orientação a objetos, servindo como interface para interagir com os elementos, sendo as classes as páginas e os métodos as ações que o usuário pode fazer na tela.
- Nesse projeto fazemos uso do JUnit 5 o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em português para nossos testes.
- Utilizei Dotenv para trabalhar com variáveis sensiveis, como usuário e senha do login. Assim, posso versionar o meu código sem passar os valores reais utilizados em cada váriavel, pois o Dotenv irá carregar os valores definidos nas variaveis configuradas no arquivo .env e este sendo adicionado no arquivo .gitignore.

## IDE utilizada
- IntelliJ