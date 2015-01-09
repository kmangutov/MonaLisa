# MonaLisa

<img src="http://i.imgur.com/Jbvt5GL.png"
 alt="MonaLisa" title="MonaLisa" align="right" width="278" height="400"/>

MonaLisa is a Java Genetic Algorithm implementation with a focus on ease of use and extensibility.

## Usage

To use MonaLisa to solve a problem, take the following steps

1. Define **Genes** that make up the solution to the problem
2. Define a **GeneFactory** that produces random Genes
3. Select a **ChromosomeFactory** that describes how to create **Chromosomes** from Genes
4. Select a **SelectionStrategy** that describes how to select candidates for reproduction
5. Select a **CrossoverStrategy** that breeds two Chromosomes to produce offspring
6. Select a **MutationStategy** that describes how to perform mutation on Genes

Now, you can easily iterate through generations with one function call.

## Provided

### ChromosomeFactory

1. **StaticChromosomeFactoryImpl** - Takes a **GeneFactory** implementation and an initial chromosome size. Populates chromosome using **GeneFactory**

### SelectionStrategy

1. **RankSelectionImpl** - Selects **Chromosome** with probability proportional to fitness ranking

### CrossoverStrategy

1. **SingleLocusCrossoverImpl** - Splits provided **Chromosomes** each with a single locus and performs swap

### MutationStrategy

1. **StandardMutationImpl** - Mutates each **Gene** in **Chromosome** with given probability. Needs to be subclassed to describe how to mutate a Gene
2. **StandardMutationRandomImpl** - Implementation of **StandardMutationImpl** that takes a **GeneFactory**. Defines mutation as replacement by new random **Gene**

## References

<a href="http://www.boente.eti.br/fuzzy/ebook-fuzzy-mitchell.pdf">Melanie Mitchell - An Introduction to Genetic Algorithms</a>

<a href="http://www.doc.ic.ac.uk/~nd/surprise_96/journal/vol1/hmw/article1.html">Genetic Algorithms</a>

<a href="http://www.ai-junkie.com/ga/intro/gat1.html">Genetic Algorithsm in Plain English</a>
