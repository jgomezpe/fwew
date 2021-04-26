/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fwew.local;

import fwew.Adapt;
import fwew.AdaptVariation;

/**
 *
 * @author jgomez
 */
public class OneFifthRule implements AdaptVariation{
    protected int G;
    protected int Gcount = 0;
    protected int Gstar = 0;
    protected Adapt adapt;

    public OneFifthRule( int G, Adapt adapt ){
        this.G = G;
        this.adapt = adapt;
    }
    
    @Override
    public void reset() {
	adapt.reset();
	Gcount = 0;
	Gstar = 0;
    }
	
    @Override
    public void adapt(double current, double next) {
	double productivity = next - current;
        if( productivity > 0.0 )  Gstar++;
        Gcount++;
        if(Gcount==G){
            double p = (double)Gstar/(double)G;
            if( p > 0.2 ) adapt.reward();
            else if( p < 0.2) adapt.punish();
            Gcount = 0;
            Gstar = 0;
        }
    }
}