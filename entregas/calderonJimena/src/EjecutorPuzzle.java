
public class EjecutorPuzzle {
    public static void main(String[] args) {
        CriptoSolver solver = new CriptoSolver();

        System.out.println("========================================");
        System.out.println("CASO 1: SEND + MORE = MONEY");
        System.out.println("========================================");
        solver.printSolution(solver.solve(new String[]{"SEND", "MORE"}, "MONEY"));

        System.out.println("\n========================================");
        System.out.println("CASO 2: FORTY + TEN + TEN = SIXTY");
        System.out.println("========================================");
        solver.printSolution(solver.solve(new String[]{"FORTY", "TEN", "TEN"}, "SIXTY"));

        System.out.println("\n========================================");
        System.out.println("CASO 3: ODD + ODD = EVEN");
        System.out.println("========================================");
        solver.printSolution(solver.solve(new String[]{"ODD", "ODD"}, "EVEN"));
    }
}