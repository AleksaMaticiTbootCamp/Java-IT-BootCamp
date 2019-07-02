package vatraURupi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
	private static int M;
	static int N;

	public static void print(int[][] bombs) {
		try (FileWriter fw = new FileWriter("bombs.txt")) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					fw.write(bombs[i][j]);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int[][] analiza(int[][] matrix) {
		int[][] buffer = new int[M][N];

		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				buffer[i][j] = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// Ugao

				if (i == 0 && j == 0) {
					if (matrix[i][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j + 1] == 1)
						buffer[i][j]++;
				} else if (i == 0 && j == N - 1) {
					if (matrix[i][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j] == 1)
						buffer[i][j]++;
				
				} else if (i == M - 1 && j == 0) {
					if (matrix[i - 1][j] == 1)
						buffer[i][j]++;
					if (matrix[i - 1][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i][j + 1] == 1)
						buffer[i][j]++;
				
				 } else if (i == M - 1 && j == N - 1) {
					if (matrix[i][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i - 1][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i - 1][j] == 1)
						buffer[i][j]++;
				}
				// krajnje vrste i kolone

				else if (i == 0 && j != 0 && j != N - 1) {
					if (matrix[i][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i][j + 1] == 1)
						buffer[i][j]++;

				} else if (j == 0 && i != 0 && i != M - 1) {
					if (matrix[i - 1][j] == 1)
						buffer[i][j]++;
					if (matrix[i - 1][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j] == 1)
						buffer[i][j]++;

				}

				else if (i == M - 1 && j != 0 && j != N - 1) {
					if (matrix[i][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i - 1][j - 1] == 1)
						buffer[i - 1][j]++;
					if (matrix[i][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i - 1][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i][j + 1] == 1)
						buffer[i][j]++;

				} else if (j == N - 1 && i != 0 && i != M - 1) {
					if (matrix[i - 1][j] == 1)
						buffer[i][j]++;
					if (matrix[i - 1][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j] == 1)
						buffer[i][j]++;

				}

				// Ostali elementi
				else {
					if (matrix[i - 1][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i - 1][j] == 1)
						buffer[i][j]++;
					if (matrix[i - 1][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i][j + 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j - 1] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j] == 1)
						buffer[i][j]++;
					if (matrix[i + 1][j + 1] == 1)
						buffer[i][j]++;

				}
			}

		}

		return buffer;
	}

	public static int[][] ucitaj() {
		int matrix[][] = new int[100][100];
		try (BufferedReader r = new BufferedReader(new FileReader("map.txt"))) {
			String[] nums = r.readLine().split(" ");
			M = Integer.parseInt(nums[0]);
			N = Integer.parseInt(nums[1]);

			for (int i = 0; i < M; i++) {
				String line = r.readLine();
				for (int j = 0; j < N; j++) {

					matrix[i][j] = line.charAt(j);

				}
			}

			for (int i = M; i < matrix.length; i++) {
				for (int j = N; j < matrix.length; j++) {

					matrix[i][j] = -1;

				}
			}
			return matrix;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return matrix;

	}

	public static void main(String[] args) {
		int matrix[][] = new int[100][100];
		matrix = ucitaj();

		int bombs[][] = new int[100][100];

		bombs = analiza(matrix);

		print(bombs);

	}
}
