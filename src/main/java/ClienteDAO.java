import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    // meu banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/postgre-ti2";
    private static final String USER = "ti2cc"; 
    private static final String PASSWORD = "ti@cc"; 

    // conectar o banco de dados
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // INSERIR um cliente
    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // LISTAR todos os clientes, usando Java list
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        // parametro SQL
        String sql = "SELECT * FROM cliente";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // EXCLUIR um cliente
    public void excluirCliente(int id) {
        // parametro SQL
        String sql = "DELETE FROM cliente WHERE id = ?";

        // verificar erros e execoes
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ATUALIZAR um cliente
    public void atualizarCliente(Cliente cliente) {

        // parametro SQL
        String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ? WHERE id = ?";

        // verificar excecoes e chamar metodos da classe
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
