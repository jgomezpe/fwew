package fwew.bit.array.mutation;

import fwew.local.Variation;
import hazarda.integer.Uniform;
import kopii.Copier;
import speco.bit.array.Array;


/**
 * <p>Title: DelGen</p>
 * <p>Description: The gene deletion operator.  Deletes a gene in the genome</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author Jonatan Gomez
 * @version 1.0
 */

public class DelGen implements Variation<Array> {
  /**
   * If the last gene is going to be deleted or one randomly selected
   */
  protected boolean del_last_gene = true;

  protected int gene_size;
  protected int min_length;
  protected int max_length;

  protected Uniform g = new Uniform(0);

  public DelGen(int gene_size, int min_length, int max_length) {
      this.gene_size = gene_size;
      this.min_length = min_length;
      this.max_length = max_length;
  }


  /**
   * Constructor: create a deletion gene operator that deletes a gene of a genome
   * @param gene_size Number of bits defining a gene
   * @param min_length Minimum number of genes in the chromosome
   * @param max_length Maximun number of genes in the chromosome
   * @param del_last_gene Determines if the gene to be deleted is the last in
   * the genome or not. A true value indicates that the last gene is deleted.
   * A false value indiciates that a gene is randomly selected and deleted
   */
  public DelGen(int gene_size, int min_length, int max_length, boolean del_last_gene) {
      this(gene_size, min_length, max_length);
      this.del_last_gene = del_last_gene;
  }

  /**
   * Delete from the given genome the last gene
   * @param gen Genome to be modified
   */
  public Array apply(Array gen) {
      try{
          Array genome = (Array)Copier.apply(gen);
          if (genome.size() > min_length + gene_size) {
              if (del_last_gene) {
                  genome.del(gene_size);
              } else {
                  int size = (genome.size()-min_length)/gene_size;
                  g.set(size+1);
                  int k = g.next();
                  Array right = genome.subArray(min_length + (k + 1) * gene_size);
                  genome.del((size - k) * gene_size);
                  genome.add(right);
              }
          }
          return genome;         
      }catch( Exception e ){
      }
      return null;
 }
}
