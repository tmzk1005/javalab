package zk.javalab.picocli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "sum", version = "1.0", description = "sum two integer nums.")
public class SumConf implements Runnable {

    @Option(names = { "-x" }, required = true, description = "num1")
    private int num1;

    @Option(names = { "-y" }, required = true, description = "num2")
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public void run() {
    }

}
