/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fwew.population;

/**
 *
 * @author Jonatan
 */
public interface Replacement<T>{
    static final int VARIABLE = -1;
    T[] apply( T[] current, T[] next );
    default int range(){ return VARIABLE; };	
}