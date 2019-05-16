package com.zq.util;

import com.zq.entity.Fraction;

import static com.zq.util.Operation.add;
import static com.zq.util.Operation.product;

public class Det {
    private static Fraction[][] getComplement(Fraction[][] a, int row, int column) {
        Fraction[][] ans = new Fraction[a.length - 1][a.length - 1];// ans用于储存返回的最终结果
        Fraction[] temp = new Fraction[(a.length - 1) * (a.length - 1)];// 临时一维数组temp用于按顺序储存剔除相应行和列元素后的数组
        int k = 0;
        // 剔除行和列并按顺序储存到temp内
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == row - 1) {
                    continue;
                } else if (j == column - 1) {
                    continue;
                }
                temp[k++] = a[i][j];
            }
        }
        // 按顺序从temp中读取数据并储存到ans内
        k = 0;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = temp[k++];
            }
        }
        return ans;
    }

    // det用于求行列式
    public static Fraction getDet(Fraction[][] a) {
        if (a.length == 1) {
            return a[0][0];
        } else {
            Fraction ans=new Fraction(0,1);
            for (int i = 0; i < a.length; i++) {
                int l = (int)Math.pow(-1, i);
                ans = Operation.add(ans,Operation.product(Operation.product(a[i][0],new Fraction(l,1)),getDet(getComplement(a,i+1,1))));
            }
            return ans;
        }
    }
}
