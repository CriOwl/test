package Automata;

import java.io.*;
import java.util.Scanner;

public class Reto {
    public String alfabeto = "5-10-25- ";
    public String productos = "Chicle,Chifle";
    public int error = -10,
            chicle = 200,
            chifle = 250,
            matriz_Transicion[][] = {
                    { 1,2,5,error,error},
                    { 2,3,5,chicle,chicle},
                    { 3,4,5,error,error},
                    { 4,5,5,error,error},
                    { 5,5,5,error,error},
                    { 5,5,5,chifle,chifle}
            };
    public String text_completo;
    public String monedas_usadas;
    public void reto(){}
    public String leer_archivo() {
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src\\sources\\monedas_latino.txt"));
            String entrada;
            String temp = "";
            while ((entrada = bf.readLine()) != null) {
                temp = temp + entrada;
            }
            texto = temp;
            bf.close();
        } catch (Exception e) {
            System.out.println(" Error al leer el archivo: ");
        }
        return texto;
    }

    public int comparar_Alfabeto(String moneda) {
        Scanner getAlfabeto = new Scanner(alfabeto).useDelimiter("-");
        for (int indice = 0; getAlfabeto.hasNext(); indice++) {
            if (getAlfabeto.next().equals(moneda)) {
                return indice;
            }
        }
        return -1;
    }

    public void separar_texto() {
        text_completo = leer_archivo();
        Scanner separador = new Scanner(text_completo).useDelimiter(" ");
        while (separador.hasNext()) {
            monedas_usadas = separador.next();
            validar_monedas(monedas_usadas);
        }
    }

    public void validar_monedas(String monedas_usad) {
        monedas_usad = monedas_usad + " ";
        Scanner monedas_introducidas = new Scanner(monedas_usad).useDelimiter("-");
        int q = 0;
        for (int indice = 0; monedas_introducidas.hasNext();) {
            int indice_matriz_columnas = comparar_Alfabeto(monedas_introducidas.next());
            if (indice_matriz_columnas < 0 || matriz_Transicion[q][indice_matriz_columnas] == error) {
                break;
            }
            q = matriz_Transicion[q][indice_matriz_columnas];
        }
        switch (q) {
            case 200: {System.out.println("Chicle"); break; }
            case 250: {System.out.println("Chifle");break; }
            default:
                System.out.println("Te devuelvo el dinero");
        }

    }
}