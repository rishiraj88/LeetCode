package leetcode;
/**
 * to count the islands ('1' surrounded by all four '1's) whereas '0' means water.
 * @author rishiraj
 *
 */
public class NumberOfIslands {
	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, 
				{ '1', '1', '0', '1', '0' }, 
				{ '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' }
		};
		System.out.println(solution(grid));
	}

	static int solution(char[][] g) {
		int count = 0;

		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				if (g[i][j] == '1') {
					count += 1;
					checkNeighbor(g, i, j);
				}
			}
		}
		return count;
	}

	static void checkNeighbor(char[][] g, int i, int j) {
		if (i < 0 || i >= g.length || j < 0 || j >= g[i].length || g[i][j] == '0') {
			return;
		}
		g[i][j] ='0';
		checkNeighbor(g, i + 1, j);
		checkNeighbor(g, i - 1, j);
		checkNeighbor(g, i, j + 1);
		checkNeighbor(g, i, j - 1);

	}
}
