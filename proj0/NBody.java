public class NBody {
    public static double readRadius(String pth){
        In in = new In(pth);
        int nums = in.readInt();
        double radius =  in.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String pth){
        In in = new In(pth);
        int nums = in.readInt();
        double radius =  in.readDouble();
        Planet[] planets = new Planet[nums];
        for (int i=0;i<nums;i+=1){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();

            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
    }

    public static void main(String[] args){
        if (args.length == 0) {
            System.out.println("Please input T, dt, filename.");
        }

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double uniRadius = readRadius(filename);
        Planet[] allplanets = readPlanets(filename);
        int n = allplanets.length;

        StdDraw.setXscale(-uniRadius, uniRadius);
        StdDraw.setYscale(-uniRadius, uniRadius);
        StdDraw.enableDoubleBuffering();

        for(double iT=0; iT<=T; iT+=dt){

            double[] xForces = new double[n];
            double[] yForces = new double[n];

            for (int i=0;i<n;i+=1){
                double xForce = allplanets[i].calcNetForceExertedByX(allplanets);
                double yForce = allplanets[i].calcNetForceExertedByY(allplanets);
                xForces[i] = xForce;
                yForces[i] = yForce;
            }
            for (int i=0;i<n;i+=1){
                allplanets[i].update(dt,xForces[i],yForces[i]);
            }


            StdDraw.picture(0.5,0.5,"./images/starfield.jpg");
            for (Planet p:allplanets){
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

        }

        StdOut.printf("%d\n", allplanets.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < allplanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    allplanets[i].xxPos, allplanets[i].yyPos, allplanets[i].xxVel,
                    allplanets[i].yyVel, allplanets[i].mass, allplanets[i].imgFileName);
        }

    }

}
