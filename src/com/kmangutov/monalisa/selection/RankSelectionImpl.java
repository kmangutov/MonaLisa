package com.kmangutov.monalisa.selection;

import com.google.common.collect.TreeMultimap;
import com.kmangutov.monalisa.chromosome.Chromosome;
import com.kmangutov.monalisa.population.Population;
import javafx.util.Pair;

import java.util.Map;
import java.util.Random;

/**
 * Created by kmangutov on 1/8/15.
 */
public class RankSelectionImpl extends SelectionStrategy {

    protected Random mRandom = new Random();

    public Pair<Chromosome, Chromosome> select(Population population) {

        Chromosome first = null;
        Chromosome second = null;
        int counter = 0;

        for(Map.Entry<Float, Chromosome> entry : population.entries()) {

            if(mRandom.nextFloat() < selectionChance(counter, population.getRealSize())
                    || counter++ >= population.getRealSize() -2) {

                if(first == null)
                    first = entry.getValue();
                else {
                    second = entry.getValue();
                    return new Pair<Chromosome, Chromosome>(first, second);
                }
            }
        }

        return new Pair<Chromosome, Chromosome>(first, second);
    }

    public float selectionChance(int i, int total) {

        return 0.4f;
    }
}
