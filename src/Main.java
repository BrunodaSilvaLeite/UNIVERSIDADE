//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//Criando try e catch para tratativa de erro
    try {
        //Criando um objeto Produto e passando os valores dos atributos
        Aluno aluno = new Aluno("João Silva", "123456");

        //Criando e setando valores de nota,presença e ead
        double[] notas = {10, 10,10,10};
        aluno.setNotas(notas);

        aluno.setPresenca(76);
        aluno.setEad(false);
        aluno.imprimirInfo();

    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
    }
}