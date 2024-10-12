package algorithm.huaweiOD2024;

import java.util.Scanner;

/**
 * @author hason
 * 螺旋矩阵
 * https://fcqian.blog.csdn.net/article/details/135085069
 * @since 2024/5/29 14:29
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        // 输入数字、行数
        Scanner scanner = new Scanner(System.in);

        // 数字
        int m = scanner.nextInt();
        // 行数
        int n = scanner.nextInt();
        // 计算列数(向上取整)
        int k = (int)Math.ceil(m * 1.0 / n);

        int[][] spiralMatrix = new int[n][k];
        int step = 1;
        int x = 0, y = 0;
        while (step <= m) {
            // 横向正向
            while (y < k && spiralMatrix[x][y] == 0 && step <= m) {
                spiralMatrix[x][y++] = step++;
            }
            x += 1;
            y -= 1;
            // 横向反向
            while (x < n && spiralMatrix[x][y] == 0 && step <= m) {
                spiralMatrix[x++][y] = step++;
            }
            x -= 1;
            y -= 1;
            // 竖向正向
            while (y >= 0 && spiralMatrix[x][y] == 0 && step <= m) {
                spiralMatrix[x][y--] = step++;
            }
            x -= 1;
            y += 1;
            // 竖向反向
            while (x >= 0 && spiralMatrix[x][y] == 0 && step <= m) {
                spiralMatrix[x--][y] = step++;
            }
            x += 1;
            y += 1;
        }
        

        // 打印
        for (int i = 0; i < spiralMatrix.length; i++) {
            for (int j = 0; j < spiralMatrix[0].length; j++) 
                System.out.print(spiralMatrix[i][j] == 0 ? "*" : spiralMatrix[i][j]);
            }
            System.out.println();
        }
        
    }
}
