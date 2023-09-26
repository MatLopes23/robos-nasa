# Projeto Robôs

### Documentação

REST API que fornece um serviço para o cálculo de posicionamento do robô.

A atual solução utiliza o Design **Command Pattern**, atribuindo um command para cada tipo de ação do robô.

### Open API Documentation
```
http://localhost:8080/swagger-ui/index.html
```

### Deploy

Para criar a imagem através do gradle:
```
./gradlew bootBuildImage --imageName=api:v1.0
```

Para subir a aplicação pelo Docker:
```
docker run -p 8080:8080 api:v1.0
```
