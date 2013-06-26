/*
 * === CLASSES DE APOIO JSF ===
 * Este código fonte pode ser livremente copiado, modificado e distribuído,
 * desde que esta mensagem seja preservada.
 * Todo o esforço foi feito para escrever um código correto e eficiente, entretanto o
 * autor não assume qualquer responsabilidade, direta ou indireta sobre a aplicabilidade
 * e/ou adequação a um fim específico e não garante que esteja livre de erros.
 * Copyright (C) 2009 <a href="http://www.utfpr.edu.br">Universidade Tecnológica Federal do Paraná</a>
 */

package utfpr.faces.support;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * Classe base para os beans de aplicação, sessão, request e página.
 * @version 1.0.0
 *
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 * <a href="http://www.utfpr.edu.br">Universidade Tecnológica Federal do Paraná</a>
 */
public class FacesBean implements Serializable {

    private static final Logger logger = Logger.getLogger(PageBean.class.getName());

    /**
     * Retorna o <code>FacesContext</code> corrente.
     * @return O <code>FacesContext</code>
     */
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Retorna o contexto externo de JSF.
     * @return O contexto externo
     */
    public ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }
    
    /**
     * Retorna ou cria uma sessão. 
     * @param create {@code true} para cria uma nova sessão, caso não exista
     * @return A sessão, ou null, caso não exista
     */
    public HttpSession getSession(boolean create) {
        return (HttpSession) getExternalContext().getSession(create);
    }
    
    /**
     * Retorna a sessão atual ou {@code null} caso não exista.
     * @return A sessão existente ou {@code null}
     */
    public HttpSession getSession() {
        return getSession(false);
    }
    
    /**
     * Retorna o contexto do servlet.
     * @return O contexto do servlet
     */
    public ServletContext getServletContext() {
        return (ServletContext) getExternalContext().getContext();
    }

    /**
     * Gera um log de informação com a mensagem especificada.
     * @param message A mensagem
     */
    public void log(String message) {
        logger.log(Level.INFO, message);
    }

    /**
     * Gera um log de erro com a mensagem e exceção especificadas.
     * @param message A mensagem
     * @param t A exceção
     */
    public void log(String message, Throwable t) {
        logger.log(Level.SEVERE, message, t);
    }
}
