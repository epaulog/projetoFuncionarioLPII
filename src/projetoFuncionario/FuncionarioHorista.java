package projetoFuncionario;

public class FuncionarioHorista extends Funcionario {
	
	private float horasTrabalhadas;
	private float salarioPorHora;
	
	public FuncionarioHorista() {
		super();
	}
	
	public FuncionarioHorista (String nome, char sexo, String rua, int numero, String cpf) {
    	super(nome, sexo, rua, numero, cpf);
    }
    
	public float salarioBruto() {
		return (horasTrabalhadas * salarioPorHora);
	}
	
	public void setHorasTrabalhadas(float _horasTrabalhadas) {
		if (_horasTrabalhadas > 0) {
			horasTrabalhadas = _horasTrabalhadas;
		}
		else {
			throw new RuntimeException("Erro: Horas Trabalhadas deve ser numérico e maior do que 0.");
		}
	}
	
	public void setSalarioPorHora(float _salarioPorHora) {
		if (_salarioPorHora > 0) {
			salarioPorHora = _salarioPorHora;
		}
		else {
			throw new RuntimeException("Erro: o Salário Por Hora deve ser numérico e maior do que 0.");
		}
	}
	
}
