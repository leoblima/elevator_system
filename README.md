
# APISUL Prova Admissional

O projeto consiste básicamente em gerar um relatório sobre um sistema de controle dos elevadores. 
No caso, é um prédio de 16 andares e com cinco elevadores denominados A, B, C, D e E. 

E gera um relatório com as seguintes informações:
- Qual é o andar menos utilizado pelos usuários;
- Qual é o elevador mais frequentado e o período que se encontra maior fluxo;
- Qual é o elevador menos frequentado e o período que se encontra menor fluxo;
- Qual o período de maior utilização do conjunto de elevadores;
- Qual o percentual de uso de cada elevador com relação a todos os serviços prestados;

Os dados básicos são fornecidos pelo arquivo input.json que está na pasta data dentro do src do projeto. 




## Installation

Para poder rodar o projeto é imperativo que tenha instalado o Java 8 ou maior e o Maven. 

Para confirmar se o Java está instalado basta utilizar o seguinte comando: 
```bash
  java -version
```
Você deve obter um retorno parecido com:
```bash
openjdk version "11.0.17" 2022-10-18
OpenJDK Runtime Environment (build 11.0.17+8-post-Ubuntu-1ubuntu220.04)
OpenJDK 64-Bit Server VM (build 11.0.17+8-post-Ubuntu-1ubuntu220.04, mixed mode, sharing)
```

Para se certificar que tem o Maven basta escrever no terminal: 

```bash
  mvm -version
```

e obter um retorno parecido com esse:
```bash
Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: 11.0.17, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.15.0-60-generic", arch: "amd64", family: "unix"
```

Uma vez certo das instalações, basta clonar o repositório usando git clone

Vá até o diretório do repositório e digite o seguinte comando para buildar o projeto:

```bash
mvn package
```
Esse comando irá compilar o código, executar os testes e criar um arquivo .jar na pasta target do projeto.

Para rodar o programa, basta digitar 
```bash
java -jar target/nome-do-arquivo.jar 
```
no terminal. O nome do arquivo .jar gerado pode vai ser o do projeto.
Deve iniciar e trazer os resultado listados na apresentação do projeto. 


## Response 

#### Retorno

Ao rodar o programa deve ter uma saída semelhante à seguinte: 
```bash
Iniciando programa! Com dados default: 'src/main/java/apisul/data/input.json'
Andares menos utilizados: [8]
Elevador mais frequentado: [C]
Elevador menos frequentado: [D, E]
Periodo maior fluxo do elevador mais frequentado[M]
Período menor fluxo do elevador menos frequentado: [V, V]
Periodo(s) de maior utilização do conjunto de elevadores: [M]
Percentual de uso do elevador A: 34.78
Percentual de uso do elevador B: 17.39
Percentual de uso do elevador C: 39.13
Percentual de uso do elevador D: 4.35
Percentual de uso do elevador A: 4.35
```

Ele avisa qual arquivo ta usando com input. Em versões futuras, implementar para poder receber vários arquivos e até mesmo registrar um log das saídas são os próximos passos. 

## Tech Stack

**Ferramentas:** Maven, Junit.

**Language:** Java


## Authors

- [@leoblima](https://github.com/leoblima)

