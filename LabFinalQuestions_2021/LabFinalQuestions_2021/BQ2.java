// BQ2.java
package pkB;

class S implements pkB.p3.PC.IPC2 {}

public class BQ2 {
    public static void main(String[] args) { System.out.println("Start");
        pkB.p1.PA pa = new pkB.p1.PA(); System.out.println(pa.m("MNR"));
        System.out.println(pa.m4(8)); System.out.println(pa.m4(3));
        pkB.p3.PC.IPC ipc = pa; System.out.println(ipc.m4(15));
        System.out.println(pkB.p1.p2.PB.m2("ABCD"));
        pkB.p1.p2.PB pb = new pkB.p1.p2.PB(); System.out.println(pb.m(4,2));
        System.out.println(pb.m(10,20)); 
        pkB.p3.PC pc = pb; System.out.println(pc.m(4,6)); 
        System.out.println(pkB.p3.PC.m3("TBD")); 
        S s = new S(); System.out.println(s.m2(9));
        pkB.p3.PC.IPC2 ipc2 = s; System.out.println(ipc2.m2(20));
    }
}