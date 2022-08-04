/**
 *
 * @author Jv Loreti
 */

import java.util.ArrayList;
import java.util.List;

public class GerenciadorEmpregados{
    private static GerenciadorEmpregados instance;
    
    private List<Empregado> empregados;
    
    private GerenciadorEmpregados(){
        empregados = new ArrayList<>();
    }
    
    public static synchronized GerenciadorEmpregados getInstance(){
        if(instance == null){
            instance = new GerenciadorEmpregados();
        }
        return instance;
    }
    
    public boolean cadastrar(Empregado empregado){
        if(empregado != null){
            empregados.add(empregado);
            return true;
        }
        return false;
    }
    
    public Empregado pesquisarNome(String nome){
        for(Empregado empregado : empregados){
            if(empregado.getNome().equalsIgnoreCase(nome)){
                return empregado;
            }
        }
        return null;
    }
    
    public boolean alterar(Empregado empregado){
        int indice = empregados.indexOf(empregado);
        if(indice != -1){
            empregados.set(indice, empregado);
            return true;
        }
        return false;
    }
    
    public boolean remover(Empregado empregado){
        return empregados.remove(empregado);
    }
    
    public float totalSalarial(){
        float somatoria = 0;
        for(Empregado empregado : empregados){
            somatoria += empregado.getSalario();
        }
        return somatoria;
    }
    
    public float mediaSalarial(){
        float somatoria = totalSalarial();
        int count = 0;
        for(Empregado empregado : empregados){
            count++;
        }
        float media = somatoria / count;
        return media;
    }
    
    public Empregado maiorSalario(){
        Empregado empregado_maiorSalario = empregados.get(0);
        for(Empregado empregado : empregados){
            if(empregado.getSalario() > empregado_maiorSalario.getSalario()){
                empregado_maiorSalario = empregado;
            }
        }
        return empregado_maiorSalario;
    }
    
    public Empregado menorSalario(){
        Empregado empregado_menorSalario = empregados.get(0);
        for(Empregado empregado : empregados){
            if(empregado.getSalario() < empregado_menorSalario.getSalario()){
                empregado_menorSalario = empregado;
            }
        }
        return empregado_menorSalario;
    }
    
    public List<Empregado> getEmpregados(){
        return empregados;
    }
}
