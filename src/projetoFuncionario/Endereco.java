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
    
    
    public Endereco(String rua, int numero) {
        this.setRua(rua);
        this.setNumero(numero);
    }
    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }
    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }
    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

}
