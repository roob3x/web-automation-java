# Defina a imagem base
FROM ubuntu:latest

# Instale as dependências necessárias para executar o projeto
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk maven

# Copie o código do projeto para o contêiner
COPY . /usr/src/app

# Defina o diretório de trabalho como o diretório raiz do projeto
WORKDIR /usr/src/app

# Construa o projeto com o Maven
RUN mvn clean install

# Defina o comando padrão a ser executado quando o contêiner for iniciado
CMD ["mvn", "test"]