package com.zq.util;

import com.zq.entity.Fraction;

public class EquationSolver {
    public static Fraction[] solve(Fraction[][] xList, Fraction[] yList) {
        Fraction result[] = new Fraction[xList.length];
        Fraction sumDet = Det.getDet(xList);
        if (Operation.equals(sumDet, new Fraction(0,1))) {
            System.out.println("行列式为0");
            throw new NullPointerException();
        }else {
            for(int i = 0 ; i < xList.length; i++) {
                Fraction temp[][] =  new Fraction[xList.length][xList.length];
                for(int j = 0; j < xList.length; j++) {
                    for(int k = 0; k < xList.length; k++) {
                        if(k == i) {
                            temp[j][k] = yList[j];
                        } else {
                            temp[j][k] = xList[j][k];
                        }
                    }
                }
                result[i] = Operation.divide(Det.getDet(temp), sumDet);
            }
            return result;
        }
    }
}
