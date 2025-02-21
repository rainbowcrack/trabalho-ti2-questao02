# Atividade 02 - Integração PostgreSql e Eclipse

### **Aluna**: Izabel Oliveira da Paz Chaves - CC (PUC MINAS) 2025.1, TI2

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
