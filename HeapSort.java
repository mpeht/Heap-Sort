/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mpeht
 */
public class HeapSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = 0;
        int i;
        System.out.println("Digite o tamanho do vetor:");
        size = sc.nextInt();        
        int vetor[] = new int[size];
        System.out.println("");
        System.out.println("Digite " + size + " números para preencher o vetor para executar o HeapSort:");
        
        for(i = 0; i < vetor.length; i++)   {
            vetor[i] = sc.nextInt();
        }
        //vet [21, 5, 36, 2, 45]
        Heap(vetor);
    }
    
    public static void Heap(int vet[]) {
        ///vet, 5
        criaHeap(vet, vet.length);
       ///fim = vet.lenght - 1 = 4 
        int fim = vet.length - 1;
        while (fim > 0) {
            ///troca vet, 5, 21
            troca(vet, fim, 0);
            ///fim = 4 - 1 = 3
            fim = fim - 1;
            //vet, 0, 3
            arrumaHeap(vet, 0, fim);
        }
    }

    public static void troca(int vet[], int i, int j) {
        ///temp = [45]
        ///temp = [21]
        //************************
        //1 - temp = 45
        int temp = vet[j];
        ///[] = [5]
        ///[] = [5]
        //1 - [] = 5
        vet[j] = vet[i];
        ///[5] = 45
        ///[5] = [21]
        //1 - [5] = [45]
        vet[i] = temp;

    }

    public static void criaHeap(int vet[], int a)   {
      ///inicio = (5 - 2) / 2 = 1
      
        int inicio = ((a - 2)/2);
        ///1 >= 0 = true
        while(inicio >= 0)  {
            ///vet, 1, vet.length - 1
            //vet, 0, 4
            arrumaHeap(vet, inicio, a - 1);
            //
            //inicio = 1 - 1 = 0
            //inicio = 0 -1 = -1
            inicio = inicio - 1;
        }
    }
    public static void arrumaHeap(int vet[], int inicio, int fim)  {
        ///raiz = 1
        ///raiz = 0
        //********
        //raiz = 0
        int raiz = inicio;
       ///(1 * 2) + 1 = 3 <= 4 = true
       ///(0 * 2) + 1 = 1 <= 4 true
       //(0 * 2) + 1 = 1 <= 4 true
       //******************************
       //(0 * 2) + 1 = 1 <= 3 true
        while((raiz * 2 + 1) <= fim)    {
            ///filho = 3
            ///filho = 
            //*****************
            //filho = 1
            int filho = (raiz * 2 + 1);
            ///trocar = 1
            ///trocar = 0
            //******************
            //trocar = 0
            int trocar = raiz;
            ///[5] < [2] = false
            //[21] < [45] = true
            //********************
            //[5] <
            if(vet[trocar] < vet[filho])    {
                //[5] < [36]
                //[21] = [45]
                trocar = filho;
            }
            ///[5] < [2] = false
            //[36] < [36] = false
            //[45] < [45] = false
            if(vet[trocar] < vet[filho])    {
                trocar = filho;
            }
            ///(4 <= 4 = true && [5] < [45] = true = true
            //(2 <= 4 = true && [21] < [36] = false = false
            if(filho + 1 <= fim && vet[trocar] < vet[filho + 1])    {
                ///[5] = [45]
                //[21] = [36]
                trocar = filho + 1;
            }
            //4 == 1 = false 
            //0 == 1 = false
            if(trocar == raiz)  {
                break;
            }else{
                ///vet, 1, 4
                //vet, 1, 0
                troca(vet, raiz, trocar);
                //1 = 4
                //1 = 0
                raiz = trocar;
            }
        }
        System.out.println(Arrays.toString(vet));
        ///[21, 5, 36, 2, 45]
       ///[21, 45, 36, 2, 5]
       ///[5, 45, 36, 2, 21]
    }
}
