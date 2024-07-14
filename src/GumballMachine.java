public class GumballMachine {
    private State state;
    private int gumballCount;

    private enum State {
        NO_QUARTER, HAS_QUARTER, GUMBALL_SOLD, OUT_OF_GUMBALLS
    }

    public GumballMachine(int gumballCount) {
        this.gumballCount = gumballCount;
        if (gumballCount > 0) {
            state = State.NO_QUARTER;
            system();
        } else {
            state = State.OUT_OF_GUMBALLS;
        }
    }

    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        if (state == State.NO_QUARTER) {
            state = State.HAS_QUARTER;
        } else {
            System.out.println("You can't insert another quarter.");
        }
        System.out.println("You turned...");

    }

    public void rejectQuarter() {
        if (state == State.HAS_QUARTER) {
            state = State.NO_QUARTER;
            System.out.println("Quarter returned.");
            System.out.println("You turned but there's no quarter\n");
        } else {
            System.out.println("You haven't inserted a quarter.");
        }
        system();

    }

    public void turnCrank() {
        if (state == State.HAS_QUARTER) {
            state = State.GUMBALL_SOLD;
            dispenseGumball();
        } else {
            System.out.println("You need to insert a quarter first.");
        }
    }

    private void dispenseGumball() {
        if (state == State.GUMBALL_SOLD) {
            System.out.println("A gumball comes rolling out the slot.");
            gumballCount--;
            if (gumballCount > 0) {
                state = State.NO_QUARTER;
            } else {
                System.out.println("Oops, out of gumballs!");
                System.out.println("You can't insert quarter, the machine is sold out");
                System.out.println("You turned but there's no gumballs\n");

                state = State.OUT_OF_GUMBALLS;
            }
            system();
        }
    }

    private void system(){
        if (state == State.NO_QUARTER) {
            System.out.println("Mighty Gumball, Inc.");
            System.out.println("Java-enable Standing Gumball Model #2004");
            System.out.println("Inventory: " + this.getGumballCount() + " gumball" + (this.getGumballCount() != 1 ? "s" : ""));
            System.out.println("Machine is wait for quarter\n");
        } else if (state == State.OUT_OF_GUMBALLS) {
            System.out.println("Mighty Gumball, Inc.");
            System.out.println("Java-enable Standing Gumball Model #2004");
            System.out.println("Inventory: " + this.getGumballCount() + " gumball" + (this.getGumballCount() != 1 ? "s" : ""));
            System.out.println("Machine is sold out");
        }
    }

    public String getState() {
        return state.toString();
    }

    public int getGumballCount() {
        return gumballCount;
    }
}