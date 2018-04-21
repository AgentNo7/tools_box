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
     * 表示数独中所有的81个空格，带有横坐标x和纵坐标y两个属性
     * 实际用到的是size个，取决于数独盘中未填的数量
     * 原点在左上角，x正向为下，代表某一行；y正向为右，代表某一列
     */
    private static xy space[] = new xy[81];

    static {
        for (int i = 0; i < 81; i++) space[i] = new xy();
    }

    /**
     * 尝试填入一个数字后，会把数组h、l、c中的对应数据改成非0，表示val已经不可用
     * @param x 第x行
     * @param y 第y列
     * @param val 数据val已填，删除val的可用性
     */
    private static void delete(int x, int y, int val) {
        int x0 = x / 3, y0 = y / 3;
        c[x0 * 3 + y0][val]++;
        h[x][val]++;
        l[y][val]++;
    }

    /**
     * 回溯法的必要部分，当前情况不满足要求时，进行回溯，对delete的内容进行unDelete，返回过去的情况，并作出不同选择
     * @param x 第x行
     * @param y 第y列
     * @param val 复活val的可用性，以便下面填入其他数据
     */
    private static void unDelete(int x, int y, int val) {
        int x0 = x / 3, y0 = y / 3;
        c[x0 * 3 + y0][val] = 0;
        h[x][val] = 0;
        l[y][val] = 0;
    }

    /**
     * 对初始数独盘进行检查，如果初始数独盘就是无解的，在多次调用的过程中将会返回false
     * @param x 第x行
     * @param y 第y列
     * @param val 数据val初始已存在，删除val的可用性
     * @return false表示数独的数据冲突，无解；true表示暂无数据冲突
     */
    private static boolean deleteCheck(int x, int y, int val) {
        int x0 = x / 3, y0 = y / 3;
        if (++c[x0 * 3 + y0][val] > 1) return false;
        if (++h[x][val] > 1) return false;
        if (++l[y][val] > 1) return false;
        return true;
    }

    /**
     * 测试debug过程中使用
     * @param a 待打印的数组
     */
    private static void print(Integer a[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * dfs深度优先遍历，使用回溯法，本数独算法的核心
     * @param t 表示size中的第t个待填入数据的空格
     * @return 返回值表示是否有解
     */
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

    /**
     * 初始化函数
     * @return 表示传入的数独是否明显无解（有冲突数据）
     */
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


    /**
     * 对外可调用的接口
     * @param origin 表示被传入的原始数独题
     * @return 无解返回null，有解返回解数组
     */
    public static Integer[][] solve(Integer[][] origin) {
        pan = origin;
        if (!init()) {
            return null;
        }
        if (!dfs(0)) {
            System.out.println("无解！！！");
            return null;
        }
        return pan;
    }

    /**
     * 辅助内部类，表示坐标
     */
    private static class xy {
        int x, y;

        xy() {
        }
    }
}


