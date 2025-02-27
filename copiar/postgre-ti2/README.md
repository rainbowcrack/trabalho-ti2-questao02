# Atividade 02 - Integração PostgreSql e Eclipse

### Aluna: Izabel Oliveira da Paz Chaves, Ciência da Computação - PUC MINAS (2025.1) / 2º período - TI2

## Problema
Problema
Esta tarefa consiste na criação de um programa em Java utilizando o ambiente de desenvolvimento Eclipse, sendo que os alunos devem:

* Criar uma tabela X no SGBDR PostgreSQL.
* Criar uma classe X em Java.
* Criar uma classe DAO para manipular a classe X.
* Criam uma classe Principal contendo um menu com as opções Listar, Inserir, Excluir, Atualizar e Sair para acessar as funções CRUD da DAO.
* A tarefa deve ser executada de acordo com os recursos especificados abaixo, particularmente o video que apresenta um exemplo de conexão com o SGBDR PostgreSQL.

## Detalhes técnicos
Estrutura do diretório do projeto:

```bash
postgre-ti2/
├── pom.xml
└── src/
    └── main/
        └── java/
            ├── Cliente.java
            ├── ClienteDAO.java
            └── Principal.java
├── README.md
```

Execute o maven:

```bash
mvn clean install
mvn exec:java
```

Exemplo de tabela SQL:

```bash
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(15)
);
```

Utilização de **docker** no **console da Google Cloud**:

```bash
docker pull postgres
sudo apt update && sudo apt-get install postgresql postgresql-contrib
sudo su postgres
psql
```
**OBS:** na Cloud a interface gráfica do **phppgadmin** pode ser acessado por uma conexão SSH, já que as instâncias virtuais tem IP's privados e não possuem externos IPv4. O problema pode ser resolvido com IPv6 também, ou pela compra de uma VM para sair do carácter ephemeral da nuvem.

**Aluna**: Izabel Oliveira da Paz Chaves - CC (PUC MINAS) 2025.1, TI2
