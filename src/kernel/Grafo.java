package kernel;

public class Grafo {
    BitMap[] g;
    int size;

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

    private int[] getVecinos(int i) {
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

}
