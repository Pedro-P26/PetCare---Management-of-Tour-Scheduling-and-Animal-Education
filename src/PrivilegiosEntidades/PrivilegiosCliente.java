package PrivilegiosEntidades;
import Entidades.Animal;
import Entidades.Cliente;
import Entidades.Servico;
import Enumerados.StatusServico;
import ExceptionMessage.ExisteAnimalException;
import ExceptionMessage.ServicoException;
import Repositorios.*;

import java.util.Date;
import java.util.List;

public class PrivilegiosCliente {

   public static void adicionarAnimal(Animal newAnimal, List<Animal> animais) throws ExisteAnimalException {
        boolean existe = false;

        for(Animal ani : animais){
            if(newAnimal.getNchip() == ani.getNchip()){
                existe = true;
                break;
            }
        }
        if(existe){
            throw new ExisteAnimalException("Impossível adicionar Animal!");
        }else {
            animais.add(newAnimal);
            RepositorioFicheiros.serializarAnimal();
        }
   }

   public static void adicionarservico(Servico servico) throws ServicoException{
        boolean existe = false;

        for(Servico ser : Repositorio.getInstance().getServicos()){
            if (ser.getNomeprestador().equals(servico.getNomeprestador())){
                if(ser.getDataservico().equals(servico.getDataservico())) {
                existe = true;
                break;
                }
            }
        }

        if(!existe){
            Repositorio.getInstance().getServicos().add(servico);
            RepositorioFicheiros.serializarServico();
            //throw new ServicoException("Impossivel marcar Servico!");
        }else{
            throw new ServicoException("Impossivel marcar Servico!");

        }
   }



   public static Servico escolherconsultarpagamento (int nchip){

       for(Servico s : Repositorio.getInstance().getServicos()){
           if(s.getNchip() == nchip && s.getStatusservico().equals(StatusServico.EFETUADA)){
               return s;
           }
       }
       return null;
   }

   public static void pagamentoefetuado (Servico s){

       for(Servico ser : Repositorio.getInstance().getServicos()){
           if(ser.equals(s)){
               ser.setStatusservico(StatusServico.CONCLUIDA);
               ser.setDatapagamento(new Date());
           }
       }
       RepositorioFicheiros.serializarServico();
   }



}
