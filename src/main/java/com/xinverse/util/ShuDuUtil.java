package com.xinverse.util;

public class ShuDuUtil {

    /**
     * 表示整个数独盘（9*9）
     */
    private static Integer pan[][];

    /**
     * h[x][n]表示横向的第x行的数字n是否合法
     * l[y][n]表示纵向的第y行的数字n是否合法
     * c[k][n]表示九宫格的第k格里的数字n是否合法
     */
    private static int h[][] = new int[9][10], l[][] = new int[9][10];
    private static int c[][] = new int[9][10];

    /**
     * 数独的未填的空的数量为size，在初始化中被赋值
     */
    private static int size = 0;

    /**
     * 表示81个空格，带有横坐标和纵坐标两个属性
     * 原点在左上角，x正向为下，代表某一行；y正向为右，代表某一列
     */
    private static xy space[] = new xy[81];

    static {
        for (int i = 0; i < 81; i++) space[i] = new xy();
    }

    private static void delete(int x, int y, int val) {
        int x0 = x / 3, y0 = y / 3;
        c[x0 * 3 + y0][val]++;
        h[x][val]++;
        l[y][val]++;
    }

    private static void unDelete(int x, int y, int val) {
        int x0 = x / 3, y0 = y / 3;
        c[x0 * 3 + y0][val] = 0;
        h[x][val] = 0;
        l[y][val] = 0;
    }

    private static boolean deleteCheck(int x, int y, int val) {
        int x0 = x / 3, y0 = y / 3;
        if (++c[x0 * 3 + y0][val] > 1) return false;
        if (++h[x][val] > 1) return false;
        if (++l[y][val] > 1) return false;
        return true;
    }

    private static void print(Integer a[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean dfs(int t) {
        if (t == size) {
            return true;
        }
        int x = space[t].x, y = space[t].y;
        int nx = x / 3, ny = y / 3; //九宫格看做3*3的棋盘
        for (int i = 1; i <= 9; i++) {
            if (c[nx * 3 + ny][i] == 0 && h[x][i] == 0 && l[y][i] == 0) {
                pan[x][y] = i;
                delete(x, y, i);
                if (dfs(t + 1))
                    return true;
                pan[x][y] = 0;
                unDelete(x, y, i);
            }
        }
        return false;
    }

    private static boolean init() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                c[i][j] = h[i][j] = l[i][j] = 0;
            }
        }
        size = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (pan[i][j] != 0) {
                    if (!deleteCheck(i, j, pan[i][j])) {
                        System.out.println("输入有误！！！");
                        return false;
                    }
                } else {
                    space[size].x = i;
                    space[size].y = j;
                    size++;
                }

            }
        }
        return true;
    }


    public static Integer[][] solve(Integer[][] origin) {
        pan = origin;
//        System.out.println("origin is ");
//        print(origin);
        if (!init()) {
            return null;
        }
        if (!dfs(0)) {
            System.out.println("无解！！！");
            return null;
        } //else print(pan);
        return pan;
    }

    private static class xy {
        int x, y;

        xy() {
        }
    }
}


