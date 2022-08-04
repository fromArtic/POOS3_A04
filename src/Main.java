/**
 *
 * @author Jv Loreti
 */

public class Main{
    public static void main(String[] args){
        GerenciadorEmpregados gerenciador = GerenciadorEmpregados.getInstance();
        
        //Cadastro dos empregados
        if(gerenciador.cadastrar(new Empregado("John", "1212", 1500))
                && gerenciador.cadastrar(new Empregado("Bob", "1414", 500))
                && gerenciador.cadastrar(new Empregado("Tom", "1313", 4300))){
            System.out.println("Cadastro realizado com sucesso.");
        }else{
            System.out.println("Cadastro não realizado.");
        }
        
        System.out.println(gerenciador.getEmpregados()); //Imprime os empregados cadastrados
        
        Empregado empregado = gerenciador.pesquisarNome("john"); //Consulta um empregado pelo nome

        if(empregado != null){
            System.out.println("[" + empregado.getNome() + "] Cadastro encontrado.");
            
            //Altera o nome do empregado consultado
            empregado.setNome("Jack");
            if(gerenciador.alterar(empregado)){
                System.out.println("Alteração realizada com sucesso.");
            }else{
                System.out.println("Alteração não realizada.");
            }
            
            System.out.println(gerenciador.getEmpregados()); //Imprime novamente
            
            //Ex. 2 (total e média salarial, empregados com maior e menor salário)
            System.out.println("Total salarial=R$" + gerenciador.totalSalarial() + ", média salarial=R$" + gerenciador.mediaSalarial());
            System.out.println("Maior salário=" + gerenciador.maiorSalario());
            System.out.println("Menor salário=" + gerenciador.menorSalario());
            
            //Remove o empregado consultado
            if(gerenciador.remover(empregado)){
                System.out.println("Remoção realizada com sucesso.");
            }else{
                System.out.println("Remoção não realizada.");
            }
        }else{
            System.out.println("Empregado não encontrado.");
        }
    }
}
