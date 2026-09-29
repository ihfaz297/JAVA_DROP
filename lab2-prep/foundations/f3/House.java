public class House 
{
    static int built = 0;
    int roomCount = 0;
    String color;
    House(String color)
    {
        built++;
        this.color = color;
    }

    Greeter doorbell(){
        return new Greeter(){
            public String greet(String who){
                return "Welcome to "+color+", "+who;
            }
        };
    }
    class Room 
    {
        String name;
        Room(String name)
        {
            roomCount++;
            this.name = name;
        }
        String describe(){return name +  " of " + color;}
        House home(){return House.this;}    // this is able to reference oneself
    }
    House.Room addRoom(String room){ return new Room(room);}
    static class Plan{
        int floors;
        Plan(int floors){
            this.floors = floors;
        }
        String info(){return "plan:"+floors+":Standard";}
        static Plan cheapest(){return new Plan(1);}
    }
}
