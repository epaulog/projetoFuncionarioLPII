package projetoFuncionario;

public class FuncionarioSalarioFixo extends Funcionario {
	
	private float salario;
	
	public FuncionarioSalarioFixo() {
		super();
	}
    public FuncionarioSalarioFixo (String nome, char sexo, String rua, int numero, String cpf) {
    	super(nome, sexo, rua, numero, cpf);
    }
		
	public float salarioBruto() {
		return salario;
	}
	
	public void setSalario(float _salario) {
		if (_salario > 0) {
			salario = _salario;
		}
		else {
			throw new RuntimeException("Erro: o Salário deve ser numérico e maior do que 0.");
		}
	}

}
