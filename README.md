# Projeto Automacao Web

Este projeto de e-commerce tem como objetivo validar as paginas, com fluxos de sucesso e alternativo conforme o escopo e requesitos.

##  DOWNLOADS E INSTALACAO
* Java 8+ JDK deve estar instalado
    * https://www.java.com/pt_BR/download/
* Maven deve estar instalado e configurado no path da aplicação
    * Realize download https://maven.apache.org/download.cgi e descompacte
    * No seu terminal, insira o comando: defaults write com.apple.finder AppleShowAllFiles -bool true

## Configurando variaveis de ambiente
* Caso nao exista o arquivo .profile crie
    * touch ~/.profile
    * nano ~/.profile
    * adicione as variáveis de ambiente: JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home
      export JAVA_HOME
      J6=$JAVA_HOME/bin
      M3_HOME=/Users/robertofilho/downloads/apache-maven-3.9.1
      export M3_HOME
      M3=$M3_HOME/bin
      PATH=$M3:$PATH:$J6
      export PATH
    * Agora carregue o arquivo com comando: source ~/.profile
    * Para salvar clique: Ctlr+X depois Y e por fim ENTER
    * source ~/.profile
    * verifique se o maven foi instalado com comando mvn - version
    * Caso nao seja possivel visualizar o maven, instale via terminal com:
        * brew install maven
    * Ao final volte as configuracoes com:
        * defaults write com.apple.finder AppleShowAllFiles -bool false

## Baixando as dependencias do projeto
* Baixe as dependencias no arquivo pom.xml


## Como executar o projeto
* execute no terminal na raiz do projeto:
    * mvn test -Dcucumber.options="--tags @smoke"
* Ou voce pode executar direto no arquivo TestRunner
* Obs 1: a tag smoke é comum em todos os cenarios. para executar cenario especifico altere para a tag desejada.
    * No caso de execucao no arquivo TestRunner altear o parametro da tags.


## Regras de desenvolvimento
* Afim de obter a melhor experiencia, escalabilidade e melhor manutencao no codigo, siga os passos para que seja implementados novos cenarios de automacao:
    * Crie o arquivo com extensao.feature com o nome da funcionalidade que deseja validar em src/test/resources
    * Crie o arquivo com os steps com o nome da pagina que deseja automatizar em src/test/java/steps
        * Obs: Assegure que seja implementado o step com apenas o que ele deve realmente fazer. nada mais nada menos.
    * Para inserir regras e logicas de metodos, utilize o arquivo src/test/java/pages/BasePage
        * Obs: Assegure que a logica que voce deseja nao esta realmente implementada nessa classe
    * Para mapear os elementos de uma nova pagina, crie um novo arquivo em src/test/java/pages/<nomePaginaPage>
    * Para mapear os elementos siga o mesmo padrao de locators com By(caso precise manipular de outra forma, alinhar com a lideranca)
        * Abaixo crie os metodos das acoes que deseja fazer nessa pagina
    * Para utilizar os metodos da pagina nos steps, instancie a pagina deseja. por ex: HomePage homePage new HomePage(), e assim podera usar a funcao por ex: mainpage.preencherUsuario() no step desejado;
    * Caso seus testes tenham mais de uma URL, centralize no arquivo src/test/java/constants/Url
    * Para manipular diferentes versoes de drivers ou navegadores, adicionar em src/test/java/common/drivers
    * Para criacao de metodos para algum tratamento, centralize o metodo em utils/Filters
    * O arquivo ServiceHooks tem o intuito de executar acoes antes e depois dos cenarios. Tenha cautela caso necessite inserir algo para nao impactar outros cenarios.
    * A cada step executado, sera disparado o metodo takeScreenshot antes e depois do mesmo. e sera armazenada as evidencias em source/relatorios com a data de execucao
      * Obs: As evidencias serao apagadas sempre que executar a suite de teste, para evitar o acumulo de evidencias antigas. 
* Obs: Caso enxergue melhorias possiveis na estrutura do projeto, conversar com a lideranca para entender a melhor forma para ajustar.
* Thats all folks! enjoy :)