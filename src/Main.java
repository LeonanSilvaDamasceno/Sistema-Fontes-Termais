import Classes.Funcionario;
import DAO.ChamadoDAO;
import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import Swing.*;

public class Main{
    public static void main (String [] args){
       // Frame.initializer();
        
      // Instanciação da classe que contém o método de remoção
      /* FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
      
      

     String nome = "Luis";
      String email ="luishenrique9863@gmail.com";
      float salario = 150;
      String cargo = "Camaleao";
      String cpf = "123456789";
      funcionarioDAO.atualizarFunci(cpf,nome,email,salario,cargo);

      ChamadoDAO dao = new ChamadoDAO();
      dao.procurarChamado(2);
*/
      ClienteDAO clienteDAO = new ClienteDAO();
      clienteDAO.procurarCliente("70050305166");
      
    }
}
