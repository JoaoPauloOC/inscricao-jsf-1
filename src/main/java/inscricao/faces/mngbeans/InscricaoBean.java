package inscricao.faces.mngbeans;

import inscricao.entity.Candidato;
import inscricao.entity.Idioma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import utfpr.faces.support.PageBean;

/**
 *
 * @author Wilson
 */
@ManagedBean
@SessionScoped
public class InscricaoBean extends PageBean {

    private boolean alteracao = false;
    private String texto = "Confirmar inscrição";
    private static final Idioma[] idiomas = {
        new Idioma(1, "Inglês"),
        new Idioma(2, "Alemão"),
        new Idioma(3, "Francês")
    };
    private Candidato candidato = new Candidato(idiomas[0]); // inicialmente ingles
    private List<SelectItem> idiomaItemList;

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public boolean isAlteracao() {
        return alteracao;
    }

    public void setAlteracao(boolean alteracao) {
        this.alteracao = alteracao;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<SelectItem> getIdiomaItemList() {
        if (idiomaItemList != null) return idiomaItemList;
        idiomaItemList = new ArrayList<>();
        for (Idioma id: idiomas) {
            idiomaItemList.add(new SelectItem(id.getCodigo(), id.getDescricao()));
        }
        return idiomaItemList;
    }

    public String confirmaAction() {
        if(alteracao){
            alteracao = false;
            texto = "Confirmar inscrição";
            candidato.setDataHora(new Date());
            candidato.setIdioma(idiomas[candidato.getIdioma().getCodigo()-1]);
            return "confirma";
        } else {
            InscricoesBean ins = (InscricoesBean) getBean("inscricoesBean");
            if(ins.existeCpf(candidato.getCpf())){
                error("Cpf já encontrado!");
                return null;
            }
            ins.adicionar(candidato);
            candidato.setDataHora(new Date());
            candidato.setIdioma(idiomas[candidato.getIdioma().getCodigo()-1]);
            return "confirma";
        }
    }
    
    public String alteraAction(){
        alteracao = true;
        texto = "Alterar inscrição";
        return "inscricao";
    }
    
    public String voltaAction(){
        candidato = new Candidato(idiomas[0]);
        return "inscricao";
    }
    
    public String novaInscricaoAction(){
        candidato = new Candidato(idiomas[0]);
        alteracao = false;
        texto = "Confirmar inscrição";
        return "inscricao";
    }
    
}
