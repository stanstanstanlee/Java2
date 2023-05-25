package class03;

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
public class PointColorPointAnswer {
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
   }
}