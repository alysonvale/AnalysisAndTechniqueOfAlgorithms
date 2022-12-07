package Dinamica_Mochila;

import java.util.*;


public class AppMochila {

    public static void main(String[] args) {
        Dictionary<Integer, ItemMochila> s = new Hashtable<>();
        Scanner sc = new Scanner(System.in);
        long tempoInicial;
        int n, W, op;

        System.out.print("Escolha a quantidade de itens:");
        n = sc.nextInt();
        System.out.print("1 - PD | 2 - Recursivo Memoizado | 3 - Recursivo:");
        op = sc.nextInt();
        System.out.print("Tamanho da mochila:");
        W = sc.nextInt();

        if (n == 0) {
            s.put(1, new ItemMochila(6,30));
            s.put(2, new ItemMochila(3,14));
            s.put(3, new ItemMochila(4,16));
            s.put(4, new ItemMochila(2,9));
        }else{
            Random rand = new Random();
            for (int i = 1 ; i < n; i++) {
                s.put(i, new ItemMochila(rand.nextInt(6)+1, rand.nextInt((15-10)+1)+10));
            }
        }

        switch (op){
            case 1:{
                tempoInicial = System.currentTimeMillis();
                System.out.println("Algoritmo da mochila: " + Mochila.mochila(s, s.size(), W));
                System.out.printf("%f s%n", (System.currentTimeMillis() - tempoInicial) / 1000d);
                break;
            }
            case 2:{
                List<List<Integer>> m = new ArrayList<>();
                MochilaRecursivaMemoizado.inicializaMatriz(m, s.size(), W);
                tempoInicial = System.currentTimeMillis();
                System.out.println("\nAlgoritmo da mochila recursivo memoizado: " + MochilaRecursivaMemoizado.mochilaRecursivaMemoizado(W, s, m, s.size()-1));
                System.out.printf("%f s%n", (System.currentTimeMillis() - tempoInicial) / 1000d);
                break;
            }
            case 3:{
                tempoInicial = System.currentTimeMillis();
                System.out.println("\nAlgoritmo da mochila recursivo: " + MochilaRecursiva.mochilaRecursiva(W, s, s.size()));
                System.out.printf("%f s%n", (System.currentTimeMillis() - tempoInicial) / 1000d);
                break;
            }
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }
}