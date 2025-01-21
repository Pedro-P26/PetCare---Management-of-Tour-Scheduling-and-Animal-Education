package Entidades;

public class Admin extends User{

    private static final long serialVersionUID = 1178312435136L;

    public Admin(String username, String password,String nome, int numeroCC, int numeroIF, int telefone, String morada, String localidade) {
        super(username,password,nome,numeroCC,numeroIF,telefone,morada,localidade);
    }
}
