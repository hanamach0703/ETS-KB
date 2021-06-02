package com.company;

public class GraphColoring {

    final int V = 13;
    int color[];

    /* Fungsi untuk mengecek jika pemberian warna node v */
    boolean cek(int v, int graph[][], int color[], int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && c == color[i])
                return false;
        }
        return true;
    }

    /* Sebuah fungsi rekursif untuk menyelesaikan m soal pewarnaan */
    boolean rekursif(int graph[][], int m, int color[], int v) {

        /* ika semua simpul adalah diberi warna lalu mengembalikan true */
        if (v == V) return true;

		/* Pertimbangkan simpul v ini dan coba warna yang berbeda */
        for (int c = 1; c <= m; c++) {

            /* Cek apakah penugasan warna c ke v baik-baik saja*/
            if (cek(v, graph, color, c)) {
                color[v] = c;

				/* berulang untuk menetapkan warna untuk beristirahat dari simpul */
                if (rekursif(graph, m, color, v + 1))
                    return true;

				/* Jika menetapkan warna c tidak mengarah ke solusi lalu hapus */
                color[v] = 0;
            }
        }

		/* Jika tidak ada warna yang dapat ditetapkan simpul ini kemudian mengembalikan false */
        return false;
    }


    boolean graphColoring(int graph[][], int m) {
        // Inisialisasi semua warna node belum ada atau = 0
        color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = 0;
        }

        // Panggil graphColoringUtil () untuk simpul 0
        if (!rekursif(graph, m, color, 0)) {
            System.out.println("Solusi Tidak Ada");
            return false;
        }

        printSolution(color);
        return true;
    }

    /* Fungsi untuk print solusi */
    void printSolution(int color[]) {
        System.out.println("Solusi warna graph : ");
        for (int i = 0; i < V; i++) {
            System.out.print(" " + color[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        GraphColoring Coloring = new GraphColoring();

        int graph[][] = {
                { 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0 }
        };
        int m = 4; // jumlah warna yang digunakan 1=kuning, 2=hijau, 3=merah, 4=biru
        Coloring.graphColoring(graph, m);
    }
}