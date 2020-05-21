# Demo sobre a talk sobre WebFlux e MongoDB para a comunidade Nerdgirlz 

link da talk: https://bit.ly/nerdgirlz-pokedex

:house: Para rodar esta Rest API local você precisa usar
` mvn clean ` & ` mvn install `

:arrow_forward: E rodar na sua IDE a classe main()

` public static void main(String[] args) {
		SpringApplication.run(DemoPokedexNergirlzApplication.class, args);
		System.out.println("Helo Pokedex");
	} `

:arrow_right: Endoints:

http://localhost:8080/pokedex

http://localhost:8080/pokedex/events

http://localhost:8080/pokedex/{id}

Esta RestAPI esta hospedada no Heroku, você consegue acessar em: https://mighty-journey-86009.herokuapp.com/

**Dê um fork, e crie seu pokedex reativo :D**

