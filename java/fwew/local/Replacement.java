/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fwew.local;

/**
 *
 * @author jgomez
 */
public interface Replacement<T> {
    public T apply( T current, T next );
}
