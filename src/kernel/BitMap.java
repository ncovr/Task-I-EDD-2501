package kernel;

/**
 * El recorrido se hace de izquierda a derecha
 */

public class BitMap {
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
        if (j <= 0) {
            return -1;
        }

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
        int c = 0; // cuenta la cantidad de bits integrados a la salida final

        for (int i = 0; i < b.length && c < size; i++) {
            int m = 0x80000000;
            for (int j = 0; j < 32 && c < size; j++) {
                if ((b[i] & m) == 0) s.append("0");
                else s.append("1");
                m >>>= 1;
                c++;
            }
            if (b.length > 1 && i != b.length - 1) {
                s.append("\n");
            }
        }
        return s.toString();
    }
}
