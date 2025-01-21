package Entidades;

import java.io.Serial;

public class DonoServico extends User {

    @Serial
    private static final long serialVersionUID = 209134728132L;

    public DonoServico(String username, String password, String nome, int numeroCC, int numeroIF, int telefone, String morada, String localidade) {
        super(username, password, nome, numeroCC, numeroIF, telefone, morada, localidade);
    }

}
