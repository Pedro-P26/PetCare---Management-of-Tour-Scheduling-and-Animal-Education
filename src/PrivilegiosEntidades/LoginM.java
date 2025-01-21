package PrivilegiosEntidades;

import java.util.List;
import Entidades.User;
import ExceptionMessage.ExisteUserException;
import Repositorios.Repositorio;

public class LoginM {
    public LoginM() {}

    public User Login(String username, String password) throws ExisteUserException {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        List<User> users = Repositorio.getInstance().getUsers();

        for (User u : users) {
            if (newUser.getUsername().equals(u.getUsername()) && newUser.getPassword().equals(u.getPassword())) {
                Repositorio.getInstance().setIniUser(u);
                return u;
            }
        }
        throw new ExisteUserException("Login failed!");
    }
}
