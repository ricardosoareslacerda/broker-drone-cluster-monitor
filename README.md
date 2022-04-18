<h1>Monitoramento de Informações de Drones - FIAP</h1> 

<p align="center">
  <img src="http://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge"/>
  <img src="http://img.shields.io/static/v1?label=Ruby%20On%20Rails%20&message=6.0.2.2&color=red&style=for-the-badge&logo=ruby"/>
  <img src="http://img.shields.io/static/v1?label=TESTES&message=%3E100&color=GREEN&style=for-the-badge"/>
   <img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=RED&style=for-the-badge"/>
   <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>

> Status do Projeto: :heavy_check_mark: :warning: (concluido, com possíbilidade de um versão com autenticação, e front-end simplificado)

### Tópicos

:small_blue_diamond: [Descrição do projeto](#descrição-do-projeto)

:small_blue_diamond: [Funcionalidades](#funcionalidades)

:small_blue_diamond: [Deploy da Aplicação](#deploy-da-aplicação-dash)

:small_blue_diamond: [Pré-requisitos](#pré-requisitos)

:small_blue_diamond: [Como rodar a aplicação](#como-rodar-a-aplicação-arrow_forward)

...

Insira os tópicos do README em links para facilitar a navegação do leitor

## Descrição do projeto

<p align="justify">
  Este sistema compôem 3 modulos de um Projeto de Monitoramento de Drones:
  - drone-monitor-job -> Responsável por enviar de forma simulada 4 drones com informações aleatórias do temperatura e de umidade 
  - drone-monitor-producer -> Responsável por receber dados do drone através do end-point (localhost:8082/api/v1/drones-monitor/drones/register/), validar suas rastreabilidade, e envia para o tópico do Kafka.
  - drone-monitor-consumer -> Responsável por consumir as mensagens do tópico do kafka e trata-las a sua deserialização e validar as informações do drone, estando dentro das regras de alerta, será enviado um e-mail
  # O projeto foi desenvolvido sobre a plataforma Java com o framework Spring Boot, utilizando o padrão de projeto RESTful e ferramentas como Kafka, Freemaker, Schedule, MailSender. Design Patterns Docker, Java 11, JUnit 4.

</p>

## Funcionalidades

##### :heavy_check_mark: **Monitoramento de Informações enviadas de Drones**
- ###### Monitoramento de Informações enviadas de Drones

  - ###### Seleção de drones para recuperar informações
  - ###### Postagema automatizada de informações do drone no end-point do produtor kafka
  - ###### Validar rastreabilidade do drone e serialização dos dados
  - ###### Postar no tópico do kafka
  - ###### Consumir do tópico do kafka
  - ###### Deserializar as informações do drone
  - ###### Validar a regra para envio do alerta
  - ###### Enviar e-mail quando igual ou superior a regra parametrizada

:heavy_check_mark: **Transações de crédito com os cartões de crédito dos estudantes**
- ###### Cadastro de transações de crédito dos cartões do estudante
  - ###### Transações de crédito devem ser feitas apenas para cartões do estudante

- ###### Cancelamento de transações de crédito

:heavy_check_mark: Extraçã das transações de crédito
- ###### Extrato deve ser enviado para o email do estudante

:heavy_check_mark: Importação de cartões dos estudantes

:heavy_check_mark: Importação de transações de crédito

## Layout ou Deploy da Aplicação :dash:

> Link do deploy da aplicação. Exemplo com netlify: https://certificates-for-everyone-womakerscode.netlify.app/

## Pré-requisitos

- [Docker](https://www.docker.com/products/docker-desktop)
- Java 11 ou superior(JDK 11)
- [Intellij]() (IDE)

## Como rodar a aplicação :arrow_forward:

No terminal, clone o projeto:

```
git clone https://github.com/ricardosoareslacerda/credit-card-integration.git
```

...

Coloque um passo a passo para rodar a sua aplicação. **Dica: clone o próprio projeto e verfique se o passo a passo funciona**
- [Instalar o JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Instalar o Intellij](https://www.jetbrains.com/idea/download/#download-section)
- Baixar o projeto do git [git clone https://github.com/ricardosoareslacerda/credit-card-integration.git]
- [Instalar o Docker](https://www.docker.com/products/docker-desktop)
- [Instalar o Docker Compose](https://docs.docker.com/compose/install/)
- Executar o Docker Compose:
  - docker-compose up (na raiz do projeto)

## Como rodar os testes

-

```
$ npm test, rspec, etc 
```

## Casos de Uso

Explique com mais detalhes como a sua aplicação poderia ser utilizada. O uso de **gifs** aqui seria bem interessante.

Exemplo: Caso a sua aplicação tenha alguma funcionalidade de login apresente neste tópico os dados necessários para acessá-la.

## JSON :floppy_disk:

### Students-Cards:

|registrationNumberCard|full_name|registration|numberCard|mail|
| -------- |-------- |-------- |-------- |-------- |


### Cards-Transactions:

|registrationNumberCard|establishmentName|value|status|installments|createdAt|updatedAt
| -------- |-------- |-------- |-------- |-------- |

...

Se quiser, coloque uma amostra do banco de dados

## Iniciando/Configurando banco de dados

Se for necessário configurar algo antes de iniciar o banco de dados insira os comandos a serem executados
...

Liste as tecnologias utilizadas no projeto que **não** forem reconhecidas pelo Github

## Desenvolvedores/Contribuintes :octocat:

Liste o time responsável pelo desenvolvimento do projeto

| [<br><sub>Marcos Porto</sub>](https://github.com/maporto) |  [<br><sub>Juscelino Carvalho</sub>](https://github.com/JuscelinoCarvalho) |  [<br><sub>Gabriel Batalha</sub>]() |
| :---: | :---: | :---: 

## Licença

The [Apacha 2]() (MIT)

Copyright :copyright: Ano - Titulo do Projeto