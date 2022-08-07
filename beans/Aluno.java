
package beans;

/**
 *
 * @author ander
 */
public class Aluno {
    private int id;
    private String nomeAluno;
    private Curso cursoid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Curso getCursoid() {
        return cursoid;
    }

    public void setCursoid(Curso cursoid) {
        this.cursoid = cursoid;
    }
    
    
}
