package Repositorios;
import java.io.*;
import java.util.*;
import Entidades.*;

import javax.swing.*;


public class RepositorioFicheiros {





    //Escrever para ficheiro as informações de cada

    public static void serializarUser() {
        File file = new File("Users.dat");
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Repositorio.getInstance().getUsers());
            out.close();
            fileOut.close();
            System.out.println("Dados serializados guardados no ficheiro: " + file + "\n");
        } catch (IOException ex) {
            System.out.println("Erro ao Serializar: " + ex.getMessage());
        }
    }
    public static void serializarAnimal() {
        File file = new File("Animais.dat");
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Repositorio.getInstance().getAnimais());
            out.close();
            fileOut.close();
            System.out.println("Dados serializados guardados no ficheiro: " + file + "\n");
        } catch (IOException ex) {
            System.out.println("Erro ao Serializar: " + ex.getMessage());
        }
    }
    public static void serializarCliente() {
        File file = new File("Clientes.dat");
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Repositorio.getInstance().getClientes());
            out.close();
            fileOut.close();
            System.out.println("Dados serializados guardados no ficheiro: " + file + "\n");
        } catch (IOException ex) {
            System.out.println("Erro ao Serializar: " + ex.getMessage());
        }
    }
    public static void serializarPrestadorServico() {
        File file = new File("PrestadorServicos.dat");
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Repositorio.getInstance().getPrestadorservicos());
            out.close();
            fileOut.close();
            System.out.println("Dados serializados guardados no ficheiro: " + file + "\n");
        } catch (IOException ex) {
            System.out.println("Erro ao Serializar: " + ex.getMessage());
        }
    }
    public static void serializarLocalidadeEmpresa() {
        File file = new File("LocalidadesEmpresas.dat");
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Repositorio.getInstance().getMapLocalidadeEmpresa());
            out.close();
            fileOut.close();
            System.out.println("Dados serializados guardados no ficheiro: " + file + "\n");
        } catch (IOException ex) {
            System.out.println("Erro ao Serializar: " + ex.getMessage());
        }
    }
    public static void serializarLocalEntrega() {
        File file = new File("LocalEntrega.dat");
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Repositorio.getInstance().getLocalentregas());
            out.close();
            fileOut.close();
            System.out.println("Dados serializados guardados no ficheiro: " + file + "\n");
        } catch (IOException ex) {
            System.out.println("Erro ao Serializar: " + ex.getMessage());
        }
    }
    public static void serializarLocalRecolha() {
        File file = new File("LocalRecolha.dat");
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Repositorio.getInstance().getLocalrecolhas());
            out.close();
            fileOut.close();
            System.out.println("Dados serializados guardados no ficheiro: " + file + "\n");
        } catch (IOException ex) {
            System.out.println("Erro ao Serializar: " + ex.getMessage());
        }
    }
    public static void serializarServico() {
        File file = new File("Servicos.dat");
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Repositorio.getInstance().getServicos());
            out.close();
            fileOut.close();
            System.out.println("Dados serializados guardados no ficheiro: " + file + "\n");
        } catch (IOException ex) {
            System.out.println("Erro ao Serializar: " + ex.getMessage());
        }
    }
    public static void serializarFuncionario() {
        File file = new File("Funcionarios.dat");
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Repositorio.getInstance().getFuncionarios());
            out.close();
            fileOut.close();
            System.out.println("Dados serializados guardados no ficheiro: " + file + "\n");
        } catch (IOException ex) {
            System.out.println("Erro ao Serializar: " + ex.getMessage());
        }
    }
    public static void serializar(){
        serializarUser();
        serializarAnimal();
        serializarCliente();
        serializarPrestadorServico();
        serializarLocalidadeEmpresa();
        serializarLocalEntrega();
        serializarLocalRecolha();
        serializarServico();
        serializarFuncionario();
    }




    //Ler informação dos ficheiros



    public static void desserializarUser() {
        List<User> users = new ArrayList<>();
        try {
            File file = new File("Users.dat");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objInput = new ObjectInputStream(fileIn);
                users = (List<User>)objInput.readObject();
                objInput.close();
            }
        }
        catch(IOException erro) {
            System.out.println("Erro: "+ erro.getMessage());
            return;
        }
        catch(ClassNotFoundException erro2) {
            System.out.println("Erro: "+erro2.getMessage());
            return;
        }

        Repositorio.getInstance().setUsers(users);
    }
    public static void desserializarAnimal() {
        List<Animal> animais = new ArrayList<>();
        try {
            File file = new File("Animais.dat");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objInput = new ObjectInputStream(fileIn);
                animais = (List<Animal>)objInput.readObject();
                objInput.close();
            }
        }
        catch(IOException erro1) {
            System.out.println("Erro: "+ erro1.getMessage());
            return;
        }
        catch(ClassNotFoundException erro) {
            System.out.println("Erro: "+erro.getMessage());
            return;
        }
        Repositorio.getInstance().setAnimais(animais);
    }
    public static void desserializarCliente() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            File file = new File("Clientes.dat");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objInput = new ObjectInputStream(fileIn);
                clientes = (List<Cliente>)objInput.readObject();
                objInput.close();
            }
        }
        catch(IOException erro1) {
            System.out.println("Erro: "+ erro1.getMessage());
            return;
        }
        catch(ClassNotFoundException erro) {
            System.out.println("Erro: "+erro.getMessage());
            return;
        }
        Repositorio.getInstance().setClientes(clientes);
    }
    public static void desserializarPrestadorServico() {
        List<PrestadorServico> prestadorservicos = new ArrayList<>();
        try {
            File file = new File("PrestadorServicos.dat");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objInput = new ObjectInputStream(fileIn);
                prestadorservicos = (List<PrestadorServico>)objInput.readObject();
                objInput.close();
            }
        }
        catch(IOException erro1) {
            System.out.println("Erro: "+ erro1.getMessage());
            return;
        }
        catch(ClassNotFoundException erro) {
            System.out.println("Erro: "+erro.getMessage());
            return;
        }
        Repositorio.getInstance().setPrestadorservicos(prestadorservicos);
    }
    public static void desserializarLocalidadeEmpresa() {
        Map<String,PrestadorServico> mapLocalidadeEmpresa = new HashMap<>();
        try {
            File file = new File("LocalidadesEmpresas.dat");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objInput = new ObjectInputStream(fileIn);
                mapLocalidadeEmpresa = (Map<String,PrestadorServico>)objInput.readObject();
                objInput.close();
            }
        }
        catch(IOException erro1) {
            System.out.println("Erro: "+ erro1.getMessage());
            return;
        }
        catch(ClassNotFoundException erro) {
            System.out.println("Erro: "+erro.getMessage());
            return;
        }
        Repositorio.getInstance().setMapLocalidadeEmpresa(mapLocalidadeEmpresa);
    }
    public static void desserializarLocalEntrega() {
        List<LocalEntrega> localentregas = new ArrayList<>();
        try {
            File file = new File("LocalEntrega.dat");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objInput = new ObjectInputStream(fileIn);
                localentregas = (List<LocalEntrega>)objInput.readObject();
                objInput.close();
            }
        }
        catch(IOException erro1) {
            System.out.println("Erro: "+ erro1.getMessage());
            return;
        }
        catch(ClassNotFoundException erro) {
            System.out.println("Erro: "+erro.getMessage());
            return;
        }
        Repositorio.getInstance().setLocalentregas(localentregas);
    }
    public static void desserializarLocalRecolha() {
        List<LocalRecolha> localrecolhas = new ArrayList<>();
        try {
            File file = new File("LocalRecolha.dat");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objInput = new ObjectInputStream(fileIn);
                localrecolhas = (List<LocalRecolha>)objInput.readObject();
                objInput.close();
            }
        }
        catch(IOException erro1) {
            System.out.println("Erro: "+ erro1.getMessage());
            return;
        }
        catch(ClassNotFoundException erro) {
            System.out.println("Erro: "+erro.getMessage());
            return;
        }
        Repositorio.getInstance().setLocalrecolhas(localrecolhas);
    }
    public static void desserializarServico() {
        List<Servico> servicos = new ArrayList<>();
        try {
            File file = new File("Servicos.dat");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objInput = new ObjectInputStream(fileIn);
                servicos = (List<Servico>)objInput.readObject();
                objInput.close();
            }
        }
        catch(IOException erro1) {
            System.out.println("Erro: "+ erro1.getMessage());
            return;
        }
        catch(ClassNotFoundException erro) {
            System.out.println("Erro: "+erro.getMessage());
            return;
        }
        Repositorio.getInstance().setServicos(servicos);
    }
    public static void desserializarFuncionario() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            File file = new File("Funcionarios.dat");
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objInput = new ObjectInputStream(fileIn);
                funcionarios = (List<Funcionario>)objInput.readObject();
                objInput.close();
            }
        }
        catch(IOException erro1) {
            System.out.println("Erro: "+ erro1.getMessage());
            return;
        }
        catch(ClassNotFoundException erro) {
            System.out.println("Erro: "+erro.getMessage());
            return;
        }
        Repositorio.getInstance().setFuncionarios(funcionarios);
    }

    public static void desserializar(){
        desserializarUser();
        desserializarAnimal();
        desserializarCliente();
        desserializarPrestadorServico();
        desserializarLocalidadeEmpresa();
        desserializarLocalEntrega();
        desserializarLocalRecolha();
        desserializarServico();
        desserializarFuncionario();
    }
}
