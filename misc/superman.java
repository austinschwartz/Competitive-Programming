import java.util.*;

class superman
{
  static final int MAXN = 100;
  static final double EPSILON = 0.000001;
  static Point s = new Point();
  static Point t = new Point();
  static int ncircles; 
  static circle c[] = new circle[MAXN];
  
  static class Point
  {
    double x,y;
  }
  
  static class circle
  {
    Point c;
    double r;
  }
  
  static class Line
  {
    double a,b,c;
  }
  
  static Line point_and_slope_to_line(Point p, double m)
  {
    Line L = new Line();
    L.a = -m; L.b = 1; L.c =-((L.a*p.x) + (L.b*p.y));
    return L;
  }
  
  static Line points_to_line(Point p1, Point p2)
  {
    Line L = new Line();
    if(p1.x == p2.x)
    {
      L.a = 1;
      L.b = 0;
      L.c = -p1.x;
    }
    else
    {
      L.b = 1;
      L.a = -(p1.y - p2.y) / (p1.x - p2.x);
      L.c = -(L.a * p1.x) - (L.b * p1.y);
    }
    return L;
  }
  
  static boolean parallelQ(Line l1, Line l2)
  {
    return ( (Math.abs(l1.a-l2.a) <= EPSILON) && (Math.abs(l1.b-l2.b) <= EPSILON) );
  }
  
  static boolean same_lineQ(Line l1, Line l2)
  {
    return ( parallelQ(l1,l2) && (Math.abs(l1.c-l2.c) <= EPSILON) );
  }
  
  static boolean point_in_box(Point p, Point b1, Point b2)
  {
    return( 
    (p.x >= Math.min(b1.x,b2.x)) && 
    (p.x <= Math.max(b1.x,b2.x)) && 
    (p.y >= Math.min(b1.y,b2.y)) && 
    (p.y <= Math.max(b1.y,b2.y)));
  }
  
  static Point intersection_point(Line l1, Line l2)
  {
    Point p = new Point();
    if(same_lineQ(l1,l2))
    {
      System.out.printf("Warning: Identical lines, all points intersect.\n");
      p.x = p.y = 0.0;
      return p;
    }
    if(parallelQ(l1,l2))
    {
      System.out.printf("Error: Distinct parallel lines do not intersect.\n");
      return p;
    }
    p.x = (l2.b*l1.c - l1.b*l2.c) / (l2.a*l1.b - l1.a*l2.b);
    if (Math.abs(l1.b) > EPSILON)
      p.y = - (l1.a * (p.x) + l1.c) / l1.b;
    else
      p.y = - (l2.a * (p.x) + l2.c) / l2.b;
    return p;
  }
  
  static Point closest_point(Point p_in, Line l)
  {
    Line perp;
    Point p_c = new Point();
    if (Math.abs(l.b) <= EPSILON) { /* vertical line */
      p_c.x = -(l.c);
      p_c.y = p_in.y;
      return p_c;
    }
    if (Math.abs(l.a) <= EPSILON) { /* horizontal line */
      p_c.x = p_in.x;
      p_c.y = -(l.c);
      return p_c;
    }
    perp = point_and_slope_to_line(p_in,1/l.a);
    return intersection_point(l,perp);
  }
  
  static double distance(Point a, Point b)
  {
    int i;
    double d = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    return Math.sqrt(d);
  }
  
  static void foo()
  {
    Line l;
    Point close;
    double d;   /* distance from circle-center */
    double xray = 0.0;  /* length of intersection with circles */
    double around = 0.0;  /* length around circular arcs */
    double angle;   /* angle subtended by arc */
    double travel;    /* total travel distance */
    int i;      /* counter */
    l = points_to_line(s,t);
    for (i=1; i<=ncircles; i++) {
      close = closest_point(c[i].c,l);
      d = distance(c[i].c,close);
      if ((d>=0) && (d < c[i].r) && point_in_box(close,s,t)) {
        xray += 2*Math.sqrt(c[i].r*c[i].r - d*d);
        angle = Math.acos(d/c[i].r);
        around += ((2*angle)/(2*Math.PI)) * (2*Math.PI*c[i].r);
        System.out.printf("circle %d (%7.3f,%7.3f,%7.3f) is %7.3f away from l, xray=%7.3f around=%7.3f angle=%7.3f.\n",
          i,c[i].c.x,c[i].c.y,c[i].r,d,xray,around,angle);
      }
    }
    travel = distance(s,t) - xray + around;
    System.out.printf("Superman sees through %7.3f units, and flies %7.3f units\n",
      xray, travel);
  }
  
  static public void main(String[] args)
  {
    int i;
    Scanner sc = new Scanner(System.in);
    s.x = sc.nextDouble(); s.y = sc.nextDouble();
    t.x = sc.nextDouble(); t.y = sc.nextDouble();
    ncircles = sc.nextInt();
    for(i=1;i<=ncircles;i++)
    {
      c[i] = new circle();
      c[i].c = new Point();
      c[i].c.x = sc.nextDouble();
      c[i].c.y = sc.nextDouble();
      c[i].r = sc.nextDouble();
    }
    System.out.printf("%7.3f %7.3f\n",s.x,s.y);
    System.out.printf("%7.3f %7.3f\n",t.x,t.y);
    System.out.printf("%d\n",ncircles);
    for (i=1; i<=ncircles; i++)
      System.out.printf("%7.3f %7.3f %7.3f\n",c[i].c.x,c[i].c.y,c[i].r);
    foo();
  }
}

