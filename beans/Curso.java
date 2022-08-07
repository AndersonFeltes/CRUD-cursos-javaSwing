
package beans;

/**
 *
 * @author ander
 */
public class Curso {
    private int id;
    private String nomeCurso;
    private String nivel;
    private int duracao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    //o método toString é a representação do objeto em String
    //significa que quando um objeto do tipo Cuurso for printado ele imprime o que este método retornar
    @Override
    public String toString(){
      return  this.nomeCurso;
    }
    
    //no método equals define a regra para comparar dois objetos do tipo "Curso"
    //os dois objetos serão iguais se o ID de ambos forem iguais
    @Override
    public boolean equals(Object objeto){
        Curso c = (Curso) objeto;
        if(this.id == c.getId()){
            return true;
        }
        else{
            return false;
        }
    }
}
