/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fwew.real.array.mutation;

import hazarda.integer.Random;
import hazarda.real.PowerLaw;
import hazarda.real.Symmetric;

/**
 *
 * @author jgomez
 */
public class PowerLawMutation extends IntensityMutation {
  /**
   * Creates a Gaussian Mutation with the given standard deviation per component
   * @param _sigma Standard deviation per component
   */
  public PowerLawMutation( double sigma ) {
      super(sigma, new Symmetric(new PowerLaw()));
  }

    public PowerLawMutation( double sigma, Random components){
        super(sigma, new Symmetric(new PowerLaw()), components);
    }
}
