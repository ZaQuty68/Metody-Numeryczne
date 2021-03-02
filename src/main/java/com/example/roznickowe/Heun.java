package com.example.roznickowe;

import javafx.css.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heun {
    double n;
    double a = 0;
    double b;
    double y0 = 1;
    List<Double> list;
    double bmax;

    public Heun(int n, int b){
        this.n = n;
        this.b = b;
        heun();
    }

    public List<Double> WynikL() { return list; }
    public double WynikB() {return bmax; }

    private double f(double x, double y){
        double w = 3 * (y - 4 * x * x * x - 1) * (y - 4 * x * x * x - 1) + 2;
        return w;
    }

    private double fd(double x){
        double w = 4 * x * x * x + 2 * x + 1;
        return w;
    }

    private double fm(double x, double y, double h){
        double w = f(x + h, y + h*f(x,y));
        return w;
    }

    private void heun(){
        double h = (b-a)/n;

        List<Double> xk = new ArrayList<>();
        for(int k = 0; k <= n; k++){
            xk.add(a + k * h);
        }

        List<Double> yk = new ArrayList<>();
        yk.add(y0);
        for(int k=1; k <= n; k++){
            double y = yk.get(k-1);
            double x = xk.get(k-1);
            yk.add(y + h/2 * (f(x,y) + fm(x, y, h)));
        }

        list = new ArrayList<>();
        for(int k=1; k<=n; k++){
            list.add(yk.get(k));
        }

        List<Double> yx = new ArrayList<>();
        yx.add(0.0);
        for(int k=1; k <= n; k++){
            yx.add(fd(xk.get(k)));
        }

        List<Double> blad = new ArrayList<>();
        for(int k=1; k<= n; k++){
            blad.add(Math.abs(yx.get(k) - yk.get(k)));
        }

        bmax = Collections.max(blad);
    }
}
