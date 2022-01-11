package Lesson6.Home6;

public class Animal {

    static final int swim_false = 0;
    static final int swim_ok = 1;
    static final int swim_none = 2;

    private String type;
    protected String name;
    private float maxRun;
    private float maxSwim;

    public Animal(String type, String name, float maxRun, float maxSwim) {
        this.type = type;
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public float getMaxRun() {
        return maxRun;
    }

    public float getMaxSwim() {
        return maxSwim;
    }

    public boolean run(float dist){
        return dist <= maxRun;
    }

    protected int swim(float dist){
        return (dist <= maxSwim) ? swim_ok : swim_false;
    }
}


