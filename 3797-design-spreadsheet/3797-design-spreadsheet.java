class Spreadsheet {
    private int[][] grid;
    private int rows;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.grid = new int[rows][26]; 
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        // Formula format: =X+Y
        String expr = formula.substring(1); // remove '='
        String[] parts = expr.split("\\+");

        return getOperandValue(parts[0]) + getOperandValue(parts[1]);
    }

    private int getOperandValue(String operand) {
        if (Character.isLetter(operand.charAt(0))) {
            int[] pos = parseCell(operand);
            return grid[pos[0]][pos[1]];
        } else {
            return Integer.parseInt(operand);
        }
    }

    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}
