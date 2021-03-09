package com.leetcode.Dynamic_programming;

/**
 * @ClassName: getBestGoldMining
 * @Description: TODO
 * @Author: jackey
 * @Create: 2021/3/9 下午5:25
 */
public class getBestGoldMining {

    /**
     *  @Description:   递归求解金矿问题，该方法实现的时间复杂度比较大
     *  @Param:     [w 挖矿人数, n 矿个数, p 每个矿需要的开工人数, g 每个矿的收益]
     *  @Return:    挖矿最大值
     */
    public static int getBestGoldMining(int w,int n,int[] p,int[] g){
        if (w==0 || n==0){
            return 0;
        }
        if (w<p[n-1]){
            return getBestGoldMining(w,n-1, p, g);
        }
        return Math.max(getBestGoldMining(w, n-1, p, g), getBestGoldMining(w-p[n-1],n-1, p, g)+g[n-1]);
    }

    /**
     *  @Description:   采用二维数组实现，在时间复杂度上面比递归实现要优化很多
     *  @Param:         [w, p, g]
     *  @Return:        int
     */
    public static int getBestGoldMiningV2(int w, int[] p, int[] g){
        //创建表格
        int[][] resultTable = new int[g.length+1][w+1];
        //填充表格
        for(int i=1; i<=g.length; i++){
            for(int j=1; j<=w; j++){
                if(j<p[i-1]){
                    resultTable[i][j] = resultTable[i-1][j];
                } else {
                    resultTable[i][j] = Math.max(resultTable[i-1]
                            [j], resultTable[i-1][j-p[i-1]]+ g[i-1]);
                }
            }
        }
        //返回最后1个格子的值
        return resultTable[g.length][w];
    }

    /**
     *  @Description:   再次优化，只有一行数据存储当前结果，空间复杂度只需要O(n)
     *  @Param:         [w, p, g]
     *  @Return:        int
     */
    public static int getBestGoldMiningV3(int w, int[] p, int[] g){
        //创建当前结果
        int[] results = new int[w+1];
        //填充一维数组
        for(int i=1; i<=g.length; i++){
            for(int j=w; j>=1; j--){
                if(j>=p[i-1]){
                    results[j] = Math.max(results[j],
                            results[j-p[i-1]]+ g[i-1]);
                }
            }
        }
        //返回最后1个格子的值
        return results[w];
    }


    public static void main(String[] args) {
        int w = 10;
        int[] p = {5, 5, 3, 4 ,3};
        int[] g = {400, 500, 200, 300 ,350};
        System.out.println("最优收益：" + getBestGoldMining(w, g.length, p, g));
        System.out.println("最优收益：" + getBestGoldMiningV2(w, p, g));
        System.out.println("最优收益："+getBestGoldMiningV3(w, p, g));
    }

}
