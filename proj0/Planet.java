import java.lang.Math;
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;

    }

    public double calcDistance(Planet p){
        double xx = this.xxPos - p.xxPos;
        double yy = this.yyPos - p.yyPos;
        double dist = Math.sqrt(xx*xx + yy*yy);
        return dist;
    }

    public double calcForceExertedBy(Planet p){
        double dist = this.calcDistance(p);
        double force = (G*this.mass*p.mass)/(dist*dist);
        return force;
    }

    public double calcForceExertedByX(Planet p){
        double xx = p.xxPos - this.xxPos;
        double xForce = (xx*this.calcForceExertedBy(p))/this.calcDistance(p);
        return xForce;
    }

    public double calcForceExertedByY(Planet p){
        double yy = p.yyPos - this.yyPos;
        double yForce = (yy*this.calcForceExertedBy(p))/this.calcDistance(p);
        return yForce;
    }

    public double calcNetForceExertedByX(Planet[] allp){
        double xForceSum = 0;
        double xxForce = 0;
        for (Planet p: allp){
            if (p.equals(this)){
                continue;
            }

            xxForce = this.calcForceExertedByX(p);
            xForceSum += xxForce;
        }

        return xForceSum;
    }
    public double calcNetForceExertedByY(Planet[] allp){
        double yForceSum = 0;
        double yyForce = 0;
        for (Planet p: allp){
            if (p.equals(this)){
                continue;
            }
            yyForce = this.calcForceExertedByY(p);
            yForceSum += yyForce;

        }

        return yForceSum;
    }

    public void update(double dt,double fX,double fY){
        double aX = fX/this.mass;
        double aY = fY/this.mass;

        this.xxVel += aX*dt;
        this.yyVel += aY*dt;
        this.xxPos += xxVel*dt;
        this.yyPos += yyVel*dt;
    }

    public void draw(){
        String img = "./images/"+imgFileName;

        StdDraw.picture(xxPos,yyPos,img);
    }

    
}
