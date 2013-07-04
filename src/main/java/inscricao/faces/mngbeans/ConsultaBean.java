/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.entity.Candidato;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utfpr.faces.support.PageBean;

/**
 *
 * @author a1151185
 */
@ManagedBean
@RequestScoped
public class ConsultaBean extends PageBean {

    private long cpf;
    
    /**
     * Creates a new instance of ConsultaBean
     */
    public ConsultaBean() {
    }
    
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    public String enviaAction(){
        InscricoesBean ins = (InscricoesBean) getBean("inscricoesBean");
        Candidato c = ins.getCandidato(cpf);
        if(c!=null){
            InscricaoBean ins2 = (InscricaoBean) getBean("inscricaoBean");
            ins2.setCandidato(c);
            ins2.setAlteracao(true);
            ins2.setTexto("Alterar inscrição");
            return "inscricao";
        }
        return null;
    }
    
}
