class Solution {
    public int maximumPopulation(int[][] logs) {
        int Max_population = 0;
        int year = logs[0][0];

        for  (int i = 0; i < logs.length; i++) {
            int population = 0;

            // calculation the max population of a year
            for (int j = 0; j < logs.length; j++) {
                if (logs[i][0] >= logs[j][0] && logs[i][0] < logs[j][1]) {
                    population++;
                }
            }

            if (population > Max_population) {
                Max_population = population;
                year = logs[i][0];
            }

            else if (population == Max_population) {
                year = (logs[i][0] < year) ? logs[i][0] : year ;
            }
 
        }

        return year;
    }

}