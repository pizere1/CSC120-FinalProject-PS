public class Features  extends Room{
    public int x1,x2,y1,y2,z,roomnumber;
    public String feature="<Unknown name>";
    public Features(String featurename,int z, int x1, int y1, int featurenumber) {
        super(featurename,z,x1,y1,featurenumber);
        this.feature=featurename;
        this.z=z;
        this.x1=x1;
        this.y1=y1;
    }
    public Features(String featurename,int z, int x1,int x2, int y1, int y2, int featurenumber) {
        super(featurename,z,x1,x2,y1,y2,featurenumber);
        this.feature=featurename;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.z=z;
    }
}
