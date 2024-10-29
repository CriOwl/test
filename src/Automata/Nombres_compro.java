package Automata;

import java.io.*;
import java.util.Scanner;

public class Nombres_compro {
    public String alfabeto = "c-r-i-s-t-h-a-n-p-u-l-o- ";
    public int error = -10,
            cristhian = 200,
            carrillo = 250,
            paul = 500,
            matriz_Transicion[][] = {
                    // 1,2,3,4,5,6
                    { 1, error, error, error, error, error, error, error, 10, error, error, error, error, error },
                    { error, 2, error, error, error, error, 14, error, error, error, error, error, error, error },
                    { error, error, 3, error, error, error, error, error, error, error, error, error, error, error },
                    { error, error, error, 4, error, error, error, error, error, error, error, error, error, error },
                    { error, error, error, error, 5, error, error, error, error, error, error, error, error, error },
                    { error, error, error, error, error, 6, error, error, error, error, error, error, error, error },
                    { error, error, 7, error, error, error, error, error, error, error, error, error, error, error },
                    { error, error, error, error, error, error, 8, error, error, error, error, error, error, error },
                    { error, error, error, error, error, error, error, 9, error, error, error, error, error, error },
                    { error, error, error, error, error, error, error, error, error, error, error, error, cristhian,cristhian },
                    { error, error, error, error, error, error, 11, error, error, error, error, error, error, error },
                    { error, error, error, error, error, error, error, error, error, 12, error, error, error, error },
                    { error, error, error, error, error, error, error, error, error, error, 13, error, error, error },
                    { error, error, error, error, error, error, error, error, error, error, error, error, paul, paul },
                    { error, 15, error, error, error, error, error, error, error, error, error, error, error, error },
                    { error, 16, error, error, error, error, error, error, error, error, error, error, error, error },
                    { error, error, 17, error, error, error, error, error, error, error, error, error, error, error },
                    { error, error, error, error, error, error, error, error, error, error, 18, error, error, error },
                    { error, error, error, error, error, error, error, error, error, error, 19, error, error, error },
                    { error, error, error, error, error, error, error, error, error, error, error, 20, error, error },
                    { error, error, error, error, error, error, error, error, error, error, error, error, carrillo,carrillo },
            };
    public String text_completo;
    public String nombres_leidos;
    public void Nombres_compro(){}
    public String leer_archivo() {
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src\\sources\\nombres.txt"));
            String entrada;
            String temp = "";
            while ((entrada = bf.readLine()) != null) {
                temp = temp + entrada;
            }texto = temp;
            bf.close();
        } catch (Exception e) {
            System.out.println(" Error al leer el archivo: ");
        } 
        return texto;
    }

    public void separar_texto() {
        text_completo = leer_archivo();
        Scanner separador = new Scanner(text_completo).useDelimiter(" ");
        while (separador.hasNext()) {
            nombres_leidos = separador.next();
            validar_nombre(nombres_leidos); }
    }

    public int comparar_Alfabeto(String nombre) {
        Scanner getAlfabeto = new Scanner(alfabeto).useDelimiter("-");
        for (int indice = 0; getAlfabeto.hasNext(); indice++) {
            if (getAlfabeto.next().equals(nombre)) {
                return indice; }
        }
        return -1;
    }

    public void validar_nombre(String nombre_s) {
        nombre_s = nombre_s + " ";
        Scanner nombre_introducido = new Scanner(nombre_s).useDelimiter("-");
        int q = 0;
        while (nombre_introducido.hasNext()) {
            int indice_matriz_columnas = comparar_Alfabeto(nombre_introducido.next());
            if (indice_matriz_columnas < 0 || matriz_Transicion[q][indice_matriz_columnas] == error) {
                break;
            }
            q = matriz_Transicion[q][indice_matriz_columnas];
        }
        switch (q) {
            case 200: {System.out.println("Felicidades,Cristhian");break;}
            case 250: {System.out.println("Felicidades,Carrillo");break;}
            case 500: {System.out.println("Felicidades, Paul"); break;}
            default:
                System.out.println("Fallaste");
        }
    }
}