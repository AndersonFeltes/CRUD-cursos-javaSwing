
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ander
 */
public class Conexao {
    public Connection getConexao(){
        try {
            //tentar estabelecer a conexao
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projetojava?serverTimezone=UTC", //linha de conexao
                    "root", //usuario do mysql
                    "" //senha do mysql
            );
            return conn;
        } catch (Exception e) {
            //se deu erro na hora de conectar
            System.out.println("Erro ao conectar "+ e.getMessage());
            return null;
        }
    }
}
