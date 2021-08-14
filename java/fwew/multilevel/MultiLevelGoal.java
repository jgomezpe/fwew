package fwew.multilevel;

import fwew.Goal;
import speco.function.Function;
import spuro.Spuro;

public class MultiLevelGoal<G,P> extends Goal<G>{
    protected Function<P,Double> hf;
    protected CodeDecodeMap<G, P> map; 
	
    public MultiLevelGoal( CodeDecodeMap<G, P> map, Function<P,Double> f, boolean maximize ){
	super(null, maximize);
	this.hf = f;
	this.map = map;
    }
    
    @Override
    public double apply( G x ){
    	double y = hf.apply(map.decode(x));
    	Spuro.trace(this,x,y);
    	return y;
    }
    
}
