package chapter3.item10.highqualityequalsmethod.performanceequality;

import java.util.Arrays;

class Polygon {
    private final int edges;
    private final int vertices;
    private final double[] sides;
    private double area;
    private boolean areaCached;

    public Polygon(int edges, int vertices, double[] sides) {
        this.edges = edges;
        this.vertices = vertices;
        this.sides = Arrays.copyOf(sides, edges);
        this.areaCached = false;
    }

    public double area() {
        if (!areaCached) {
            /**
             * Calculate the area of the polygon using the sides array.
             * And set the area field according to the vertices.
             * ## The formula maybe wrong! ##
             */
            if(vertices == 3) {
                /** For triangle. */
                double p = (sides[0] + sides[1] + sides[2]) / 2;
                area = Math.sqrt(p*(p-sides[0])*(p-sides[1])*(p-sides[2]));
            }else if (vertices == 4){
                /** For rectangle. */
                area = sides[0] * sides[1];
            }
            else{
                // Other polygons. Put specific formula for your polygon type.
            }
            areaCached = true;
        }
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polygon)) return false;
        Polygon polygon = (Polygon) o;
        /** Only the area field is considered for logical equality */
        return Double.compare(polygon.area(), area()) == 0;
    }

    public static void main(String[] args) {
        /** Creating a triangle. */
        double[] sides = {3, 4, 5};
        Polygon triangle = new Polygon(3, 3, sides);

        /** Creating a rectangle. */
        double[] sides2 = {3, 4};
        Polygon rectangle = new Polygon(4, 4, sides2);

        /** Creating a second triangle. */
        double[] sides3 = {3, 4, 5};
        Polygon triangle2 = new Polygon(3, 3, sides3);

        System.out.println("Comparing triangle to rectangle -> " + triangle.equals(rectangle));
        System.out.println("Comparing triangle 1 to triangle 2 -> " + triangle.equals(triangle2));
    }
}
