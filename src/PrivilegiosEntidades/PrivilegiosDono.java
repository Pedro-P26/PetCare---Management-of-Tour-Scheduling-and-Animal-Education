package PrivilegiosEntidades;

import Entidades.*;
import Enumerados.StatusServico;
import ExceptionMessage.*;

import java.sql.Time;
import java.util.List;
import java.util.Map;

import Repositorios.*;

public class PrivilegiosDono {

    public static void AdicionarEmpresa(PrestadorServico prestadorservico, List<PrestadorServico> prestadorservicos,Map<String,PrestadorServico>localidadeprestador) throws ExisteException {

        for (PrestadorServico p : prestadorservicos) {
            if (prestadorservico.getNome().equals(p.getNome()) || prestadorservico.getMorada().equals(p.getMorada()) || localidadeprestador.containsKey(prestadorservico)) {
                throw new ExisteException("ERRO campos iguais");
            }
        }

        prestadorservicos.add(prestadorservico);
        addmapLocalidadeEmpresa(localidadeprestador,prestadorservico);
        RepositorioFicheiros.serializarPrestadorServico();
        RepositorioFicheiros.serializarLocalidadeEmpresa();

    }


    //Adicionar funcionario como registar o local entrega

    public static void adicionarfuncionario(Funcionario funcionario, List<Funcionario> funcionarios ) throws ExisteFuncionarioException{


        for(Funcionario f : funcionarios){
            if(funcionario.getNumeroIF()==f.getNumeroIF() || funcionario.getNumeroCC()==f.getNumeroCC()){
                throw new ExisteFuncionarioException("ERRO campos iguais!!");
            }
        }
        funcionarios.add(funcionario);
        RepositorioFicheiros.serializarFuncionario();


    }



   public static void AdicionarLocalEntrega(LocalEntrega localentrega, List<LocalEntrega> localentregas) throws LocalEntregaException {

        for(LocalEntrega l : localentregas){
            if(localentrega.getLocalidade().equals(l.getLocalidade()) || localentrega.getTelefone() == l.getTelefone()){
                throw new LocalEntregaException("ERRO campos iguais!");
            }
        }
        localentregas.add(localentrega);
        RepositorioFicheiros.serializarLocalEntrega();


    }
  public static void AdicionarLocalRecolha(LocalRecolha localrecolha, List<LocalRecolha> localrecolhas) throws localrecolhaException {

        for(LocalRecolha r : localrecolhas){
            if(localrecolha.getLocalidade().equals(r.getLocalidade()) || localrecolha.getTelefone() == r.getTelefone()){
                throw new localrecolhaException("ERRO campos iguais!");
            }
        }
        localrecolhas.add(localrecolha);
        RepositorioFicheiros.serializarLocalRecolha();


    }


    public static void RemoverEmpresa(PrestadorServico prestadorservico, List<PrestadorServico> prestadorservicos) throws RemoverException {
        boolean existe = false;

        for (PrestadorServico p : prestadorservicos) {
            if (p.equals(prestadorservico)) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            throw new RemoverException("Empresa não identificada");
        } else {
            prestadorservicos.remove(prestadorservico);
        }
    }
///Associar localidade a Prestador
    public static void addmapLocalidadeEmpresa(Map<String,PrestadorServico>localidadeprestador,PrestadorServico prestadorservico){
        localidadeprestador.put(prestadorservico.getLocalidade(), prestadorservico);
    }
    public static void addMapDonoPrestadorservico(Map<String,PrestadorServico>donoprestador,PrestadorServico prestadorservico){
        donoprestador.put(prestadorservico.getDono(),prestadorservico);
    }

    public static void mapprestadorlistarecolha(Map<String,List<LocalRecolha>> MapEmpresaLocalRecolha, PrestadorServico prestadorservico){
        MapEmpresaLocalRecolha.put(prestadorservico.getNome(), (List<LocalRecolha>) prestadorservico);
    }

    public static PrestadorServico escolherprestador(String nomepre){

        for(PrestadorServico prestador : Repositorio.getInstance().getPrestadorservicos()){
            if(prestador.getNome().equals(nomepre)){
                return prestador;
            }
        }
        return null;
    }

    public static LocalEntrega escolherlocalentrega(int telefone){

        for(LocalEntrega le : Repositorio.getInstance().getLocalentregas()){
            if(le.getTelefone() == telefone){
                return le;
            }
        }
        return null;
    }
    public static LocalRecolha escolherlocalrecolha(int telefone){

        for (LocalRecolha re : Repositorio.getInstance().getLocalrecolhas()){
            if (re.getTelefone() == telefone){
                return re;
            }
        }
        return null;
    }

    public static Funcionario escolherniffuncioanrio_prestador(int nif, PrestadorServico nomepre){

        /*for(User u : Repositorio.getInstance().getUsers()){
            if(u instanceof Funcionario && ((Funcionario)u).getNomeprestador().equals(nomepre) && u.getNumeroIF() == nif){
                return (Funcionario) u;
            }
        }
        return null;*/
        for (Funcionario fun : Repositorio.getInstance().getFuncionarios()){
            if(fun.getNomeprestador().equals(nomepre) && fun.getNumeroIF()==nif){
                return fun;
            }
        }
        return null;
    }

    public static Servico escolheranimal_prestador(int nchip, String nomepre){

        for (Servico ser :Repositorio.getInstance().getServicos()){
            if(ser.getNchip()==nchip && ser.getNomeprestador().equals(nomepre)){
                return ser;
            }
        }
        return null;
    }

    public static void RemoverFuncionario(int Nif,int NumCC) throws ExisteUserException{

        for(User u: Repositorio.getInstance().getUsers()){
            if(u instanceof Funcionario && u.getNumeroIF()==Nif && u.getNumeroCC()==NumCC){
                Repositorio.getInstance().getUsers().remove(u);
                RepositorioFicheiros.serializarUser();

                return;
            }
        }
        throw new ExisteUserException("Não existe o respetivo funcionario");
    }
    public static void removeuser(User user){
        Repositorio.getInstance().getUsers().remove(user);
    }

    public static void removefun(Funcionario funcionario){
        
    }

    public static void changeinfoprestador(PrestadorServico prestadorservico) throws changeinfoException {

        for(PrestadorServico pre : Repositorio.getInstance().getPrestadorservicos()){
            if(pre.getNome().equals(prestadorservico.getNome())){
                pre.setLocalidade(pre.getLocalidade());
                pre.setNome(pre.getNome());
                pre.setMorada(pre.getMorada());
                pre.setTelefone(pre.getTelefone());
                RepositorioFicheiros.serializarPrestadorServico();
                RepositorioFicheiros.serializarLocalidadeEmpresa();


                return;
            }
        }
        throw new changeinfoException("Impossível alterar info desse prestador de servico!!");
    }

    public static void changeinfofuncionario(Funcionario fun) throws changeinfoException{
        for( User user : Repositorio.getInstance().getUsers()){
            if(user instanceof Funcionario && user.getNumeroIF() == fun.getNumeroIF()){
                user.setNome(fun.getNome());
                user.setMorada(fun.getMorada());
                user.setUsername(fun.getUsername());
                user.setPassword(fun.getPassword());
                user.setTelefone(fun.getTelefone());
                user.setNumeroCC(fun.getNumeroCC());
                user.setLocalidade(fun.getLocalidade());
                ((Funcionario)user).setProfissao(fun.getProfissao());
                ((Funcionario) user).setSalario(fun.getSalario());
                ((Funcionario)user).setHoratioini((Time) fun.getHoratioini());
                ((Funcionario)user).setHorariofim((Time) fun.getHorariofim());

                RepositorioFicheiros.serializarUser();
                return;
            }
        }
        throw new changeinfoException("NIF inválido!!");
    }
    public static Funcionario selecionarfunnif(int nif){

        for(User user : Repositorio.getInstance().getUsers()){
            if(user instanceof Funcionario && user.getNumeroIF()==nif){
                return (Funcionario) user;
            }
        }
        return null;
    }

    public static void alterarinfolocalentrega(LocalEntrega entrega) throws changeinfoException{

        for(LocalEntrega en : Repositorio.getInstance().getLocalentregas()){
            if(en.getNomeprestador().equals(entrega.getNomeprestador())){
                en.setMorada(en.getMorada());
                en.setLocalidade(en.getLocalidade());
                en.setTelefone(en.getTelefone());
                en.setNomeprestador(en.getNomeprestador());
                //en.setTiposervico(en.getTiposervico());

                RepositorioFicheiros.serializarLocalEntrega();
                return;
            }
        }
        throw new changeinfoException("Impossível");
    }

    public static void alterarinfolocalrecolha(LocalRecolha recolha) throws changeinfoException{

        for(LocalRecolha re : Repositorio.getInstance().getLocalrecolhas()){
            if(re.getNomeprestador().equals(recolha.getNomeprestador())){
                re.setMorada(re.getMorada());
                re.setLocalidade(re.getLocalidade());
                re.setTelefone(re.getTelefone());
                re.setNomeprestador(re.getNomeprestador());
                //re.setTiposervico(re.getTiposervico());

                RepositorioFicheiros.serializarLocalRecolha();
                return;
            }
        }
        throw new changeinfoException("Impossível");
    }

    public static void alterarservico(StatusServico stat , String cliente){

        for(Servico ser : Repositorio.getInstance().getServicos()){
            if(ser.getUsercliente().equals(cliente)){
                ser.getStatusservico(stat);
                RepositorioFicheiros.serializarServico();

            }
        }
    }
}
