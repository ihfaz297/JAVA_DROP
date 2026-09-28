// CQ2.java
package pkC;

class S implements pkC.p3.PC.IPC2 {}

public class CQ2 {
    public static void main(String[] args) { System.out.println("Start C");
        pkC.p1.PA pa = new pkC.p1.PA(); System.out.println(pa.m("MNR"));
        System.out.println(pa.m4(8)); System.out.println(pa.m4(3));
        pkC.p3.PC.IPC ipc = pa; System.out.println(ipc.m4(15));
        System.out.println(pkC.p1.p2.PB.m2("QRBS"));
        pkC.p1.p2.PB pb = new pkC.p1.p2.PB(); System.out.println(pb.m(4,2));
        System.out.println(pb.m(10,20)); 
        pkC.p3.PC pc = pb; System.out.println(pc.m(4,6)); 
        System.out.println(pkC.p3.PC.m3("TBD")); 
        S s = new S(); System.out.println(s.m2(9));
        pkC.p3.PC.IPC2 ipc2 = s; System.out.println(ipc2.m2(20));
    }
}