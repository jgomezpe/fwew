package fwew.bit.array.mutation;
import fwew.bit.array.space.Space;
import fwew.local.Variation;
import hazarda.integer.Uniform;
import kopii.Copier;
import speco.bit.array.Array;

/**
 * <p>Title: AddGen</p>
 * <p>Description: The gene addition operator. Add a gene generated randomly</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author Jonatan Gomez
 * @version 1.0
 */

public class AddGen implements Variation<Array> {
  /**
   * If the added gene is added to the end of the genome or not (randomly added)
   */
  protected boolean append = true;

  protected int gene_size;
  protected int min_length;
  protected int max_length;
  
  protected Uniform g = new Uniform(0);
  protected Space space;

  public AddGen(int gene_size, int min_length, int max_length) {
      this.gene_size = gene_size;
      this.min_length = min_length;
      this.max_length = max_length;
      space = new Space(gene_size);
  }

  /**
   * Constructor: creates an addition gene operator that adds a gene according to
   * the variable _append
   * @param append If the added gene is added to the end of the genome or not (randomly added)
   */
  public AddGen(int gene_size, int min_length, int max_length, boolean append) {
      this(gene_size, min_length, max_length);
      this.append = append;
  }
  
  /**
   * Add to the end of the given genome a new gene
   * @param gen Genome to be modified
   * @return The added gene or a String
   */
  public Array apply(Array gen) {
      try{
          Array genome = (Array)Copier.apply(gen);
          if (genome.size() < max_length) {
              Array gene = space.pick();
              if (append) genome.add(gene);
              else{
                  int size = (genome.size() - min_length) / gene_size;
                  g.set(size+1);
                  int k = g.next();
                  if (k == size) genome.add(gene);
                  else{
                      Array right = genome.subArray(min_length + k * gene_size);
                      genome.del((size - k) * gene_size);
                      genome.add(gene);
                      genome.add(right);
                  }
              }
          }
          return genome;
      }catch( Exception e ){
          e.printStackTrace();
      }
      return null;
  }
}