package inscricao.faces.mngbeans;

import inscricao.entity.Candidato;
import inscricao.entity.Idioma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import utfpr.faces.support.PageBean;

/**
 *
 * @author Wilson
 */
@ManagedBean
@RequestScoped
public class InscricaoBean extends PageBean {
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

    public List<SelectItem> getIdiomaItemList() {
        if (idiomaItemList != null) return idiomaItemList;
        idiomaItemList = new ArrayList<>();
        for (Idioma id: idiomas) {
            idiomaItemList.add(new SelectItem(id.getCodigo(), id.getDescricao()));
        }
        return idiomaItemList;
    }

    public String confirmaAction() {
        candidato.setDataHora(new Date());
        candidato.setIdioma(idiomas[candidato.getIdioma().getCodigo()-1]);
        return "confirma";
    }
}
