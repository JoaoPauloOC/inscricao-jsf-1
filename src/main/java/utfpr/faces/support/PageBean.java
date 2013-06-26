/*
 * EXEMPLOS
 */
package utfpr.faces.support;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * Classe base dos managed beans de páginas JSF.
 * @author Wilson
 */
public class PageBean extends FacesBean {

    /**
     * Retorna um managed bean dado o seu nome
     * @return O bean de aplicação
     */
    public Object getBean(String name) {
        return getFacesContext().getApplication().evaluateExpressionGet(
            FacesContext.getCurrentInstance(), "#{" + name +  "}", Object.class);
    }

    /**
     * Gera uma mensagem de informação associada a um componente.
     * @param component O componente
     * @param message A mensagem
     */
    public void info(UIComponent component, String message) {
        getFacesContext().addMessage(component.getClientId(getFacesContext()),
            new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    /**
     * Gera uma mensagem de informação não associada a um componente.
     * @param message O <i>summary</i> da mensagem
     */
    public void info(String message) {
        getFacesContext().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    /**
     * Gera uma mensagem de advertência associada a um componente.
     * @param component O componente
     * @param message A mensagem
     */
    public void warn(UIComponent component, String message) {
        getFacesContext().addMessage(component.getClientId(getFacesContext()),
            new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
    }

    /**
     * Gera uma mensagem de advertência não associada a um componente.
     * @param message O <i>summary</i> da mensagem
     */
    public void warn(String message) {
        getFacesContext().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
    }

    /**
     * Gera uma mensagem de erro associada a um componente.
     * @param component O componente
     * @param message A mensagem
     */
    public void error(UIComponent component, String message) {
        getFacesContext().addMessage(component.getClientId(getFacesContext()),
            new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    /**
     * Gera uma mensagem de erro não associada a um componente.
     * @param message <i>summary</i> da mensagem
     */
    public void error(String message) {
        getFacesContext().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
}
