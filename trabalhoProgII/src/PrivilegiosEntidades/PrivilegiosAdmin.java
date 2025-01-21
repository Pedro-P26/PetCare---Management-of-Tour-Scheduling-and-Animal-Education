package PrivilegiosEntidades;

import Entidades.PrestadorServico;
import ExceptionMessage.changeinfoException;
import Repositorios.Repositorio;
import Repositorios.RepositorioFicheiros;

public class PrivilegiosAdmin {


    public static void removeprestador(PrestadorServico pre){

        Repositorio.getInstance().getPrestadorservicos().remove(pre);
        Repositorio.getInstance().getLocalidadeprestador().remove(pre);
        RepositorioFicheiros.serializarPrestadorServico();
        RepositorioFicheiros.serializarLocalidadeEmpresa();

    }

    public static void changeinfoprestador(PrestadorServico prestador) throws changeinfoException {

        for(PrestadorServico pre : Repositorio.getInstance().getPrestadorservicos()){
            if(pre.getNome().equals(prestador.getNome())){
                pre.setNome(pre.getNome());
                pre.setMorada(pre.getMorada());
                pre.setTelefone(pre.getTelefone());
                pre.setLocalidade(pre.getLocalidade());
                RepositorioFicheiros.serializarPrestadorServico();
                RepositorioFicheiros.serializarLocalidadeEmpresa();
                return;
            }
        }
        throw new changeinfoException("Erro!!");
    }

    public static PrestadorServico prestadornome(String nome){

        for(PrestadorServico prestador : Repositorio.getInstance().getPrestadorservicos()){
            if(prestador.getNome().equals(nome)){
                return prestador;
            }
        }
        return null;
    }

}
