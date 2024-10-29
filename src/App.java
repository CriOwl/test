import Automata.Maquina_Expe;
import Automata.Nombres_compro;
import Automata.Reto;

public class App {
    public static void main(String[] args) throws Exception {
        Maquina_Expe maquina_expendedora = new Maquina_Expe();
        maquina_expendedora.separar_texto();
        System.out.println(maquina_expendedora.leer_archivo());
        System.out.println("-----------------------------");
        Nombres_compro validadora_nombres = new Nombres_compro();
        validadora_nombres.separar_texto();
        //System.out.println(validadora_nombres.leer_archivo());
        System.out.println("-----------------------------");
        Reto maquina_latina = new Reto();
        maquina_latina.separar_texto();
        //System.out.println(validadora_nombres.leer_archivo());
    }

}
