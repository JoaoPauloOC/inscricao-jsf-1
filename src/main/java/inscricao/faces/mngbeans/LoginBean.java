/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author a1151185
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private String login;
    private String senha;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String confirmaAction() {
        if(login.equals("admin") && senha.equals("admin")){
            return "inscricao";
        }
        return null;
    }
    
}
