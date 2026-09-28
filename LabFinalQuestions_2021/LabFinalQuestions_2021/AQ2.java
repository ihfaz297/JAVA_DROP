// AQ2.java
package pkA;

class S implements pkA.p3.PC.IPC2 {}

public class AQ2 {
    public static void main(String[] args) { System.out.println("Start");
        pkA.p1.PA pa = new pkA.p1.PA(); System.out.println(pa.m("ABC"));
        System.out.println(pa.m4(5)); System.out.println(pa.m4(10));
        pkA.p3.PC.IPC ipc = pa; System.out.println(ipc.m4(20));
        System.out.println(pkA.p1.p2.PB.m2("Java"));
        pkA.p1.p2.PB pb = new pkA.p1.p2.PB(); System.out.println(pb.m(4,2));
        System.out.println(pb.m(9,3)); 
        pkA.p3.PC pc = pb; System.out.println(pc.m(7,1)); 
        System.out.println(pkA.p3.PC.m3("XYZ")); 
        S s = new S(); System.out.println(s.m2(5));
        pkA.p3.PC.IPC2 ipc2 = s; System.out.println(ipc2.m2(10));
    }
}