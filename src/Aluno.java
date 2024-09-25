public class Aluno {
    private String nome;
    private String ra;
    private double[] notas;
    private int presenca;
    private boolean ead; // Indica se a disciplina é EAD
    private int notaCount;

    public Aluno(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
        this.notas = new double[4];
        this.presenca = 0;
        this.ead = false;
        this.notaCount = 0;
    }
    // Criando metodo para setar e validar meu array de notas
    public void setNotas(double[] notas) throws Exception {
        // se notas for maior que 4 ele da erro
        if (notas.length > 4) {
            throw new Exception("Limite de 4 notas excedido.");
        }

        /*
        Inicialmente, eu pensei em usar    this.notas = notas; para atribuir o array diretamente, mas
        eu vi em alguns exemplos, q é legal criar uma cópia do array recebido. Isso é feito para:
        Gerenciar Tamanhos Diferentes e Manter a Integridade dos Dados
        */

        this.notas = new double[4];
        System.arraycopy(notas, 0, this.notas, 0, notas.length);
        this.notaCount = notas.length;
    }
    // Criando metodo para setar e validar Presenca
    public void setPresenca(int presenca)  throws Exception {
        // se presenca for menor que 0 ele da erro
        if (presenca < 0) {
            throw new Exception("Não pode inserir número negativo.");
        }
        this.presenca = presenca;
    }
    //Metoddo para setar Ead true ou false
    public void setEad(boolean ead)   {

        this.ead = ead;
    }

    // Criação de metodo calcularNotaFinal com switch  case
    public double calcularNotaFinal(double[] notas) {
        /*Eu pensei em criar um metodo para cada situação utilizando SOBRECARGA, mas no fim achei melhor pedir a nota em um arr e utilizar
        o switch case para determinar qual calculo vou fazer com base nos index do arr */
        switch (notaCount) {
            case 1:
            case 2:
                return (notas[0] + notas[1]) / 2; // Média aritmética
            case 3:
                return (notas[0] * 1 + notas[1] * 2 + notas[2] * 4) / 7; // Média ponderada
            case 4:
                return (notas[0] * 0.15) + (notas[1] * 0.30) + (notas[2] * 0.10) + (notas[3] * 0.45); // Media especifica
            default:
                return 0; // sem notas
        }
    }
    //metodo que verifica a situação do aluno
    public String situacao() {
        double notaFinal = calcularNotaFinal(notas);
        //valida se ead esta true e retorna a nota sem valida faltas
        if (ead) {
            return notaFinal >= 5 ? "Aprovado" : "Reprovado";
        }
        //valida nota e presença
        else {
            return (presenca >= 75) ? (notaFinal >= 5 ? "Aprovado" : "Reprovado") : "Reprovado por falta";
        }
    }
    public void imprimirInfo() {
        double notaFinal = calcularNotaFinal(notas);
        String situacao = situacao();
        System.out.printf("Nome: %s, RA: %s, Nota Final: %.2f, Situação: %s%n", nome, ra, notaFinal, situacao);
    }


}
