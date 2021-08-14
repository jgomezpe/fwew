/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fwew;

import java.util.HashMap;

import kompari.real.H2LOrder;
import kompari.real.L2HOrder;
import kompari.real.DoubleOrder;
import speco.function.Function;
import spuro.Spuro;

/**
 *
 * @author jgomez
 */
public class Goal<T> {
    
    protected boolean maximize=true; 
    protected Function<T,Double> f;
    protected DoubleOrder order;
    protected HashMap<T,Double> memoization = new HashMap<T, Double>();
    protected int count=0;
    
    public Goal(Function<T,Double> f) {
	this(f,true);
    }
    
    public Goal(Function<T,Double> f, boolean maximize) {
	this.f = f;
	this.maximize = maximize;
	this.order = maximize?new L2HOrder():new H2LOrder();
    }
    
    public void clear() { memoization.clear(); }
    
    public void keep(T[] x) {
	HashMap<T, Double> keep = new HashMap<T, Double>();
	for(T y:x ) keep.put(y,memoization.get(y));
	clear(); 
	memoization = keep;
    }
    
    public int count() { return count; }
    
    public boolean maximize() { return maximize; }
    
    public int compare(double x, double y){ return order.compare(x,y); }

    public int compare(T x, T y){ return compare(apply(x),apply(y)); }
         
    public double apply( T x ){
	Double ym = memoization.get(x);
	if(ym==null) {
	    ym = f.apply(x);
	    memoization.put(x, ym);
	    count++;
	}
    	Spuro.trace(this,count,x,ym);
    	return ym;
    }
}