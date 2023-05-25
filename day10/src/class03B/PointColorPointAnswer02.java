package class03B;

class Point{
   int x;
   int y;
   Point(int x,int y){
      this.x=x;
      this.y=y;
   }
   void printInfo() {
      System.out.println("("+this.x+","+this.y+")");
   }
   @Override
   public boolean equals(Object obj) {
      Point point=(Point)obj;
      if(this.x==point.x) {
         if(this.y==point.y) {
            return true;
         }
      }
      return false;
   }
}
class ColorPoint extends Point{
   String color;
   ColorPoint(String color,int x,int y){
      super(x,y);
      this.color=color;
   }
   @Override
   public boolean equals(Object obj) {
      ColorPoint colorPoint = (ColorPoint)obj;
      if((this.x==colorPoint.x)&&(this.y==colorPoint.y)&&(this.color.equals(colorPoint.color))) {
         return true;
      }
      return false;
   }   
}
public class PointColorPointAnswer02 {
   public static void main(String[] args) {      
      Point[] data=new Point[3];
      data[0]=new Point(10,20);
      data[1]=new Point(123,20);
      data[2]=new Point(10,20);
      for(int i=1;i<=2;i++) {
         if(data[0].equals(data[i])) {
            System.out.println("같아~");
         }
         else {
            System.out.println("달라~");
         }
      }
      ColorPoint[] data2=new ColorPoint[3];
      data2[0]=new ColorPoint("파랑",10,20);
      data2[1]=new ColorPoint("파랑",10,20);
      data2[2]=new ColorPoint("빨강",10,20);
      for(int i=1;i<=2;i++) {
         if(data2[0].equals(data2[i])) {
            System.out.println("같아~");
         }
         else {
            System.out.println("달라~");
         }
      }
   }
}