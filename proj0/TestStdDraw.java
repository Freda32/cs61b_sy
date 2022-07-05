public class TestStdDraw {
    public static void main(String[] args) {
//        StdDraw.setPenRadius(0.05);
//        StdDraw.setPenColor(StdDraw.BLUE);
//        StdDraw.point(0.5, 0.5);
//        StdDraw.setPenColor(StdDraw.MAGENTA);
//        StdDraw.line(0.2, 0.2, 0.8, 0.2);
        StdDraw.setXscale(-2.50e+11, 2.50e+11);
        StdDraw.setYscale(-2.50e+11, 2.50e+11);
        StdDraw.picture(0.5,0.5,"./images/starfield.jpg");
    }
}
