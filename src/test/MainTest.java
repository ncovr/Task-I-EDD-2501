package test;

import kernel.BitMap;

public class MainTest {
    public static void main(String[] args)  {
        // ***** BitMap *****
        int size = 33; // Cantidad de bits para representar un número
        BitMap b = new BitMap(size);
        System.out.println("Nuevo BitMap _______ "+b);
        System.out.println("\n__ Encendiendo bits __");
        encenderBits(b);
        System.out.println("\n__ Apagando bits __");
        apagarBits(b);
        System.out.println("\n__ Consultando bits __");
        valorDeLaPosicion(b);
        System.out.println("\n__ Operación Rank __");
        rank(b);
        System.out.println("\n__ Operación Select __");
        select(b);
    }

    private static void encenderBits(BitMap b) {
        // Aquí puede encender los bits usando...
        int x;
        x = -1;
        b.On(x);
        print("("+x+") |-> "+b);
        // Como recomendación: encender y luego imprimir para ver el cambio
        // Por eso, copie y pegue lo anterior editando la variable
        x = 32;
        b.On(x);
        print("("+x+") |-> "+b);
        x = 4;
        b.On(x);
        print("("+x+") |-> "+b);
        x = 6;
        b.On(x);
        print("("+x+") |-> "+b);
    }

    private static void apagarBits(BitMap b) {
        // Aquí puede apagar los bits usando...
        int x;
        x = -1;
        b.Off(x);
        print("("+x+") |-> "+b);
        // Como recomendación: apagar y luego imprimir para ver el cambio
        // Por eso, copie y pegue lo anterior editando la variable
        x = 4;
        b.Off(x);
        print("("+x+") |-> "+b);
        x = 2;
        b.Off(x);
        print("("+x+") |-> "+b);
    }

    public static void valorDeLaPosicion(BitMap b) {
        // Aquí puede consultar el estado de cada bit en el BitMap
        int i;
        i = -1;
        System.out.println("Estado del bit "+i+" en "+b+" -> "+b.Access(i));
        // Puede copiar y pegar las dos últimas líneas anteriores y editar i
        for (int j = 0; j < 8; j++) {
            System.out.println("Estado del bit "+j+" en "+b+" -> "+b.Access(j));
        }
    }

    public static void rank(BitMap b) {
        // Aquí puede consultar el método Rank
        int i;
        i = -1;
        System.out.println("Existen "+b.Rank(i)+" bits en 1 en [0, "+i+"]");
        // Puede copiar y pegar las dos últimas líneas anteriores y editar i
        i = 3;
        System.out.println("Existen "+b.Rank(i)+" bits en 1 en [0, "+i+"]");
        i = 7;
        System.out.println("Existen "+b.Rank(i)+" bits en 1 hasta el índice "+i);
    }

    private static void select(BitMap b) {
        // Aqui puede consultar el metodo Select
        print(b+"");
        int i;
        i = 1;
        System.out.println("Existen "+b.Select(i)+" bits en 1 hasta la posición "+i);
        // Puede copiar y pegar las dos últimas líneas anteriores y editar i
        i = 3;
        System.out.println("Existen "+b.Select(i)+" bits en 1 hasta la posición "+i);
        i = 7;
        System.out.println("Existen "+b.Select(i)+" bits en 1 hasta la posición "+i);
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
