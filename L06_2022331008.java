/**
 * @LabId: 06
 * @Date: 2026-09-02
 * @RegNo: 2022331008
 * @Section: B
 */
public class L06_2022331008 {
    public static void main(String[] args) {
        P p = new P();
        P.Q h = new P.Q();
        p.m();
        P.R f = p.new R();
    }
}
class P{
    // static nested
    static class Q {
        Q(){System.out.println("Q created");}
    }
    // non static
    class R{R(){System.out.println("R created");}}
    void m(){
        Q q  = new Q();
        R r = new R();
    }
}