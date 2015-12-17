package paridaderedes;

public class Bloco {

    public static void main(String[] args) {
        Bloco b = new Bloco();
        b.verificaParidade();
        b.printBloco();
    }
    private boolean[][] bloco;

    public Bloco() {
        this.bloco = geraMatrizAleatoria(9);
    }

    public Bloco(int size) {
        this.bloco = geraMatrizAleatoria(size);
    }

    /**
     * Gera uma matriz quadrada com dados aleatorios.
     *
     * @param size Quantidade de linhas e colunas da matriz.
     * @return Matriz quadrada com dados aleatorios.
     */
    private boolean[][] geraMatrizAleatoria(int size) {
        boolean[][] b = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                b[i][j] = this.getBoolean(Math.round(Math.random()));
            }
        }
        return b;
    }

    /**
     * Transforma um long em um boolean caso o mesmo seja igual a 1.
     *
     * @param d Numero a ser transformado em boolean.
     * @return Equivalente booleano do long informado.
     */
    private boolean getBoolean(long d) {
        return d == 1;
    }

    /**
     * Imprime o bloco em formato de matriz.
     */
    private void printBloco() {
        for (int i = 0; i < bloco.length; i++) {
            for (int j = 0; j < bloco.length; j++) {
                System.out.print((bloco[i][j] ? "1" : "0") + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Completa os bytes de paridade da matriz, caso a quantidade de bits igual
     * a 1 na linha ou coluna seja par, completa com 0, caso contrario completa
     * com 1.
     */
    private void verificaParidade() {
        for (int i = 0; i < bloco.length - 1; i++) {
            for (int j = 0; j < bloco[i].length - 1; j++) {
                if (bloco[i][j]) {
                    bloco[i][bloco[i].length - 1] = !bloco[i][bloco[i].length - 1];
                    bloco[bloco.length - 1][j] = !bloco[bloco.length - 1][j];
                }
            }
        }
    }

}
