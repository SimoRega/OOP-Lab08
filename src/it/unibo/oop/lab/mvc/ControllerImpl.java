package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    String current = null;
    List<String> history = null;

    public ControllerImpl() {
        this.history = new ArrayList<String>();
    }

    @Override
    public void nextString(String s) throws NullPointerException {
        this.current = s;
    }

    @Override
    public String getString() {
        if (this.current == null) {
            throw new NullPointerException();
        }
        return this.current;
    }

    @Override
    public List<String> getHistory() {
        // TODO Auto-generated method stub
        return this.history;
    }

    @Override
    public void printString() throws IllegalStateException {
        if (current == null) {
            throw new IllegalStateException();
        } else {
            System.out.println(this.current + '\n');
            this.history.add(this.current);
        }
    }

}
