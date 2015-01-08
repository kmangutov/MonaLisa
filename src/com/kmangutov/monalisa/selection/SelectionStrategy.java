package com.kmangutov.monalisa.selection;

import com.kmangutov.monalisa.chromosome.Chromosome;
import com.kmangutov.monalisa.population.Population;
import javafx.util.Pair;

/**
 * Created by kmangutov on 1/8/15.
 */
public abstract class SelectionStrategy {

    public abstract Pair<Chromosome, Chromosome> select(Population population);
}
