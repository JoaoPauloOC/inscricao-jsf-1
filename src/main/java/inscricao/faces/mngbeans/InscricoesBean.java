/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.entity.Candidato;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import utfpr.faces.support.PageBean;

/**
 *
 * @author a1151185
 */
@ManagedBean
@ApplicationScoped
public class InscricoesBean  extends PageBean {

    private ArrayList<Candidato> candidatos;
    private ListDataModel<Candidato> candidatoDataModel;
    
    /**
     * Creates a new instance of InscricoesBean
     */
    public InscricoesBean() {
        candidatos = new ArrayList<Candidato>();
        candidatoDataModel = new ListDataModel<>(candidatos);
    }

    public ListDataModel<Candidato> getCandidatoDataModel() {
        return candidatoDataModel;
    }
    
    public void adicionar(Candidato c){
        candidatos.add(c);
    }
    
    public boolean existeCpf(long cpf){
        for(Candidato c: candidatos){
            if(c.getCpf()==cpf){
                return true;
            }
        }
        return false;
    }
   
    public Candidato getCandidato(long cpf){
        for(Candidato c: candidatos){
            if(c.getCpf()==cpf){
                return c;
            }
        }
        return null;
    }
    
    public void excluirAction() {
        Candidato c = candidatoDataModel.getRowData();
        candidatos.remove(c);
    }
    
    public String editarAction() {
        Candidato c = candidatoDataModel.getRowData();
        InscricaoBean ins = (InscricaoBean) getBean("inscricaoBean");
        ins.setAlteracao(true);
        ins.setTexto("Alterar inscrição");
        ins.setCandidato(c);
        return "inscricao";
    }
    
}
