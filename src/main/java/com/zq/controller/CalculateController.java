package com.zq.controller;

import com.zq.entity.Fraction;
import com.zq.util.DataProcessing;
import com.zq.util.EquationSolver;
import com.zq.util.FloatDispose;
import com.zq.util.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculateController {
    @RequestMapping(value = "/calculate",method = RequestMethod.POST)
    public String calculate(@RequestParam("count") int count,Model model, HttpServletRequest req) {
        Fraction fractionXList[][] = new Fraction[count][count];
        Fraction fractionYList[] = new Fraction[count];
        model.addAttribute("isError", 0);
        for(int i = 1; i <= count; i++) {
            for(int j = 1; j <= count; j++) {
                try {
                    fractionXList[i - 1][ j - 1] = DataProcessing.process(req.getParameter("x" + i + j));
                } catch (Exception e) {
                    model.addAttribute("isError",1);
                }
            }
        }
        for(int i = 1; i <= count; i++) {
            try {
                fractionYList[i - 1] = DataProcessing.process(req.getParameter("y" + i));
            } catch (Exception e) {
                model.addAttribute("isError", 1);
            }
        }
        Fraction result[] = EquationSolver.solve(fractionXList, fractionYList);
        for(int i = 0; i < result.length; i++) {
                result[i] = new Fraction(result[i].getTop() / Operation.gcd(result[i].getTop(), result[i].getBottom()), result[i].getBottom() / Operation.gcd(result[i].getTop(), result[i].getBottom()));
        }
        for(int i = 0; i < result.length; i++) {
            if(result[i].getBottom() < 0) {
                result[i].setTop(-1 * result[i].getTop());
                result[i].setBottom(-1 * result[i].getBottom());
            }
        }
        model.addAttribute("res", result);
        model.addAttribute("count", result.length);
        return "result";
    }
}
