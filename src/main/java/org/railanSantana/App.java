package org.railanSantana;

import org.railanSantana.DAO.UserDAO;
import org.railanSantana.model.User;

public class App 
{
    public static void main( String[] args )
    {

        UserDAO userDAO = new UserDAO();
        //userDAO.insert(new User("Tchelo", "etapas@etus.com"));
        System.out.println(userDAO.getAll());
    }
}
