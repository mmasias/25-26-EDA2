public class AcertijoIterativo {
    public static void main(String[] args) {
            for (int s = 1; s <= 9; s++) {
                for (int e = 0; e <= 9; e++) {
                    if (e != s) {
                        for (int n = 0; n <= 9; n++) {
                            if (n != s && n != e) {
                                for (int d = 0; d <= 9; d++) {
                                    if (d != s && d != e && d != n) {
                                        for (int m = 1; m <= 9; m++) {
                                            if (m != s && m != e && m != n && m != d) {
                                                for (int o = 0; o <= 9; o++) {
                                                    if (o != s && o != e && o != n && o != d && o != m) {
                                                        for (int r = 0; r <= 9; r++) {
                                                            if (r != s && r != e && r != n && r != d && r != m && r != o) {
                                                                for (int y = 0; y <= 9; y++) {
                                                                    if (y != s && y != e && y != n && y != d && y != m && y != o && y != r) {
                                                                        
                                                                        int send = s * 1000 + e * 100 + n * 10 + d;
                                                                        int more = m * 1000 + o * 100 + r * 10 + e;
                                                                        int money = m * 10000 + o * 1000 + n * 100 + e * 10 + y;
    
                                                                        if (send + more == money) {
                                                                            System.out.println("Letras asignadas:");
                                                                            System.out.println("S = " + s + " | E = " + e + " | N = " + n + " | D = " + d);
                                                                            System.out.println("M = " + m + " | O = " + o + " | R = " + r + " | Y = " + y);
                                                                            System.out.println();
                                                                            System.out.println("    S E N D          " + s + " " + e + " " + n + " " + d);
                                                                            System.out.println("  + M O R E        + " + m + " " + o + " " + r + " " + e);
                                                                            System.out.println("  ---------        ---------");
                                                                            System.out.println("  M O N E Y        " + m + " " + o + " " + n + " " + e + " " + y);
                                                                            return; 
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

