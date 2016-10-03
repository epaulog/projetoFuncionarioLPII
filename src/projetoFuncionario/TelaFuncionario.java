/*
 * Eden Paulo Gill
 * 
 * Linguagem de Programação II
 * 
 * Exercício Funcionário
 * 
 * Classe TelaFuncionário
 * 
 * Alteração para o item 1.6
 * 
 */

package projetoFuncionario;

import java.util.Scanner;

public class TelaFuncionario {
    
    //Atributo que mantem uma referencia
    private Funcionario funcionario;
    
    //Atributo para fazer leitura pelo teclado.
    protected static Scanner input = new Scanner(System.in);

    
    public TelaFuncionario(Funcionario f) {
        this.setFuncionario(f);
    }
    
    public void setFuncionario(Funcionario f) {
        if (f != null){
            this.funcionario = f;
        }
        else {
            throw new RuntimeException("Erro: Funcionário null.");
        }
    }
    
    public void leDados(Funcionario f) {
    	leNome();
    	leSexo();
    	leEndereco();
    	leCPF();
    	
    	if (f instanceof FuncionarioSalarioFixo) {
    		System.out.println("Funcionário com Salário Fixo");
    		((FuncionarioSalarioFixo) f).setSalario(leSalario());
    	}
    	
    	if (f instanceof FuncionarioHorista) {
    		System.out.println("Funcionário Horista");
    		((FuncionarioHorista) f).setHorasTrabalhadas(leHorasTrabalhadas());
    		((FuncionarioHorista) f).setSalarioPorHora(leSalario());
    	}
    	
    	if (f instanceof FuncionarioComissionado) {
    		System.out.println("Funcionário Comissionado");
    		((FuncionarioComissionado) f).setSalarioBase(leSalario());
    		((FuncionarioComissionado) f).setValorVendas(leValorVendas());
    		((FuncionarioComissionado) f).setPorcentagemComissao(lePorcentagemComissao());
    	}
    }
    
    public void mostraDados(Funcionario f) {
    	if (f instanceof FuncionarioSalarioFixo) {
            System.out.println("-------------------------------------");
    		System.out.println("Funcionário com Salário Fixo");
    	}
    	
    	if (f instanceof FuncionarioHorista) {
            System.out.println("-------------------------------------");
    		System.out.println("Funcionário Horista");
    	}
    	
    	if (f instanceof FuncionarioComissionado) {
            System.out.println("-------------------------------------");
    		System.out.println("Funcionário Comissionado");
    	}

    	imprimeFuncionario();
    	imprimeSalario();
    }
    
    /**
     * @return the funcionario
     */
    private Funcionario getFuncionario() {
        return funcionario;
    }
    
    private void leNome(){
        System.out.print("Digite o Nome: ");
        this.funcionario.setNome( input.nextLine() );
    }//leNome()
    
    private void leSexo(){
        System.out.print("Digite o Sexo: ");
        this.funcionario.setSexo( input.nextLine().charAt(0));
    }//leSexo()
    
    private void leEndereco(){
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
    
    private void leCPF(){
        System.out.print("Digite o CPF: ");
        this.funcionario.setCPF( input.nextLine() );
    }//leCPF()
    
    private float leSalario(){
        float sal = 0;
        System.out.print("Digite o Salário: ");
        while (sal <=0){
            sal = input.nextFloat();
            if (sal <= 0 ){
                System.out.println("O Salário deve ser diferente de 0 e positivo\nDigite o Salário: ");
            }
        }
        input.nextLine(); //pega os caracteres extras limpando o buffer de teclado
        
        return sal;
    }

    private float leHorasTrabalhadas(){
        float horas = -1;
        System.out.print("Digite o total de Horas Trabalhadas: ");
        while (horas < 0){
            horas = input.nextFloat();
            if (horas < 0 ){
                System.out.println("O Total de Horas Trabalhadas deve ser 0 ou positivo\nDigite o Horas Trablhadas: ");
            }
        }
        input.nextLine(); //pega os caracteres extras limpando o buffer de teclado
        
        return horas;
    }    

    private float lePorcentagemComissao(){
        float porcentagem = -1;
        System.out.print("Digite a Porcentagem de Comissão: ");
        while (porcentagem < 0){
            porcentagem = input.nextFloat();
            if (porcentagem < 0 ){
                System.out.println("A Porcentagem de Comissão deve ser 0 ou positivo\nDigite o Valor de Vendas: ");
            }
        }
        input.nextLine(); //pega os caracteres extras limpando o buffer de teclado
        
        return porcentagem;
    }    
    
    private float leValorVendas(){
        float valor = -1;
        System.out.print("Digite o Valor de Vendas: ");
        while (valor < 0){
            valor = input.nextFloat();
            if (valor < 0 ){
                System.out.println("O Valor de Vendas deve ser 0 ou positivo\nDigite o Valor de Vendas: ");
            }
        }
        input.nextLine(); //pega os caracteres extras limpando o buffer de teclado
        
        return valor;
    }    
    
    private void imprimeFuncionario(){
        System.out.println("-------------------------------------");
        System.out.println("--  Dados do Funcionário  -----------");
        System.out.println("-");
        System.out.println("- Nome: " + funcionario.getNome());
        System.out.println("- Sexo: " + funcionario.getSexo());
        System.out.println("- CPF : " + funcionario.getCPF());
        System.out.println("-------------------------------------");
        
    }//imprimeFuncionario()
    
    private void imprimeSalario(){
        System.out.println("--  Salário  ------------------------");
        System.out.printf ("- Salário Bruto\t\t= %#9.2f\n",funcionario.getSalarioBruto());
        
        if (funcionario.valorINSS() < Funcionario.getLimiteINSS())
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
    
    private void imprimeEndereco(){
        System.out.println("-- Endereço -------------------------");
        System.out.println("- Rua: " + funcionario.getEndereco());
        System.out.println("-------------------------------------");
    }//imprimeEndereco()
    
    public static void alteraLimiteINSS() {
    	double limite = 0;
    	String limiteString;
    	imprimeLimiteINSS();
    	System.out.println("Entre com o TETO de INSS que será utilizado (se vazio ou negativo o limite atual continuará sendo usado): ");
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
    	System.out.printf ("Limite Atual do INSS é R$%#3.2f\n", Funcionario.getLimiteINSS());
    }
    
}
