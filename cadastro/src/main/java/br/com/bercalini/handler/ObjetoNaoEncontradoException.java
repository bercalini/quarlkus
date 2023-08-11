package br.com.bercalini.handler;

import java.io.Serializable;

public class ObjetoNaoEncontradoException extends RuntimeException  implements Serializable {

    private static final long serialVersionUID = 1L;

    public ObjetoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
