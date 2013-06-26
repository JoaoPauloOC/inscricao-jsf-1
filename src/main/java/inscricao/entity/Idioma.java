/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.entity;

import java.io.Serializable;

/**
 *
 * @author Wilson
 */
public class Idioma implements Serializable {
    private Integer codigo;
    private String descricao;

    public Idioma() {
    }

    public Idioma(Integer codigo) {
        this.codigo = codigo;
    }

    public Idioma(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
