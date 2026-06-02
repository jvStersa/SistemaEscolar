package SistemaEscolar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int quantidadeAlunos=lerQuantidadeDeAlunos(entrada);
        String[] nomes = new String[quantidadeAlunos];
        double[] notas = new double[quantidadeAlunos];
        cadastrarAluno(entrada, nomes, notas, quantidadeAlunos);
        double media=calculadorMedia(notas, quantidadeAlunos);
        int[] empateMaior=calcularMaiorNota(notas, quantidadeAlunos);
        int[] empateMenor=calculadorMenorNota(notas, quantidadeAlunos);
        System.out.printf("Media da turma = %.2f\n",media);
        System.out.println("Maior notas");
        for (int i =0;i< empateMaior.length;i++){
            System.out.println(nomes[empateMaior[i]]+": "+ notas[empateMaior[i]]);
        }
        System.out.println("Menor notas");
        for(int i=0;i<empateMenor.length;i++){
            System.out.println(nomes[empateMenor[i]]+": "+notas[empateMenor[i]]);
        }
        listarSituacaoAlunos(notas, nomes, quantidadeAlunos);
}
    

static int lerQuantidadeDeAlunos(Scanner entrada){
    System.out.println("Digite a quantidade de alunos: ");
    int quantidadeAlunos = entrada.nextInt();
    entrada.nextLine();
    return quantidadeAlunos;
}
static void cadastrarAluno(Scanner entrada, String[] nomes,double[] notas, int quantidadeAlunos){
    for(int i = 0;i<quantidadeAlunos;i++){
        System.out.println("Digite o nome do aluno: ");
        nomes[i] = entrada.nextLine();
        System.out.println("Digite a nota do aluno: ");
        notas[i] =entrada.nextDouble();
        entrada.nextLine();
        if (notas[i]<0 || notas[i] > 10){
            i--;
            System.out.println("nota invalida");
        }
        

    }
}
static double calculadorMedia(double[] notas, int quantidadeAlunos){
    double media = 0;
    for(int i=0;i<quantidadeAlunos;i++){
        media = media + notas[i];
    }
    media = media/quantidadeAlunos;
    return media;
}
static int[] calcularMaiorNota(double[] notas,int quantidadeAlunos){
    int indicadorMaior = 0;
    int empate = 0;
    int z =0;
    for(int i=0;i<quantidadeAlunos;i++){
        if(notas[indicadorMaior]<notas[i]){
            indicadorMaior = i;
        }
    }
    for(int i=0;i<quantidadeAlunos;i++){
         if (notas[indicadorMaior]==notas[i]){
            empate++;
         }
        }
        int[] empateMaior = new int[empate];
    for(int i=0;i<quantidadeAlunos;i++){
         if (notas[indicadorMaior]==notas[i]){
            empateMaior[z]=i;
            z++;
    }
}
return empateMaior;
}
static int[] calculadorMenorNota(double[] notas,int quantidadeAlunos){
    int indicadorMenor =0;
    int z=0;
    int empate = 0;
    for (int i = 0; i < quantidadeAlunos; i++) {
        if (notas[indicadorMenor]>notas[i]){
            indicadorMenor = i;
        }
    }
    for(int i=0;i<quantidadeAlunos;i++){
         if (notas[indicadorMenor]==notas[i]){
            empate++;
         }
        }
        int[] empateMenor = new int[empate];
    for(int i = 0; i < quantidadeAlunos; i++){
        if (notas[indicadorMenor]==notas[i]){
            empateMenor[z]=i;
            z++;
        }
    }
    return empateMenor;
}
static void listarSituacaoAlunos(double []notas,String[] nomes,int quantidadeAlunos) {
    for(int i=0;i<quantidadeAlunos;i++){
        if (notas[i]>=6){
            System.out.println(nomes[i]+": Aprovado");
        }else {
            System.out.println(nomes[i]+ ": Reprovado");
        }
    }
    
}
}