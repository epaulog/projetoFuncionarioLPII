/*
 * Eden Paulo Gill
 * 
 * Linguagem de  II
 * 
 * Exercício Funcionário
 * 
 * Classe Funcionário
 * 
 * Alteração para o item 1.6
 * 
 */
package projetoFuncionario;

public abstract class Funcionario {
	public final char MASCULINO = 'M';
	public final char FEMINO = 'F';
	
    private static double limiteINSS = 900.0;
    
    private String nome;
    private char sexo;
    private String cpf;
    private Endereco endereco;

    abstract public float salarioBruto();
    
    
    
    //contrutor vazio
    public Funcionario(){
        this.setNome("...");
        this.setSexo('X');
        this.setCPF("123.456.789-01");

        Endereco e;
        e = new Endereco(" ", 1);
        this.setEndereco(e);

 //       this.setSalario(1);
    }//Funcionario()
    
    //construtor com parametros explicitos
    public Funcionario(String nome, char sexo, String rua, int numero, 
                        String cpf){
        this.setNome(nome);
        this.setSexo(sexo);
        this.setCPF(cpf);

        this.setEndereco(rua, numero);
        
 //       this.setSalario(salario);
    }//Funcionario(n,s,c,r,n,sal)
    
    //construtor com endereco
    public Funcionario(String nome, char sexo, Endereco endereco, 
                        String cpf){
        this.setNome(nome);
        this.setSexo(sexo);
        this.setCPF(cpf);
        this.setEndereco(endereco);
//        this.setSalario(salario);
    }//Funcionario(n,s,e,c,sal)

   
    
    public double txINSS(){
        if ((this.salarioBruto()) <= 1000) return 8;
        else if ((this.salarioBruto()) <= 2000) return 9;
        else if ((this.salarioBruto()) <= 3000) return 10;
        else return 11;
    }//txINSS()
    
    public double valorINSS(){
        if ((this.salarioBruto() * this.txINSS()/100) < limiteINSS)
            return (this.salarioBruto() * this.txINSS()/100);
        else
            return (limiteINSS);
    }//valorINSS()
                  
    public double salarioBaseIR(){
        return (this.salarioBruto() - this.valorINSS());
    }//salarioBaseIR()
    
    public double txIR(){
        if (this.salarioBaseIR() <= 1000) return 0;
        else if (this.salarioBaseIR() <= 3000) return 10;
        else if (this.salarioBaseIR() <= 5000) return 20;
        else return 30;
    }//txIR()
    
    public double valorIR(){
        return (this.salarioBaseIR() * this.txIR()/100);
    }//valorIR()
    
    public double salarioLiquido(){
        return (this.salarioBruto() - this.valorINSS() - this.valorIR());
    }//salarioLiquido()
    
    public static void setLimiteINSS(double _limiteINSS) {
    	if (limiteINSS > 0) {
    		limiteINSS = _limiteINSS;
    	}	
    	else {
    		throw new RuntimeException("Erro: o Limite de INSS deve ser numérico e maior do que 0.");
    	}
    }
    
    public static double getLimiteINSS() {
    	return limiteINSS;
    }
    
    public void setNome(String n){
        if (n.length() >= 2){
            this.nome = n;
        }
        else {
            throw new RuntimeException("Erro: nome deve ter pelo menos dois caracteres");
        }
    }//setNome()
    
    public void setSexo(char s){
        if (s != ' '){
            this.sexo = Character.toUpperCase(s);
        }
        else{
            throw new RuntimeException("Erro: sexo não pode ficar vazio");
        }
    }//setSexo()
    
    public void setCPF(String c){
        if (c.length() > 1){ // teria q ser ==14
            this.cpf = c;
        }
        else {
            throw new RuntimeException("Erro: CPF deve ter 14 caracteres - Formato: 123.456.789-01");
        }
    }//setCPF()
    
/*    public void setSalario(double s){
        if (s > 0){
            this.salarioBruto() = s;
        }
        else {
            throw new RuntimeException("Erro: salário deve ser um valor positivo.");
        }
    }//setSalario()
*/
    
    public String getCPF() {
        return cpf;
    }//getCPF

    public double getSalarioBruto() {
        return salarioBruto();
    }//getSalarioBruto()

    public String getNome() {
        return nome;
    }//getNome()

    public char getSexo() {
        return sexo;
    }//getSexo()

    public String getEndereco() {
        return ( endereco.getRua() + ", " + endereco.getNumero() );
    }//getEndereco()

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }//setEndereco(endereco)

    //TODO: consigo criar um setEndereco passando parametro a parametro???
    public void setEndereco(String r, int n){
        
        Endereco e;
        e = new Endereco(r, n);
        this.setEndereco(e);
        
        /*this.endereco.setRua(r);
        this.endereco.setNumero(n);*/
        
    }//setEndereco(r, n);



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

    
}//class Funcionario

