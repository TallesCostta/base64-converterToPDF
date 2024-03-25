# API de Conversão de Arquivo Base64 para diversos formatos

Esta é uma API REST desenvolvida em Java com o framework Spring Boot. O objetivo desta API é converter um arquivo no formato Base64 em um formato desejado.

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

##### Utilize o método POST decodificar e pré-visualizar o arquivo
```
POST /api/v1/convertBase64/PDF
```

## Corpo da Requisição

A requisição deve conter um objeto JSON com o seguinte formato:

```json
{
  "nomeArquivo": "<string com nome do arquivo>"
  "base64Data": "<string no formato Base64>"
}
```

### Resposta

Se a conversão for bem-sucedida, você receberá uma resposta com o código de status HTTP 200, e dependendo da IDE de teste, uma janela de preview do arquivo será exibida.

Em caso de erro, você receberá uma resposta com o código de status HTTP apropriado e uma mensagem de erro no corpo da resposta.

## Contribuindo

Contribuições são bem-vindas! Se você quiser contribuir para este projeto, siga as etapas abaixo:

1. Faça um fork deste repositório.
2. Crie uma branch com a sua feature ou correção de bug: `git checkout -b minha-feature`
3. Faça commit das suas alterações: `git commit -m 'Adicionando uma nova feature'`
4. Envie a branch para o repositório remoto: `git push origin minha-feature`
5. Abra um pull request no GitHub.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE.txt).
