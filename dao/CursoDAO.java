
package dao;

import beans.Curso;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ander
 */
public class CursoDAO {
    private Conexao conexao;
    private Connection conn;
    
    //criando o construtor da classe. O construtor é executado automaticamente sempre que um novo objeto é criado
    //CursoDAO cursoDAO = new CursoDAO();
    public CursoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Curso curso){
        
        String sql = "INSERT INTO cursos (nomecurso, nivel, duracao) VALUES "
                +"(?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setString(2, curso.getNivel());
            stmt.setInt(3, curso.getDuracao());
            stmt.execute();
        } 
        catch (Exception e) {
            System.out.println("ERRO AO INSERIR O CURSO: "+e.getMessage());
        }
    }
    
    public void editar(Curso curso){
        String sql = "UPDATE cursos SET nomecurso=?, nivel=?, duracao=? WHERE id=?";
        try {
           PreparedStatement stmt = this.conn.prepareStatement(sql);
           stmt.setString(1, curso.getNomeCurso());
           stmt.setString(2, curso.getNivel());
           stmt.setInt(3, curso.getDuracao());
           stmt.setInt(4, curso.getId());
           stmt.execute();
        } 
        catch (Exception e){
            System.out.println("ERRO ao editar o curso: "+e.getMessage());
        }
    }
    
    public void excluir(int id){
        String sql = "DELETE FROM cursos WHERE id=?";
        try {
            PreparedStatement stmt  = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } 
        catch (Exception e) {
            System.out.println("ERRO AO EXCLUIR CURSO: "+e.getMessage());
        }
    }
    
    public Curso getCurso(int id){
        String sql = "SELECT * FROM cursos WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Curso curso = new Curso();
            //primeiro posiciona o rs na primeira posicao
            rs.first();
            curso.setId(id);
            //passando o nome da coluna do curso para pegar a informação
            curso.setNomeCurso(rs.getString("nomecurso"));
            curso.setNivel(rs.getString("nivel"));
            curso.setDuracao(rs.getInt("duracao"));
            return curso;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public List<Curso> getCursos(String nomecurso){
        String sql = "SELECT * FROM cursos WHERE nomecurso LIKE ?";
        try {
           PreparedStatement stmt = this.conn.prepareStatement(sql);
           stmt.setString(1, "%"+nomecurso+"%");
           ResultSet rs = stmt.executeQuery();
           List<Curso> listaCursos = new ArrayList<>();
           //percorre o "rs" e salva as informações dentro de uma variavel "Curso"
           //depois salva essa variavel dentro da lista
           while(rs.next()){
               Curso curso = new Curso();
               curso.setId(rs.getInt("id"));
               curso.setNomeCurso(rs.getString("nomecurso"));
               curso.setNivel(rs.getString("nivel"));
               curso.setDuracao(rs.getInt("duracao"));
               listaCursos.add(curso);
           }
           return listaCursos;
        }
        catch (Exception e) {
            return null;
        }
    }
}
