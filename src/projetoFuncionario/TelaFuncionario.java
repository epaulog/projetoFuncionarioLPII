/*
 * Eden Paulo Gill
 * 
 * Linguagem de Programação II
 * 
 * Exercício Funcionário
 * 
 * Classe TelaFuncionário
 * 
 * 
 */

package projetoFuncionario;

import java.util.Scanner;

public class TelaFuncionario {
    
    //Atributo que mantem uma referencia
    private Funcionario funcionario;
    
    //Atributo para fazer leitura pelo teclado.
    protected static Scanner input = new Scanner(System.in);

    
    public TelaFuncionario(Funcionario f){
        this.setFuncionario(f);
    }//TelaFuncionario
    
    public void setFuncionario(Funcionario f){
        if (f != null){
            this.funcionario = f;
        }
        else {
            throw new RuntimeException("Erro: Funcinário null.");
        }
    }//setFuncionario()
    
    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void leNome(){
        System.out.print("Digite o Nome: ");
        this.funcionario.setNome( input.nextLine() );
    }//leNome()
    
    public void leSexo(){
        System.out.print("Digite o Sexo: ");
        this.funcionario.setSexo( input.nextLine().charAt(0));
    }//leSexo()
    
    public void leEndereco(){
        String rua;
        int num;
        System.out.println("Digite a Rua: ");
        rua = input.nextLine();
        System.out.println("Digite o número: ");
        num = input.nextInt();
        input.nextLine();
        
//        Endereco e = new Endereco(rua, num);
        this.funcionario.setEndereco(rua, num);
    }
    
    public void leCPF(){
        System.out.print("Digite o CPF: ");
        this.funcionario.setCPF( input.nextLine() );
    }//leCPF()
    
    public void leSalarioBruto(){
        double sal = 0;
        System.out.print("Digite o Salário: ");
        while (sal <=0){
            sal = input.nextDouble();
            if (sal <= 0 ){
                System.out.println("O Salário deve ser diferente de 0 e positivo\nDigite o Salário: ");
            }
        }
        input.nextLine(); //pega os caracteres extras limpando o buffer de teclado
        this.funcionario.setSalario(sal);
    }

    public void imprimeFuncionario(){
        System.out.println("-------------------------------------");
        System.out.println("--  Dados do Funcionário  -----------");
        System.out.println("-");
        System.out.println("- Nome: " + funcionario.getNome());
        System.out.println("- Sexo: " + funcionario.getSexo());
        System.out.println("- CPF : " + funcionario.getCPF());
        System.out.println("-------------------------------------");
        
    }//imprimeFuncionario()
    
    public void imprimeSalario(){
        System.out.println("--  Salário  ------------------------");
        System.out.printf ("- Salário Bruto\t\t= %#9.2f\n",funcionario.getSalarioBruto());
        
        if (funcionario.valorINSS() < funcionario.getLimiteINSS())
            System.out.printf("- INSS (%#3.2f%%)\t\t= %#9.2f\n", funcionario.txINSS(), funcionario.valorINSS());

        else
            System.out.printf("- INSS (%#3.2f%% -> teto)\t= %#9.2f\n", funcionario.txINSS(), funcionario.valorINSS());
        
        System.out.println("-                         ---------");
        System.out.printf ("- Salário Base IR\t= %#9.2f\n", funcionario.salarioBaseIR());
        System.out.printf ("- IR (%#3.2f%%)\t\t= %#9.2f\n", funcionario.txIR(), funcionario.valorIR());
        System.out.println("-                         ---------");
        System.out.printf ("- Salário Líquido\t= %#9.2f\n", funcionario.salarioLiquido());
        System.out.println("-");
        System.out.println("-------------------------------------");
        System.out.println("");
    }//imprimeSalario()
    
    public void imprimeEndereco(){
        System.out.println("-- Endereço -------------------------");
        System.out.println("- Rua: " + funcionario.getEndereco());
        System.out.println("-------------------------------------");
    }//imprimeEndereco()
    
    public static void alteraLimiteINSS() {
    	double limite = 0;
    	String limiteString;
    	imprimeLimiteINSS();
    	System.out.println("Entre com o TETO de INSS que será utilizado (se vazio ou negativo limite continuará sendo usado): ");
        limiteString = input.nextLine();
        
        try {
	        limiteString.replaceAll( "," , "." );	        
	        limite = Double.parseDouble( limiteString.trim() );
        } 
        catch (Exception e) {
        	limite = -1;
        }
        
        if (limite > 0 ) 
        	Funcionario.setLimiteINSS(limite);
        else 
        	System.out.println("Valor mantido!");
    }

    public static void imprimeLimiteINSS() {
    	System.out.printf ("Limite Atual do INSS é R$ %#3.2f\n", Funcionario.getLimiteINSS());
    }
    
}
