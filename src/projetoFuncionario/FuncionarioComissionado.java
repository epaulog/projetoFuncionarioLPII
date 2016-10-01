package projetoFuncionario;

public class FuncionarioComissionado extends Funcionario {
	
	private float salarioBase;
	private float valorVendas;
	private float porcentagemComissao;
	
	public FuncionarioComissionado() {
		super();
	}
	
    public FuncionarioComissionado (String nome, char sexo, String rua, int numero, String cpf) {
    	super(nome, sexo, rua, numero, cpf);
    }
    
	public float salarioBruto() {
		return (salarioBase + (valorVendas * porcentagemComissao / 100));
	}
	
	public void setSalarioBase(float _salarioBase) {
		if (_salarioBase > 0) {
			salarioBase = _salarioBase;
		}
		else {
			throw new RuntimeException("Erro: Salário Base deve ser numérico e maior do que 0.");
		}
	}
	
	public void setValorVendas(float _valorVendas) {
		if (_valorVendas > 0) {
			valorVendas = _valorVendas;
		}
		else {
			throw new RuntimeException("Erro: Valor de Vendas deve ser numérico e maior do que 0.");
		}	
	}
	
	public void setPorcentagemComissao(float _porcentagemComissao) {
		if (_porcentagemComissao > 0) {
			porcentagemComissao = _porcentagemComissao;
		}
		else {
			throw new RuntimeException("Erro: Porcentagem de Comissão deve ser numérico e maior do que 0.");
		}	
	}

}
