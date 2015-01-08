package com.kmangutov.monalisa.crossover;

import com.kmangutov.monalisa.chromosome.Chromosome;
import javafx.util.Pair;

/**
 * Created by kmangutov on 1/8/15.
 */
public interface CrossoverStrategy
{
    /**
     * Interface describing a strategy to perform crossover
     * between two chromosomes
     * @param a First chromosome
     * @param b Second chromosome
     */
    public abstract Pair<Chromosome, Chromosome>
        crossover(Chromosome a,
                  Chromosome b);
}
