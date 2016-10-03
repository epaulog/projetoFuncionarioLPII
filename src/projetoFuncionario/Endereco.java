/*
 * Eden Paulo Gill
 * 
 * Linguagem de Programação II
 * 
 * Exercício Funcionário
 * 
 * Classe Endereço
 * 
 * Alteração para o item 1.6
 * 
 */

package projetoFuncionario;

public class Endereco {
    
    private String rua;
    private int numero;
    
    
    public Endereco(String _rua, int _numero) {
        setRua(_rua);
        setNumero(_numero);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String _rua) {
        rua = _rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int _numero) {
        numero = _numero;
    }

}
