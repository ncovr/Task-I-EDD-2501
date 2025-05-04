import java.util.Scanner;

//Desarrollado por
// - Nicolás Verdugo
// - Diego Mercado
// Con la participación de
//  - ChatGPT, para crear casos de testeo y botar el programa

public class Main {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        // Testers
        boolean testBitMap = false;
        boolean testGrafo = false;

        if (testBitMap) {
            // ***** BitMap *****
            int size = 0; // Cantidad de bits para representar un número
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

        if (testGrafo) {
            // ***** Grafo *****
            int n = 2; // Digite cantidad de nodos
            int[] conexiones = {
                    // Digite pares de números. Representan una conexión
                    // 1, 2,
                    // 2, 3
                    1,2,
            };
            int[] camino = {1,2,3}; // Digite una secuencia de numeros para verificar si existe un camino

            Grafo g = new Grafo(n, conexiones);
            System.out.println("\nNuevo Grafo _______ "+g);
            System.out.println("\n__ Vecinos de cada nodo __");
            vecinos(g);
            System.out.println("\n__ Verificar camino __ "+toString(camino));
            camino(g, camino);
        }

        if (testBitMap == false && testGrafo == false) System.out.println("Comience cambiando el valor de las variables boolean");
    }

    // Grafo
    private static void vecinos(Grafo g) {
        for (int i = 1; i <= g.size; i++) {
            g.vecinos(i);
        }
    }

    private static void camino(Grafo g, int[] camino) {
        System.out.println("Estado: "+g.esunCamino(camino));
    }


    // BitMap
    private static void encenderBits(BitMap b) {
        // Aquí puede encender los bits usando...
        int x;
        x = -1;
        b.On(x);
        print("("+x+") |-> "+b);
        // Como recomendación: encender y luego imprimir para ver el cambio
        // Por eso, copie y pegue lo anterior editando la variable
    }

    private static void apagarBits(BitMap b) {
        // Aquí puede apagar los bits usando...
        int x;
        x = -1;
        b.Off(x);
        print("("+x+") |-> "+b);
        // Como recomendación: apagar y luego imprimir para ver el cambio
        // Por eso, copie y pegue lo anterior editando la variable
    }

    public static void valorDeLaPosicion(BitMap b) {
        // Aquí puede consultar el estado de cada bit en el BitMap
        int i;
        i = -1;
        System.out.println("Estado del bit "+i+" en "+b+" -> "+b.Access(i));
        // Puede copiar y pegar las dos últimas líneas anteriores y editar i
    }

    public static void rank(BitMap b) {
        // Aquí puede consultar el método Rank
        int i;
        i = -1;
        System.out.println("Existen "+b.Rank(i)+" bits en 1 en [0, "+i+"]");
        // Puede copiar y pegar las dos últimas líneas anteriores y editar i
    }

    private static void select(BitMap b) {
        // Aqui puede consultar el metodo Select
        int i;
        i = -1;
        System.out.println("Select("+i+"): "+b.Select(i));
        // Puede copiar y pegar las dos últimas líneas anteriores y editar i
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static String toString(int[] n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n.length; i++) {
            if (i == n.length-1) {
                s.append(n[i]);
            } else s.append(n[i]+"_");
        }
        return s.toString();
    }
}

class BitMap {
    private int[] b;
    int size;

    public BitMap(int size) {
        if (size >= 0) {
            b = new int[(int) Math.ceil(size / 32.0)];
            this.size = size;
        }
    }

    // Métodos obligatorios --------------------------------------------------------------------------------------------

    /**
     * Enciende el bit de la posición i del kernel.BitMap
     */
    public void On(int i) {
        if(i < 0 || i >= size) return;
        int index = i / 32; // Posición del bit en el BitMap
        int temp = b[index]; // int a operar
        i = i % 32;
        int m = 0x80000000 >>> i;
        b[index] = temp | m;
    }

    /**
     * Apaga el bit de la posición i del kernel.BitMap
     */
    public void Off(int i) {
        if(i < 0 || i >= size) return;
        int index = i / 32; // Posición del bit en el BitMap
        int temp = b[index]; // int a operar
        i = i % 32;
        int m = 0x80000000 >>> i;
        b[index] = temp & ~m;
    }

    /**
     * Retorna el valor de la posición i
     */
    public byte Access(int i) {
        if(i < 0 || i >= size) return -1;
        int index = i / 32;
        int temp = b[index];
        i %= 32;
        int m = 0x80000000 >>> i;

        if ((temp & m) == 0) return 0;
        return 1;
    }

    /**
     * Retorna la cantidad de bits encendidos desde la posición 0 hasta i
     */
    public int Rank(int in) {
        if (in < 0 || in >= size) return -1;
        int c = 0;
        for (int i = 0; i <= in; i++) {
            if (Access(i) == 1) c++;
        }
        return c;
    }


    /**

     Retorna la posición hasta donde existen j bits en 1. Si la cantidad de bits en 1 es menor que j, se retorna -1*/
    public int Select(int j) {
        if (j <= 0 || j >= size) return -1;

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (Access(i) == 1) {
                count++;
                if (count == j) {
                    return i;
                }
            }
        }
        return -1; // No se encontró el j-ésimo 1
    }


    // Métodos extras --------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(Access(i));
        }
        return s.toString();
    }
}

class Grafo {
    private BitMap[] g;
    public int size;

    public Grafo(int n, int[] relaciones) {
        g = new BitMap[n + 1];
        size = n;
        for (int i = 0; i <= size; i++) {
            if (g[i] == null) g[i] = new BitMap(size+1);
        }
        for (int i = 0; i < relaciones.length - 1; i += 2) {
            int a = relaciones[i];
            int b = relaciones[i + 1];
            if (a <= 0 || b <= 0 || a == b || a > n || b > n) continue;
            relacionar(a, b);
        }
    }

    private void relacionar(int a, int b) {
        g[a].On(b);
        g[b].On(a);
    }

    public void vecinos(int i) {
        if (i < 1 || i > size) {
            System.out.println("Error al buscar vecinos de " + i + ": Nodo inexistente");
            return;
        }

        if (g[i] == null) {
            System.out.println("Error al buscar vecinos de " + i + ": No tiene vecinos");
            return;
        }

        StringBuilder s = new StringBuilder();
        int[] vecinos = getVecinos(i);
        for (int j = 0; j < vecinos.length; j++) {
            if (vecinos[j] == 1) s.append(j + " ");
        }
        System.out.println("Vecinos de " + i + ": " + s);
    }

    public int[] getVecinos(int i) {
        if (g[i] == null) return null;

        int[] vecinos = new int[size + 1];
        for (int c = 1; c <= size; c++) {
            if (g[i].Access(c) == 1) vecinos[c]++;
        }
        return vecinos;
    }

    public boolean esunCamino(int[] secuencia) {
        for (int i = 0; i < secuencia.length - 1; i++) {
            int a = secuencia[i];
            int b = secuencia[i + 1];
            if (a > size || b > size || a < 1 || b < 1) return false;
            if (g[a] == null || g[b] == null) return false;
            if (g[a].Access(b) == 0) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            s.append("("+i+")_");
            int[] v = getVecinos(i);
            for (int j = 1; j < v.length; j++) {
                if (v[j] == 1) s.append(j + " ");
            }
            s.append(" ");
        }
        return s.toString();
    }

}
