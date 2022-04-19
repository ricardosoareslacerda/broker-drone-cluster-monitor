<h1>Monitoramento de Informações de Drones - FIAP</h1> 

<p align="center">
  <img src="http://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge"/>
   <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>

> Status do Projeto: :heavy_check_mark: :warning: (concluido, com possíbilidade de um versão com autenticação, e front-end simplificado)

### Tópicos

:small_blue_diamond: [Descrição do projeto](#descrição-do-projeto)

:small_blue_diamond: [Funcionalidades](#funcionalidades)

:small_blue_diamond: [Deploy da Aplicação](#deploy-da-aplicação-dash)

:small_blue_diamond: [Pré-requisitos](#pré-requisitos)

:small_blue_diamond: [Como rodar a aplicação](#como-rodar-a-aplicação-arrow_forward)

## Descrição do projeto

Este sistema compôem 3 modulos de um Projeto de Monitoramento de Drones:

- **drone-monitor-job** -> Responsável por enviar de forma simulada 4 drones com informações aleatórias do temperatura e de umidade
- **drone-monitor-producer** -> Responsável por receber dados do drone através do end-point (localhost:8082/api/v1/drones-monitor/drones/register/), validar suas rastreabilidade, e envia para o tópico do Kafka.
- **drone-monitor-consumer** -> Responsável por consumir as mensagens do tópico do kafka e trata-las a sua deserialização e validar as informações do drone, estando dentro das regras de alerta, será enviado um e-mail

## Funcionalidades

#### :heavy_check_mark: **Monitoramento de Informações enviadas de Drones**
- ##### Monitoramento de Informações enviadas de Drones

  - ###### Seleção de drones para recuperar informações
  - ###### Postagema automatizada de informações do drone no end-point do produtor kafka
  - ###### Validar rastreabilidade do drone e serialização dos dados
  - ###### Postar no tópico do kafka
  - ###### Consumir do tópico do kafka
  - ###### Deserializar as informações do drone
  - ###### Validar a regra para envio do alerta
  - ###### Enviar e-mail quando igual ou superior a regra parametrizada

## Tecnologias

- [Docker](https://www.docker.com/products/docker-desktop)
- [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.htm)
- [Intellij](https://www.jetbrains.com/idea/download/#download-section) (IDE)
- [Docker](https://www.docker.com/products/docker-desktop)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Kafka](https://kafka.apache.org/)
- [Lombok](https://projectlombok.org/)
- [Gradle](https://gradle.org/)
- [Spring](https://spring.io/)
- [Spring Kafka](https://spring.io/projects/spring-kafka)
- [Spring RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)
- [Spring Freemarker](https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/ch16s04.html)



## Vídeo-1 Apresentação da Aplicação :dash:

> Link em vídeo da aplicação rodando. https://www.loom.com/share/2cbb9686bbc442de93fa1f238a52d546

## Vídeo-2 Apresentação da Aplicação :dash:

> Link em vídeo-2 da aplicação rodando.  https://www.loom.com/share/1605329bd5e54e60915623a4a59367d5

## Como rodar a aplicação :arrow_forward:

No terminal, clone o projeto:

```
git clone https://github.com/ricardosoareslacerda/broker-drone-monitor.git
```

- [Instalar o JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Instalar o Intellij](https://www.jetbrains.com/idea/download/#download-section)
- Baixar o projeto do git [git clone https://github.com/ricardosoareslacerda/broker-drone-monitor.git]
- [Instalar o Docker](https://www.docker.com/products/docker-desktop)
- Executar o Docker Compose:
  - docker-compose up (na raiz do projeto)
  - aguardar a instalação do server (Zookeeper/Kafka)
- Iniciar a ide Intellij
- Abrir o projeto no Intellij
- Para receber o envio de alerta, das informações do drone, será necessário configurar o e-mail no arquivo de properties do projeto. 
```  drone-monitor-consumer -> src\main\resources -> application.properties - mail.sender.toAddresses```
- Executar os projetos no Intellij:
  * **drone-monitor-producer**
  * **drone-monitor-consumer**
  * **drone-monitor-job**

## Desenvolvedores/Contribuintes :octocat:

Liste o time responsável pelo desenvolvimento do projeto
[<br><sub>Ricardo Lacerda</sub>](https://github.com/ricardosoareslacerda) | [<br><sub>Marcos Porto</sub>](https://github.com/maporto) |  [<br><sub>Juscelino Carvalho</sub>](https://github.com/JuscelinoCarvalho) |  [<br><sub>Gabriel Batalha</sub>]() |

## Licença

The [Apacha 2]() (MIT)

Copyright :copyright: Ano - Titulo do Projeto