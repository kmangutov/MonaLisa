package com.kmangutov.monalisa.mutation;

import com.kmangutov.monalisa.chromosome.Chromosome;
import com.kmangutov.monalisa.chromosome.Gene;

import java.util.Random;

/**
 * Created by kmangutov on 1/8/15.
 */
public abstract class StandardMutationImpl implements MutationStrategy {

    protected float mMutationChance = 0.01f;
    protected Random mRandom = new Random();

    public StandardMutationImpl() {

    }

    public StandardMutationImpl(float chance) {

        mMutationChance = chance;
    }

    public Chromosome mutate(Chromosome c) {

        for(int i = 0; i < c.size(); i++) {

            if(mRandom.nextFloat() <= mMutationChance) {

                Gene toMutate = c.remove(i);
                c.add(i, mutate(toMutate));
            }
        }

        return c;
    }

    public abstract Gene mutate(Gene g);
}
