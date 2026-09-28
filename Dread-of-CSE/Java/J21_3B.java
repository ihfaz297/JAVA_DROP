abstract class P{
    int p=70;
    P(int p){
        this.p=p;
        System.out.println("Const:="+p);
    }
    void pm(){System.out.println("PM : "+p);}
    abstract void d();
}
class Q extends P{
    int q=60;
    Q(int p,int q){
        super(p);
        this.q=q;
        System.out.println("Const: Q="+q++);
    }
    void d(){p++;System.out.println("QD:"+p);}
    class R extends P{
        int p=50;
        R(int p,int r){
            super(p);
            System.out.println("Const:R="+q);
        }
        void d(){p--;System.out.println("RD: "+p);}
    }
}
class J21_3B{
    public static void main(String[] args) {
        Q q=new Q(11,22);
        q.p=300;
        q.d();
        Q.R r=q.new R(30,10);
        r.pm();
        r.d();
        P p=r;
        p.d();
        p.pm();
        p.p=200;
        r.d();
    }
}
