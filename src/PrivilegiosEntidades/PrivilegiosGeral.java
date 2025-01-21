package PrivilegiosEntidades;

import Entidades.User;
import ExceptionMessage.ExisteUserException;
import Repositorios.Repositorio;
import Repositorios.RepositorioFicheiros;

public class PrivilegiosGeral {

    public static void adicionarUser(User newuser) throws ExisteUserException {
        boolean existe = false;

        for (User user : Repositorio.getInstance().getUsers()) {
            if (user.getUsername().equals(newuser.getUsername()) && user.getNumeroIF() == newuser.getNumeroIF()) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            Repositorio.getInstance().getUsers().add(newuser);
            RepositorioFicheiros.serializarUser();
        } else {
            throw new ExisteUserException("Impossível adicionar User!");
        }
    }
}