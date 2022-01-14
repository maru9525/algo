package Algo0113;

public class Main_pr_최소직사각형 {

	public int solution(int[][] sizes) {
		int answer = 0;
		int maxValue = 0;
		int minValue = 0;
		for (int i = 0; i < sizes.length; i++) {
			int maxTemp = Math.max(sizes[i][0], sizes[i][1]);
			int minTemp = Math.min(sizes[i][0], sizes[i][1]);

			maxValue = Math.max(maxValue, maxTemp);
			minValue = Math.max(minValue, minTemp);
		}
		answer = maxValue * minValue;

		return answer;
	}

}
