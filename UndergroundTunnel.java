public class UndergroundTunnel {
    boolean opened=false;
    public UndergroundTunnel() {
    }
    public void open(String item){
        if(item.equals("old crowbar")){
            System.out.println("The floor block is removed. There are downward steps.");
         this.opened = true;
        } else {
            System.out.println(item + " cannot help you do that.");
            this.opened = false;
        }
    }
    public void descend(){
        if(opened==true){
            System.out.println("You descend through the square opening and climb down the steps .");
            ending();
        } else {
            System.out.println("Sorry. You don't have anywhere to descend to");
        }
    }
    public void ending(){
        System.out.println("****************YAY!! YOU WON******************.");

    }
}