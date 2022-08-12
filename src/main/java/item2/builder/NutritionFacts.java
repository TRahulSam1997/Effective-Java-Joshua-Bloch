package item2.builder;
/*
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item2/builder/NutritionFacts.java
 * Builder Pattern combines the safety of telescoping constructor pattern with the readability of the JavaBeans pattern.
 */
/* Immutable class as the builders setter methods return the builder itself. */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        /* Setter-like methods build the object as required. */
        public Builder calories(int val) {
            /* Throws IllegalArgumentException for invalid parameters. */
            if (val < 0) {
                throw new IllegalArgumentException(Integer.toString(val) + " is negative!");
            }

            calories = val;
            return this;
        }
        public Builder fat(int val)
        { fat = val;           return this; }
        public Builder sodium(int val)
        { sodium = val;        return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val;  return this; }

        /* Parameterless build method generates the object. */
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        /*
         * Client gets a builder object instead of making the desired object directly.
         * Method chaining keeps the code concise.
         */
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        NutritionFacts bundaberg = new Builder(10, 4)
                .calories(20)
                .build();
    }
}
