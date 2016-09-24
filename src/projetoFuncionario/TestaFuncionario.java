package projetoFuncionario;

public class TestaFuncionario {
    
    public static void main(String [] args){
        
        // declaração de duas variaveis do tipo Funcionario
        Funcionario f1, 
                    f2, 
                    f3;
        
        TelaFuncionario telaComum;  //declaraçãoo de um única tela que será utilizada para cada uma das impressoes
        
        
        //Instanciar as duas variaveis criando os objetos
        f1 = new Funcionario("João da Silva", 'M', "Rua A", 100, "987.654.321-11", 2000);
        f2 = new Funcionario("Maria Aparecida", 'f', "Av. B", 200, "123.456.789-99", 20000);
        f3 = new Funcionario();
        
        telaComum = new TelaFuncionario(f1);
        
        telaComum.imprimeFuncionario();
        telaComum.imprimeSalario();
                
        telaComum.setFuncionario(f2);

        telaComum.imprimeFuncionario();
        telaComum.imprimeSalario();

        telaComum.setFuncionario(f3);
        telaComum.leNome();
        telaComum.leSexo();
        telaComum.leEndereco();
        telaComum.leCPF();
        telaComum.leSalarioBruto();
        
        if (f3.equals(f1)) { 
        	System.out.println("Dados iguais ao funcionário 1");
        }	
        if (f3.equals(f2)) {
        	System.out.println("Dados iguais ao funcionário 2");
        }

        telaComum.imprimeFuncionario();
        telaComum.imprimeEndereco();
        telaComum.imprimeSalario();

        
        
        telaComum.setFuncionario(f1);
        telaComum.imprimeFuncionario();
        telaComum.imprimeSalario();
                
        telaComum.setFuncionario(f2);
        telaComum.imprimeFuncionario();
        telaComum.imprimeSalario();

        telaComum.setFuncionario(f3);
        telaComum.imprimeFuncionario();
        telaComum.imprimeSalario();
        
    }//main()

}//class TestaFuncionario
