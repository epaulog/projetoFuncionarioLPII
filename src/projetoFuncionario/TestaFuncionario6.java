/*
 * Eden Paulo Gill
 * 
 * Linguagem de Programação II
 * 
 * Exercício Funcionário
 * 
 * Classe TestaFuncionário4
 * 
 * Alteração para o item 1.6
 * 
 */

package projetoFuncionario;

public class TestaFuncionario6 {
    
    public static void main(String [] args){
    	
    	TelaFuncionario.alteraLimiteINSS();
    	TelaFuncionario.imprimeLimiteINSS();
        
        // declaração de duas variaveis do tipo Funcionario
        Funcionario f1, 
                    f2, 
                    f3,
        			f4;
        
        TelaFuncionario telaComum;  //declaraçãoo de uma única tela que será utilizada para cada uma das impressões
        
        
        //Instanciar as duas variaveis criando os objetos
        f1 = new FuncionarioHorista("João da Silva", 'M', "Rua A", 100, "987.654.321-11");
        f2 = new FuncionarioComissionado("Maria Aparecida", 'f', "Av. B", 200, "123.456.789-99");
        f3 = new FuncionarioSalarioFixo("Carlos Xavier", 'M', "Rua C", 300, "111.222.333-44");
        
        f4 = new FuncionarioSalarioFixo();
        
       
        
        ((FuncionarioHorista)f1).setSalarioPorHora(50f);
        ((FuncionarioHorista)f1).setHorasTrabalhadas(200f);
        
        ((FuncionarioComissionado)f2).setSalarioBase(1000f);
        ((FuncionarioComissionado)f2).setValorVendas(50000f);
        ((FuncionarioComissionado)f2).setPorcentagemComissao(1f);
        
        ((FuncionarioSalarioFixo)f3).setSalario(1000f);
        
        telaComum = new TelaFuncionario(f4);
        telaComum.leDados(f4);
        
       

        telaComum.setFuncionario(f1);
        telaComum.mostraDados(f1);
                
        telaComum.setFuncionario(f2);
        telaComum.mostraDados(f2);

        telaComum.setFuncionario(f3);
        telaComum.mostraDados(f3);
        
        telaComum.setFuncionario(f4);
        telaComum.mostraDados(f4);
        
        
    }//main()

}//class TestaFuncionario
