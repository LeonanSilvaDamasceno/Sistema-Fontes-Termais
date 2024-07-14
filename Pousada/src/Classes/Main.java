package Classes;

import DAO.ClienteDAO;

public class Main{
    public static void main (String [] args){
        /*Cliente cl = new Cliente("Teste", "12345678912", "eu.teste@gmail.com", 101, 15);

        ClienteDAO dao = new ClienteDAO();
        dao.cadastrarCliente(cl);*/
        
    	Frame fr = new Frame();
    	fr.cadastroCliente();
    	//fr.login(null);
    	
    }
}
