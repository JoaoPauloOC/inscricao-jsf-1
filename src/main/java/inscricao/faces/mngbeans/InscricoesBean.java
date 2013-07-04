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
import utfpr.faces.support.PageBean;

/**
 *
 * @author a1151185
 */
@ManagedBean
@ApplicationScoped
public class InscricoesBean  {

    private ArrayList<Candidato> candidatos;
    
    /**
     * Creates a new instance of InscricoesBean
     */
    public InscricoesBean() {
        candidatos = new ArrayList<Candidato>();
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
    
}
