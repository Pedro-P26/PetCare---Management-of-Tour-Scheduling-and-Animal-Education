package Repositorios;

import java.io.FileOutputStream;
import java.util.*;
import java.io.*;

import Entidades.*;

public class Repositorio implements Serializable {
    private static volatile Repositorio singleinstance;
    //volatile é usado para que as alteraços feitas por uma thread sejam visiveis para outras threads
    private List<Animal> animais;
    private List<Admin> admins;
    private List<Cliente> clientes;
    private List<User> users;
    private User iniUser;
    private List<Funcionario> funcionarios;
    private List<LocalEntrega> localentregas;
    private List<LocalRecolha> localrecolhas;
    private List<PrestadorServico> prestadorservicos;
    private List<Servico> servicos;
    private Map<String, PrestadorServico> localidadeprestador;
    private Map<Integer, PrestadorServico> mapPrestadorEmpresa;
    private Map<PrestadorServico, List<LocalRecolha>> mapEmpresaLocalRecolha;
    private Map<PrestadorServico, List<LocalEntrega>> mapEmpresaLocalEntrega;

    private Repositorio() {
        servicos = new ArrayList<>();
        prestadorservicos = new ArrayList<>();
        localrecolhas = new ArrayList<>();
        localentregas = new ArrayList<>();
        animais = new ArrayList<>();
        admins = new ArrayList<>();
        clientes = new ArrayList<>();
        users = new ArrayList<>();
        funcionarios = new ArrayList<>();
        localidadeprestador = new HashMap<>();
        mapPrestadorEmpresa = new HashMap<>();
        mapEmpresaLocalRecolha = new HashMap<>();
        mapEmpresaLocalEntrega = new HashMap<>();

    }

    public static Repositorio getInstance() {
        if (singleinstance == null) {
            synchronized (Repositorio.class) {
                if (singleinstance == null) {
                    singleinstance = new Repositorio();
                }
            }
        }
        return singleinstance;
    }

    /*
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }*/

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<LocalRecolha> getLocalrecolhas() {
        return localrecolhas;
    }

    public void setLocalrecolhas(List<LocalRecolha> localrecolhas) {
        this.localrecolhas = localrecolhas;
    }

/* public List<LocalRecolha> getLocalrecolhas() {
        return localrecolhas;
    }

    public void setLocalrecolhas(List<LocalRecolha> localrecolhas) {
        this.localrecolhas = localrecolhas;
    }*/

    public List<LocalEntrega> getLocalentregas() {
        return localentregas;
    }

    public void setLocalentregas(List<LocalEntrega> localentregas) {
        this.localentregas = localentregas;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getIniUser() {
        return iniUser;
    }

    public void setIniUser(User iniUser) {
        this.iniUser = iniUser;
    }

    public Map<String, PrestadorServico> getLocalidadeprestador() {
        return localidadeprestador;
    }

    public void setMapLocalidadeEmpresa(Map<String, PrestadorServico> localidadeprestador) {
        this.localidadeprestador = localidadeprestador;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Map<String, PrestadorServico> getMapLocalidadeEmpresa() {
        return localidadeprestador;
    }

    public Map<Integer, PrestadorServico> getMapPrestadorEmpresa() {

        return mapPrestadorEmpresa;
    }

    public Map<PrestadorServico, List<LocalRecolha>> getMapEmpresaLocalRecolha() {
        return mapEmpresaLocalRecolha;
    }

    public Map<PrestadorServico, List<LocalEntrega>> getMapEmpresaLocalEntrega() {
        return mapEmpresaLocalEntrega;
    }

    public List<PrestadorServico> getPrestadorservicos() {
        return prestadorservicos;
    }

    public void setPrestadorservicos(List<PrestadorServico> prestadorservicos) {
        this.prestadorservicos = prestadorservicos;
    }
}




