# API de Conversão de Arquivos Base64

Esta é uma API REST desenvolvida em Java com o framework Spring Boot. O objetivo desta API é oferecer funcionalidades para codificar e decodificar arquivos do tipo Base64.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Web
- Maven

## Pré-requisitos

Certifique-se de ter o seguinte software instalado em sua máquina:

- Java JDK 8 ou superior
- Maven
- Spring Tools 4
- Postman
- Lombok (jar)

## Configuração do Projeto

1. Clone o repositório do projeto para o seu ambiente local.
2. Abra o terminal e navegue até o diretório raiz do projeto.

## Compilação e Execução

Execute os seguintes comandos no terminal:

1. Compile o projeto usando o Maven:
   ```
   mvn clean install
   ```

2. Inicie a aplicação Spring Boot:
   ```
   mvn spring-boot:run
   ```

## Utilização da API

Uma vez que a aplicação esteja em execução, você pode interagir com a API utilizando um cliente REST, como o Postman ou o cURL.

## Endpoint

##### Utilize o método POST para codificar o arquivo
```
POST /api/v1/Base64Tools/encode/{FORMATO}
```

##### Utilize o método POST para decodificar o arquivo
```
POST /api/v1/Base64Tools/decode/{FORMATO}
```

Substitua `{FORMATO}` pelo formato desejado para codificação ou decodificação, por exemplo, PDF, JPG, PNG, etc.

## Corpo da Requisição

A requisição deve conter um objeto JSON com o seguinte formato para codificar:

```json
{
  "nomeArquivo": "<string com nome do arquivo>",
  "encodeData": "<string>"
}
```

A requisição deve conter um objeto JSON com o seguinte formato para decodificar:

```json
{
  "nomeArquivo": "<string com nome do arquivo>",
  "base64Data": "<string no formato Base64>"
}
```

### Resposta

Se a conversão for bem-sucedida, você receberá uma resposta com o código de status HTTP 200, o retorno seguirá o seguinte padrão:

```json
{
	"codigo": 200,
	"mensagem": "Mensagem operação realizadaa",
	"resultado": {
		"decodeData": "Sting arquivo decodificado"
	}
}
```

Em caso de erro, você receberá uma resposta com o código de status HTTP apropriado e uma mensagem de erro no corpo da requisição:

```json
{
	"erros": [
		{
			"mensagem": "Mensagem contendo o erro ocorrido",
			"codigo": 409
		}
	]
}
```

## Contribuindo

Contribuições são bem-vindas! Se você quiser contribuir para este projeto, siga as etapas abaixo:

1. Faça um fork deste repositório.
2. Crie uma branch com a sua feature ou correção de bug: `git checkout -b minha-feature`
3. Faça commit das suas alterações: `git commit -m 'Adicionando uma nova feature'`
4. Envie a branch para o repositório remoto: `git push origin minha-feature`
5. Abra um pull request no GitHub.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE.txt).
